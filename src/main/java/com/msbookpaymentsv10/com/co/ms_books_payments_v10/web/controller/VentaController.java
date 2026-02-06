package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping ("/ventas")
    public ResponseEntity<Void> crearVenta(@RequestBody VentaDTO ventaDTO){
        try{
            ventaService.CrearVenta(ventaDTO);
            return ResponseEntity.ok().build();
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().build();
        }
    }

    //LEER CONSULTA DE REGISTRO POR ID:
    @GetMapping("/ventasbyId/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD CONSULTAR REGISTRO.
    public ResponseEntity<Void> listarVentasByIdUsuario(@PathVariable Long idUsuario){
        try{
            ventaService.listarVentasPorIdUsuario(idUsuario);
            return ResponseEntity.ok().build();
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
