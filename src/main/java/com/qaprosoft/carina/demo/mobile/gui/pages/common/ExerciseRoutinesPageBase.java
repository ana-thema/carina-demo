package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Buttons;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.ExerciseRoutines;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ExerciseRoutinesPageBase extends AbstractPage {
    public ExerciseRoutinesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addWorkoutRoutine1();

    public abstract void addWorkoutRoutine2();

    public abstract void saveRoutine();

    public abstract void openRoutineMenu();

    public abstract List<ExerciseRoutines> getRoutinesList();

    public abstract List<Buttons> getButtonsList();

    public abstract List<Buttons> getRemovalButtonsList();

    public abstract int getNumberOfRoutines(List<ExerciseRoutines> list);

    public abstract void removeBtnClick();

    public abstract void removeExercise();

    public abstract void clickEditBtn();
}
