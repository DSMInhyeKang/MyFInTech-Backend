package com.inhyekang.myfintech.controller;

import com.inhyekang.myfintech.dto.request.RegisterRequest;
import com.inhyekang.myfintech.dto.response.FindUserInfoResponse;
import com.inhyekang.myfintech.dto.response.SearchUserResponse;
import com.inhyekang.myfintech.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest request) {
        userService.register(request);
    }

    @GetMapping("/user")
    public FindUserInfoResponse findMyInfo() {
        return userService.findMyInfo();
    }

    @GetMapping("/user/{userId}")
    public FindUserInfoResponse findUserInfo(@PathVariable Long userId) {
        return userService.findUserInfo(userId);
    }

    @GetMapping("/search/{userId}")
    public SearchUserResponse searchUser(@PathVariable String userId){
        return userService.searchUser(userId);
    }}
