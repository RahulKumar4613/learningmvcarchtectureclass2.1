package com.gupta.learningmvcarchitectureofspringboot.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
