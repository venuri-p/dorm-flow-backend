package com.dormflow.dorm_flow_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * Global interceptor class to handle exceptions across the entire application.
 * It catches specific exceptions and translates them into standard JSON ErrorResponse payloads.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Hook Binding 1: Handling Missing Records
     * Catches lookup anomalies when a student is not found.
     * Returns a 404 Not Found status with the standard error payload.
     */
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleStudentNotFoundException(StudentNotFoundException ex, HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    /**
     * Hook Binding 2: Handling Sequential Anomalies & Access Violations
     * Catches gate operational traffic errors like sequence violations and access rejections.
     * Returns a 400 Bad Request status with the standard error payload.
     */
    @ExceptionHandler(StateMachineException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleStateMachineException(StateMachineException ex, HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
    }
}
