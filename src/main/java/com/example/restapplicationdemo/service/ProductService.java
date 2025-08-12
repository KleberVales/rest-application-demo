package com.example.restapplicationdemo.service;

import com.example.restapplicationdemo.entity.Product;
import com.example.restapplicationdemo.exception.ProductNotFoundException;
import com.example.restapplicationdemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado com ID " + id));
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        return repository.save(existing);
    }

    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException("Produto não encontrado para exclusão com ID " + id);
        }
        repository.deleteById(id);
    }
}
