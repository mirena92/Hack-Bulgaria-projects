package com.hackbulgaria.corejava;

public class InvalidLevelException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public InvalidLevelException() {
        super("The level must be positive!");
    }
}
