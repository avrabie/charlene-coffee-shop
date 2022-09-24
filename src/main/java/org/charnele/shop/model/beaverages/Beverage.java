package org.charnele.shop.model.beaverages;

import org.charnele.shop.model.Food;
import org.charnele.shop.model.FoodItem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//This is the Decorator Pattern, only Beverages will follow the decorator pattern
public abstract class Beverage extends Food {

    protected Beverage beverage;
    protected double price;
    protected List<FoodItem> extras;
    private String description = "generic beverage";

    public Beverage(Beverage beverage, String description, double price, List<FoodItem> extras) {
        this(description, price, extras);
        this.beverage = beverage;
    }

    public Beverage(String description, double price, List<FoodItem> extras) {
        this.description = description;
        this.price = price;
        this.extras = extras;
    }

    @Override
    public String getDescription() {
        return extras.size() > 0 ?
                this.description + " with extras: " + this.extras.stream().map(FoodItem::getDescription).collect(Collectors.joining(", ")) :
                this.description;
    }

    @Override
    public Double getPrice() {
        Optional<Double> priceExtras = extras.stream().map(FoodItem::getPrice).reduce(Double::sum);
        Optional<Double> beveragePrice = Optional.ofNullable(beverage).map(Food::getPrice);
        return this.price + priceExtras.orElse(0.0) + beveragePrice.orElse(0.0);
    }

    public Beverage withExtras(FoodItem extra) {
        extras.add(extra);
        return this;
    }

    //non immutable on purpose
    public List<FoodItem> getExtras() {
        return extras;
    }

}
