package com.lazylords.exceptions.handler;

import com.lazylords.exceptions.LazyLordsBaseException;
import com.lazylords.to.response.ErrorResponseTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(LazyLordsBaseException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorResponseTO handleExternalDatabaseException(LazyLordsBaseException e) {
        return new ErrorResponseTO("ERROR");
    }
}
