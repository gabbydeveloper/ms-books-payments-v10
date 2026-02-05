package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.SalidaInventarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.CatalogueClientService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.ProductoFacturadoService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.ProductoFacturadoDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.ProductoFacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductoFacturadoServiceImpl implements ProductoFacturadoService {

  @Autowired
  private ProductoFacturadoDAO productoFacturadoDAO;

  @Autowired
  private ProductoFacturadoRepository productoFacturadoRepository;

  @Autowired
  private CatalogueClientService catalogueClientService;

  @Override
  public void crearProductoFacturado(ProductoFacturadoDTO productoFacturadoDTO) {
    Long idLibro = productoFacturadoDTO.getIdLibro();
    Integer cantidad = productoFacturadoDTO.getCantidadItem();

    //Revisa el catalogue para traer el stock
    Integer stock = catalogueClientService.getStock(idLibro);

    System.out.println("Stock disponible: " + stock);

    if (stock == null || stock < cantidad) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Stock insuficiente. Disponible: " + stock
      );
    }

    //Registra el producto facturado
    productoFacturadoRepository.save(productoFacturadoDAO.productoFacturado(productoFacturadoDTO));

    //Registra la salida del inventario
    SalidaInventarioDTO salidaDTO = new SalidaInventarioDTO();
    salidaDTO.setIdLibro(idLibro);
    salidaDTO.setCantidadInventario(cantidad);
    catalogueClientService.registrarSalidaInventario(salidaDTO);

  }
}
