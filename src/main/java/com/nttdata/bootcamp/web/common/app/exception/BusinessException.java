package com.nttdata.bootcamp.web.common.app.exception;

import com.nttdata.bootcamp.web.common.app.web.HttpError;

public class BusinessException extends GlobalException {

    public BusinessException(String message) {
        super(message);
    }

    @Override
    public Integer getCode() {
        return HttpError.BUSINESS.getCode();
    }

    @Override
    public String getType() {
        return HttpError.BUSINESS.getType();
    }
}
