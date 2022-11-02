package com.hiberus.ms.app.item.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.hiberus.ms.app.item.models.Item;
import com.hiberus.ms.app.item.models.Product;
import com.hiberus.ms.app.item.restclients.ProductRestClient;
import com.hiberus.ms.app.item.services.ItemService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("feign")
@AllArgsConstructor
@Slf4j
public class ItemServiceFeignImpl implements ItemService {

  private final ProductRestClient productRestClient;

  @Override
  public List<Item> findAll() {
    List<Product> productList = productRestClient.getAll();
    return productList.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
  }

  @Override
  //@HystrixCommand(fallbackMethod = "findByIdFallbackMethod")
  @CircuitBreaker(name="items", fallbackMethod = "findByIdFallbackMethod")
  public Item findById(Long id, Integer quantity) {
    return new Item(productRestClient.getById(id), quantity);
  }

  @Override
  public String getCircuitBreaker(String name) {
    return productRestClient.getCircuitBreaker(name);
  }

  @Override
  public Product save(Product product) {
    return productRestClient.createProduct(product);
  }

  @Override
  public Product update(Product product) {
    return productRestClient.updateProduct(product);
  }

  @Override
  public void delete(Long id) {
    productRestClient.deleteProduct(id);
  }

  private Item findByIdFallbackMethod(Long id, Integer quantity, Throwable exception) {
    log.error("Exception: {}", exception.getMessage());
    final Product product = new Product();
    product.setId(id);
    product.setName("Default product");
    product.setPrice(500.00);
    final Item item = new Item();
    item.setQuantity(quantity);
    item.setProduct(product);
    return item;
  }
}
