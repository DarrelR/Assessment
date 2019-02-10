package com.assessment.spring.dto;

import com.assessment.spring.model.OrderType;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Darrel Rayen on 2/10/19.
 */
@Data
public class OrderDto implements Serializable{
    private Integer productId;
    private OrderType orderType;
    private Integer quantity;

    public OrderDto() {
    }
}
