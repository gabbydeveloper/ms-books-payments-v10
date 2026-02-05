package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.ProductoFacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoFacturadoController {

  @Autowired
  ProductoFacturadoService productoFacturadoService;

  @PostMapping("/productos")
  public ResponseEntity<ProductoFacturadoDTO> crearProducto(@RequestBody ProductoFacturadoDTO productoFacturadoDTO) {
    productoFacturadoService.crearProductoFacturado(productoFacturadoDTO);
    return ResponseEntity.ok(productoFacturadoDTO);
  }
}
