package com.qaprosoft.carina.demo.mobile.gui.pages.additional;

public enum Nutrients {
    PROTEIN("Protein"),
    CARBS("Carbs"),
    FAT("Fat"),
    SUGAR("Sugar");
    private final String name;

    Nutrients(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
