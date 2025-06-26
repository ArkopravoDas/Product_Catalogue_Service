package org.example.productcatalogueservice.controllers;

import org.example.productcatalogueservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setPrice(1000D);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        return productList;
    }
}
