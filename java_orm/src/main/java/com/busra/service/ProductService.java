package com.busra.service;

import com.busra.dao.ProductDAO;
import com.busra.model.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

}
