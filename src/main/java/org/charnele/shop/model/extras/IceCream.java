package org.charnele.shop.model.extras;

import org.charnele.shop.model.Extra;
import org.charnele.shop.model.FoodItem;

//Ice cream can be BOTH: an extra to coffee (Tucanno coffe) or it can be served on its own
public class IceCream implements Extra, FoodItem {
    @Override
    public String getDescription() {
        return "ice-cream";
    }

    @Override
    public Double getPrice() {
        return 1.25;
    }
}
