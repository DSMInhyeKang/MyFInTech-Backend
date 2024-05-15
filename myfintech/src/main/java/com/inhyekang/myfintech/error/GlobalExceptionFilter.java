package com.inhyekang.myfintech.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class GlobalExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e){

            ErrorCode errorCode = e.getErrorCode();

            response.setStatus(errorCode.getStatusCode());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ErrorResponse errorResponse = ErrorResponse.of(errorCode, errorCode.getMessage());
            objectMapper.writeValue(response.getWriter(), errorResponse);
        }
    }
}