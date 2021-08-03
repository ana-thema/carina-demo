package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DiaryPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Dismiss'`]")
    private ExtendedWebElement dismiss;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'PremiumUpsellViewController_closeButton'`]")
    private ExtendedWebElement closeAd;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Skip'`]")
    private ExtendedWebElement skip;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == 'MyFitnessPal'`]")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'DIARY'`]")
    private ExtendedWebElement diary;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Add Entry'`]")
    private ExtendedWebElement addEntry;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'STATUS'`]")
    private ExtendedWebElement addStatus;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeKey")
    private ExtendedWebElement enterStatus;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]")
    private ExtendedWebElement text;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Done'`]")
    private ExtendedWebElement done;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Dismiss'`]")
    private ExtendedWebElement alert;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        pause(5);
        dismiss.click();
        closeAd.click();
        skip.click();
        driver.getPageSource();
        return logo.isElementPresent();
    }

    @Override
    public DiaryPageBase openDiary(){
        diary.click();
        return initPage(getDriver(), DiaryPageBase.class);
    }

    @Override
    public String addStatus(String status){
        addEntry.click();
        driver.getPageSource();
        addStatus.click();
        enterStatus.type(status);
        String enteredStatus = enterStatus.getElement().getText();
        done.click();
        return enteredStatus;
    }
}
