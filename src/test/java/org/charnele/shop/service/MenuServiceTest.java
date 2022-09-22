package org.charnele.shop.service;

import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.beaverages.Coffee;
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
        Beverage coffee = menuService.orderCoffee(Size.LARGE);
        Assertions.assertEquals(3.5, coffee.getPrice());
        Assertions.assertEquals("large coffee", coffee.getDescription());

    }


    @Test
    void orderCoffeeAndMilk() {
        Beverage coffee = menuService.orderCoffee(Size.LARGE);
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
        Tea tea = menuService.orderTeaWithMilk(Size.MEDIUM);
        Assertions.assertEquals(2.64, tea.getPrice());
        Assertions.assertEquals("medium tea with extras: milk", tea.getDescription());

    }

    @Test
    void orderSmallCoffeSpecialRoastWithDoubleMilk() {
        Coffee coffee = menuService.orderCoffee(Size.SMALL);
        coffee.withExtras(new SpecialRoast()).withExtras(new Milk()).withExtras(new Milk());
        Assertions.assertEquals(4.0, coffee.getPrice());
        Assertions.assertEquals("small coffee with extras: special roast, milk, milk", coffee.getDescription());

    }

}