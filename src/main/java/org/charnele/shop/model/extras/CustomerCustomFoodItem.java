package org.charnele.shop.model.extras;

import org.charnele.shop.model.Extra;
import org.charnele.shop.model.FoodItem;

// New Feature: Assume some customers or the chef wants some ingredients to be put in the beverages or in their foods,
//  this item allows us to customize the menu with add-ons we are not aware of in the impl phase
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
