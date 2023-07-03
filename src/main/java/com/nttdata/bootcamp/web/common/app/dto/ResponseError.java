package com.nttdata.bootcamp.web.common.app.dto;

import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ResponseError implements Serializable {
    private static final long serialVersionUID = 747059752821306879L;
    @Setter
    private String message;
    @Setter
    private String type;
    @Setter
    private Integer code;
    private OffsetDateTime timestamp = OffsetDateTime.now();
}
