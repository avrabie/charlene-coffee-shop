package org.charnele.shop.model.discount;

import org.charnele.shop.model.FoodItem;

;import java.text.DecimalFormat;

public class Discount {
    private String name;
    private Double amount;
    private FoodItem discountedFood;
    DecimalFormat df = new DecimalFormat("###.###");

    public Discount(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Discount(FoodItem discountedFood) {
        this.discountedFood = discountedFood;
        this.name = "Free of charge: "+discountedFood.getDescription();
        this.amount = discountedFood.getPrice();
    }

    public Double getAmount() {
        return amount;
    }


    public FoodItem getDiscountedFood() {
        return discountedFood;
    }

    public void setDiscountedFood(FoodItem discountedFood) {
        this.discountedFood = discountedFood;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        int length = 80;
        String currencySymbol = " CHF";
        length = length - this.getName().length();
        String formatPaddingPrice = String.format("%1$" + length + "s", df.format(this.getAmount()));
        return String.format("%s", this.getName() + formatPaddingPrice + currencySymbol);
    }
}
