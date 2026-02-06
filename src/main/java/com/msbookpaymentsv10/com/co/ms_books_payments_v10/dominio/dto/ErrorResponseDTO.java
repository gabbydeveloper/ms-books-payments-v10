package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

public class ErrorResponseDTO {
  private String errorCode;
  private String errorMessage;

  public ErrorResponseDTO(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
