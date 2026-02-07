package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.exception.BusinessException;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.Constantes.MensajeRespuesta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.VentaDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
  @Autowired
  private VentaRepository ventaRepository;

  @Autowired
  private VentaDAO ventaDAO;

  @Override
  public List<VentaDTO> listarVentasPorIdUsuario(Long idUsuario) {
    List<Venta> ventas = ventaRepository.findByIdUsuario(idUsuario);

    if(ventas.isEmpty()){
      throw new BusinessException(MensajeRespuesta.ERROR_NO_EXISTEN_REGISTROS);
    }

    return ventas.stream().map(ventaDAO::ventaDTO).toList();
  }

  @Override
  public VentaDTO crearVenta(VentaDTO ventaDTO) {
    Venta nuevaVenta = ventaRepository.save(ventaDAO.venta(ventaDTO));
    return ventaDAO.ventaDTO(nuevaVenta);
  }

  @Override
  public VentaDTO actualizarVenta(Long idVenta, VentaDTO ventaDTO) {
    Optional<Venta> ventaId = ventaRepository.findById(idVenta);

    if(ventaId.isEmpty()){
      throw new BusinessException(MensajeRespuesta.ERROR_REGISTRO_NO_ENCONTRADO);
    }

    Venta venta = ventaId.get();

    if(ventaDTO.getEstadoVenta() != null){
      venta.setEstadoVenta(ventaDTO.getEstadoVenta());
    }

    if(ventaDTO.getCostoEnvio() != venta.getCostoEnvio()){
      venta.setCostoEnvio(ventaDTO.getCostoEnvio());
    }

    if(ventaDTO.getPorcentajeDescuento() != venta.getPorcentajeDescuento()){
      venta.setPorcentajeDescuento(ventaDTO.getPorcentajeDescuento());
    }

    if(ventaDTO.getNumeroOrden() != null){
      venta.setNumeroOrden(ventaDTO.getNumeroOrden());
    }

    Venta ventaActualizada = ventaRepository.save(venta);

    return ventaDAO.ventaDTO(ventaActualizada);
  }
}
