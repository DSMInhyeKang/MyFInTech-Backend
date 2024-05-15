package com.inhyekang.myfintech.service;

import com.inhyekang.myfintech.dto.request.RegisterRequest;
import com.inhyekang.myfintech.dto.response.FindUserInfoResponse;
import com.inhyekang.myfintech.dto.response.SearchUserResponse;
import com.inhyekang.myfintech.entity.User;
import com.inhyekang.myfintech.exception.UserAlreadyExistException;
import com.inhyekang.myfintech.exception.UserNotFoundException;
import com.inhyekang.myfintech.facade.UserFacade;
import com.inhyekang.myfintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserFacade userFacade;

    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw UserAlreadyExistException.EXCEPTION;
        else {
            userRepository.save(User
                    .builder()
                    .email(request.getEmail())
                    .name(request.getName())
                    .sub(request.getSub())
                    .build());
        }
    }
    public FindUserInfoResponse findMyInfo() {

        User user = userFacade.currentUser();

        return FindUserInfoResponse.of(user);
    }

    public FindUserInfoResponse findUserInfo(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return FindUserInfoResponse.of(user);
    }

    public SearchUserResponse searchUser(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return SearchUserResponse.of(user);
    }
}