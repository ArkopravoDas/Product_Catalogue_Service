package org.example.productcatalogueservice.controllers;

import org.example.productcatalogueservice.dtos.SearchRequestDto;
import org.example.productcatalogueservice.models.Product;
import org.example.productcatalogueservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    public Page<Product> searchProduct(@RequestBody SearchRequestDto searchRequestDto) {
        return searchService.searchProducts(searchRequestDto.getQuery(), searchRequestDto.getPageSize(), searchRequestDto.getPageNumber(), searchRequestDto.getSortParams());
    }
}


/*
  Payload

  {
  "query" : "iphone",
   "pageSize" : 8,
   "pageNumber" : 0,
   "sortParams" : [
    {
       "sortCriteria" : "price",
       "sortType" : "DESC"
    },
    {
       "sortCriteria" : "id",
       "sortType" : "DESC"
    }
   ]
}
 */