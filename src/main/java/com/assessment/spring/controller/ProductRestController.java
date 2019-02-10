package com.assessment.spring.controller;

import com.assessment.spring.dto.OrderDto;
import com.assessment.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Darrel Rayen on 2/11/19.
 */
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDto> addOrder(){
        return null;
    }
}
