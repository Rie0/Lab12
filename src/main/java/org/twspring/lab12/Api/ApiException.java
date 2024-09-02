package org.twspring.lab12.Api;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
