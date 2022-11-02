package com.hiberus.ms.app.item.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.hiberus.ms.app.item.models.Item;
import com.hiberus.ms.app.item.models.Product;
import com.hiberus.ms.app.item.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("rest")
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

  private static final String PRODUCT_SERVICE_URL = "http://product-service/products";
  private final RestTemplate restTemplate;

  @Override
  public List<Item> findAll() {
    List<Product> productList =
        List.of(
            Objects.requireNonNull(
                restTemplate.getForObject(PRODUCT_SERVICE_URL, Product[].class)));

    return productList.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("id", id.toString());
    Product product =
        restTemplate.getForObject(PRODUCT_SERVICE_URL + "/{id}", Product.class, pathVariables);
    return new Item(product, quantity);
  }

  @Override
  public String getCircuitBreaker(String name) {
    return null;
  }

  @Override
  public Product save(Product product) {
    final HttpEntity<Product> body = new HttpEntity<>(product);
    final ResponseEntity<Product> responseEntity =
        restTemplate.exchange(PRODUCT_SERVICE_URL, HttpMethod.POST, body, Product.class);
    return responseEntity.getBody();
  }

  @Override
  public Product update(Product product) {
    final HttpEntity<Product> body = new HttpEntity<>(product);
    final ResponseEntity<Product> responseEntity =
        restTemplate.exchange(PRODUCT_SERVICE_URL, HttpMethod.PUT, body, Product.class);
    return responseEntity.getBody();
  }

  @Override
  public void delete(Long id) {
    Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("id", id.toString());
    restTemplate.delete(PRODUCT_SERVICE_URL + "/{id}", Product.class, pathVariables);
  }
}
