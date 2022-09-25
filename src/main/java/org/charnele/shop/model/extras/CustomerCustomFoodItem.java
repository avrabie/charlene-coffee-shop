package org.charnele.shop.model.extras;

// New Feature: Assume some customers want some ingredients to be put in the beverages
// this item allows us to customize the menu with add-ons we are not aware of in the impl phase
// provided we segregate the functionality and MenuService is a separate Microservice, models will not need to be changed/compiled again
public class CustomerCustomFoodItem implements Extra {
    private final String description;
    private final Double price;

    public CustomerCustomFoodItem(String description, Double price) {
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
