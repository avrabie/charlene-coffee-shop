package org.charnele.shop.service;

import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.OrangeJuice;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.FoamedMilk;
import org.charnele.shop.model.extras.Milk;
import org.charnele.shop.model.food.BaconRoll;

public class MenuService {
    public Coffee coffee(Size size) {
        return new Coffee(size);
    }

    public BaconRoll bakonRoll(Size size) {
        return new BaconRoll();
    }

    public OrangeJuice orangeJuice() {
        return new OrangeJuice();
    }

    public OrangeJuice refillOrangeJuice(OrangeJuice orangeJuice) {
        return new OrangeJuice(orangeJuice);
    }

    public Coffee orderCoffeeWithMilk(Size size) {
        Coffee coffee = new Coffee(size);
        coffee.withExtras(new Milk());
        return coffee;
    }

    public Coffee orderLatte(Size size) {
        Coffee coffee = new Coffee(size);
        coffee.withExtras(new FoamedMilk()).withExtras(new Milk());
        return coffee;

    }

    public Tea orderTeaWithMilk(Size size) {
        Tea tea = new Tea(size);
        tea.withExtras(new Milk());
        return tea;
    }
}
