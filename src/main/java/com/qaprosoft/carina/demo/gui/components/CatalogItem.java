package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogItem extends AbstractUIObject {

    @FindBy(xpath = "./a")
    public ExtendedWebElement titleLink;

    public String readTitle() {
        return titleLink.getElement().getText();
    }

    public CatalogItem(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }
}
