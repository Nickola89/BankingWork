package com.example.bankingwork.exceptions;

public class NoSuchCustomerException extends RuntimeException{
    public NoSuchCustomerException(String message) {
        super(message);
    }
}
