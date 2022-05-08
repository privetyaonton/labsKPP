package com.example.laba1.controller;

import com.example.laba1.FibonacciExeption;
import com.example.laba1.Logic;
import com.example.laba1.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import com.example.laba1.Count;
import java.util.List;
import java.util.LinkedList;

@RestController
public class Controller {
    private static final Logger ErrorLogger = LoggerFactory.getLogger(Controller.class);
    private Logic fibTemp = new Logic();
    private Count countTemp = new Count();
    @GetMapping("/")
    public void error() throws Exception{
        ErrorLogger.info("Endpoint: /");
        ErrorLogger.info("Internal Server Error");
        countTemp.incrementTemp();
        throw new FibonacciExeption("Empty endpoint", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/fibonacci")
    public int output (@RequestParam(value = "num", defaultValue = "0")int num) throws FibonacciExeption{
        ErrorLogger.info("Endpoint: /fibonacci");
        ErrorLogger.info("Request: " + num);
        if(num < 0 || num > 46) {
            ErrorLogger.info("BAD REQUEST");
            throw new FibonacciExeption("Invalid data (0 <= num <= 46)", HttpStatus.BAD_REQUEST);
        }
        countTemp.incrementTemp();
        ErrorLogger.info("Count - " + countTemp.getTemp());
        return fibTemp.getFibonacciNumber(num);
    }
    @RequestMapping (value = {"/calc"}, method = RequestMethod.POST)
    public List<Integer> calculateBulkParam (@RequestBody List<Integer> bodyList)
    {
        List<Integer> resultList = new LinkedList<>();
        bodyList.forEach((currentElement) -> {
            Logic logic = new Logic();
            resultList.add(logic.getFibonacciNumber(currentElement));
        });
        ErrorLogger.info("Succeful post-mapping");
        return resultList;
    }
    @ExceptionHandler (FibonacciExeption.class)
    public ResponseEntity handleException(FibonacciExeption temp){
        ErrorLogger.info("Exception: " + temp.getException());
        Response response = new Response(temp.getException());
        return new ResponseEntity<>(response, temp.getStatus());
    }
}


