package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Integer.parseInt;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(text(), 'Log In')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(), 'Food')]")
    private ExtendedWebElement food;

    @FindBy(xpath = "//div[@class='close-btn-container']")
    private ExtendedWebElement closeAd;

    @FindBy(xpath = "//div[@class='add-buttons']/a")
    private ExtendedWebElement addExercise;

    @FindBy(xpath = "//div[@class='add-buttons']/a[2]")
    private ExtendedWebElement addFood;

    @FindBy(xpath = "//div[@class='energy-remaining']/div/div")
    private ExtendedWebElement remainingHome;

    @FindBy(xpath = "//div[@class='value'][1]/span[@class='num']")
    private ExtendedWebElement foodCalHome;

    @FindBy(xpath = "//div[@class='value'][2]/span[@class='num']")
    private ExtendedWebElement exCalHome;

    @FindBy(xpath = "//div[@class='value'][3]/span[@class='num']")
    private ExtendedWebElement netCalHome;

    @FindBy(xpath = "//div[@class='value goal']/span[@class='num']")
    private ExtendedWebElement goalHome;

    @FindBy(xpath = "//a[contains(text(), 'Goals')]")
    private ExtendedWebElement goalsBtn;

    @FindBy(xpath = "//a[contains(text(), 'Check-In')]")
    private ExtendedWebElement checkInBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(food);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public LoginPage getLoginPage() {
        loginBtn.click();
        return new LoginPage(driver);
    }

    public DiaryPage addFood() {
        if (closeAd.isElementPresent())
            closeAd.click();
        driver.getPageSource();
        addFood.click();
        return new DiaryPage(driver);
    }

    public GoalsPage getGoalsPage() {
        goalsBtn.click();
        return new GoalsPage(driver);
    }

    public CheckInPage getCheckInPage() {
        checkInBtn.click();
        return new CheckInPage(driver);
    }

    public int getRemainingCaloriesHome() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(remainingHome.getBy()), 10);
        return parseInt(remainingHome.getElement().getText().replaceAll(",", ""));
    }

    public int getExerciseCalories() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(exCalHome.getBy()), 10);
        return parseInt(exCalHome.getElement().getText().replaceAll(",", ""));
    }


    public int calculateNet() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(foodCalHome.getBy()), 10);
        int foodCal = parseInt(foodCalHome.getElement().getText().replaceAll(",", ""));
        int exCal = parseInt(exCalHome.getElement().getText().replaceAll(",", ""));
        return foodCal - exCal;
    }

    public int getNetCal() {
        return parseInt(netCalHome.getElement().getText().replaceAll(",", ""));
    }

    public int calculateRemaining() {
        int goalCal = parseInt(goalHome.getElement().getText().replaceAll(",", ""));
        int netCal = parseInt(netCalHome.getElement().getText().replaceAll(",", ""));
        return goalCal - netCal;
    }

    public DiaryPage addExercise() {
        if (closeAd.isElementPresent())
            closeAd.click();
        driver.getPageSource();
        addExercise.click();
        return new DiaryPage(driver);
    }

    public int getNewRemainingCalories(int remaining, int exerciseCal) {
        return remaining + exerciseCal;
    }
}
