package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.ProductoFacturadoService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.ProductoFacturadoDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.ProductoFacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoFacturadoServiceImpl implements ProductoFacturadoService {

  @Autowired
  private ProductoFacturadoDAO productoFacturadoDAO;

  @Autowired
  private ProductoFacturadoRepository productoFacturadoRepository;

  @Override
  public void crearProductoFacturado(ProductoFacturadoDTO productoFacturadoDTO) {
    productoFacturadoRepository.save(productoFacturadoDAO.productoFacturado(productoFacturadoDTO));
  }
}
