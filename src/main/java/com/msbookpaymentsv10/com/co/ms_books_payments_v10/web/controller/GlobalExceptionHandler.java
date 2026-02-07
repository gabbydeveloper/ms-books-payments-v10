package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.exception.BusinessException;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes.MensajeRespuesta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponseDTO> handleBusiness(BusinessException ex) {

    MensajeRespuesta msg = ex.getMensajeRespuesta();

    ErrorResponseDTO error = new ErrorResponseDTO(
        msg.getStatus(),
        msg.getMensaje()
    );

    return new ResponseEntity<>(error, msg.getStatus());

  }
}
