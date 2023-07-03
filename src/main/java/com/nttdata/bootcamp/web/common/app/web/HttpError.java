package com.nttdata.bootcamp.web.common.app.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HttpError {

    SUCCESS(1000, "Success"),
    ERROR(1002, "Error"),
    TECHNICAL(1004, "Technical"),
    FUNCTIONAL(1006, "Functional"),
    BUSINESS(1008, "Business");

    private final Integer code;
    private final String type;
}
