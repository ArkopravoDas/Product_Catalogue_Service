package org.example.productcatalogueservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;

    // Related to business
    private Boolean isPrimeSaleSpecific;
}
