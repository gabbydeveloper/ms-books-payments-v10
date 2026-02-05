package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductoFacturadoDTO {
  @Schema(description = "ID generado automáticamente (NO ENVIAR)", example = "1")
  private Long idProductoFacturado;
  @Schema(description = "ID de la venta (tiene que existir una venta)", example = "1")
  private Long idVenta;
  @Schema(description = "ID del libro, compara con uno existente", example = "1")
  private Long idLibro;
  @Schema(description = "Cantidad de libros para comprar compara con stock", example = "1")
  private Integer cantidadItem;
  @Schema(description = "Precio unitario que trae de catalogue", example = "1")
  private double precioUnitarioLibro;
  @Schema(description = "Estado por default ACTIVO (NO ENVIAR)", example = "ACTIVO")
  private String estadoProductoFacturado;
}
