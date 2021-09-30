package com.crud.library.controller;

import com.crud.library.domain.User;
import com.crud.library.domain.UserDto;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserDbService userDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userDbService.addUser(user);
        return userMapper.mapToUserDto(savedUser);
    }
}
