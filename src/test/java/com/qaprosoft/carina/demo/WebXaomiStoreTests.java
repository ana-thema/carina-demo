package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.CatalogItem;
import com.qaprosoft.carina.demo.gui.components.Filter;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebXaomiStoreTests implements IAbstractTest {
    @Test()
    public void testAboutUsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        AboutUsPage auPage = homePage.openAboutUsPage();
        Assert.assertTrue(auPage.isPageOpened(), "Home page is not opened");
        String text = auPage.readText();
        Assert.assertEquals(text,"Приветствуем вас в Xiaomi-Store.by (Официальный магазин техники Xiaomi в Беларуси.)","Text is not correct");
    }

    @Test()
    public void testCatalog() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        CatalogPage catalogPage;
        catalogPage = homePage.openCatalogPage();
        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened");
        Filter filter = catalogPage.selectFilters();
        List<CatalogItem> items = filter.selectSmartphonesFilter();
        Assert.assertFalse(CollectionUtils.isEmpty(items), "Items not found!");
        SoftAssert softAssert = new SoftAssert();
        String name;
        for(CatalogItem n : items) {
            name = n.readTitle();
            System.out.println(name);
            softAssert.assertTrue(StringUtils.containsIgnoreCase(name, "Смартфон"),
                    "Invalid search results for " + name);
        }
        softAssert.assertAll();
    }

    @Test()
    public void testShipmentPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.openConsultant();
        ShipmentPage shipmentPage;
        shipmentPage = homePage.getFooterMenu().openShipmentPage();
        Assert.assertTrue(shipmentPage.isPageOpened(), "Shipment page is not opened");
        String text1 = shipmentPage.readTextMethod();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text1,"Способы получения заказа:","Text is not correct");
        String text2 = shipmentPage.readTextRegulations();
        softAssert.assertEquals(text2,"Положения доставки:","Text is not correct");
        softAssert.assertAll();
        homePage = shipmentPage.returnHome();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        final String searchQ = "redmi";
        List<SearchItem> items = homePage.searchFor(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(items), "News not found!");
        SoftAssert softAssert = new SoftAssert();
        for(SearchItem n : items) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
    }

    @Test()
    public void testLoginErr() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        Cabinet cabinet = homePage.openCabinet();
        cabinet.login();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cabinet.readErrMail(),"Необходимо заполнить «Email».","Text is not correct");
        softAssert.assertEquals(cabinet.readErrPassword(),"Необходимо заполнить «Пароль».","Text is not correct");
        softAssert.assertEquals(cabinet.readErrCaptcha(),"Необходимо заполнить «Captcha».","Text is not correct");
        softAssert.assertAll();
    }

}
