package com.nttdata.bootcamp.web.common.app.exception;

public abstract class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public abstract Integer getCode();

    public abstract String getType();

    protected GlobalException(String message) {
        super(message);
    }
}
