package org.charnele.shop.model.extras;

import org.charnele.shop.model.Item;

public class Spices implements Item {
    @Override
    public String getDescription() {
        return "spices";
    }

    @Override
    public Double getPrice() {
        return 1.0;
    }
}
