package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Cabinet extends AbstractPage {

    private final String comparePageUrl = "https://xiaomi-store.by/login";

    @FindBy(xpath = "//button[@class='btn btn-primary mt20']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[@class='form-group field-loginform-email required has-error']//p[@class='error']")
    private ExtendedWebElement errMail;

    @FindBy(xpath = "//div[@class='form-group field-loginform-password required has-error']//p[@class='error']")
    private ExtendedWebElement errPassword;

    @FindBy(xpath = "//div[@class='gaReCaptcha field-loginform-recaptcha has-error']//p[@class='error']")
    private ExtendedWebElement errCapcha;

    public Cabinet(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
        setPageAbsoluteURL(comparePageUrl);
    }

    public void login() {
        loginButton.click();
    }

    public String readErrMail() {
        return errMail.getText();
    }

    public String readErrPassword() {
        return errPassword.getText();
    }

    public String readErrCaptcha() {
        return errCapcha.getText();
    }
}
