package org.charnele.shop.service;

import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.FoamedMilk;
import org.charnele.shop.model.extras.Milk;

public class MenuService {
    public Coffee orderCoffee(Size size) {
        return new Coffee(size);
    }

    public Coffee orderCoffeeWithMilk(Size size) {
        return new Coffee(size);
    }

    public Coffee orderLatte(Size size) {
        Coffee coffee = new Coffee(size);
        coffee.withExtras(new FoamedMilk()).withExtras(new Milk());
        return coffee;

    }

    public Tea orderTeaWithMilk(Size size){
        Tea tea = new Tea(size);
        tea.withExtras(new Milk());
        return tea;
    }
}
