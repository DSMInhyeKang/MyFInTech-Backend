package com.inhyekang.myfintech.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // request
    INVALID_PARAMETER(400, "Invalid Parameter"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    // token
    TOKEN_EXPIRED(401 , "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),

    // user
    USER_NOT_FOUND(404,"User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists"),
    USER_FORBIDDEN(403, "User Forbidden"),

    // server
    INTERNAL_SERVER_ERROR(500,"Internal Server Error");

    private final int statusCode;
    private final String message;
}