package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
  @Autowired
  private VentaService ventaService;

  @PostMapping
  public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO ventaDTO) {
    VentaDTO nuevaVenta = ventaService.crearVenta(ventaDTO);
    return ResponseEntity.ok(nuevaVenta);
  }

  @GetMapping("/usuario/{idUsuario}")
  public ResponseEntity<List<VentaDTO>> listarVentasByIdUsuario(@PathVariable Long idUsuario) {
    List<VentaDTO> ventas = ventaService.listarVentasPorIdUsuario(idUsuario);
    return new ResponseEntity<>(ventas, HttpStatus.OK);
  }

  @PatchMapping("/{idVenta}")
  public ResponseEntity<VentaDTO> actualizarVenta(@PathVariable Long idVenta, @RequestBody VentaDTO ventaDTO) {
    VentaDTO ventaActualizada = ventaService.actualizarVenta(idVenta, ventaDTO);
    return ResponseEntity.ok(ventaActualizada);
  }


}
