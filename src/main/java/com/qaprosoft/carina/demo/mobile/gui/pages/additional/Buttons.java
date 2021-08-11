package com.qaprosoft.carina.demo.mobile.gui.pages.additional;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Buttons extends AbstractUIObject {

    @FindBy(xpath = ".")
    private ExtendedWebElement title;

    public Buttons(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readTitle() {
        return title.getElement().getText();
    }

    public boolean isButtonPresent() {
        return title.isElementPresent();
    }
}
