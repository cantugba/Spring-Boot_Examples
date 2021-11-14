package com.sprinBootExamples.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String param) {
        super(param);
    }
}
