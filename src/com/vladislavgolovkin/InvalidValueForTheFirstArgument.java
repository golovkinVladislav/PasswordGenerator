package com.vladislavgolovkin;

public class InvalidValueForTheFirstArgument extends RuntimeException{
    public InvalidValueForTheFirstArgument(String message) {
        super(message);
    }
}
