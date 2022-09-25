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

    // for customers without cards
    public Order createNewOrder() {
        return new Order();
    }

    public void getReceit(Order order) {
        List<Food> orderedFoods = order.getOrderedFoods();

        String welcome = "Welcome to the Charlene's Shop";
        System.out.println(String.format("%-" + 80 + "s", String.format("%" + (welcome.length() + (80 - welcome.length()) / 2) + "s", welcome)));
        orderedFoods.forEach(System.out::println);
        // TODO: 25/09/2022 IMPORTANT Extract this into a service to calculate some discounts
        Double grossTotal = orderedFoods.stream().map(FoodItem::getPrice).reduce(Double::sum).orElse(0.0);

        List<Discount> discounts = discountService.applyDiscount(order);
        Double discountAmount = discounts.stream().map(Discount::getAmount).reduce(Double::sum).orElse(0.0);


        System.out.println(String.format("%1$80s", "Total: " + grossTotal) + " CHF");
        System.out.println("Discounts");
        discounts.forEach(System.out::println);

        System.out.println(String.format("%1$80s", "Total Discounts: " + discountAmount) + " CHF");
        System.out.println("Billable Invoice");
        System.out.println(String.format("%1$80s", "Total for Payment: " + (grossTotal-discountAmount)) + " CHF");

    }


}
