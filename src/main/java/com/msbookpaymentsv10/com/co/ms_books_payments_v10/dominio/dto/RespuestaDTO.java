package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import lombok.Data;
import java.util.List;

@Data
public class RespuestaDTO {

  private UsuarioDTO usuarioDTO;
  private List<UsuarioDTO> usuariosDTO;

  public RespuestaDTO() {
  }
}
