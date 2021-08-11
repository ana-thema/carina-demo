package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Nutrients;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MealsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static java.lang.Double.parseDouble;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MealsPageBase.class)
public class MealsPage extends MealsPageBase {
    public MealsPage(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'MFPSearchBarView'`]/XCUIElementTypeButton")
    private ExtendedWebElement searchClick;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSearchField")
    private ExtendedWebElement search;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Search'`]")
    private ExtendedWebElement searchKeyBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Yogurt'`][3]")
    private ExtendedWebElement item1;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Apple'`][1]")
    private ExtendedWebElement item2;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == '1 medium'`][2]")
    private ExtendedWebElement sizeBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == '1 small'`]")
    private ExtendedWebElement size;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
    private ExtendedWebElement numberBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypePicker/XCUIElementTypePickerWheel[1]")
    private ExtendedWebElement number;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Confirm'`]")
    private ExtendedWebElement confirm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Done'`]")
    private ExtendedWebElement done;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Next'`]")
    private ExtendedWebElement next;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Add Food']")
    private ExtendedWebElement add;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Quick Add'`]")
    private ExtendedWebElement quickAdd;

    @ExtendedFindBy(iosClassChain = "**XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    private ExtendedWebElement calories;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[11]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement fat;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[18]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement carbs;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[20]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement sugar;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[24]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement protein;

    @Override
    public void addBreakfast() {
        searchClick.click();
        search.type("yogurt");
        searchKeyBtn.click();
        item1.click();
    }

    @Override
    public void addLunch() {
        next.click();
        next.click();
        done.click();
        driver.getPageSource();
        searchClick.click();
        search.type("apple");
        searchKeyBtn.click();
        item2.click();
        sizeBtn.click();
        driver.getPageSource();
        size.click();
        confirm.click();
        numberBtn.click();
        driver.getPageSource();
        number.getElement().sendKeys("2");
        done.click();
    }

    @Override
    public void quickAddLunch(String amount) {
        add.click();
        driver.getPageSource();
        quickAdd.click();
        calories.type(amount);
    }

    @Override
    public double getNutrients(Nutrients n) {
        switch (n.getName()) {
            case ("Protein"):
                driver.getPageSource();
                String p = protein.getElement().getText();
                return parseDouble(p.substring(0, p.length() - 2));
            case ("Fat"):
                String f = fat.getElement().getText();
                return parseDouble(f.substring(0, f.length() - 2));
            case ("Carbs"):
                String c = carbs.getElement().getText();
                return parseDouble(c.substring(0, c.length() - 2));
            case ("Sugar"):
                String s = sugar.getElement().getText();
                return parseDouble(s.substring(0, s.length() - 2));
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }

}
