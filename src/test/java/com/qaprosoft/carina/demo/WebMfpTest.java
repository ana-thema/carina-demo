package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.ExerciseItem;
import com.qaprosoft.carina.demo.gui.components.FoodItem;
import com.qaprosoft.carina.demo.gui.pages.mfp.DiaryPage;
import com.qaprosoft.carina.demo.gui.pages.mfp.HomePage;
import com.qaprosoft.carina.demo.gui.pages.mfp.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.mfp.SearchPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Meals;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.Nutrients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WebMfpTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String FoodItem1 = "Apple";
    private final String FoodItem2 = "Mac & Cheese";
    private final String Exercise = "Running";
    private final String EMAIL = "asydoruk@solvd.com";
    private final String PASSWORD = "passwd*1234";

    @Test()
    public void addMealsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.auth(EMAIL, PASSWORD);
        DiaryPage diaryPage = homePage.addFood();
        diaryPage.deleteAll();
        diaryPage.enterFood(Meals.BREAKFAST);
        SearchPage searchPage = diaryPage.addMealOrExercise(FoodItem1);
        List<FoodItem> items1 = searchPage.getMatchedFoodList();
        searchPage.getRandomFoodItem(items1);
        searchPage.addFoodToDiary();
        diaryPage.enterFood(Meals.LUNCH);
        searchPage = diaryPage.addMealOrExercise(FoodItem2);
        List<FoodItem> items2 = searchPage.getMatchedFoodList();
        searchPage.getRandomFoodItem(items2);
        searchPage.addFoodToDiary();
        SoftAssert softAssert = new SoftAssert();
        int remaining = diaryPage.calculateMacros(Nutrients.CALORIES);
        softAssert.assertEquals(remaining, diaryPage.getRemainingMacros(Nutrients.CALORIES), "Remaining calories amount is not equal");
        softAssert.assertEquals(diaryPage.calculateMacros(Nutrients.CARBS), diaryPage.getRemainingMacros(Nutrients.CARBS), "Remaining carbs amount is not equal");
        softAssert.assertEquals(diaryPage.calculateMacros(Nutrients.FAT), diaryPage.getRemainingMacros(Nutrients.FAT), "Remaining fat amount is not equal");
        softAssert.assertEquals(diaryPage.calculateMacros(Nutrients.PROTEIN), diaryPage.getRemainingMacros(Nutrients.PROTEIN), "Remaining protein amount is not equal");
        softAssert.assertAll();
        diaryPage.returnHome();
        Assert.assertEquals(homePage.getRemainingCaloriesHome(), remaining, "Remaining calories amount is not equal");
        homePage.addExercise().enterExercise();
        List<ExerciseItem> exercises = diaryPage.addMealOrExercise(Exercise).getMatchedExList();
        searchPage.getRandomExItem(exercises);
        searchPage.addExerciseToDiary();
        diaryPage.returnHome();
    }

    @Test()
    public void waterConsumptionTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.auth(EMAIL, PASSWORD);
        DiaryPage diaryPage = homePage.addFood();
        diaryPage.editCups();
        Assert.assertEquals(diaryPage.getAddedCups(), 0, "Edited cups amount is not equal!");
        diaryPage.addCups();
        Assert.assertEquals(diaryPage.getAddedCups(), 2, "Added cups amount is not equal!");
        diaryPage.addCustomCups();
        Assert.assertTrue(diaryPage.checkCustomCups(), "Custom cups amount is not present in Quick Add");
        Assert.assertEquals(diaryPage.getAddedCups(), 5, "Added cups amount is not equal!");
    }

    @Test()
    public void checkDateTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.auth(EMAIL, PASSWORD);
        DiaryPage diaryPage = homePage.addFood();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        LOGGER.info("Today's Date: " + sdf.format(date));
        Assert.assertEquals(diaryPage.getDate(), sdf.format(date), "Date is different!");
    }

}
