package org.charnele.shop.model.beaverages;

import org.charnele.shop.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Beverage implements Item {

    private String description = "generic beverage";
    protected double price;
    protected List<Item> extras;

    public Beverage(String description, double price, List<Item> extras) {
        this.description = description;
        this.price = price;
        this.extras = extras;
    }

    @Override
    public String getDescription() {
        return extras.size() > 0 ?
                this.description +" with extras: "+ this.extras.stream().map(Item::getDescription).collect(Collectors.joining(", ")) :
                this.description;
    }

    @Override
    public Double getPrice() {
        Optional<Double> priceExtras = extras.stream().map(Item::getPrice).reduce(Double::sum);
        return this.price + priceExtras.orElse(0.0);
    }

    public Beverage withExtras(Item extra) {
        extras.add(extra);
        return this;
    }

    //modifiable
    public List<Item> getExtras() {
        return extras;
    }
}
