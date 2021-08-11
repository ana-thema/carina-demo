package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Meals;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Nutrients;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DiaryPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ExercisePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MealsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//XCUIElementTypeOther[@name='%s']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeButton[@name='ADD FOOD']")
    private ExtendedWebElement addFoodButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD FOOD'`][1]")
    private ExtendedWebElement breakfast;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD FOOD'`][2]")
    private ExtendedWebElement lunch;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText[3]")
    private ExtendedWebElement item1cal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeStaticText[3]")
    private ExtendedWebElement item2Cal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[8]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement quickAddCal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Lunch'`]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement lunchCal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Breakfast'`]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement breakCal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD EXERCISE'`]")
    private ExtendedWebElement exercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'MORE'`]")
    private ExtendedWebElement more;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Dismiss'`]")
    private ExtendedWebElement dismiss;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Save'`]")
    private ExtendedWebElement save;

    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MealsPageBase addFood(Meals meal) {
        addFoodButton.format("%s", meal.getName()).click();
        return initPage(getDriver(), MealsPageBase.class);
    }

    @Override
    public void save(){
        save.click();
    }

    @Override
    public ExercisePageBase clickExercise() {
        exercise.click();
        return initPage(getDriver(), ExercisePageBase.class);
    }

    @Override
    public void clickAlert() {
        driver.getPageSource();
        dismiss.click();
    }


    @Override
    public int getItemCalories() {
        driver.getPageSource();
        return parseInt(item1cal.getElement().getText());
    }

    @Override
    public int getItemsCalories() {
        int i1 = parseInt(item2Cal.getElement().getText().replaceAll(",", ""));
        int i2 = parseInt(quickAddCal.getElement().getText().replaceAll(",", ""));
        return i1 + i2;
    }

    @Override
    public int getMealCalories(Meals meal) {
        switch (meal.getName()) {
            case ("Breakfast"):
                String b = breakCal.getElement().getText().replaceAll(",", "");
                LOGGER.info("Breakfast Calories: " + b);
                return parseInt(b);
            case ("Lunch"):
                String l = lunchCal.getElement().getText().replaceAll(",", "");
                LOGGER.info("Lunch Calories: " + l);
                return parseInt(l);
            default:
                throw new IllegalStateException("Unexpected value: " + meal);
        }
    }

    @Override
    public boolean isPageOpened() {
        driver.getPageSource();
        return breakfast.isElementPresent();
    }

    @Override
    public ProfilePageBase openProfile() {
        more.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }
}
