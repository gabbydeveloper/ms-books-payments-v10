package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.VentaDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaDAO ventaDAO;

    @Override
    public List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario) {
        List<Venta> ventas = ventaRepository.findByIdUsuario(idUsuario);
        return ventas.stream().map(ventaDAO::ventaDTO).toList();
    }

    @Override
    public VentaDTO CrearVenta(VentaDTO ventaDTO) {
      Venta nuevaVenta = ventaRepository.save(ventaDAO.venta(ventaDTO));
      return ventaDAO.ventaDTO(nuevaVenta);
    }
}
