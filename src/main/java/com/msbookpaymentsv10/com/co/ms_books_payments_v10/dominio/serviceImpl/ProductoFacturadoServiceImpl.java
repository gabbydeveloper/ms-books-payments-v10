package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.serviceImpl;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.ProductoFacturadoDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.KardexInventarioDTO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.CatalogueClientService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service.ProductoFacturadoService;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.dao.ProductoFacturadoDAO;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.entity.ProductoFacturado;
import com.msbookpaymentsv10.com.co.ms_books_payments_v10.persistencia.repository.ProductoFacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    if (stock == null || stock < cantidad) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Stock insuficiente. Disponible: " + stock
      );
    }

    //Registra el producto facturado
    productoFacturadoRepository.save(productoFacturadoDAO.productoFacturado(productoFacturadoDTO));

    //Registra la salida del inventario
    KardexInventarioDTO salidaDTO = new KardexInventarioDTO();
    salidaDTO.setIdLibro(idLibro);
    salidaDTO.setCantidadInventario(cantidad);
    catalogueClientService.registrarSalidaInventario(salidaDTO);

  }

  @Override
  public void eliminarProductoFacturado(Long idProductoFacturado) {

    Optional<ProductoFacturado> productoFacturado = productoFacturadoRepository.findById(idProductoFacturado);

    if(productoFacturado.isEmpty())
    {
      throw new IllegalStateException("El detalle no existe");
    }

    Long idLibro = productoFacturado.get().getIdLibro();
    Integer cantidad = productoFacturado.get().getCantidadItem();

    productoFacturadoRepository.deleteById(idProductoFacturado);

    //Registra la entrada del inventario
    KardexInventarioDTO entradaDTO = new KardexInventarioDTO();
    entradaDTO.setIdLibro(idLibro);
    entradaDTO.setCantidadInventario(cantidad);
    catalogueClientService.registrarEntradaInventario(entradaDTO);
  }

  @Override
  public Integer cuantosProductosFacturadosPorIdLibro(Long idLibro) {
    return productoFacturadoRepository.cuantosLibrosFacturadosXIdLibro(idLibro);
  }

  @Override
  public List<ProductoFacturadoDTO> listaProductosFacturadosXIdVenta(Long idVenta) {
    List<ProductoFacturado> productos = productoFacturadoRepository.productosPorIdVenta(idVenta);
    return productos.stream().map(productoFacturadoDAO::productoFacturadoDTO).toList();
  }

}
