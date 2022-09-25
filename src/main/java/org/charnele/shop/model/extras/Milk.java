package org.charnele.shop.model.extras;

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
