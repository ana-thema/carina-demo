package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Filter extends AbstractUIObject {

    @FindBy(xpath ="//div[@class='dn-group-facet']/p/a[contains(text(), 'Смартфоны')]")
    private ExtendedWebElement smartphonesFilter;

    @FindBy(xpath="//span[@class='dn-cat-card-title']")
    private List<CatalogItem> items;

    public Filter(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(smartphonesFilter);
    }

    public List<CatalogItem> selectSmartphonesFilter(){
        assertElementPresent(smartphonesFilter);
        smartphonesFilter.click();
        return items;
    }

}
