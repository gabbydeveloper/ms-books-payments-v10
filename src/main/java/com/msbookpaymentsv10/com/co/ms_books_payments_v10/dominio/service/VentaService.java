package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.RespuestaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;

public interface VentaService {
    RespuestaDTO registrarVenta(VentaDTO ventaDTO);
}
