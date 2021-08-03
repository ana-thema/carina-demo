package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignUpPageBase extends AbstractPage {

    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void signUp();

    public abstract void pickGoals();

    public abstract void enterPersonalInfo();

    public abstract void enterWeight();

    public abstract HomePageBase enterDetails(String randEmail, String randPasswd);

    public abstract boolean enterShortPassword(String randEmail, String randPasswd);

    public abstract String shortPasswordAlert();
}
