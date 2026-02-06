package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="TBL_VENTAS")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VENTA")
    private Long idVenta;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name="NUMERO_ORDEN", nullable = false)
    private String numeroOrden;

    @Column(name="FECHA_VENTA", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name="PORCENTAJE_DESCUENTO", nullable = false)
    private Double porcentajeDescuento;

    @Column(name="COSTO_ENVIO", nullable = false)
    private Double costoEnvio;

    @Column(name="ESTADO_VENTA", nullable = false)
    private String estadoVenta;
}

