package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MyWelcomePageBase extends AbstractPage {
    public MyWelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignUpPageBase clickSignUpBtn();

    public abstract MyLogInPageBase clickLoginBtn();
}
