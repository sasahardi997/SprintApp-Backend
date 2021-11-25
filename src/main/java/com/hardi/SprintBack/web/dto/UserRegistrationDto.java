package com.hardi.SprintBack.web.dto;

import javax.validation.constraints.NotBlank;

public class UserRegistrationDto extends UserDto{

    @NotBlank(message = "Password can not be blank.")
    private String password;

    @NotBlank(message = "Confirm Password can not be blank.")
    private String confirmPassword;

    public UserRegistrationDto() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}