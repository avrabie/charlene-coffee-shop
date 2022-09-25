package org.charnele.shop.service;

import org.charnele.shop.model.Order;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.FoamedMilk;
import org.charnele.shop.model.food.BaconRoll;
import org.charnele.shop.model.food.Hamburger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    //CUT
    OrderService orderService = new OrderService();
    //this should have been mocked, so doing an IT instead since Mockito is not allowed
    MenuService menuService = new MenuService();
    @Test
    void createNewOrder() {
        Order newOrder = orderService.createNewOrder();

        Coffee coffee = menuService.coffee(Size.LARGE);
        menuService.addMilk(coffee);
        menuService.addFoamedMilk(coffee);
        menuService.addSpecialRoast(coffee);

        Tea tea = menuService.tea(Size.MEDIUM);
        menuService.addSpices(tea);

        newOrder.addFoodItem(coffee);
        newOrder.addFoodItem(tea);

        orderService.getReceit(newOrder);

    }

    @Test
    void createNewOrderWithSnackAndCoffeeAndTee() {
        Order newOrder = orderService.createNewOrder();

        Coffee coffee = menuService.coffee(Size.LARGE);
        menuService.addMilk(coffee);
        menuService.addFoamedMilk(coffee);
        menuService.addSpecialRoast(coffee);

        Tea tea = menuService.tea(Size.MEDIUM);
        menuService.addSpices(tea);

        newOrder.addFoodItem(coffee);
        newOrder.addFoodItem(tea);

        BaconRoll baconRoll = menuService.baconRoll();
        newOrder.addFoodItem(baconRoll);

        orderService.getReceit(newOrder);

    }

    @Test
    void createNewOrderWithSnack() {
        Order newOrder = orderService.createNewOrder();

        Coffee coffee = menuService.coffee(Size.LARGE);
        menuService.addMilk(coffee);
        menuService.addFoamedMilk(coffee);
        menuService.addSpecialRoast(coffee);
        newOrder.addFoodItem(coffee);

        BaconRoll baconRoll = menuService.baconRoll();
        newOrder.addFoodItem(baconRoll);

        orderService.getReceit(newOrder);

    }
    @Test
    void createNewOrderWithSnackHamburger() {
        Order newOrder = orderService.createNewOrder();

        Coffee coffee = menuService.coffee(Size.LARGE);
        menuService.addMilk(coffee);
        menuService.addFoamedMilk(coffee);
        menuService.addSpecialRoast(coffee);
        newOrder.addFoodItem(coffee);

        Hamburger hamburger = menuService.hamburger();
        newOrder.addFoodItem(hamburger);

        orderService.getReceit(newOrder);

    }
}