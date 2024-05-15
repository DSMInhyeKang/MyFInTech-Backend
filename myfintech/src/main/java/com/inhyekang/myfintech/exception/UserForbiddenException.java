package com.inhyekang.myfintech.exception;

import com.inhyekang.myfintech.error.BusinessException;
import com.inhyekang.myfintech.error.ErrorCode;

public class UserForbiddenException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserForbiddenException();
    public UserForbiddenException(){
        super(ErrorCode.USER_FORBIDDEN);
    }
}