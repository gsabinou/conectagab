package com.aguiabranca.ConectaGab.advice;

import com.aguiabranca.ConectaGab.exceptions.GuidelineNotFoundException;
import com.aguiabranca.ConectaGab.exceptions.IdeaNotFoundException;
import com.aguiabranca.ConectaGab.exceptions.ProjectNotFoundException;
import com.aguiabranca.ConectaGab.exceptions.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {

        Map<String, String> errorMap = new HashMap<>();

        List<FieldError> camposErro = error.getBindingResult().getFieldErrors();

        for (FieldError campo : camposErro) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }

        return errorMap;

    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleIntegrityViolation() {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Algum dado inserido está inválido e/ou já foi cadastrado.");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleUserNotFound() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Usuário não encontrado");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdeaNotFoundException.class)
    public Map<String, String> handleIdeaNotFound() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Ideia não encontrada");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProjectNotFoundException.class)
    public Map<String, String> handleProjectNotFound() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Projeto não encontrado");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GuidelineNotFoundException.class)
    public Map<String, String> handleGuidelineNotFound() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Estratégia não encontrada");

        return errorMap;
    }

}
