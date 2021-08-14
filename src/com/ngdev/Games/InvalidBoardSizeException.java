package com.ngdev.Games;

import com.ngdev.exceptions.ValidationException;

public class InvalidBoardSizeException extends ValidationException {
    public InvalidBoardSizeException(String s) {
        super(s);
    }
}
