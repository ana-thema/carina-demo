package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private final String comparePageUrl = "https://kurs.onliner.by/";

    @FindBy(xpath = "//div[@class='auth-form__line auth-form__line_condensed']/div/input[@type='text']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//div[@class='auth-form__line auth-form__line_condensed']/div/input[@type='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@class='auth-button auth-button_primary auth-button_middle auth-form__button auth-form__button_width_full']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
        setPageAbsoluteURL(comparePageUrl);
    }

    public void auth(String login, String password) {
        loginField.type(login);
        passwordField.type(password);
        loginButton.click();
    }

}
