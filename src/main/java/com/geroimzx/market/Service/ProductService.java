package com.geroimzx.market.Service;

import com.geroimzx.market.Entity.Product;
import com.geroimzx.market.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
    }

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(String id, Product product) {
        product.updateId(id);
        return productRepository.save(product);
    }

    public Optional<Product> read(String id) {
        return productRepository.findById(id);
    }
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public boolean exists(String id) {
        return productRepository.existsById(id);
    }
}
