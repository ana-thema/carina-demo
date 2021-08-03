package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DiaryPageBase extends AbstractPage {
    public DiaryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addBreakfast();

    public abstract void addLunch();

    public abstract void quickAddLunch(String amount);

    public abstract int getItemCalories();

    public abstract int getBreakfastCalories();

    public abstract void save();

    public abstract void addExercise();

    public abstract double getFats();

    public abstract double getCarbs();

    public abstract double getSugar();

    public abstract double getProtein();

    public abstract int getItemsCalories();

    public abstract int getLunchCalories();

    public abstract ProfilePageBase openProfile();
}
