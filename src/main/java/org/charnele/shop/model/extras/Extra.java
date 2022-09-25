package org.charnele.shop.model.extras;

import org.charnele.shop.model.FoodItem;

// marker interface to be able to discriminate between FoodItems and Extra add-ons for beverages. Later we can have extras for Snacks as well
public interface Extra extends FoodItem {
}
