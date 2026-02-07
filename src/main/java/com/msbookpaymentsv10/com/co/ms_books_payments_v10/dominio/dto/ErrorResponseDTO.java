package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
  private HttpStatus errorCode;
  private String errorMessage;

}
