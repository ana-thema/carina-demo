package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String comparePageUrl = "https://cart.onliner.by/";

    @FindBy(xpath = "//div[@class='cart-form__description cart-form__description_primary cart-form__description_base-alter cart-form__description_font-weight_semibold cart-form__description_condensed-other']")
    private List<SearchItem> items;

    @FindBy(xpath = "//div[@class='cart-form__title cart-form__title_big-alter cart-form__title_condensed-additional']")
    private ExtendedWebElement text;

    @FindBy(xpath = "//div[@class='cart-form__description cart-form__description_other cart-form__description_extended']")
    private ExtendedWebElement description;

    public List<SearchItem> getItems() {
        return items;
    }

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(text);
        setPageAbsoluteURL(comparePageUrl);
    }

    public int getNumber() {
        String s = description.getElement().getText();
        int n = parseInt(s.substring(0, 1));
        LOGGER.info("Items in cart: " + n);
        return n;
    }
}
