package com.nttdata.bootcamp.web.common.app.web;

import com.nttdata.bootcamp.web.common.app.dto.ResponseError;
import com.nttdata.bootcamp.web.common.app.exception.BusinessException;
import com.nttdata.bootcamp.web.common.app.exception.FunctionalException;
import com.nttdata.bootcamp.web.common.app.exception.GlobalException;
import com.nttdata.bootcamp.web.common.app.exception.TechnicalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({TechnicalException.class, FunctionalException.class, BusinessException.class})
    public ResponseEntity<ResponseError> exceptionHandler(GlobalException ex) {
        ResponseError responseError = new ResponseError();
        responseError.setMessage(ex.getMessage());
        responseError.setCode(ex.getCode());
        responseError.setType(ex.getType());
        return ResponseEntity.ok(responseError);
    }

}
