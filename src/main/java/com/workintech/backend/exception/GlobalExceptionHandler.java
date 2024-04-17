package com.workintech.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonErrorResponse> handleException(CommonException commonException){
        log.error("CategoryException occured ! Exception details : " + commonException.getMessage());

        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(commonException.getHttpStatus().value(),
                commonException.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(commonErrorResponse, commonException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException (MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String, String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
        return new ResponseEntity(errorList , HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<CommonErrorResponse> handleException(Exception exception){
        log.error("GeneralException occured ! Exception details : " + exception.getMessage());

        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(commonErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
