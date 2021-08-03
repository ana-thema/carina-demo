package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.exception.NotImplementedException;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MyLogInPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignUpPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MyWelcomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MyWelcomePageBase.class)
public class MyWelcomePage extends MyWelcomePageBase{
    public MyWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignUpPageBase clickSignUpBtn() {
        throw new NotImplementedException();
    }

    @Override
    public MyLogInPageBase clickLoginBtn() {
        throw new NotImplementedException();
    }
}
