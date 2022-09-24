package org.charnele.shop.model.extras;

import org.charnele.shop.model.FoodItem;

public class Spices implements FoodItem {
    @Override
    public String getDescription() {
        return "spices";
    }

    @Override
    public Double getPrice() {
        return 1.0;
    }
}
