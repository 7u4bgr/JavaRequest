package com.example.sqldatabasenew.errormessage;

public class ErrorMessage  extends RuntimeException{
    public ErrorMessage(String message){
        super(message);
    }
}
