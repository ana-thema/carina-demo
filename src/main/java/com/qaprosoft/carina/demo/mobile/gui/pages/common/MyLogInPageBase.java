package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MyLogInPageBase extends AbstractPage {
    public MyLogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase login(String email, String passwd);
}
