package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinerCatalog extends AbstractPage {

    private final String comparePageUrl = "https://catalog.onliner.by/tv";

    @FindBy(xpath = "//div[@class='schema-product__title']")
    private List<SearchItem> items;

    @FindBy(xpath = "//div[@class='schema-product__title']/a/span")
    private ExtendedWebElement item;

    public OnlinerCatalog(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(item);
        setPageAbsoluteURL(comparePageUrl);
    }

    public List<SearchItem> getItems() {
        return items;
    }

    public ItemPage pickItem(){
        item.click();
        return new ItemPage(driver);
    }

    public String readItem() {
        return item.getElement().getText();
    }
}
