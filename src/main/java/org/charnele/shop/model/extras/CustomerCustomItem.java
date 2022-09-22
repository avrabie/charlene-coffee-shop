package org.charnele.shop.model.extras;

import org.charnele.shop.model.Item;

// Assume some customers want some ingredients to be put in the beverages
public class CustomerCustomItem implements Item {
    private final String description;
    private final Double price;

    public CustomerCustomItem(String description, Double price) {
        this.description = description;
        this.price = price;
    }


    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
