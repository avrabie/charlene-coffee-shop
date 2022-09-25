package org.charnele.shop.model;

import java.text.DecimalFormat;

public abstract class Food implements FoodItem {
    DecimalFormat df = new DecimalFormat("###.###");

    @Override
    public String toString() {
        int length = 80;
        String currencySymbol = " CHF"; //for $ or other symbols, no need to put a space in front
        length = length - this.getDescription().length() ;
        String formatPaddingPrice = String.format("%1$" + length + "s", df.format(this.getPrice()));
        return String.format("%s", this.getDescription() + formatPaddingPrice + currencySymbol);
    }
}
