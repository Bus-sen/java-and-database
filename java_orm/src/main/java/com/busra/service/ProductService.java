package com.busra.service;

import com.busra.dao.ProductDAO;
import com.busra.model.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product insertProduct(String name, double price) {
        if (name == null || price < 0) {
            return null;
        }
        Product product = new Product(name, price);
        return productDAO.insertProduct(product);
    }

    public void updateProduct(int id, String name, double price) {
        Product product = new Product(name, price);
        product.setId(id);
        productDAO.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}
