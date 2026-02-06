package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<ErrorResponseDTO> handleIllegalStateException(IllegalStateException ex) {

    ErrorResponseDTO error = new ErrorResponseDTO(
        HttpStatus.NOT_FOUND.name(),
        ex.getMessage()
    );

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
