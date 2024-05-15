package com.inhyekang.myfintech.exception;

import com.inhyekang.myfintech.error.BusinessException;
import com.inhyekang.myfintech.error.ErrorCode;

public class TokenExpiredException extends BusinessException {
    public static final BusinessException EXCEPTION = new TokenExpiredException();
    public TokenExpiredException(){
        super(ErrorCode.TOKEN_EXPIRED);
    }
}