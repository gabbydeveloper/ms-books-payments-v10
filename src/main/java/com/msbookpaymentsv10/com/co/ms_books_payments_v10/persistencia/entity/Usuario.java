package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="TBL_USUARIOS")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_USUARIO")
  private Long idUsuario;

  @Column(name="CORREO_USUARIO")
  private String correoUsuario;

  @Column(name="CLAVE_USUARIO")
  private String claveUsuario;

  @Column(name="ESTADO_USUARIO")
  private String estadoUsuario;

}
