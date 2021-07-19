package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class ItemPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(), 'В корзину')]")
    private ExtendedWebElement button;

    @FindBy(xpath = "//a[@class='b-top-profile__cart']")
    private ExtendedWebElement cart;

    @FindBy(xpath = "//span[@itemprop='offerCount']")
    private ExtendedWebElement offerCount;

    @FindBy(xpath = "//span[@class='button-style button-style_another button-style_base offers-form__button']")
    private ExtendedWebElement city;

    @FindBy(xpath = "//span[@class='popover-style popover-style_alter popover-style_small popover-style_bottom-left offers-list__popover offers-list__popover_width_ssm']")
    private WebElement offersForm;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCart(){
        offerCount.click();
        city.click();
        driver.switchTo().defaultContent();
        button.click();
        cart.click();
       return new CartPage(driver);
    }
}
