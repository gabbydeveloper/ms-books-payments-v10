package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_PRODUCTOS_FACTURADOS")
public class ProductoFacturado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_PRODUCTO_FACTURADO")
  private Long idProductoFacturado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_VENTA", nullable = false)
  private Venta venta;

  @Column(name="ID_LIBRO")
  private Long idLibro;

  @Column(name="CANTIDAD_ITEM")
  private Integer cantidadItem;

  @Column(name="PRECIO_UNITARIO_LIBRO")
  private double precioUnitarioLibro;

  @Column(name="ESTADO_PRODUCTO_FACTURADO")
  private String estadoProductoFacturado;

}
