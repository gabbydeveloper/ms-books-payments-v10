package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository <Venta, Long> {
    List<Venta> findByIdUsuario(Long idUsuario);
}
