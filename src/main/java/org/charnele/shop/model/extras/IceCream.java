package org.charnele.shop.model.extras;

import org.charnele.shop.model.Extra;

public class IceCream implements Extra {
    @Override
    public String getDescription() {
        return "ice-cream";
    }

    @Override
    public Double getPrice() {
        return 1.25;
    }
}
