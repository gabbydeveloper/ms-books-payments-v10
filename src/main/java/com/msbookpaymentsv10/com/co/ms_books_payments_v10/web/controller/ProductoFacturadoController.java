package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.UsuarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.ProductoFacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoFacturadoController {

  @Autowired
  ProductoFacturadoService productoFacturadoService;

  @GetMapping("/productos/facturados/{idLibro}")
  public Integer cuantosLibrosFacturados(@PathVariable Long idLibro) {
    return productoFacturadoService.cuantosProductosFacturadosPorIdLibro(idLibro);
  }

  @GetMapping("/productos/{idVenta}")
  public ResponseEntity<List<ProductoFacturadoDTO>> productosPorVenta(@PathVariable Long idVenta) {
    List<ProductoFacturadoDTO> productos = productoFacturadoService.listaProductosFacturadosXIdVenta(idVenta);

    if (productos.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return new ResponseEntity<>(productos, HttpStatus.OK);
    }
  }

  @PostMapping("/productos")
  public ResponseEntity<ProductoFacturadoDTO> crearProducto(@RequestBody ProductoFacturadoDTO productoFacturadoDTO) {
    ProductoFacturadoDTO nuevoProducto = productoFacturadoService.crearProductoFacturado(productoFacturadoDTO);
    return ResponseEntity.ok(nuevoProducto);
  }

  @DeleteMapping("/productos/{idProductoFacturado}")
  public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProductoFacturado) {
    try {
      productoFacturadoService.eliminarProductoFacturado(idProductoFacturado);
      return ResponseEntity.ok().build();
    } catch (IllegalStateException e) {
      return ResponseEntity.notFound().build();
    }
  }

}
