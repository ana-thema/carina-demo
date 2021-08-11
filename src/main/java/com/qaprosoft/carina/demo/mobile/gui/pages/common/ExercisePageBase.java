package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ExercisePageBase extends AbstractPage {
    public ExercisePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addExercise();

    public abstract ExerciseRoutinesPageBase clickWorkoutRoutine();
}
