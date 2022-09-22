package org.charnele.shop.model.beaverages.size;

public enum Size {
    SMALL("small", 2.5),
    MEDIUM("medium", 3.0),
    LARGE("large", 3.5);

    private String description;
    private Double price; //base price

    Size(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice() {
        return price;
    }
}