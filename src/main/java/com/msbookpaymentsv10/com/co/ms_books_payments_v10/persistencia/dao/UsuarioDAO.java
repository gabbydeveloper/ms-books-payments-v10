package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Usuario;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.utils.PasswordGenerator;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDAO {

  //Este método es para guardar los datos. Se hace la conversión DTO → ENTITY
  public Usuario usuario(UsuarioDTO usuarioDTO){
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(usuarioDTO.getIdUsuario());
    //Por default va el ROL 2 que es el de usuario que ingresa a la plataforma
    usuario.setIdRolUsuario(2L);
    usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());

    String claveGenerada = PasswordGenerator.generateRandomPassword();

    usuario.setClaveUsuario(claveGenerada);
    usuario.setEstadoUsuario("ACTIVO");

    return usuario;
  }

  //Este método es para presentar los datos. Se hace la conversión ENTITY → DTO
  public UsuarioDTO usuarioDTO(Usuario usuario){
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setIdUsuario(usuario.getIdUsuario());
    usuarioDTO.setIdRolUsuario(usuario.getIdRolUsuario());
    usuarioDTO.setCorreoUsuario(usuario.getCorreoUsuario());
    usuarioDTO.setClaveUsuario(usuario.getClaveUsuario());
    usuarioDTO.setEstadoUsuario(usuario.getEstadoUsuario());

    return  usuarioDTO;
  }

}
