package org.charnele.shop.service;

import org.charnele.shop.model.Extra;
import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.OrangeJuice;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.*;
import org.charnele.shop.model.snack.BaconRoll;
import org.charnele.shop.model.snack.Hamburger;

public class MenuService {

    public Coffee coffee(Size size) {
        return new Coffee(size);
    }

    public OrangeJuice orangeJuice() {
        return new OrangeJuice();
    }

    public BaconRoll baconRoll() {
        return new BaconRoll();
    }

    public Hamburger hamburger() {
        return new Hamburger();
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


    // let's say we do have some extras in the shop which are not in the menu that the customer wants as an add-on
    public Beverage addCustomerExtraNotOnMenu(Beverage beverage, Extra extra) {
        beverage.withExtras(extra);
        return beverage;
    }

    // customer has an add hock wish, then we must come up with a price
    public Beverage addCustomerAddHockWish(Beverage beverage, String name, Double price) {
        beverage.withExtras(new CustomerCustomFoodItem(name, price));
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
