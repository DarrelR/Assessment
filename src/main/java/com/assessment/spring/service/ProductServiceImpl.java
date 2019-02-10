package com.assessment.spring.service;

import com.assessment.spring.dto.ProductDto;
import com.assessment.spring.model.OrderType;
import com.assessment.spring.model.Product;
import com.assessment.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Darrel Rayen on 2/9/19.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDto> findAllProducts(Pageable pageable) {
        Page<Product> productPageList = productRepository.findAll(pageable);
        return productPageList.map(ProductDto::new);
    }

    @Override
    @Transactional
    public Double calculatePrice(Integer productId, Integer quantity, OrderType orderType) {
        Double totalPrice = null;
        Optional<Product> optional = productRepository.findById(productId);
        //optional.ifPresent(Product::new);

        return totalPrice;
    }

    @Override
    @Transactional
    public ProductDto addProduct(ProductDto product) {
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setBoxPrice(product.getBoxPrice());
        newProduct.setUnitsPerBox(product.getUnitsPerBox());
        Double actualUnitPrice = product.getBoxPrice() / product.getUnitPrice();
        Double unitPrice = actualUnitPrice + (30 / 100 * actualUnitPrice);
        newProduct.setUnitPrice(unitPrice);
        return new ProductDto(productRepository.saveAndFlush(newProduct));
    }
}
