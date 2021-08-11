package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Buttons;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.ExerciseRoutines;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ExerciseRoutinesPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ExerciseRoutinesPageBase.class)
public class ExerciseRoutinePage extends ExerciseRoutinesPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD EXERCISE'`]")
    private ExtendedWebElement addExerciseBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Push Up'`]")
    private ExtendedWebElement pushUpExercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Bent Over Row'`]")
    private ExtendedWebElement bentOverRowExercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'ADD (2)'`]")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Deadlift']")
    private ExtendedWebElement deadliftExercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Back Squat'`]")
    private ExtendedWebElement backSquatExercise;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'SAVE'`]")
    private ExtendedWebElement saveBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'CONTINUE'`]")
    private ExtendedWebElement continueBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'No'`]")
    private ExtendedWebElement noBtn;

    @FindBy(xpath= "(//XCUIElementTypeButton[@name='ic tabbar more active redesign'])[1]")
    private ExtendedWebElement menuBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'BUILD ROUTINE'`]")
    private ExtendedWebElement buildRoutineBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Unnamed Routine'`]")
    private ExtendedWebElement unnamedRoutine;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Unnamed Routine'`]")
    private List<ExerciseRoutines> routinesList;

    @FindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/*/*/XCUIElementTypeButton")
    private List<Buttons> buttonsList;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Edit'`]")
    private ExtendedWebElement editBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Remove Exercise'`]")
    private ExtendedWebElement removeExBtn;

    @FindBy(xpath = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]/*/*/XCUIElementTypeButton")
    private List<Buttons>  removalBtnsList;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Cancel'`]")
    private ExtendedWebElement cancelBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == 'Remove'`]")
    private ExtendedWebElement removeBtn;

    public ExerciseRoutinePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addWorkoutRoutine1(){
        buildRoutineBtn.click();
        addExerciseBtn.click();
        pushUpExercise.click();
        bentOverRowExercise.click();
        addBtn.click();
    }

    @Override
    public void addWorkoutRoutine2(){
        buildRoutineBtn.click();
        addExerciseBtn.click();
        deadliftExercise.click();
        backSquatExercise.click();
        addBtn.click();
    }

    @Override
    public void saveRoutine(){
        saveBtn.click();
        if (continueBtn.isElementPresent()){
            continueBtn.click();
        }
        driver.getPageSource();
        noBtn.click();
    }

    @Override
    public void openRoutineMenu(){
        unnamedRoutine.click();
        menuBtn.click();
        driver.getPageSource();
    }

    @Override
    public List<ExerciseRoutines> getRoutinesList(){
        return routinesList;
    }

    @Override
    public List<Buttons> getButtonsList(){
        return buttonsList;
    }

    @Override
    public List<Buttons> getRemovalButtonsList(){
        return removalBtnsList;
    }

    @Override
    public int getNumberOfRoutines(List<ExerciseRoutines> list){
        return list.size();
    }

    @Override
    public void removeBtnClick(){
        removeExBtn.click();
        driver.getPageSource();
    }

    @Override
    public void removeExercise(){
        removeBtn.click();
        saveBtn.click();
    }

    @Override
    public void clickEditBtn(){
        editBtn.click();
        menuBtn.click();
        driver.getPageSource();
    }
}
