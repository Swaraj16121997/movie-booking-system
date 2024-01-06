package com.example.showbookingsystem.controllers;

import com.example.showbookingsystem.dtos.SignupUserRequestDto;
import com.example.showbookingsystem.dtos.SignupUserResponseDto;
import com.example.showbookingsystem.exceptions.UserNotFoundException;
import com.example.showbookingsystem.models.ResponseStatus;
import com.example.showbookingsystem.models.User;
import com.example.showbookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    public SignupUserResponseDto loginUser(SignupUserRequestDto userRequestDto) throws UserNotFoundException {

        User user = userService.login(userRequestDto.getUsername(),userRequestDto.getEmail(),userRequestDto.getPassword());
        SignupUserResponseDto signupUserResponseDto = new SignupUserResponseDto();

        try {
            if (user == null)
                throw new UserNotFoundException("Unable to login or sign-up the user");

            signupUserResponseDto.setUserId(user.getId());
            signupUserResponseDto.setResponseStatus(ResponseStatus.CONFIRMED);
        } catch (Exception exception){
            signupUserResponseDto.setResponseStatus(ResponseStatus.NOT_CONFIRMED);
        }

        return signupUserResponseDto;
    }
}
