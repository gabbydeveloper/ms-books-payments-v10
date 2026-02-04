package com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
