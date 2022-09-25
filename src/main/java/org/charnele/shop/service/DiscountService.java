package org.charnele.shop.service;

import org.charnele.shop.model.FoodItem;
import org.charnele.shop.model.order.Order;
import org.charnele.shop.model.beaverages.Beverage;
import org.charnele.shop.model.discount.Discount;
import org.charnele.shop.model.snack.Snack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DiscountService {
    //If a customer orders a beverage and a snack, one of the extra's is free
    public List<Discount> applyDiscount(Order order) {
        List<Discount> applicableDiscounts = new ArrayList<>();
        Boolean orderedSnack = order.getOrderedFoods().stream().anyMatch(food -> food instanceof Snack);
        Boolean orderedBeverage = order.getOrderedFoods().stream().anyMatch(food -> food instanceof Beverage);
        if (orderedSnack && orderedBeverage) {
            // I assume we want to discount the most expensive extra in case there are multiple
            Optional<FoodItem> max = order.getOrderedFoods().stream().filter(food -> food instanceof Beverage).filter(beverage -> ((Beverage) beverage).getExtras().size() > 0)
                    .flatMap(beverage -> ((Beverage) beverage).getExtras().stream())
                    .max(Comparator.comparing(FoodItem::getPrice));
            Discount discount = max.map(food -> new Discount(food))
                    .orElse(new Discount("You are entitled to a free extra. Make use of it next time!", 0.0));
            applicableDiscounts.add(discount);
        }
        return applicableDiscounts;
    }
}
