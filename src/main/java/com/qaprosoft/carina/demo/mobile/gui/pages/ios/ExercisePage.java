package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ExercisePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ExerciseRoutinesPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ExercisePageBase.class)
public class ExercisePage extends ExercisePageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Cardio'`]")
    private ExtendedWebElement cardio;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Workout Routine'`]")
    private ExtendedWebElement routine;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'MY ROUTINES'`]")
    private ExtendedWebElement myRoutinesBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Create a New Exercise'`]")
    private ExtendedWebElement createNewExercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField")
    private ExtendedWebElement exerciseName;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    private ExtendedWebElement minutes;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeTextField")
    private ExtendedWebElement caloriesBurned;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD EXERCISE'`]")
    private ExtendedWebElement exercise;

    public ExercisePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addExercise(){
        driver.getPageSource();
        if (!cardio.isElementPresent()){
            exercise.click();
        }
        cardio.click();
        createNewExercise.click();
        exerciseName.type("Exercise");
        minutes.type("15");
        caloriesBurned.type("100");
    }

    @Override
    public ExerciseRoutinesPageBase clickWorkoutRoutine(){
        driver.getPageSource();
        if (!routine.isElementPresent()){
            exercise.click();
        }
        routine.click();
        myRoutinesBtn.click();
        return initPage(getDriver(), ExerciseRoutinesPageBase.class);
    }
}
