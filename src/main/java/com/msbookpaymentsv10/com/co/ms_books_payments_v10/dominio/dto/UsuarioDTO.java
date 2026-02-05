package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioDTO {
  @Schema(description = "ID generado automáticamente (NO ENVIAR)", example = "1")
  private Long idUsuario;
  @Schema(description = "ID del rol del usuario (2 por default NO ENVIAR)", example = "2")
  private Long idRolUsuario;
  @Schema(description = "Correo que ingresa el usuario al registrarse", example = "gabby@gmail.com")
  private String correoUsuario;
  @Schema(description = "Clave generada automáticamente (NO ENVIAR)")
  private String claveUsuario;
  @Schema(description = "Estado del usuario (ACTIVO por default NO ENVIAR)", example = "ACTIVO/INACTIVO")
  private String estadoUsuario;
}
