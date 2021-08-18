package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Meals;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Nutrients;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Integer.parseInt;

public class DiaryPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String comparePageUrl = "https://www.myfitnesspal.com/food/diary";

    @FindBy(xpath = "//td[contains(text(), '%s')] /../following-sibling::tr/td/a[@class='add_food']")
    private ExtendedWebElement addFoodBtn;

    @FindBy(xpath = "//td[contains(text(), 'Breakfast')] /../following-sibling::tr/td/a[@class='add_food']")
    private ExtendedWebElement addBreakfast;

    @FindBy(xpath = "//td[contains(text(), 'Lunch')] /../following-sibling::tr/td/a[@class='add_food']")
    private ExtendedWebElement addLunch;

    @FindBy(xpath = "//input[@id='search']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//input[@value='Search']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//tr[@class='total']/td[2]")
    private ExtendedWebElement totals;

    @FindBy(xpath = "//tr[@class='total alt']/td[2]")
    private ExtendedWebElement dailyGoal;

    @FindBy(xpath = "//tr[@class='total remaining']/td[2]")
    private ExtendedWebElement remaining;

    @FindBy(xpath = "//tr[@class='total']/td/span[@class='macro-value']['%d']")
    private ExtendedWebElement totalsMacros;

    @FindBy(xpath = "//tr[@class='total alt']/td/span[@class='macro-value']['%d']")
    private ExtendedWebElement dailyGoalMacros;

    @FindBy(xpath = "//tr[@class='total remaining']/td/span[@class='macro-value']['%d']")
    private ExtendedWebElement remainingMacros;

    @FindBy(xpath = "//i[@class='icon-minus-sign']")
    private ExtendedWebElement minusBtn;

    @FindBy(xpath = "//a[contains(text(), 'My Home')]")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//li[contains(text(), '+2 cups')]")
    private ExtendedWebElement addCups;

    @FindBy(xpath = "//span[@class='water-value-static']")
    private ExtendedWebElement cupsAmount;

    @FindBy(xpath = "//input[@class='add-custom-amount']")
    private ExtendedWebElement waterCustomInput;

    @FindBy(xpath = "//li[contains(text(), '+3 cups')]")
    private ExtendedWebElement customCupsAmount;

    @FindBy(xpath = "//input[@type='button'][@value='Add']")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//input[@type='button'][@value='Save']")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//span[@class='edit-daily-value-icon']")
    private ExtendedWebElement editCupsbtn;

    @FindBy(xpath = "//input[@class='water-value-input']")
    private ExtendedWebElement waterValueInput;

    @FindBy(xpath = "//a[contains(text(), 'Add Exercise')]")
    private ExtendedWebElement addExercise;

    @FindBy(xpath = "//time")
    private ExtendedWebElement date;

    public DiaryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(comparePageUrl);
    }

    public void enterFood(Meals meal) {
        switch (meal.getName()) {
            case ("Breakfast"): {
                driver.getPageSource();
                if (addBreakfast.isElementPresent())
                    addBreakfast.click();
                break;
            }
            case ("Lunch"): {
                driver.getPageSource();
                addLunch.click();
                break;
            }
        }
    }

    public void enterExercise(){
        driver.getPageSource();
        addExercise.click();
    }

    public SearchPage addMealOrExercise(String name) {
        searchField.type(name);
        searchBtn.click();
        return new SearchPage(driver);
    }

    public int getRemainingMacros(Nutrients nutrients) {
        int m;
        switch (nutrients.getName()) {
            case ("Calories"): {
                int r = parseInt(remaining.getElement().getText().replaceAll(",", ""));
                LOGGER.info("Remaining " + nutrients.getName() + " " + r);
                return r;
            }
            case ("Carbs"): {
                remainingMacros.format(1);
                break;
            }
            case ("Fat"): {
                remainingMacros.format(2);
                break;
            }
            case ("Protein"): {
                remainingMacros.format(3);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + nutrients.getName());
        }
        m = parseInt(remainingMacros.getElement().getText().replaceAll(",", ""));
        LOGGER.info("Remaining " + nutrients.getName() + " " + m);
        return m;
    }

    public int calculateMacros(Nutrients nutrients) {
        int total;
        int goal;
        switch (nutrients.getName()) {
            case ("Calories"): {
                int totalCal = parseInt(totals.getElement().getText().replaceAll(",", ""));
                int goalCal = parseInt(dailyGoal.getElement().getText().replaceAll(",", ""));
                LOGGER.info("Total " + nutrients.getName() + " " + totalCal);
                LOGGER.info("Goal " + nutrients.getName() + " " + goalCal);
                return goalCal - totalCal;
            }
            case ("Carbs"): {
                totalsMacros.format(1);
                dailyGoalMacros.format(1);
                break;
            }
            case ("Fat"): {
                totalsMacros.format(2);
                dailyGoalMacros.format(2);
                break;
            }
            case ("Protein"): {
                totalsMacros.format(3);
                dailyGoalMacros.format(3);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + nutrients.getName());
        }
        total = parseInt(totalsMacros.getElement().getText().replaceAll(",", ""));
        goal = parseInt(dailyGoalMacros.getElement().getText().replaceAll(",", ""));
        LOGGER.info("Total " + nutrients.getName() + " " + total);
        LOGGER.info("Goal " + nutrients.getName() + " " + +goal);
        return goal - total;
    }

    public void deleteAll() {
        while (minusBtn.isElementPresent())
            minusBtn.click();
    }

    public void returnHome() {
        homeBtn.click();
    }

    public void addCups() {
        addCups.click();
    }

    public int getAddedCups() {
        return parseInt(cupsAmount.getElement().getText());
    }

    public void addCustomCups() {
        waterCustomInput.type("3");
        addBtn.click();
    }

    public boolean checkCustomCups() {
        return customCupsAmount.isElementPresent();
    }

    public void editCups() {
        editCupsbtn.click();
        waterValueInput.type("0");
        saveBtn.click();
    }

    public String getDate() {
        return date.getElement().getText();
    }
}
