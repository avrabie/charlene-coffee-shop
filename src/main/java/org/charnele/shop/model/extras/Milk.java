package org.charnele.shop.model.extras;

import org.charnele.shop.model.Extra;
import org.charnele.shop.model.Item;

public class Milk implements Extra {
    @Override
    public String getDescription() {
        return "milk";
    }

    @Override
    public Double getPrice() {
        return 0.3;
    }
}
