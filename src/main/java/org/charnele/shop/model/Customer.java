package org.charnele.shop.model;

import java.util.List;

public class Customer {
    List<Order> previousOrders;
    private Integer id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }
}
