package com.geroimzx.market.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Document
public class Product {
    @Id
    private String id;

    private String name;
    private String description;
    private double price;

    private List<ProductCharacteristic> characteristics;

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Collection getCharacteristics() {
        return characteristics;
    }

    public void addCharacteristic(String type, String value) {
        characteristics.add(new ProductCharacteristic(type, value));
    }

    public void removeCharacteristic(String key) {
        characteristics.remove(key);
    }

    public void updateId(String id) {
        this.id = id;
    }
}
