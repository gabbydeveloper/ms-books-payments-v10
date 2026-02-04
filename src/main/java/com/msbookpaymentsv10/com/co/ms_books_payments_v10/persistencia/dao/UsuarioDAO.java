package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDAO {

  public Usuario usuario(UsuarioDTO usuarioDTO){
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(usuarioDTO.getIdUsuario());
    usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
    usuario.setClaveUsuario(usuarioDTO.getClaveUsuario());
    usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
    return usuario;
  }

  public UsuarioDTO usuarioDTO(Usuario usuario){
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setIdUsuario(usuario.getIdUsuario());
    usuarioDTO.setCorreoUsuario(usuario.getCorreoUsuario());
    usuarioDTO.setClaveUsuario(usuario.getClaveUsuario());
    usuarioDTO.setEstadoUsuario(usuario.getEstadoUsuario());

    return  usuarioDTO;
  }

}
