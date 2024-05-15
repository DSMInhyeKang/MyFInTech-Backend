package com.inhyekang.myfintech.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;

    private Integer status;

    private LocalDateTime timestamp;

    private String description;

    public static ErrorResponse of(ErrorCode errorCode, String description) {

        return ErrorResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatusCode())
                .timestamp(LocalDateTime.now())
                .description(description)
                .build();
    }
}