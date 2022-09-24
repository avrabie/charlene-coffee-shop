package org.charnele.shop.service;

import org.charnele.shop.model.Food;
import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.OrangeJuice;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.FoamedMilk;
import org.charnele.shop.model.extras.Milk;
import org.charnele.shop.model.extras.SpecialRoast;
import org.charnele.shop.model.extras.Spices;
import org.charnele.shop.model.food.BaconRoll;

public class MenuService {

    public Coffee coffee(Size size) {
        return new Coffee(size);
    }

    public OrangeJuice orangeJuice() {
        return new OrangeJuice();
    }

    public BaconRoll baconRoll(Size size) {
        return new BaconRoll();
    }

    public Tea tea(Size size) {
        Tea tea = new Tea(size);
        return tea;
    }


    //extras
    public Beverage addMilk(Beverage beverage) {
        beverage.withExtras(new Milk());
        return beverage;
    }

    public Beverage addFoamedMilk(Beverage beverage) {
        beverage.withExtras(new FoamedMilk());
        return beverage;
    }

    public Beverage addSpecialRoast(Beverage beverage) {
        beverage.withExtras(new SpecialRoast());
        return beverage;
    }

    // TODO: 25/09/2022 extract extras from Beverage to Food FEATURE
    public Beverage addSpices(Beverage beverage) {
        beverage.withExtras(new Spices());
        return beverage;
    }


    //feature
    public OrangeJuice refillOrangeJuice(OrangeJuice orangeJuice) {
        return new OrangeJuice(orangeJuice);
    }


    //prebuilt products
    public Coffee orderIrishCoffee(Size size) {
        Coffee coffee = new Coffee(size);
        coffee.withExtras(new Milk());
        // TODO: 24/09/2022 implement withExtras Irish Wisky
        return coffee;
    }

    // TODO: 24/09/2022 implement a pricing strategy for pre-defined goods. Ex: a Latte should cost less than if you'd buy all the ingredients separately.
    public Coffee orderLatte(Size size) {
        Coffee coffee = new Coffee(size);
        coffee.withExtras(new FoamedMilk()).withExtras(new Milk());
        return coffee;

    }


}
