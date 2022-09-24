package org.charnele.shop.service;

import org.charnele.shop.model.Order;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.extras.FoamedMilk;
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
}