package org.charnele.shop.model.extras;

import org.charnele.shop.model.Extra;

public class FoamedMilk implements Extra {
    @Override
    public String getDescription() {
        return "foamed milk";
    }

    @Override
    public Double getPrice() {
        return 0.5;
    }
}
