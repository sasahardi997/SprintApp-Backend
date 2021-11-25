package com.hardi.SprintBack.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class UserDto {

    @Positive(message = "Id must be a positive number.")
    private Long id;

    @NotBlank
    private String username;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
