package org.charnele.shop.model;

public abstract class Food implements FoodItem {

    @Override
    public String toString() {
        int length = 80;
        String currencySymbol = " CHF"; //for $ or other symbols, no need to put a space at the end
        length = length - this.getDescription().length() ;
        String formatPaddingPrice = String.format("%1$" + length + "s", this.getPrice());
        return String.format("%s", this.getDescription() + formatPaddingPrice + currencySymbol);
    }
}
