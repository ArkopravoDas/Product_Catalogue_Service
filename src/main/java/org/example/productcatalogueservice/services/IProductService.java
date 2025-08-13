package org.example.productcatalogueservice.services;

import org.example.productcatalogueservice.models.Product;

import java.util.List;

//ProductContoller      ->  IProductService
//                      ->  fakestoreservice  ->   client   ->    external API (fakestoreapi)
//                      ->  storage service    ->  Jpa/Repo  ->   Storage (Mysql)


public interface IProductService {
    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(Product input, Long id);

    List<Product> getAllProducts();

    Product getProductDetailsBasedOnUserScope(Long userId,Long productId);
}
