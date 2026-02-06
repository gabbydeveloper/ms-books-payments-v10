package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.ProductoFacturado;
import org.springframework.stereotype.Component;

@Component
public class ProductoFacturadoDAO {

  //Este método es para guardar los datos. Se hace la conversión DTO → ENTITY
  public ProductoFacturado productoFacturado(ProductoFacturadoDTO productoFacturadoDTO){
    ProductoFacturado productoFacturado = new ProductoFacturado();
    //Reasigna columnas para conversion DTO → ENTITY
    productoFacturado.setIdProductoFacturado(productoFacturadoDTO.getIdProductoFacturado());
    productoFacturado.setIdLibro(productoFacturadoDTO.getIdLibro());
    /*TODO: Conectar con la cabecera de la venta, crear el ventaRepository en la clase

    Venta venta = ventaRepository.findById(productoFacturadoDTO.getIdVenta())
        .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

    productoFacturado.setIdVenta(venta);

    */
    productoFacturado.setIdVenta(productoFacturadoDTO.getIdVenta());
    productoFacturado.setCantidadItem(productoFacturadoDTO.getCantidadItem());
    productoFacturado.setPrecioUnitarioLibro(productoFacturadoDTO.getPrecioUnitarioLibro());
    productoFacturado.setEstadoProductoFacturado("ACTIVO");

    return productoFacturado;
  }

  //Este método es para presentar los datos. Se hace la conversión ENTITY → DTO
  public ProductoFacturadoDTO productoFactuado( ProductoFacturadoDTO productoFacturado){
    ProductoFacturadoDTO productoFacturadoDTO = new ProductoFacturadoDTO();
    //Reasigna columnas para conversión ENTITY → DTO
    productoFacturadoDTO.setIdProductoFacturado(productoFacturado.getIdProductoFacturado());
    productoFacturadoDTO.setIdLibro(productoFacturado.getIdLibro());
    productoFacturadoDTO.setIdVenta(productoFacturado.getIdVenta());
    productoFacturadoDTO.setCantidadItem(productoFacturado.getCantidadItem());
    productoFacturadoDTO.setPrecioUnitarioLibro(productoFacturado.getPrecioUnitarioLibro());
    productoFacturadoDTO.setEstadoProductoFacturado(productoFacturado.getEstadoProductoFacturado());

    return productoFacturadoDTO;
  }

}
