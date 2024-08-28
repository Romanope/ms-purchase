package com.magazine.application.common.exception;

import com.magazine.domain.common.exceptions.InvalidDataException;
import com.magazine.domain.common.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = { InvalidDataException.class })
    public ResponseEntity<ExceptionResponseDTO> handleMethodArgumentNotValidException(final InvalidDataException e) {
        log.error("error", e);

        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), BAD_REQUEST.value());

        return new ResponseEntity<>(exceptionResponse, BAD_REQUEST);
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<ExceptionResponseDTO> resourceNotFoundException(final ResourceNotFoundException e) {

        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), NOT_FOUND.value());

        return new ResponseEntity<>(exceptionResponse, NOT_FOUND);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ExceptionResponseDTO> handleRunTimeException(final Exception e) {
        log.error("an unhandled error occurred", e);

        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(exceptionResponse, INTERNAL_SERVER_ERROR);
    }
}
