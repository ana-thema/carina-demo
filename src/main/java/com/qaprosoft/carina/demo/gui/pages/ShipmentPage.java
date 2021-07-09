package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ShipmentPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String comparePageUrl = "https://xiaomi-store.by/pages/dostavka";

    @FindBy(xpath = "//h4[contains(text(), 'Способы получения заказа:')]")
    private ExtendedWebElement text_methods;

    @FindBy(xpath = "//h4[contains(text(), 'Положения доставки:')]")
    private ExtendedWebElement text_regulations;

    @FindBy(xpath = "//div[@class='dn-header-banner']")
    private ExtendedWebElement home;


    public ShipmentPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(text_methods);
        setPageAbsoluteURL(comparePageUrl);
    }

    public String readTextMethod() {
        return text_methods.getText();
    }

    public String readTextRegulations() {
        return text_regulations.getText();
    }

    public HomePage returnHome() {
        assertElementPresent(home);
        home.click();
        return new HomePage(driver);
    }

}
