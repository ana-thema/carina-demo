package com.qaprosoft.carina.demo.mobile.gui.pages.additional;

import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.ExerciseRoutinePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ExerciseRoutines extends AbstractUIObject {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Unnamed Routine'`]")
    private List<ExerciseRoutines> routinesList;

    public ExerciseRoutines(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


}
