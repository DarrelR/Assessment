package com.assessment.spring.service;

import com.assessment.spring.dto.ProductDto;
import com.assessment.spring.model.OrderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Darrel Rayen on 2/9/19.
 */
public interface ProductService {

    Page<ProductDto> findAllProducts(Pageable pageable);

    ProductDto findOne(Integer id);

    Double calculatePrice(Integer productId, Integer quantity, OrderType orderType);

    ProductDto addProduct(ProductDto product);
}
