package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.UsuarioService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.UsuarioDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Usuario;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
  @Autowired
  private UsuarioDAO usuarioDAO;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public List<UsuarioDTO> listarUsuarios() {
    List<Usuario> usuarios = usuarioRepository.findAll();
    return usuarios.stream().map(usuarioDAO::usuarioDTO).toList();
  }

  @Override
  public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {

    Usuario nuevoUsuario = usuarioRepository.save(usuarioDAO.usuario(usuarioDTO));

    return usuarioDAO.usuarioDTO(nuevoUsuario);
  }

  @Override
  public void eliminarUsuario(Long idUsuario) {
    Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);
    if (usuarioId.isEmpty()) {
      throw new IllegalStateException("Usuario no existe");
    }
    usuarioRepository.delete(usuarioId.get());
  }

  @Override
  public UsuarioDTO consultarUsuarioPorId(Long idUsuario) {
    Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
    if (usuario.isEmpty()) {
      throw new IllegalStateException("Usuario no existe");
    }
    return usuarioDAO.usuarioDTO(usuario.get());
  }

  @Override
  public UsuarioDTO actualizarUsuarioParcial(long idUsuario, UsuarioDTO usuarioDTO) {
    Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);

    if (usuarioId.isEmpty()) {
      throw new IllegalStateException("Usuario no existe");
    }

    Usuario usuario = usuarioId.get();

    if (usuarioDTO.getCorreoUsuario() != null) {
      usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
    }

    if (usuarioDTO.getIdRolUsuario() != null) {
      usuario.setIdRolUsuario(usuarioDTO.getIdRolUsuario());
    }

    if (usuarioDTO.getEstadoUsuario() != null) {
      usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
    }

    if (usuarioDTO.getClaveUsuario() != null) {
      usuario.setClaveUsuario(usuarioDTO.getClaveUsuario());
    }

    Usuario usuarioActualizado = usuarioRepository.save(usuario);

    return usuarioDAO.usuarioDTO(usuarioActualizado);
  }

  @Override
  public UsuarioDTO actualizarUsuario(Long idUsuario, UsuarioDTO usuarioDTO) {
    Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);

    if (usuarioId.isEmpty()) {
      throw new IllegalStateException("Usuario no existe");
    }

    Usuario usuario = usuarioId.get();

    usuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
    usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
    usuario.setIdRolUsuario(usuarioDTO.getIdRolUsuario());

    Usuario usuarioActualizado = usuarioRepository.save(usuario);

    return usuarioDAO.usuarioDTO(usuarioActualizado);
  }


}
