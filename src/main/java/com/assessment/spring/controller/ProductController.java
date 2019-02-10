package com.assessment.spring.controller;

import com.assessment.spring.dto.ProductDto;
import com.assessment.spring.model.Product;
import com.assessment.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darrel Rayen on 2/9/19.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private List<ProductDto> productList = new ArrayList<>();
    private String priceLable = "$ 0:00";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView getProductsList(ModelAndView modelAndView, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        modelAndView.setViewName("/product-list");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("addedProductList", productList);
        modelAndView.addObject("actionUrl", "/products?");
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("priceLable", priceLable);
        modelAndView.addObject("productList", productService.findAllProducts(PageRequest.of(page - 1, 50)));
        return modelAndView;
    }

/*    @GetMapping("/add/{id}")
    public ModelAndView addProductToList(@PathVariable("id") Integer id) {
        ProductDto productDto = productService.findOne(id);
        productList.add(productDto);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeOrderFromList(@PathVariable("id") Integer id) {
        ProductDto productDto = productService.findOne(id);
        productList.remove(productDto);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/calculate")
    public ModelAndView calculate() {
        double price = 0;
        for (ProductDto productDto : productList) {
            price += productDto.getUnitPrice();
        }
        priceLable = "$ " + price;
        return new ModelAndView("redirect:/products");
    }*/
}
