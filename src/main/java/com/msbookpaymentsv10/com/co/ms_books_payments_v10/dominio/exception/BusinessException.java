package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.exception;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes.MensajeRespuesta;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final MensajeRespuesta MensajeRespuesta;

  public BusinessException(MensajeRespuesta MensajeRespuesta) {
    super(MensajeRespuesta.getMensaje());
    this.MensajeRespuesta = MensajeRespuesta;
  }
}
