package com.hiberus.ms.app.item.services;

import java.util.List;

import com.hiberus.ms.app.item.models.Item;
import com.hiberus.ms.app.item.models.Product;

public interface ItemService {

  public List<Item> findAll();

  public Item findById(Long id, Integer quantity);

  public String getCircuitBreaker(String name);

  public Product save(Product product);

  public Product update(Product product);

  public void delete(Long id);
}
