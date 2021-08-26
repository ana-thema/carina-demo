package com.qaprosoft.carina.demo.gui.pages.mfp;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoalsPage extends AbstractPage {

    private final String comparePageUrl = "https://www.myfitnesspal.com/account/my_goals";

    @FindBy(xpath = "//div[@class='col right']/a")
    private ExtendedWebElement editBtn;

    public GoalsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(comparePageUrl);
    }

    public GoalsEditPage clickEditBtn(){
        editBtn.click();
        return new GoalsEditPage(driver);
    }
}
