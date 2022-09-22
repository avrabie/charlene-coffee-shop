package org.charnele.shop.model.beaverages;


import org.charnele.shop.model.Item;
import org.charnele.shop.model.beaverages.size.Size;

import java.util.ArrayList;

public class Coffee extends Beverage {

    private Size size;

    public Coffee(Size size) {
        super("coffee", size.getPrice(), new ArrayList<>());
        this.size = size;
    }

    @Override
    public String getDescription() {
        return size.getDescription() + " " + super.getDescription();
    }

    @Override
    public Double getPrice() {
        return super.getPrice();
    }



}
