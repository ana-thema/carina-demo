package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DiaryPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD FOOD'`][1]")
    private ExtendedWebElement breakfast;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD FOOD'`][2]")
    private ExtendedWebElement lunch;

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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Save'`]")
    private ExtendedWebElement save;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == '1 medium'`][2]")
    private ExtendedWebElement sizeBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == '1 small'`]")
    private ExtendedWebElement size;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
    private ExtendedWebElement numberBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePicker/XCUIElementTypePickerWheel[1]")
    private ExtendedWebElement number;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Confirm'`]")
    private ExtendedWebElement confirm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Done'`]")
    private ExtendedWebElement done;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Next'`]")
    private ExtendedWebElement next;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Add Food'`]")
    private ExtendedWebElement add;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Quick Add'`]")
    private ExtendedWebElement quickAdd;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    private ExtendedWebElement calories;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText[3]")
    private ExtendedWebElement item1cal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeStaticText[3]")
    private ExtendedWebElement item2Cal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[8]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement quickAddCal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Lunch'`]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement lunchCal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Breakfast'`]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement breakCal;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Dinner'`]")
    private ExtendedWebElement dinner;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD EXERCISE'`]")
    private ExtendedWebElement exercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'MORE'`]")
    private ExtendedWebElement more;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Cardio'`]")
    private ExtendedWebElement cardio;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Create a New Exercise'`]")
    private ExtendedWebElement createNewExercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    private ExtendedWebElement exerciseName;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    private ExtendedWebElement minutes;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeTextField")
    private ExtendedWebElement caloriesBurned;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[11]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement fat;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[18]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement carbs;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[20]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement sugar;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[24]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement protein;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Dismiss'`]")
    private ExtendedWebElement dismiss;

    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addBreakfast() {
        breakfast.click();
        searchClick.click();
        search.type("yogurt");
        searchKeyBtn.click();
        item1.click();
    }

    @Override
    public void addLunch() {
        lunch.click();
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
        lunch.click();
        add.click();
        driver.getPageSource();
        quickAdd.click();
        calories.type(amount);
        if (calories.getElement().getText() != amount)
        {calories.type(amount);}
        save.click();
    }

    @Override
    public void save(){
        save.click();
    }

    @Override
    public void addExercise() {
        exercise.click();
        driver.getPageSource();
        if (!cardio.isElementPresent()){
            exercise.click();
        }
        cardio.click();
        createNewExercise.click();
        exerciseName.type("Exercise");
        minutes.type("15");
        caloriesBurned.type("100");
        save.click();
        driver.getPageSource();
        dismiss.click();
    }

    @Override
    public int getItemCalories() {
        driver.getPageSource();
        return parseInt(item1cal.getElement().getText());
    }

    @Override
    public double getFats(){
        driver.getPageSource();
        String s = fat.getElement().getText();
        return parseDouble(s.substring(0, s.length() - 2));
    }

    @Override
    public double getCarbs(){
        String s = carbs.getElement().getText();
        return parseDouble(s.substring(0, s.length() - 2));
    }

    @Override
    public double getSugar(){
        String s = sugar.getElement().getText();
        return parseDouble(s.substring(0, s.length() - 2));
    }

    @Override
    public double getProtein(){
        driver.getPageSource();
        String s = protein.getElement().getText();
        return parseDouble(s.substring(0, s.length() - 2));
    }

    @Override
    public int getItemsCalories() {
        int i1 = parseInt(item2Cal.getElement().getText().replaceAll(",", ""));
        int i2 = parseInt(quickAddCal.getElement().getText().replaceAll(",", ""));
        return i1 + i2;
    }

    @Override
    public int getBreakfastCalories() {
        String s = breakCal.getElement().getText().replaceAll(",", "");
        LOGGER.info("Breakfast Calories: " + s);
        return parseInt(s);
    }

    @Override
    public int getLunchCalories() {
        String s = lunchCal.getElement().getText().replaceAll(",", "");
        LOGGER.info("Lunch Calories: " + s);
        return parseInt(s);
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
