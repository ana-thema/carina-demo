package com.qaprosoft.carina.demo.mobile.gui.pages.additional;

public enum Meals {
    BREAKFAST("Breakfast"),
    DINNER("Dinner"),
    LUNCH("Lunch"),
    SNACKS("Snacks");
    private final String name;

    Meals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
