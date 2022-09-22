package org.charnele.shop.model.extras;

import org.charnele.shop.model.Extra;
import org.charnele.shop.model.Item;

public class SpecialRoast implements Extra {
    @Override
    public String getDescription() {
        return "special roast";
    }

    @Override
    public Double getPrice() {
        return 0.9;
    }
}
