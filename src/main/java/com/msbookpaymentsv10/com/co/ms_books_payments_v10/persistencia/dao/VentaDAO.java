package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.VentaDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaDAO {

    public Venta venta(VentaDTO ventaDTO){
        Venta venta = new Venta();
       venta.setIdVenta(ventaDTO.getIdVenta());
        venta.setIdUsuario(ventaDTO.getIdUsuario());
        venta.setNumeroOrden(ventaDTO.getNumeroOrden());
        venta.setFechaVenta(ventaDTO.getFechaVenta());
        venta.setPorcentajeDescuento(ventaDTO.getPorcentajeDescuento());
        venta.setCostoEnvio(ventaDTO.getCostoEnvio());
        venta.setEstadoVenta(ventaDTO.getEstadoVenta());

        return venta;
    }


    public VentaDTO ventaDTO(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setIdUsuario(venta.getIdUsuario());


        return ventaDTO;
    }
}
