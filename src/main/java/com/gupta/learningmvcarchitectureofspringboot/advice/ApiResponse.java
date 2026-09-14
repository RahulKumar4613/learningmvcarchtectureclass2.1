package com.gupta.learningmvcarchitectureofspringboot.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T>{

    private LocalDateTime timestamp;
    private T result;
    private ApiError apierror;

    public ApiResponse(){
        this.timestamp=LocalDateTime.now();
    }

    public ApiResponse(T result){
        this();
        this.result=result;
    }

    public ApiResponse(ApiError apierror)
    {
          this();
          this.apierror=apierror;
    }
}
