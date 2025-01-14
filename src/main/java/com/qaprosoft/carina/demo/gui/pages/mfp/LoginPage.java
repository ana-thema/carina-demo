package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='username']")
    private ExtendedWebElement emailAddressField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//li[@class='submit']/input[@value='Log In']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//div[@class='ccpa-banner-container']/i")
    private ExtendedWebElement close;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/account/login");
    }

    public void auth(String email, String password){
        driver.getPageSource();
        if (close.isElementPresent())
            close.click();
        emailAddressField.type(email);
        passwordField.type(password);
        loginBtn.click();
    }
}
