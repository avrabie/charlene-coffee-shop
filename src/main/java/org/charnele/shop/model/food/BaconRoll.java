package org.charnele.shop.model.food;

import org.charnele.shop.model.Food;

public class BaconRoll extends Food {
    @Override
    public String getDescription() {
        return "backon roll";
    }

    @Override
    public Double getPrice() {
        return 4.5;
    }
}
