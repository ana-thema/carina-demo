package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MyLogInPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MyLogInPageBase.class)
public class MyLogInPage extends MyLogInPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private ExtendedWebElement email;

    @ExtendedFindBy(iosClassChain = "XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    private ExtendedWebElement password;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Log In'`]")
    private ExtendedWebElement logInBtn;

    public MyLogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        driver.getPageSource();
        return email.isElementPresent();
    }

    @Override
    public HomePageBase login(String randEmail, String randPasswd) {
        email.type(randEmail);
        password.type(randPasswd);
        logInBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
