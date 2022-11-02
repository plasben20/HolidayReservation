package com.hiberus.ms.app.item.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  private Long id;
  private String name;
  private Double price;
  private Date createdAt;
  private Integer port;
}
