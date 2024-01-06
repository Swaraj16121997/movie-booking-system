package com.example.showbookingsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupUserRequestDto {
    private String username;
    private String email;
    private String password;
}
