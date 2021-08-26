package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.ExerciseItem;
import com.qaprosoft.carina.demo.gui.components.FoodItem;
import com.qaprosoft.carina.demo.gui.pages.mfp.*;
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

    private final String FOOD_ITEM_1 = "Apple";
    private final String FOOD_ITEM_2 = "Mac & Cheese";
    private final String EXERCISE = "Running";
    private final String EMAIL = "asydoruk@solvd.com";
    private final String PASSWORD = "passwd*1234";
    private final String START_VALUE = "50";
    private final String BIGGER_VALUE = "70";
    private final String SMALLER_VALUE = "30";
    private final String WEIGHT = "77";

    @Test()
    public void addMealsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.auth(EMAIL, PASSWORD);
        DiaryPage diaryPage = homePage.addFood();
        Assert.assertTrue(diaryPage.isPageOpened(), "Diary Page page is not opened");
        diaryPage.deleteAll();
        diaryPage.enterFood(Meals.BREAKFAST);
        SearchPage searchPage = diaryPage.addMealOrExercise(FOOD_ITEM_1);
        List<FoodItem> items1 = searchPage.getMatchedFoodList();
        searchPage.getRandomFoodItem(items1);
        searchPage.addFoodToDiary();
        diaryPage.enterFood(Meals.LUNCH);
        List<FoodItem> items2 = diaryPage.addMealOrExercise(FOOD_ITEM_2).getMatchedFoodList();
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
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        Assert.assertEquals(homePage.calculateNet(), homePage.getNetCal(), "Net calories amount is not the same!");
        Assert.assertEquals(homePage.calculateRemaining(), remaining, "Remaining calories amount is not equal");
        homePage.addExercise().deleteAll();
        diaryPage.enterExercise();
        List<ExerciseItem> exercises = diaryPage.addMealOrExercise(EXERCISE).getMatchedExList();
        searchPage.getRandomExItem(exercises);
        searchPage.addExerciseToDiary();
        diaryPage.returnHome();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        Assert.assertEquals(homePage.calculateNet(), homePage.getNetCal(), "Net calories amount is not the same!");
        Assert.assertEquals(homePage.calculateRemaining(), homePage.getRemainingCaloriesHome(), "Remaining calories amount is not equal");
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

    @Test()
    public void checkGoalsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.auth(EMAIL, PASSWORD);
        GoalsEditPage goalsEditPage = homePage.getGoalsPage().clickEditBtn();
        String startPercentage = goalsEditPage.getPercentage();
        LOGGER.info(goalsEditPage.getCarbs());
        LOGGER.info("Percentage: " + startPercentage);
        Assert.assertEquals(startPercentage, goalsEditPage.countPercentage(START_VALUE), "Percentage is not the same!");
        goalsEditPage.editCarbs(SMALLER_VALUE);
        String smallerValuePercentage = goalsEditPage.getPercentage();
        LOGGER.info("Percentage: " + smallerValuePercentage);
        Assert.assertEquals(smallerValuePercentage, goalsEditPage.countPercentage(SMALLER_VALUE), "Percentage is not the same!");
        goalsEditPage.editCarbs(BIGGER_VALUE);
        String biggerValuePercentage = goalsEditPage.getPercentage();
        LOGGER.info("Percentage: " + biggerValuePercentage);
        Assert.assertEquals(goalsEditPage.getPercentage(), goalsEditPage.countPercentage(BIGGER_VALUE), "Percentage is not the same!");
    }

    @Test()
    public void checkInWeightTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page page is not opened");
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.auth(EMAIL, PASSWORD);
        CheckInPage checkInPage = homePage.getCheckInPage();
        checkInPage.enterWeightValue(WEIGHT);
        Assert.assertEquals(checkInPage.getFlashText(), "Measurements updated", "Text is not correct!");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Assert.assertEquals(checkInPage.getRecord(), "Last recorded weight: " + WEIGHT + " kg on " + sdf.format(date), "Text is not correct!");
    }

}
