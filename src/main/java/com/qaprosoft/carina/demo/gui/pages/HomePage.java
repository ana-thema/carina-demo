/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='dn-footer-service']")
    private FooterMenu footerMenu;

    @FindBy(className = "tms-slider")
    private ExtendedWebElement tmsSlider;

    @FindBy(xpath = "//li[@class='top left']")
    private ExtendedWebElement topLeft;

    @FindBy(xpath = "//div[@class='dn-middle-menu-wrap']/a[contains(text(), 'Каталог товаров')]")
    private ExtendedWebElement catalog;

    @FindBy(xpath = "//div[@class='news-item']")
    private List<NewsItem> news;

    @FindBy(xpath = "//form")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//input[@class='multi-input']")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//div[@class='multi-content']")
    private List<SearchItem> items;

    @FindBy(xpath = "//div[@class='dn-bm-login']/a/span")
    private ExtendedWebElement cabinet;

    @FindBy(xpath = "//div[@class='dn-login-dropdown dn-logoff-dropdown']/a[contains(text(), 'Войти')]")
    private ExtendedWebElement login;

    @FindBy(xpath = "//jdiv[@class='hoverl_b520']")
    private ExtendedWebElement consult;

    @FindBy(xpath = "//jdiv[@class='closeIcon_c499']")
    private ExtendedWebElement consultClose;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(tmsSlider);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public AboutUsPage openAboutUsPage() {
        assertElementPresent(topLeft);
        topLeft.click();
        return new AboutUsPage(driver);
    }

    public List<SearchItem> searchFor(String q) {
        searchField.click();
        searchTextField.type(q);
        return items;
    }

    public CatalogPage openCatalogPage() {
        assertElementPresent(catalog);
        catalog.click();
        return new CatalogPage(driver);
    }

    public void openConsultant() {
        assertElementPresent(consult);
        consult.click();
        assertElementPresent(consultClose);
        consultClose.click();
    }

    public Cabinet openCabinet() {
        assertElementPresent(cabinet);
        cabinet.click();
        login.click();
        return new Cabinet(driver);
    }

    /*
    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }*/

    public List<NewsItem> searchStore(String q) {
        searchTextField.type(q);
        return news;
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
        return new WeValuePrivacyAd(driver);
    }
}
