package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FoodItem extends AbstractUIObject {

    @FindBy(xpath = "./div/a")
    public ExtendedWebElement title;

    public FoodItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickItem() {
        title.click();
    }
}
