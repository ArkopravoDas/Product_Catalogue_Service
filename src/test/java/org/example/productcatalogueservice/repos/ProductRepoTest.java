package org.example.productcatalogueservice.repos;

import org.example.productcatalogueservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void  testQueries() {
//        List<Product> productList = productRepo.findProductByPriceBetween(10D, 10000D);
//        List<Product> productList = productRepo.findAllByOrderByPrice();
//        for(Product product : productList) {
//            System.out.println(product.getPrice());
//        }
        System.out.println(productRepo.getMeNameOfMyFavouriteProductWhoseIdIWillGiveYou(2L));
    }
}