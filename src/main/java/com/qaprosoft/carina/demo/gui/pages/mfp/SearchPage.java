package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ExerciseItem;
import com.qaprosoft.carina.demo.gui.components.FoodItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class SearchPage extends AbstractPage {

    private final String comparePageUrl = "https://www.myfitnesspal.com/food/search";

    @FindBy(xpath = "//li[@class='matched-food']")
    private List<FoodItem> matchedFood;

    @FindBy(xpath = "//a[@class='search']")
    private List<ExerciseItem> matchedEx;

    @FindBy(xpath = "//input[@id='update_servings'][@data-food-id]")
    private ExtendedWebElement addFoodToDiaryBtn;

    @FindBy(xpath = "//input[@id='update_exercise'][@data-exercise-id]")
    private ExtendedWebElement addExerciseToDiaryBtn;

    @FindBy(xpath = "//input[@name='exercise_entry[quantity]']")
    private ExtendedWebElement exerciseQuantity;

    @FindBy(xpath = "//input[@name='exercise_entry[quantity]']")
    private ExtendedWebElement exerciseCalories;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(comparePageUrl);
    }

    public List<FoodItem> getMatchedFoodList() {
        return matchedFood;
    }

    public List<ExerciseItem> getMatchedExList() {
        return matchedEx;
    }

    public void getRandomFoodItem(List<FoodItem> list) {
        FoodItem a = list.get(new Random().nextInt(list.size()));
        a.clickItem();
    }

    public void getRandomExItem(List<ExerciseItem> list) {
        ExerciseItem a = list.get(new Random().nextInt(list.size()));
        a.clickItem();
    }

    public void addFoodToDiary() {
        driver.getPageSource();
        waitUntil(ExpectedConditions.presenceOfElementLocated(addFoodToDiaryBtn.getBy()), 5);
        addFoodToDiaryBtn.click();
    }

    public void addExerciseToDiary() {
        exerciseQuantity.type("15");
        waitUntil(ExpectedConditions.presenceOfElementLocated(addExerciseToDiaryBtn.getBy()), 5);
        addExerciseToDiaryBtn.click();
    }

}
