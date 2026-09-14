package com.gupta.learningmvcarchitectureofspringboot.advice;

import com.gupta.learningmvcarchitectureofspringboot.Exception.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleException(ResourceNotFoundException exp){
        ApiError apierror= ApiError.builder().
                status(HttpStatus.NOT_FOUND)
                .message(exp.getMessage())
                .build();
        return builderrormessage(apierror);
    }

    private ResponseEntity<ApiResponse<?>> builderrormessage(ApiError apierror) {

        return new ResponseEntity<>(new ApiResponse<>(apierror),apierror.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception exp){


        ApiError apierror=ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exp.getMessage())
                .build();

        return new ResponseEntity<>(apierror,HttpStatus.INTERNAL_SERVER_ERROR);
    }

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleinputvalidationError(MethodArgumentNotValidException exp) {

       List<String> errors= exp.getBindingResult()
                               .getAllErrors()
                               .stream()
                               .map(DefaultMessageSourceResolvable::getDefaultMessage)
                               .toList();

       ApiError apierror=ApiError.builder()
                                 .status(HttpStatus.BAD_REQUEST)
                                 .message(errors.toString())
                                 .build();

       return new ResponseEntity<>(apierror,HttpStatus.BAD_REQUEST);
   }

   }

