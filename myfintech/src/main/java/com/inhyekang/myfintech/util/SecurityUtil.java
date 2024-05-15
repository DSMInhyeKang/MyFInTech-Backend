package com.inhyekang.myfintech.util;

import com.inhyekang.myfintech.exception.TokenInvalidException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtil {
    public static String getCurrentUserEmail() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = Optional.ofNullable((UserDetails) authentication.getPrincipal())
                .orElseThrow(() -> TokenInvalidException.EXCEPTION);

        return userDetails.getUsername();
    }
}