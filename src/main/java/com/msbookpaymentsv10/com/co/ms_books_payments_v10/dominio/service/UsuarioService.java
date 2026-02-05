package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.RespuestaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
  //Creación de la lista para el GET
  List<UsuarioDTO> listarUsuarios();
  //Declara el método para crear usuario
  void crearUsuario(UsuarioDTO usuarioDTO);
  //Declara el método para eliminar usuario
  void eliminarUsuario(Long idUsuario);
  //Método que consulta un usuario por ID
  UsuarioDTO consultarUsuarioPorId(Long idUsuario);
  //Método para actualizar un usuario parcialmente por su ID
  UsuarioDTO actualizarUsuarioParcial(long idUsuario, UsuarioDTO usuarioDTO);
  //Método para actualizar todos los datos del usuario
  UsuarioDTO actualizarUsuario(Long idUsuario, UsuarioDTO usuarioDTO);
}
