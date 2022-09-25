package org.charnele.shop.model.beaverages;

import org.charnele.shop.model.FoodItem;
import org.charnele.shop.model.beaverages.size.Size;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

// Let's sell tea as well...
// this is to showcase the strategy pattern
public class Tea extends Beverage {
    private Size size;
    private Function<Double, Double> priceStrategy;

    //and assume we want to sell some custom 'magical tea' as well.. but this time it will be twice more expensive
    public Tea(String name, Size size, Function<Double, Double> priceStrategy) {
        super(name, size.getPrice(), new ArrayList<>());
        this.size =size;
        this.priceStrategy = priceStrategy;
    }

    public Tea(Size size) {
        super("tea", size.getPrice(), new ArrayList<>());
        this.size =size;
        this.priceStrategy = price -> price*.8;
    }

    @Override
    public String getDescription() {
        return size.getDescription() + " " + super.getDescription();
    }

    @Override
    public Double getPrice() {
        Optional<Double> priceExtras = extras.stream().map(FoodItem::getPrice).reduce(Double::sum);
        return priceStrategy.apply(this.price) + priceExtras.orElse(0.0);
    }
}
