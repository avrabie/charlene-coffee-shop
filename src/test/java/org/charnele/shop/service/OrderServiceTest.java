package org.charnele.shop.service;

import org.charnele.shop.model.beaverages.OrangeJuice;
import org.charnele.shop.model.customer.Customer;
import org.charnele.shop.model.order.Order;
import org.charnele.shop.model.beaverages.Coffee;
import org.charnele.shop.model.beaverages.Tea;
import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.snack.BaconRoll;
import org.charnele.shop.model.snack.Hamburger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    //CUT
    OrderService orderService = new OrderService();
    //this should have been mocked, so doing an IT instead since Mockito is not allowed
    MenuService menuService = new MenuService();
    @Test
    void orderSmallCoffee() {
        Order newOrder = orderService.createNewOrder();
        Coffee coffee = menuService.coffee(Size.SMALL);
        newOrder.addFoodItem(coffee);
        orderService.getReceipt(newOrder);
    }

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

        orderService.getReceipt(newOrder);

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

        orderService.getReceipt(newOrder);

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

        orderService.getReceipt(newOrder);

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

        orderService.getReceipt(newOrder);

    }


    @Test
    void beverageWithSpecialAddOnAndSnack() {
        Order newOrder = orderService.createNewOrder();

        Coffee coffee = menuService.coffee(Size.LARGE);
        menuService.addMilk(coffee);
        menuService.addFoamedMilk(coffee);
        menuService.addCustomerAddHockWish(coffee, "disarono liquior", 1.2);

        newOrder.addFoodItem(coffee);
        Hamburger hamburger = menuService.hamburger();
        newOrder.addFoodItem(hamburger);
        orderService.getReceipt(newOrder);
        Assertions.assertTrue(newOrder.getCustomer()==null);

    }


    @Test
    void beverageWithSnackButNoExtras() {
        Order newOrder = orderService.createNewOrder();

        Coffee coffee = menuService.coffee(Size.LARGE);

        newOrder.addFoodItem(coffee);
        Hamburger hamburger = menuService.hamburger();
        newOrder.addFoodItem(hamburger);
        orderService.getReceipt(newOrder);
        Assertions.assertTrue(newOrder.getCustomer()==null);

    }

    @Test
    void thirstyCustomerTest() {
        Order newOrder = orderService.createNewOrder();

        OrangeJuice orangeJuice = menuService.orangeJuice();
        orangeJuice = menuService.refillOrangeJuice(orangeJuice); //refill once

        newOrder.addFoodItem(orangeJuice);

        orderService.getReceipt(newOrder);
        Assertions.assertTrue(newOrder.getCustomer()==null);

    }

    @Test
    void veryThirstyCustomerTest() {
        Order newOrder = orderService.createNewOrder();

        OrangeJuice orangeJuice = menuService.orangeJuice();
        orangeJuice = menuService.refillOrangeJuice(orangeJuice);
        orangeJuice = menuService.refillOrangeJuice(orangeJuice); //refill twice

        newOrder.addFoodItem(orangeJuice);

        orderService.getReceipt(newOrder);
        Assertions.assertTrue(newOrder.getCustomer()==null);
    }


    @Test
    void existingCustomerOrderGets5CoffeeFree() {
        Customer customer = new Customer("Adrian");
        //first visit
        Order firstOrder = orderService.createNewOrder(customer);
        Coffee coffee = menuService.coffee(Size.LARGE);
        firstOrder.addFoodItem(coffee);

        OrangeJuice orangeJuice = menuService.orangeJuice();
        orangeJuice = menuService.refillOrangeJuice(orangeJuice);
        orangeJuice = menuService.refillOrangeJuice(orangeJuice); //refill twice

        firstOrder.addFoodItem(orangeJuice);
        orderService.getReceipt(firstOrder);

        Assertions.assertEquals(2, customer.getOrderedBeverages());

        //second visit
        Order secondOrder = orderService.createNewOrder(customer);
        Coffee coffee2 = menuService.coffee(Size.MEDIUM);
        menuService.addMilk(coffee2);
        secondOrder.addFoodItem(coffee2);
        Tea tea = menuService.tea(Size.MEDIUM);
        menuService.addSpices(tea);
        secondOrder.addFoodItem(tea);
        orderService.getReceipt(secondOrder);

        Assertions.assertEquals(4, customer.getOrderedBeverages());

        //third time
        Order thirdOrder = orderService.createNewOrder(customer);
        Coffee coffee3 = menuService.coffee(Size.SMALL);
        thirdOrder.addFoodItem(coffee3);
        orderService.getReceipt(thirdOrder);
        Assertions.assertEquals(5, customer.getOrderedBeverages());

    }


    @Test
    void existingCustomerOrderGets5CoffeeFree2() {
        Customer customer = new Customer("Adrian");
        //first visit
        Order firstOrder = orderService.createNewOrder(customer);
        Coffee coffee = menuService.coffee(Size.LARGE);
        firstOrder.addFoodItem(coffee);

        OrangeJuice orangeJuice = menuService.orangeJuice();
        orangeJuice = menuService.refillOrangeJuice(orangeJuice);
        orangeJuice = menuService.refillOrangeJuice(orangeJuice); //refill twice

        firstOrder.addFoodItem(orangeJuice);
        orderService.getReceipt(firstOrder);

        Assertions.assertEquals(2, customer.getOrderedBeverages());

        //second visit
        Order secondOrder = orderService.createNewOrder(customer);
        Coffee coffee2 = menuService.coffee(Size.MEDIUM);
        menuService.addMilk(coffee2);
        secondOrder.addFoodItem(coffee2);
        Tea tea = menuService.tea(Size.MEDIUM);
        menuService.addSpices(tea);
        secondOrder.addFoodItem(tea);
        orderService.getReceipt(secondOrder);

        Assertions.assertEquals(4, customer.getOrderedBeverages());

        //third time
        Order thirdOrder = orderService.createNewOrder(customer);
        Coffee coffee3 = menuService.coffee(Size.SMALL);
        thirdOrder.addFoodItem(coffee3);

        OrangeJuice orangeJuice1 = menuService.orangeJuice();
        thirdOrder.addFoodItem(orangeJuice1);

        orderService.getReceipt(thirdOrder);
        Assertions.assertEquals(6, customer.getOrderedBeverages());


    }
}