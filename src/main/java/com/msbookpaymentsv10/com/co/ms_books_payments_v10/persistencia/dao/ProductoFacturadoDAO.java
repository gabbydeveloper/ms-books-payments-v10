package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.ProductoFacturado;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoFacturadoDAO {

  @Autowired
  private VentaRepository ventaRepository;

  //Este método es para guardar los datos. Se hace la conversión DTO → ENTITY
  public ProductoFacturado productoFacturado(ProductoFacturadoDTO productoFacturadoDTO){
    ProductoFacturado productoFacturado = new ProductoFacturado();
    //Reasigna columnas para conversion DTO → ENTITY
    productoFacturado.setIdProductoFacturado(productoFacturadoDTO.getIdProductoFacturado());
    productoFacturado.setIdLibro(productoFacturadoDTO.getIdLibro());

    Venta venta = ventaRepository.findById(productoFacturadoDTO.getIdVenta())
        .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

    productoFacturado.setVenta(venta);

    productoFacturado.setCantidadItem(productoFacturadoDTO.getCantidadItem());
    productoFacturado.setPrecioUnitarioLibro(productoFacturadoDTO.getPrecioUnitarioLibro());
    productoFacturado.setEstadoProductoFacturado("ACTIVO");

    return productoFacturado;
  }

  //Este método es para presentar los datos. Se hace la conversión ENTITY → DTO
  public ProductoFacturadoDTO productoFacturadoDTO(ProductoFacturado productoFacturado){
    ProductoFacturadoDTO productoFacturadoDTO = new ProductoFacturadoDTO();
    //Reasigna columnas para conversión ENTITY → DTO
    productoFacturadoDTO.setIdVenta(productoFacturado.getVenta().getIdVenta());
    productoFacturadoDTO.setIdProductoFacturado(productoFacturado.getIdProductoFacturado());
    productoFacturadoDTO.setIdLibro(productoFacturado.getIdLibro());
    productoFacturadoDTO.setCantidadItem(productoFacturado.getCantidadItem());
    productoFacturadoDTO.setPrecioUnitarioLibro(productoFacturado.getPrecioUnitarioLibro());
    productoFacturadoDTO.setEstadoProductoFacturado(productoFacturado.getEstadoProductoFacturado());

    return productoFacturadoDTO;
  }

}
