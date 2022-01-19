package com.geroimzx.market.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.geroimzx.market.Entity.Product;
import com.geroimzx.market.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity findAllProduct() throws JsonProcessingException {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.FOUND);
    }

    @PostMapping(value = "/product/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/product/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> editProduct(@PathVariable String id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.update(id, product), HttpStatus.ACCEPTED);
    }

    @GetMapping("/productList/test")
    public ResponseEntity<List<Product>> getProductListTest() {
        productService.create(new Product("Телевізор JVC LT32MU380", "TV", 4899));
        productService.create(new Product("Телевізор LG 43UP75006LF", "TV", 13699));
        productService.create(new Product("Телевізор Samsung UE55TU7100UXUA", "TV", 17499));

        return new ResponseEntity<>(productService.findAll(), HttpStatus.FOUND);
    }

    @PostMapping
    public boolean addProduct(Product product) {
        Product insertedProduct = productService.create(product);
        return productService.exists(insertedProduct.getId());
    }
}
