package org.charnele.shop.model.order;

import org.charnele.shop.model.customer.Customer;
import org.charnele.shop.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Food> orderedFoods = new ArrayList<>();


    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addFoodItem(Food food) {
        orderedFoods.add(food);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Food> getOrderedFoods() {
        return orderedFoods;
    }
}
