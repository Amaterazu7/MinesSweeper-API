package com.exercice.minesweeper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MinesSweeperException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MinesSweeperException(String message) {
        super(message);
    }

    public MinesSweeperException(String message, Throwable cause) {
        super(message, cause);
    }
}
