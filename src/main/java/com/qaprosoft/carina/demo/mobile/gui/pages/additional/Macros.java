package com.qaprosoft.carina.demo.mobile.gui.pages.additional;

public class Macros {
    private double i1carbs;
    private double i1fats;
    private double i1protein;
    private double i2carbs;
    private double i2fats;
    private double i2protein;

    public Macros(double i1carbs, double i1fats, double i1protein, double i2carbs, double i2fats, double i2protein){
        this.i1carbs = i1carbs;
        this.i1fats = i1fats;
        this.i1protein = i1protein;
        this.i2carbs = i2carbs;
        this.i2fats = i2fats;
        this.i2protein = i2protein;
    }

    public double getI2protein() {
        return i2protein;
    }

    public double getI2fats() {
        return i2fats;
    }

    public double getI2carbs() {
        return i2carbs;
    }

    public double getI1protein() {
        return i1protein;
    }

    public double getI1fats() {
        return i1fats;
    }

    public double getI1carbs() {
        return i1carbs;
    }
}
