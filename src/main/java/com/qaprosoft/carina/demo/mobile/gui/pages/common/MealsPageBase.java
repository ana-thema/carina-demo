package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Nutrients;
import org.openqa.selenium.WebDriver;

public abstract class MealsPageBase extends AbstractPage {
    public MealsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addBreakfast();

    public abstract void addLunch();

    public abstract void quickAddLunch(String amount);

    public abstract double getNutrients(Nutrients n);
}
