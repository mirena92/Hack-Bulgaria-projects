package com.hackbulgaria.corejava;

public class EmptyMessageException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public EmptyMessageException() {
        super("The message is empty!");
    }
}
