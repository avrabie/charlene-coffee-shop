package org.charnele.shop.model.extras;

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
