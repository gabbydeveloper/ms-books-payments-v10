package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes;

import org.springframework.http.HttpStatus;

public enum MensajeRespuesta {

  // ÉXITO
  EXITO_REGISTRO_CREADO("Registro creado con éxito.", HttpStatus.CREATED),
  EXITO_REGISTRO_CONSULTADO("Registro consultado con éxito.", HttpStatus.OK),

  // ADVERTENCIAS / NEGOCIO
  ADVERTENCIA_REGISTRO_ID_NO_ENCONTRADO(
      "No se encontró el Registro con el Id proporcionado.",
      HttpStatus.NOT_FOUND
  ),
  ADVERTENCIA_REGISTRO_YA_EXISTE(
      "Id del Registro ya existe en Base de Datos.",
      HttpStatus.CONFLICT
  ),

  // ERRORES
  ERROR_REGISTRO_NO_ENCONTRADO(
      "Registro no encontrado.",
      HttpStatus.NOT_FOUND
  ),
  ERROR_NO_EXISTEN_REGISTROS(
      "No existen registros",
      HttpStatus.NOT_FOUND
  ),
  ERROR_STOCK_INSUFICIENTE(
      "Stock insuficiente o el producto no existe, verifique",
      HttpStatus.BAD_REQUEST
  ),
  ERROR_SISTEMA(
      "Error del sistema, contacte al administrador.",
      HttpStatus.INTERNAL_SERVER_ERROR
  );

  private final String mensaje;
  private final HttpStatus status;

  MensajeRespuesta(String mensaje, HttpStatus status) {
    this.mensaje = mensaje;
    this.status = status;
  }

  public String getMensaje() {
    return mensaje;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
