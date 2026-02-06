package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.ProductoFacturado;

import java.util.List;

public interface ProductoFacturadoService {
  void crearProductoFacturado(ProductoFacturadoDTO productoFacturadoDTO);
  void eliminarProductoFacturado(Long idProductoFacturado);
  Integer cuantosProductosFacturadosPorIdLibro(Long idLibro);
  List<ProductoFacturadoDTO> listaProductosFacturadosXIdVenta(Long idVenta);
}
