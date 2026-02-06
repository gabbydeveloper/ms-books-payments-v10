package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.RespuestaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;

import java.util.List;

public interface VentaService {
  List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario);
  VentaDTO CrearVenta(VentaDTO ventaDTO);
}
