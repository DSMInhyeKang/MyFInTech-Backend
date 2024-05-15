package com.inhyekang.myfintech.exception;

import com.inhyekang.myfintech.error.BusinessException;
import com.inhyekang.myfintech.error.ErrorCode;

public class TokenInvalidException extends BusinessException {
    public static final BusinessException EXCEPTION = new TokenInvalidException();
    public TokenInvalidException(){
        super(ErrorCode.TOKEN_INVALID);
    }
}