package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
      summary = "Presenta datos de un usuario",
      description = "Devuelve todos los datos de un usuario dado su código"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @GetMapping("/usuarios/{idUsuario}")
  public ResponseEntity<UsuarioDTO> consultarUsuarioPorId(@PathVariable Long idUsuario){
    try{
      UsuarioDTO usuarioDTO = usuarioService.consultarUsuarioPorId(idUsuario);
      return ResponseEntity.ok(usuarioDTO);
    }catch (IllegalStateException e){
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(
      summary = "Crea un usuario",
      description = "Crea el usuario con el cuerpo JSON enviado"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario creado"),
      @ApiResponse(responseCode = "400", description = "Parámetros inválidos")
  })
  @PostMapping("/usuarios")
  public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
    try{
      UsuarioDTO nuevoUsuario = usuarioService.crearUsuario(usuarioDTO);
      return ResponseEntity.ok(nuevoUsuario);
    }catch (IllegalStateException e){
      return ResponseEntity.badRequest().build();
    }
  }

  @Operation(
      summary = "Elimina un usuario",
      description = "Elimina los datos de un usuario dado su código"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario eliminado"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @DeleteMapping("/usuarios/{idUsuario}")
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Long idUsuario){
    try {
      usuarioService.eliminarUsuario(idUsuario);
      return ResponseEntity.ok().build();
    }catch (IllegalStateException e){
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(
      summary = "Actualización parcial de usuarios",
      description = "Actualiza uno o varios campos de un usuario dado su código"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @PatchMapping("/usuarios/{idUsuario}")
  public ResponseEntity<UsuarioDTO> actualizarUsuarioParcial(
      @PathVariable Long idUsuario,
      @RequestBody UsuarioDTO usuarioDTO) {
    try {
      UsuarioDTO usuarioActualizado =
          usuarioService.actualizarUsuarioParcial(idUsuario, usuarioDTO);
      return ResponseEntity.ok(usuarioActualizado);
    }catch (IllegalStateException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @Operation(
      summary = "Actualización de usuarios",
      description = "Actualiza todos los campos de un usuario dado su código, es obligatorio mandr todos los datos"
  )
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
      @ApiResponse(responseCode = "400", description = "Estructura mal formada o faltan datos"),
      @ApiResponse(responseCode = "404", description = "Usuario no existe")
  })
  @PutMapping("/usuarios/{idUsuario}")
  public ResponseEntity<UsuarioDTO> actualizarUsuario(
      @PathVariable Long idUsuario,
      @RequestBody UsuarioDTO usuarioDTO) {
    try {
      UsuarioDTO usuarioActualizado =
          usuarioService.actualizarUsuario(idUsuario, usuarioDTO);
      return ResponseEntity.ok(usuarioActualizado);
    }catch (IllegalStateException e){
      return ResponseEntity.notFound().build();
    }

  }
}
