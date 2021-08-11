package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Macros;
import org.openqa.selenium.WebDriver;

public abstract class ProfilePageBase extends AbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openNutrition();

    public abstract int getTotalCalories();

    public abstract int getBreakfastPercentage();

    public abstract int countBreakfastPercentage(int breakCal, int total);

    public abstract int getLunchPercentage();

    public abstract int countLunchPercentage(int breakPercentage);

    public abstract int sumCalories(int breakCal, int lunchCal);

    public abstract double getFats();

    public abstract double getCarbs();

    public abstract double sumNutrients(double i1, double i2);

    public abstract double getSugar();

    public abstract double getProtein();

    public abstract void openNutrients();

    public abstract int getCarbsPercentage();

    public abstract int countCarbsPercentage(double carbs, double total);

    public abstract int getFatPercentage();

    public abstract int countFatsPercentage(double fat, double total);

    public abstract int getProteinPercentage();

    public abstract int countProteinPercentage(int carbsPercentage, int fatPercentage);

    public abstract double getTotalMacros(Macros macros);

    public abstract void openMacros();
}
