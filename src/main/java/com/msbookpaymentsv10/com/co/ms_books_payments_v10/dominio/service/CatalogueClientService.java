package com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.service;

import com.msbookpaymentsv10.com.co.ms_books_payments_v10.dominio.dto.KardexInventarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Se crea esta clase para la comunicación con el catalogue-service
 */
@Service
public class CatalogueClientService {

  private final WebClient webClient;

  public CatalogueClientService(WebClient.Builder builder) {
    this.webClient = builder.baseUrl("lb://catalogue-service").build();
  }

  public Integer getStock(Long idLibro) {
    return webClient.get()
        .uri("inventarios/stock/{id}", idLibro)
        .retrieve()
        .bodyToMono(Integer.class)
        .block();
  }

  public void registrarSalidaInventario(KardexInventarioDTO dto) {
    webClient.post()
        .uri("/inventarios/salida")
        .bodyValue(dto)
        .retrieve()
        .toBodilessEntity()
        .block();
  }

  public void registrarEntradaInventario(KardexInventarioDTO dto) {
    webClient.post()
        .uri("/inventarios/entrada")
        .bodyValue(dto)
        .retrieve()
        .toBodilessEntity()
        .block();
  }

}
