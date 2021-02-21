package com.org.sid.billingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
