package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckInPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@id='weight_display_value']")
    private ExtendedWebElement weightValueField;

    @FindBy(xpath = "//p[@class='flash']")
    private ExtendedWebElement flash;

    @FindBy(xpath = "//p[@class='cont-2']/span[2]")
    private ExtendedWebElement text;

    @FindBy(xpath = "//p[@class='cont-1']/input")
    private ExtendedWebElement saveBtn;

    private final String comparePageUrl = "https://www.myfitnesspal.com/measurements/check_in";

    public CheckInPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(comparePageUrl);
    }

    public void enterWeightValue(String value) {
        weightValueField.type(value);
        driver.getPageSource();
        saveBtn.click();
    }

    public String getRecord() {
        return text.getElement().getText();
    }

    public String getFlashText() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(flash.getBy()), 10);
        return flash.getElement().getText();
    }

}
