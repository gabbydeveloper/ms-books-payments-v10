package com.msbookpaymentsv10.com.co.ms_books_payments_v10.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Se crea esta clase para realizar la configuración del WebCliente, para conectar con otros microservicios
 */

@Configuration
public class WebClientConfig {

  @Bean
  @LoadBalanced
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

}
