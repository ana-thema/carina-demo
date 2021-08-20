package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Integer.parseInt;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(text(), 'Log In')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//div[@class='close-btn-container']")
    private ExtendedWebElement closeAd;

    @FindBy(xpath = "//div[@class='add-buttons']/a")
    private ExtendedWebElement addExercise;

    @FindBy(xpath = "//div[@class='add-buttons']/a[2]")
    private ExtendedWebElement addFood;

    @FindBy(xpath = "//div[@class='energy-remaining-number ']")
    private ExtendedWebElement remainingHome;

    @FindBy(xpath = "//div[@class='value goal']/span")
    private ExtendedWebElement goalHome;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginBtn);
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

    public int getRemainingCaloriesHome() {
        driver.getPageSource();
        return parseInt(remainingHome.getElement().getText().replaceAll(",", ""));
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
