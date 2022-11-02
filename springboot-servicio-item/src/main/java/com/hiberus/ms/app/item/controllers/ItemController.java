package com.hiberus.ms.app.item.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hiberus.ms.app.item.config.TextConfiguration;
import com.hiberus.ms.app.item.models.Item;
import com.hiberus.ms.app.item.models.Product;
import com.hiberus.ms.app.item.services.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
@Slf4j
public class ItemController {

  private final static String CLIENT = "feign";

  private final Map<String, ItemService> itemServiceMap;
  private final TextConfiguration textConfiguration;

  @GetMapping
  public List<Item> getItems() {
    log.info("Get All Items");
    return itemServiceMap.get("feign").findAll();
  }

  @GetMapping("/{id}/quantity/{quantity}")
  public Item findById(@PathVariable Long id, @PathVariable Integer quantity) {
    log.info("GET item {} with quantity {}.", id, quantity);
    return itemServiceMap.get(CLIENT).findById(id, quantity);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product) {
    return itemServiceMap.get(CLIENT).save(product);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product updateProduct(@RequestBody Product product) {
    return itemServiceMap.get(CLIENT).update(product);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProduct(@PathVariable Long id) {
    itemServiceMap.get(CLIENT).delete(id);
  }

  @GetMapping("/config")
  public ResponseEntity<Map<String, String>> getConfig() {
    final Map<String, String> map = new HashMap<>();
    map.put("textOne", textConfiguration.getTextOne());
    map.put("textTwo", textConfiguration.getTextTwo());
    map.put("textThree", textConfiguration.getTextThree());
    log.info("Configuration Map: {}", map);
    return new ResponseEntity<>(map, HttpStatus.OK);
  }
}
