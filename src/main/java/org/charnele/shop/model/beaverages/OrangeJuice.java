package org.charnele.shop.model.beaverages;

import org.charnele.shop.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class OrangeJuice extends Beverage {
    Double volume = 0.25;
    private OrangeJuice orangeJuice;

    public OrangeJuice(OrangeJuice orangeJuice) {
        super(orangeJuice, "orange juice", 3.95, new ArrayList<>());
        this.orangeJuice = orangeJuice;
        this.volume = orangeJuice.getVolume() + 0.25; //if one want a double or a tripple orange juice
    }

    public OrangeJuice() {
        super("orange juice", 3.95, new ArrayList<>());
    }

    @Override
    public OrangeJuice withExtras(FoodItem extra) {
        super.withExtras(extra);
        return this;
    }

    @Override
    public List<FoodItem> getExtras() {
        return super.getExtras();
    }

    public Double getVolume() {
        return volume;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format("(%.2f l)", volume);
    }


}
