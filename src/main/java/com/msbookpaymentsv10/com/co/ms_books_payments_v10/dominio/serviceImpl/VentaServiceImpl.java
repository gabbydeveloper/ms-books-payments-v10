package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.RespuestaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.VentaDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaDAO ventaDAO; // Tu convertidor

    @Override

    public RespuestaDTO registrarVenta(VentaDTO ventaDTO) {



        return null;
    }
}
