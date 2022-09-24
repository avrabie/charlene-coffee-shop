package org.charnele.shop.service;

import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.OrangeJuice;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.Milk;
import org.charnele.shop.model.extras.SpecialRoast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuServiceTest {

    private MenuService menuService = new MenuService();

    @Test
    void orderDefaultCoffee() {
        Beverage coffee = menuService.coffee(Size.LARGE);
        Assertions.assertEquals(3.5, coffee.getPrice());
        Assertions.assertEquals("large coffee", coffee.getDescription());

    }


    @Test
    void orderCoffeeAndMilk() {
        Beverage coffee = menuService.coffee(Size.LARGE);
        coffee.withExtras(new Milk());
        Assertions.assertEquals(3.8, coffee.getPrice());
        Assertions.assertEquals("large coffee with extras: milk", coffee.getDescription());

    }


    @Test
    void orderLatte() {
        Coffee coffee = menuService.orderLatte(Size.LARGE);
        Assertions.assertEquals(4.3, coffee.getPrice());
        Assertions.assertEquals("large coffee with extras: foamed milk, milk", coffee.getDescription());

    }

    @Test
    void orderTeaMedium() {
        Tea tea = menuService.orderTea(Size.MEDIUM);
        menuService.addMilk(tea);
        Assertions.assertTrue(2.7-tea.getPrice()<0.01);
        Assertions.assertEquals("medium tea with extras: milk", tea.getDescription());

    }

    @Test
    void orderSmallCoffeSpecialRoastWithDoubleMilk() {
        Coffee coffee = menuService.coffee(Size.SMALL);
        coffee.withExtras(new SpecialRoast()).withExtras(new Milk()).withExtras(new Milk());
        Assertions.assertEquals(4.0, coffee.getPrice());
        Assertions.assertEquals("small coffee with extras: special roast, milk, milk", coffee.getDescription());

    }



    @Test
    void orderRefillOrangeJuiceShowToString() {
        OrangeJuice orangeJuice1 = menuService.orangeJuice();
        OrangeJuice orangeJuice2 = menuService.refillOrangeJuice(orangeJuice1);
        System.out.println(orangeJuice2);
        System.out.println(orangeJuice1);
        Coffee coffee = menuService.coffee(Size.SMALL);
        System.out.println(coffee);
        Coffee coffee1 = menuService.orderLatte(Size.LARGE);
        System.out.println(coffee1);
    }

}