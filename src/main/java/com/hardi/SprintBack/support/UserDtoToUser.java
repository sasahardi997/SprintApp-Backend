package com.hardi.SprintBack.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.SprintBack.model.User;
import com.hardi.SprintBack.service.UserService;
import com.hardi.SprintBack.web.dto.UserDto;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(UserDto dto) {
        User entity = null;

        if(dto.getId() == null){
            entity = new User();
        } else {
            entity = userService.findOne(dto.getId());
        }

        if(entity != null){
            entity.setUserName(dto.getUsername());
            return entity;
        }
        return null;
    }
}