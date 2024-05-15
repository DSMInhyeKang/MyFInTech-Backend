package com.inhyekang.myfintech.exception;

import com.inhyekang.myfintech.error.BusinessException;
import com.inhyekang.myfintech.error.ErrorCode;

public class UserAlreadyExistException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserAlreadyExistException();
    private UserAlreadyExistException(){
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}