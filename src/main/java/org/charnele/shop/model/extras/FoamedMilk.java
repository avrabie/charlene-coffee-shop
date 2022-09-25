package org.charnele.shop.model.extras;

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
