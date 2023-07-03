package com.nttdata.bootcamp.web.common.app.exception;

import com.nttdata.bootcamp.web.common.app.web.HttpError;

public class FunctionalException extends GlobalException {

    public FunctionalException(String message) {
        super(message);
    }

    @Override
    public Integer getCode() {
        return HttpError.FUNCTIONAL.getCode();
    }

    @Override
    public String getType() {
        return HttpError.FUNCTIONAL.getType();
    }
}
