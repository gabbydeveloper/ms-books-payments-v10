package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.ProductoFacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoFacturadoController {

  @Autowired
  ProductoFacturadoService productoFacturadoService;

  @GetMapping("/productos/facturados/{idLibro}")
  public Integer cuantosLibrosFacturados(@PathVariable Long idLibro){
    return productoFacturadoService.cuantosProductosFacturadosPorIdLibro(idLibro);
  }

  @PostMapping("/productos")
  public ResponseEntity<ProductoFacturadoDTO> crearProducto(@RequestBody ProductoFacturadoDTO productoFacturadoDTO) {
    productoFacturadoService.crearProductoFacturado(productoFacturadoDTO);
    return ResponseEntity.ok(productoFacturadoDTO);
  }

  @DeleteMapping("productos/{idProducto}")
  public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProductoFacturado) {
    try {
      productoFacturadoService.eliminarProductoFacturado(idProductoFacturado);
      return ResponseEntity.ok().build();
    } catch (IllegalStateException e) {
      return ResponseEntity.notFound().build();
    }
  }

}
