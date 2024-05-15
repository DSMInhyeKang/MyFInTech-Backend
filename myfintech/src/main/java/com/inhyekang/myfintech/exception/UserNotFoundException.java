package com.inhyekang.myfintech.exception;

import com.inhyekang.myfintech.error.BusinessException;
import com.inhyekang.myfintech.error.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}