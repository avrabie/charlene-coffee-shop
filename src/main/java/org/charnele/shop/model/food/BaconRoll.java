package org.charnele.shop.model.food;

import org.charnele.shop.model.Item;

public class BaconRoll implements Item {
    @Override
    public String getDescription() {
        return "backon roll";
    }

    @Override
    public Double getPrice() {
        return 4.5;
    }
}
