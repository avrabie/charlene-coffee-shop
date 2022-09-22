package org.charnele.shop.model.beaverages;

import org.charnele.shop.model.Item;

import java.util.ArrayList;
import java.util.List;

public class OrangeJuice extends Beverage{
    Double volume = 0.25;

    public OrangeJuice() {
        super("orange juice", 3.95, new ArrayList<>());
    }

    @Override
    public Beverage withExtras(Item extra) {
        return super.withExtras(extra);
    }

    @Override
    public List<Item> getExtras() {
        return super.getExtras();
    }

    public Double getVolume() {
        return volume;
    }
}
