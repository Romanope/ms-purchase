package com.magazine.application.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponseDTO {

    private String message;
    private Integer errorCode;
}
