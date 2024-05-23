package com.inhyekang.myfintech.facade;

import com.inhyekang.myfintech.entity.user.User;
import com.inhyekang.myfintech.exception.TokenInvalidException;
import com.inhyekang.myfintech.exception.UserNotFoundException;
import com.inhyekang.myfintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {

        Object detail = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!(detail instanceof UserDetails)) throw TokenInvalidException.EXCEPTION;

        return userRepository.findByEmail(((UserDetails) detail).getUsername())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}