package com.aguiabranca.ConectaGab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdeaNotFoundException extends RuntimeException {
    public IdeaNotFoundException(String message) {
        super(message);
    }
}
