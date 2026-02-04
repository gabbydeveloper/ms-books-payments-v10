package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.RespuestaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
  //Creación de la lista para el GET
  List<UsuarioDTO> listarUsuarios();
  //Declara el método para crear usuario
  void crearUsuario(UsuarioDTO usuarioDTO);
}
