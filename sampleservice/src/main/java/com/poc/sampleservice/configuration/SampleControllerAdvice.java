package com.poc.sampleservice.configuration;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.poc.sampleservice.model.ErrorMessage;
import com.poc.sampleservice.model.SampleNotFoundException;

@ControllerAdvice
@ResponseBody
public class SampleControllerAdvice {

    @ExceptionHandler(SampleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorMessage sampleNotFoundHandler(SampleNotFoundException ex, WebRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
    }

}
