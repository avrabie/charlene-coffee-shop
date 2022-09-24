package org.charnele.shop.service;

import org.charnele.shop.model.Customer;
import org.charnele.shop.model.Food;
import org.charnele.shop.model.Order;

import java.util.List;

public class OrderService {

    public Order createNewOrder(Customer existingCustomer) {
        return new Order(existingCustomer);
    }

    public Order createNewOrder() {
        return new Order();
    }

    public void getReceit(Order order) {
        List<Food> orderedFoods = order.getOrderedFoods();
        orderedFoods.forEach(System.out::println);

    }


}
