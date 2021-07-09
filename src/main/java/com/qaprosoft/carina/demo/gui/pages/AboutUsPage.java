package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AboutUsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String comparePageUrl = "https://xiaomi-store.by/pages/o-nas";

    @FindBy(xpath = "//div//strong")
    private ExtendedWebElement text;

    public AboutUsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(text);
        setPageAbsoluteURL(comparePageUrl);
    }

    public String readText() {
        return text.getText();
    }
}
