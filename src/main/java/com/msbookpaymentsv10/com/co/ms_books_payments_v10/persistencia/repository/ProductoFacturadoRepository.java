package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.ProductoFacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoFacturadoRepository extends JpaRepository<ProductoFacturado, Long> {

  @Query(nativeQuery = true, value = "SELECT SUM(id_libro) FROM tbl_productos_facturados WHERE id_libro = :idLibro")
  Integer cuantosLibrosFacturadosXIdLibro(@Param("idLibro") Long idLibro);

}
