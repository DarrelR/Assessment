package com.assessment.spring.service;

import com.assessment.spring.dto.OrderDto;
import com.assessment.spring.dto.ProductDto;
import com.assessment.spring.model.OrderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Darrel Rayen on 2/9/19.
 */
public interface ProductService {

    Page<ProductDto> findAllProducts(Pageable pageable);

    ProductDto findOne(Integer id);

    ProductDto findByName(String productName);

    Double calculatePrice(List<OrderDto> orderDtos);

    Double calculatePrice(Integer productId, Integer quantity, String orderType);

    ProductDto addProduct(ProductDto product);
}
