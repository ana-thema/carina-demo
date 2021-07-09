package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Filter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage {

    private final String comparePageUrl = "https://xiaomi-store.by/catalog";

    @FindBy(xpath = "//button[@class='filter-btn']")
    private ExtendedWebElement filter;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(filter);
        setPageAbsoluteURL(comparePageUrl);
    }

    public Filter selectFilters() {
        assertElementPresent(filter);
        filter.click();
        return new Filter(driver);
    }

}
