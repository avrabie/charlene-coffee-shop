package org.charnele.shop.model.beaverages;

import java.util.ArrayList;

// Freshly squeezed orange juice : goes very well instead of water
// This is to showcase the Decorator Pattern (Is-A, Has-A). It has an extra property on top of Beverage: Volume
// You can refill the orange juice.
public class OrangeJuice extends Beverage {
    Double volume = 0.25;
    private OrangeJuice orangeJuice;

    public OrangeJuice() {
        super("freshly squeezed orange juice", 3.95, new ArrayList<>());
    }

    public OrangeJuice(OrangeJuice orangeJuice) { // the refill.
        this();
        this.orangeJuice = orangeJuice;
        this.volume = orangeJuice.getVolume() + 0.25;
    }

    public Double getVolume() {
        return volume;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(" (%.2f l)", volume);
    }


}
