package com.gmail.goyter012.geo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IpToLocationExceptionHandler {


    @ExceptionHandler(BadIpException.class)
    public ResponseEntity<Object> handleBadIp(BadIpException bIp){
        return ResponseEntity.badRequest().body(bIp.getMessage());

    }



}
