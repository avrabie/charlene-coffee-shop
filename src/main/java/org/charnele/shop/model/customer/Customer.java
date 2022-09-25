package org.charnele.shop.model.customer;

import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Order> previousOrders = new ArrayList<>();
    Order lastOrder;
    private Integer id;
    private String name;
    private Integer orderedBeverages = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void concludeOrder(Order order) {
        previousOrders.add(order);
        this.lastOrder = order;
        long count = order.getOrderedFoods().stream().filter(food -> food instanceof Beverage).count();
        orderedBeverages += (int) count; //if it overflows, we have a bigger problem with our customer's dependency for caffeine
    }

    public List<Order> getPreviousOrders() {
        return previousOrders;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOrderedBeverages() {
        return orderedBeverages;
    }

    public Order getLastOrder() {
        return lastOrder;
    }
}
