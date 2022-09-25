package org.charnele.shop.model.extras;

import org.charnele.shop.model.FoodItem;

//spices can be added in Tea or in Snacks not implemented
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
