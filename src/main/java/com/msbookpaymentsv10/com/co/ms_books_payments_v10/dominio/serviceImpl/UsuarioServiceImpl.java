package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.RespuestaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.UsuarioService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.UsuarioDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Usuario;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
  public void crearUsuario(UsuarioDTO usuarioDTO) {
    usuarioRepository.save(usuarioDAO.usuario(usuarioDTO));
  }

}
