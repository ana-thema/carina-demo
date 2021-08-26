package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;

public class GoalsEditPage extends AbstractPage {

    private final String comparePageUrl = "https://www.myfitnesspal.com/account/my_goals/daily_nutrition_goals";

    @FindBy(xpath = "//span[@class=' percentage-at100 ']")
    private ExtendedWebElement percentageAt100;

    @FindBy(xpath = "//span[@class='  percentage-below100']")
    private ExtendedWebElement percentageBelow100;

    @FindBy(xpath = "//span[@class='percentage-above100  ']")
    private ExtendedWebElement percentageAbove100;

    @FindBy(xpath = "//select[@class='mfp-input form-control ember-view x-select']")
    private ExtendedWebElement editCarbs;

    public GoalsEditPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(comparePageUrl);
    }

    public String getPercentage(){
        if (percentageAbove100.isElementPresent())
            return percentageAbove100.getElement().getText();
        else if (percentageBelow100.isElementPresent())
            return percentageBelow100.getElement().getText();
        else return percentageAt100.getElement().getText();
    }

    public String getCarbs(){
        return editCarbs.getElement().getText();
    }

    public void editCarbs(String newValue){
        editCarbs.click();
        editCarbs.getElement().sendKeys(newValue);
    }

    public String countPercentage(String newValue){
        int p = parseInt(newValue) + 30 + 20;
        return p + "%";
    }
}
