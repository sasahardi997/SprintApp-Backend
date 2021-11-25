package com.hardi.SprintBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hardi.SprintBack.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username).orElse(null);

        if(user == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'." + username));
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            String role = "ROLE_" + user.getRole().toString();
            grantedAuthorities.add(new SimpleGrantedAuthority(role));

            return new org.springframework.security.core.userdetails.User(
                    user.getUserName().trim(),
                    user.getPassword().trim(),
                    grantedAuthorities
            );
        }
    }
}