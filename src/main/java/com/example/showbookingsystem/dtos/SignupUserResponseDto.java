package com.example.showbookingsystem.dtos;

import com.example.showbookingsystem.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupUserResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
