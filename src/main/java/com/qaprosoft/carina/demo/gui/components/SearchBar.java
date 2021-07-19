package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.OnlinerCatalog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBar  extends AbstractUIObject {

    @FindBy(xpath = "//a[@target='_parent'][contains(text(), 'Телевизоры')]")
    private ExtendedWebElement tvs;

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public OnlinerCatalog pickCategory(){
        getDriver().getPageSource();
        tvs.click();
        return new OnlinerCatalog(driver);
    }

}
