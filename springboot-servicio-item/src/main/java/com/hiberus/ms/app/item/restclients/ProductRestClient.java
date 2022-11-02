package com.hiberus.ms.app.item.restclients;

import java.util.List;

import com.hiberus.ms.app.item.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Step1: @FeignClient(name = "product-service", url="localhost:8001")
//@FeignClient(name = "product-service")
@FeignClient(name = "servicio-productos") // Step 2: remove url when add Ribbon -> now LoadBalancer
//@FeignClient(name = "api-products") // Call through the gateway
public interface ProductRestClient {

  @GetMapping("/products")
  List<Product> getAll();

  @GetMapping("/products/{id}")
  Product getById(@PathVariable Long id);

  @GetMapping("/products/cb/{name}")
  String getCircuitBreaker(@PathVariable String name);

  @PostMapping("/products")
  Product createProduct(@RequestBody Product product);

  @PutMapping("/products")
  Product updateProduct(@RequestBody Product product);

  @DeleteMapping("/products/{id}")
  Product deleteProduct(@PathVariable Long id);
}
