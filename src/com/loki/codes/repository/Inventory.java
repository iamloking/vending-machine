package com.loki.codes.repository;

import com.loki.codes.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> productMap = new HashMap<>();
    private final Map<String, Integer> stockMap = new HashMap<>();

    public void addProduct( Product product, int quantity) {
        productMap.put(product.getCode(), product);
        stockMap.put(product.getCode(), quantity);
    }

    public Product getProduct(String code) {
        return productMap.get(code);
    }

    public boolean isAvailable(String code) {
        return stockMap.getOrDefault(code, 0) > 0;
    }

    public void reduceStock(String code) {
        stockMap.put(code, stockMap.get(code) - 1);
    }
}