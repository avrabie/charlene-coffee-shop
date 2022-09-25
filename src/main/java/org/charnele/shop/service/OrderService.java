package org.charnele.shop.service;

import org.charnele.shop.model.Customer;
import org.charnele.shop.model.Food;
import org.charnele.shop.model.FoodItem;
import org.charnele.shop.model.Order;
import org.charnele.shop.model.discount.Discount;

import java.util.List;

public class OrderService {

    private final DiscountService discountService = new DiscountService();

    public Order createNewOrder(Customer existingCustomer) {
        return new Order(existingCustomer);
    }

    public Order createNewOrder() {
        return new Order();
    }

    public void getReceit(Order order) {
        List<Food> orderedFoods = order.getOrderedFoods();

        String welcome = "Welcome to the Charlene's Shop";
        System.out.println(String.format("%-" + 80 + "s", String.format("%" + (welcome.length() + (80 - welcome.length()) / 2) + "s", welcome)));
        orderedFoods.forEach(System.out::println);
        // TODO: 25/09/2022 IMPORTANT Extract this into a service to calculate some discounts
        String total = "Total: " + orderedFoods.stream().map(FoodItem::getPrice).reduce(Double::sum).orElse(0.0);

        List<Discount> discounts = discountService.applyDiscount(order);



        System.out.println(String.format("%1$80s", total) + " CHF");
        System.out.println("Discounts");
        discounts.forEach(System.out::println);

    }


}
