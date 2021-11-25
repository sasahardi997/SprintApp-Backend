package com.hardi.SprintBack.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardi.SprintBack.model.User;
import com.hardi.SprintBack.security.TokenUtils;
import com.hardi.SprintBack.service.UserService;
import com.hardi.SprintBack.support.UserDtoToUser;
import com.hardi.SprintBack.support.UserToUserDto;
import com.hardi.SprintBack.web.dto.AuthUserDto;
import com.hardi.SprintBack.web.dto.UserDto;
import com.hardi.SprintBack.web.dto.UserRegistrationDto;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoToUser toUser;

    @Autowired
    private UserToUserDto toDto;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserRegistrationDto dto){

        if(dto.getId() != null && !dto.getPassword().equals(dto.getConfirmPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = toUser.convert(dto);

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        LocalDate date = getLocalDate(timeStamp);
        user.setRegistrationDate(date);

        return new ResponseEntity<>(toDto.convert(userService.save(user)), HttpStatus.CREATED);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/auth")
    public ResponseEntity authenticateUser(@RequestBody AuthUserDto dto){

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
            return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    private LocalDate getLocalDate(String date) throws DateTimeParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}
