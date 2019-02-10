package com.assessment.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Darrel Rayen on 2/9/19.
 */
@Entity
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String productName;

    private Double boxPrice;

    private Integer unitsPerBox;

    private Double unitPrice;

    public Product() {
    }
}
