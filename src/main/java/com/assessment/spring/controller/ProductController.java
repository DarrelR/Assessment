package com.assessment.spring.controller;

import com.assessment.spring.model.Product;
import com.assessment.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Darrel Rayen on 2/9/19.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView getProductsList(ModelAndView modelAndView, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        modelAndView.setViewName("/product-list");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("actionUrl", "/products?");
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("productList", productService.findAllProducts(PageRequest.of(page - 1, 10)));
        return modelAndView;
    }
}
