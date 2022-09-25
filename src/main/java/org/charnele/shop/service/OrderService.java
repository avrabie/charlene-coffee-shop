package org.charnele.shop.service;

import org.charnele.shop.model.customer.Customer;
import org.charnele.shop.model.Food;
import org.charnele.shop.model.FoodItem;
import org.charnele.shop.model.order.Order;
import org.charnele.shop.model.discount.Discount;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private final DiscountService discountService = new DiscountService();

    public Order createNewOrder(Customer existingCustomer) {
        return new Order(existingCustomer);
    }

    // for customers without cards, and recite
    public Order createNewOrder() {
        return new Order();
    }

    public void getReceipt(Order order) {
        Optional<Customer> customer = Optional.ofNullable(order.getCustomer());
        customer.ifPresent(cust -> cust.concludeOrder(order));
        List<Food> orderedFoods = order.getOrderedFoods();

        // TODO: 25/09/2022 IMPORTANT Extract this into a service to calculate some discounts
        Double grossTotal = orderedFoods.stream().map(FoodItem::getPrice).reduce(Double::sum).orElse(0.0);

        List<Discount> discounts = discountService.applyDiscount(order);
        Double discountAmount = discounts.stream().map(Discount::getAmount).reduce(Double::sum).orElse(0.0);

        //loyal customer discount
        Optional<List<Discount>> customerDiscounts = customer.map(customer1 -> discountService.applyCustomerDiscount(order));
        Double sumCustomerDiscounts = customerDiscounts.map(list -> list.stream().map(Discount::getAmount).reduce(Double::sum).orElse(0.0)).orElse(0.0);


        printReceipt(orderedFoods, grossTotal, discounts, discountAmount, customerDiscounts, sumCustomerDiscounts, customer);

    }

    private void printReceipt(List<Food> orderedFoods, Double grossTotal, List<Discount> discounts, Double discountAmount, Optional<List<Discount>> customerDiscounts, Double sumCustomerDiscounts, Optional<Customer> customer) {
        DecimalFormat df = new DecimalFormat("####.###");
        String welcome = "Welcome to Charlene's Coffee Shop";
        System.out.println(String.format("%-" + 80 + "s", String.format("%" + (welcome.length() + (80 - welcome.length()) / 2) + "s", welcome)));
        System.out.println(customer.map(Customer::getName).orElse("Your")+" order on " + LocalDate.now());
        orderedFoods.forEach(System.out::println);
        System.out.println(String.format("%1$80s", "Total: " + df.format(grossTotal)) + " CHF");

        System.out.println("Discounts");
        discounts.forEach(System.out::println);
        customerDiscounts.ifPresent(discounts1 -> discounts1.forEach(System.out::println));

        System.out.println(String.format("%1$80s", "Total Discounts: " + df.format(discountAmount + sumCustomerDiscounts)) + " CHF");
        System.out.println("Invoice");
        System.out.println(String.format("%1$80s", "Total Payable: " + df.format(grossTotal - discountAmount - sumCustomerDiscounts)) + " CHF");
    }


}
