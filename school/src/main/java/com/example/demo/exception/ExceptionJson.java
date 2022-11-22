package com.example.demo.exception;

public class ExceptionJson {
    private String message;

    public ExceptionJson(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
