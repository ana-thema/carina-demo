package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MyLogInPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignUpPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MyWelcomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MyWelcomePageBase.class)
public class MyWelcomePage extends MyWelcomePageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Allow'`]")
    private ExtendedWebElement allow;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'SIGN UP FOR FREE'`]")
    private ExtendedWebElement signUp;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'LOG IN'`]")
    private ExtendedWebElement logIn;

    public MyWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        allow.click();
        return signUp.isElementPresent();
    }

    @Override
    public SignUpPageBase clickSignUpBtn() {
        driver.getPageSource();
        signUp.click();
        return initPage(getDriver(), SignUpPageBase.class);
    }

    public MyLogInPageBase clickLoginBtn() {
        driver.getPageSource();
        logIn.click();
        return initPage(getDriver(), MyLogInPageBase.class);
    }
}
