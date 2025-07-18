package org.example.productcatalogueservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogueservice.dtos.ProductDto;
import org.example.productcatalogueservice.models.Product;
import org.example.productcatalogueservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGetAllProducts_RunSuccessfully() throws Exception {
        //Arrange
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Iphone24");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        when(productService.getAllProducts()).thenReturn(productList);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Iphone24");
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);


        String response = objectMapper.writeValueAsString(productDtos);
        System.out.println(response);


        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
                //response body == responsestring
    }

    @Test
    public  void testCreateProduct_RunSuccessfully() throws Exception {
        //Arrange
        Product product = new Product();
        product.setId(10L);
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ProductDto productDto = new ProductDto();
        productDto.setId(10L);

        String productDtoString = objectMapper.writeValueAsString(productDto);

        //Act and Assert
        mockMvc.perform(post("/products")
                        .content(productDtoString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(productDtoString));
    }
}
