package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class VentaDTO {
    @Schema(description = "ID generado automáticamente (NO ENVIAR)", example = "1")
    private Long idVenta;
    @Schema(description = "ID del usuario", example = "2")
    private Long idUsuario;
    @Schema(description = "Numero de orden", example = "4")
    private String numeroOrden;
    @Schema(description = "Fecha y hora en que realiza la venta", example ="2026-02-05T15:17:00")
    private LocalDateTime fechaVenta;
    @Schema(description = "Porcentaje de descuento de la venta", example = "0,1")
    private double porcentajeDescuento;
    @Schema(description = "Costo de envio de la venta", example = "5,00")
    private double costoEnvio;
    @Schema(description = "Estado de la venta (INGRESADA por default)", example = "INGRESADA/PAGADA/ANULADA")
    private String estadoVenta;


}
