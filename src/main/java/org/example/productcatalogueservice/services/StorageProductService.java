package org.example.productcatalogueservice.services;

import org.example.productcatalogueservice.models.Product;
import org.example.productcatalogueservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()) return null;
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if(optionalProduct.isEmpty()) {
            return productRepo.save(product);
        }

        return optionalProduct.get();
    }

    @Override
    public Product replaceProduct(Product input, Long id) {
        input.setId(id);
        return productRepo.save(input);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
