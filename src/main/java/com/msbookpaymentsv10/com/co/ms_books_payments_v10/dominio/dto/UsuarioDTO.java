package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioDTO {
  @Schema(description = "ID del usuario generado automáticamente", example = "1")
  private Long idUsuario;
  @Schema(description = "Correo que ingresa el usuario al registrarse", example = "gabby@gmail.com")
  private String correoUsuario;
  @Schema(description = "Clave del usuario")
  private String claveUsuario;
  @Schema(description = "Estado del usuario", example = "ACTIVO/INACTIVO")
  private String estadoUsuario;
}
