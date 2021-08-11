package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignUpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignUpPageBase.class)
public class MySignUpPage extends SignUpPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Sign Up with Email'`]")
    private ExtendedWebElement emailSignUp;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Lose weight'`]")
    private ExtendedWebElement goals1;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Modify my diet'`]")
    private ExtendedWebElement goals2;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Next'`]")
    private ExtendedWebElement next;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Stress around food choices'`]")
    private ExtendedWebElement barriers;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Less sugar'`]")
    private ExtendedWebElement focus;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Lightly ActiveSpend a good part of the day on your feet (e.g. teacher, salesperson)'`]")
    private ExtendedWebElement activity;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Male'`]")
    private ExtendedWebElement sex;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Jan 1, 1970'`]")
    private ExtendedWebElement ageBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypePickerWheel[1]")
    private ExtendedWebElement pickMonth;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypePickerWheel[2]")
    private ExtendedWebElement pickDay;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypePickerWheel[3]")
    private ExtendedWebElement pickYear;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Confirm'`]")
    private ExtendedWebElement confirm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField")
    private ExtendedWebElement code;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Kilograms'`]")
    private ExtendedWebElement kilos;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Centimeters'`]")
    private ExtendedWebElement cms;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    private ExtendedWebElement height;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")
    private ExtendedWebElement weight1;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]")
    private ExtendedWebElement weight2;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    private ExtendedWebElement email;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private ExtendedWebElement password;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Sign Up'`]")
    private ExtendedWebElement signUpBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Continue'`]")
    private ExtendedWebElement continueBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Password is too short. Minimum is 10 characters.'`]")
    private ExtendedWebElement alertText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'OK'`]")
    private ExtendedWebElement okBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Unable to Proceed'`]")
    private ExtendedWebElement alert;

    @Override
    public boolean isPageOpened() {
        driver.getPageSource();
        return emailSignUp.isElementPresent();
    }

    @Override
    public void signUp() {
        emailSignUp.click();
    }

    @Override
    public void pickGoals() {
        driver.getPageSource();
        goals1.click();
        goals2.click();
        next.click();
        next.click();
        driver.getPageSource();
        barriers.click();
        next.click();
        next.click();
        driver.getPageSource();
        focus.click();
        next.click();
        next.click();
        driver.getPageSource();
        activity.click();
    }

    @Override
    public void enterPersonalInfo() {
        sex.click();
        ageBtn.click();
        driver.getPageSource();
        pickMonth.getElement().sendKeys("April");
        pickDay.getElement().sendKeys("7");
        pickYear.getElement().sendKeys("1996");
        confirm.click();
        code.type("22222");
        next.click();
    }

    @Override
    public void enterWeight() {
        height.click();
        driver.getPageSource();
        if (!cms.isElementPresent() ){
            height.click();
        }
        cms.click();
        confirm.click();
        weight1.click();
        driver.getPageSource();
        kilos.click();
        weight1.type("90");
        weight2.type("70");
        next.click();
        next.click();
    }

    @Override
    public HomePageBase enterDetails(String randEmail, String randPasswd) {
        email.type(randEmail + "@gmail.com");
        password.type(randPasswd);
        signUpBtn.click();
        pause(10);
        continueBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public boolean enterShortPassword(String randEmail, String randPasswd) {
        email.type(randEmail + "@gmail.com");
        password.type(randPasswd);
        if (password.getElement().getText() != randPasswd){
            password.getElement().clear();
            password.type(randPasswd);
        }
        signUpBtn.click();
        boolean a = alert.isElementPresent();
        driver.getPageSource();
        okBtn.click();
        return a;
    }

    @Override
    public String shortPasswordAlert() {
        return alertText.getElement().getText();
    }

    public MySignUpPage(WebDriver driver) {
        super(driver);
    }
}
