package com.hardi.SprintBack.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.SprintBack.model.User;
import com.hardi.SprintBack.web.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUserName());

        return dto;
    }

    public List<UserDto> convert(List<User> users){
        List<UserDto> dto = new ArrayList<>();
        for(User user : users){
            dto.add(convert(user));
        }
        return  dto;
    }
}