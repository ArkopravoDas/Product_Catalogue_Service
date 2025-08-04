package org.example.productcatalogueservice.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogueservice.models.Category;
import org.example.productcatalogueservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;

//    @Test
//    @Transactional
    public void testLoading() {
        Optional<Category> categoryOptional = categoryRepo.findById(2L);
        for(Product p: categoryOptional.get().getProducts()) {
            System.out.println(p.getName());
        }
    }


//    @Test
//    @Transactional
    public void testNPlus1() {
        List<Category> categoryList = categoryRepo.findAll();
        for(Category category : categoryList) {
            for(Product product : category.getProducts()) {
                System.out.println(product.getName());
            }
        }
    }
}