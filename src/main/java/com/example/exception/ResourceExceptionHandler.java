package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceExceptionHandler extends Exception{
    private static final long serialVersionUID = -470180507998010368L;

    public ResourceExceptionHandler() {
        super();
    }

    public ResourceExceptionHandler(final String message) {

        super(message);
    }
}
