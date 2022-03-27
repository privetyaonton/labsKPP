package com.example.laba1.controller;

import com.example.laba1.FibonacciExeption;
import com.example.laba1.Logic;
import com.example.laba1.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class Controller {
    private static final Logger ErrorLogger = LoggerFactory.getLogger(Controller.class);
    private Logic fibTemp = new Logic();
    @GetMapping("/")
    void error() throws Exception{
        ErrorLogger.info("Endpoint: /");
        ErrorLogger.info("Internal Server Error");
        throw new FibonacciExeption("Empty endpoint", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/fibonacci")
    int output (@RequestParam(value = "num", defaultValue = "0")int num) throws FibonacciExeption{
        ErrorLogger.info("Endpoint: /fibonacci");
        ErrorLogger.info("Request: " + num);
        if(num < 0 || num > 46){
            ErrorLogger.info("BAD REQUEST");
            throw new FibonacciExeption("Invalid data (0 <= num <= 46)", HttpStatus.BAD_REQUEST);
        }
        return fibTemp.getFibonacciNumber(num);
    }
    @ExceptionHandler (FibonacciExeption.class)
    public ResponseEntity handleException(FibonacciExeption temp){
        ErrorLogger.info("Exception: " + temp.getException());
        Response response = new Response(temp.getException());
        return new ResponseEntity<>(response, temp.getStatus());
    }
}


