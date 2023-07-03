package com.nttdata.bootcamp.web.common.app.exception;

import com.nttdata.bootcamp.web.common.app.web.HttpError;

public class TechnicalException extends GlobalException {

    public TechnicalException(String message) {
        super(message);
    }

    @Override
    public Integer getCode() {
        return HttpError.TECHNICAL.getCode();
    }

    @Override
    public String getType() {
        return HttpError.TECHNICAL.getType();
    }
}
