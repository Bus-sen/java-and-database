package com.busra.dao;

import com.busra.model.Product;

public interface ProductDAO {
    Product insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
