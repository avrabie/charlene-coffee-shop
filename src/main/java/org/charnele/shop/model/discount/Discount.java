package org.charnele.shop.model.discount;

import org.charnele.shop.model.FoodItem;

;

public class Discount {
    private String name;
    private Double amount;
    private FoodItem discountedFood;

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
        // TODO: 25/09/2022 To be formated properly
        return this.getName() + "  " + this.getAmount() + " CHF";
    }
}
