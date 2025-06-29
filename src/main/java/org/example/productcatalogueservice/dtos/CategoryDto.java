package org.example.productcatalogueservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogueservice.models.Product;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}
