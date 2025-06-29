package org.example.productcatalogueservice.controllers;

import org.example.productcatalogueservice.dtos.ProductDto;
import org.example.productcatalogueservice.models.Product;
import org.example.productcatalogueservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//@RestController = @Controller + @ResponseBody
// https://www.baeldung.com/spring-bean-scopes
@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
       return null;
    }

    //Read for @PathVariable , @RequestParam and @QueryParam
    //https://www.baeldung.com/spring-requestparam-vs-pathvariable
    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId) {
//        ProductDto productDto = new ProductDto();
//        productDto.setId(productId);
//        return productDto;
        return null;
    }

    @PostMapping("products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }
}
