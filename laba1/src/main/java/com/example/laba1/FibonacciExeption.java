package com.example.laba1;
import org.springframework.http.HttpStatus;

public class FibonacciExeption extends Exception {
    private String exception;
    private HttpStatus status;

    public FibonacciExeption(String exception, HttpStatus status) {
        this.exception = exception;
        this.status = status;
    }

    public FibonacciExeption(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
