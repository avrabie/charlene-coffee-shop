package org.charnele.shop.model;

import org.charnele.shop.model.beaverages.Beverage;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Order> previousOrders = new ArrayList<>();
    private Integer id;
    private String name;
    private Integer orderedBeverages = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void concludeOrder(Order order) {
        previousOrders.add(order);
        long count = order.getOrderedFoods().stream().filter(food -> food instanceof Beverage).count();
        orderedBeverages += (int) count; //if it overflows, we have a bigger problem with our customer's dependency for caffeine
    }

}
