package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Meals;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Nutrients;
import org.openqa.selenium.WebDriver;

public abstract class DiaryPageBase extends AbstractPage {
    public DiaryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MealsPageBase addFood(Meals meal);

    public abstract ExercisePageBase clickExercise();

    public abstract void clickAlert();

    public abstract int getItemCalories();

    public abstract int getMealCalories(Meals meal);

    public abstract void save();

    public abstract int getItemsCalories();

    public abstract ProfilePageBase openProfile();
}
