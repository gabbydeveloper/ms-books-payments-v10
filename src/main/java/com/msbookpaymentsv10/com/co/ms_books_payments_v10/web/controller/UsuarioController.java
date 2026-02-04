package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
  @Autowired
  private UsuarioService usuarioService;

  @Operation(
      summary = "Obtener una lista de usuarios",
      description = "Devuelve todos los usuarios inscritos en la base de datos"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Lista todos los usuarios"),
      @ApiResponse(responseCode = "404", description = "Si no hay usuarios")
  })
  @GetMapping("/usuarios")
  public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){

    List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();

    if(usuarios.isEmpty()){ return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); }
    else{ return new ResponseEntity<>(usuarios, HttpStatus.OK); }

  }

  @Operation(
      summary = "Crea un usuario",
      description = "Crea el usuario con el cuerpo JSON enviado"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario creado")
  })
  @PostMapping("/usuarios")
  public ResponseEntity<Void> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
    usuarioService.crearUsuario(usuarioDTO);
    return ResponseEntity.ok().build();
  }
}
