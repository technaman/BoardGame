package com.ngdev.Games;

import com.ngdev.exceptions.ValidationException;

public class InvalidLocationException extends ValidationException {
    public InvalidLocationException(String s) {
        super(s);
    }
}
