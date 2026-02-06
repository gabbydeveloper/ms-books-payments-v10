package com.msbookpaymentsv10.com.co.ms_books_payments_v10.web.controller;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping ("/ventas")
    public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO ventaDTO){
        try{
            ventaService.CrearVenta(ventaDTO);
            return ResponseEntity.ok(ventaDTO);
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().build();
        }
    }

    //LEER CONSULTA DE REGISTRO POR ID:
    @GetMapping("/ventas/{idUsuario}")//DECLARACIÓN DEL MAPEO DEL CRUD CONSULTAR REGISTRO.
    public ResponseEntity<List<VentaDTO>> listarVentasByIdUsuario(@PathVariable Long idUsuario){
        List<VentaDTO> ventas =  ventaService.listarVentasPorIdUsuario(idUsuario);
        if(ventas.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

}
