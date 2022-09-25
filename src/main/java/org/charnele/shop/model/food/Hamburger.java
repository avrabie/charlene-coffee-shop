package org.charnele.shop.model.food;

public class Hamburger extends Snack {
    @Override
    public String getDescription() {
        return "hamburger";
    }

    @Override
    public Double getPrice() {
        return 7.5;
    }
}
