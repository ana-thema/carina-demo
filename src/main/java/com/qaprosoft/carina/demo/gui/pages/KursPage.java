package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.SearchBar;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Double.parseDouble;

public class KursPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1")
    private ExtendedWebElement text;

    @FindBy(xpath = "//p[@class='value fall']/b[1]")
    private ExtendedWebElement value;

    @FindBy(xpath = "//li[@class='bank to-be-removed']/i/p/b")
    private ExtendedWebElement bank;

    @FindBy(xpath = "//select[@name='currency-in']/option[@value='usd']")
    private ExtendedWebElement inputCurrency;

    @FindBy(xpath = "//p[@class='abbr rate']/b[contains(text(), 'USD')]")
    private ExtendedWebElement bankCurrency;

    @FindBy(xpath = "//input[@name='amount-in']")
    private ExtendedWebElement input;

    @FindBy(xpath = "//b[@class='js-cur-result']")
    private ExtendedWebElement result;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//a[@target='_parent'][contains(text(), 'Телевизоры')]")
    private ExtendedWebElement tvs;

    @FindBy(xpath = "//div[@class='auth-bar__item auth-bar__item--text']")
    private ExtendedWebElement loginBtn;

    public KursPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(text);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public double getBankValue1() {
        String s = value.getElement().getText();
        LOGGER.info("Rate: " + s);
        return parseDouble(s.replaceAll(",", "."));
    }

    public String getBankCurr() {
        String s = bankCurrency.getElement().getText();
        return s.substring(2);
    }

    public String getInputCurr() {
        return inputCurrency.getElement().getText();
    }

    public double getBankValue2() {
        String s = bank.getElement().getText();
        return parseDouble(s.replaceAll(",", "."));
    }

    public double getInputValue(String q) {
        input.getElement().clear();
        input.type(q);
        return parseDouble(q);
    }

    public double getResult(double value, double kurs) {
        double r = value * kurs;
        LOGGER.info("Result: " + r + " BYN");
        return r;
    }

    public double getResultField() {
        String s = result.getElement().getText();
        return parseDouble(s.replaceAll(",", "."));
    }

    public SearchBar searchCatalog(String s){
        assertElementPresent(searchField);
        searchField.click();
        //searchField.type(s);
        return new SearchBar(driver);
    }

    public LoginPage getLoginPage(){
        loginBtn.click();
        return new LoginPage(driver);
    }

}
