package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.SearchBar;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class WebOnlinerTests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String VALUE = "50";
    private final String SEARCHQ = "Телевизор";
    private final String LOGIN = "asydoruk@solvd.com";
    private final String PASSWORD = "passwd*1234";

    @Test()
    public void testKurs() {
        KursPage kursPage = new KursPage(getDriver());
        kursPage.open();
        Assert.assertTrue(kursPage.isPageOpened(), "Kurs page is not opened");
        Assert.assertEquals(kursPage.getInputCurr(), kursPage.getBankCurr(), "Currency is different!");
        double kurs1 = kursPage.getBankValue1();
        double kurs2 = kursPage.getBankValue2();
        Assert.assertEquals(kurs1, kurs2, "Values are different!");
        double input = kursPage.getInputValue(VALUE);
        LOGGER.info("Input: " + VALUE + " " + kursPage.getInputCurr());
        Assert.assertEquals(kursPage.getResult(input, kurs1), kursPage.getResultField(), "Results are different!");
    }

    @Test()
    public void testOnlinerCatalog2() {
        KursPage kursPage = new KursPage(getDriver());
        kursPage.openURL("https://kurs.onliner.by/");
        Assert.assertTrue(kursPage.isPageOpened(), "Kurs page is not opened");
        LoginPage loginPage = kursPage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened(), "Log in page is not opened");
        loginPage.auth(LOGIN, PASSWORD);
        SearchBar searchBar = kursPage.searchCatalog(SEARCHQ);
        OnlinerCatalog catalog = searchBar.pickCategory();
        Assert.assertTrue(catalog.isPageOpened(), "Catalog page is not opened");
        String item = catalog.readItem();
        List<SearchItem> items = catalog.getItems();
        Assert.assertFalse(CollectionUtils.isEmpty(items), "Items not found!");
        SoftAssert softAssert = new SoftAssert();
        for (SearchItem n : items) {
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), SEARCHQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
        ItemPage itemPage = catalog.pickItem();
        CartPage cartPage = itemPage.addToCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        List<SearchItem> cartItems = cartPage.getItems();
        Assert.assertFalse(CollectionUtils.isEmpty(cartItems), "Items not found!");
        for(SearchItem p : cartItems) {
            LOGGER.info(p.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(item, p.readTitle()),
                    "Invalid search results for " + p.readTitle());
        }
        Assert.assertEquals(cartItems.size(), cartPage.getNumber(), "Number of items in the cart is different!");
    }
}
