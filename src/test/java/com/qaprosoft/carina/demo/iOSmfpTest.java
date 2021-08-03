package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class iOSmfpTest implements IAbstractTest, IMobileUtils {

    public String randEmail = RandomStringUtils.random(10, true, true);
    public String randPasswd = RandomStringUtils.random(10, true, true);
    public String randShortPasswd = RandomStringUtils.random(3, true, true);
    public String randAmount = RandomStringUtils.random(3, false, true);
    public final String STATUS = "This is my status.";

    @Test()
    @TestPriority(Priority.P1)
    public void testSignUpUser() {
        MyWelcomePageBase welcomePage = initPage(getDriver(), MyWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        SignUpPageBase signUpPage = welcomePage.clickSignUpBtn();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up page isn't opened");
        signUpPage.signUp();
        signUpPage.pickGoals();
        signUpPage.enterPersonalInfo();
        signUpPage.enterWeight();
        HomePageBase homePage = signUpPage.enterDetails(randEmail, randPasswd);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        DiaryPageBase diaryPage = homePage.openDiary();
        Assert.assertTrue(diaryPage.isPageOpened(), "Diary page isn't opened");
        diaryPage.addBreakfast();
        double i1protein = diaryPage.getProtein();
        double i1carbs = diaryPage.getCarbs();
        double i1fats = diaryPage.getFats();
        double i1sugar = diaryPage.getSugar();
        diaryPage.save();
        int breakfastCalories = diaryPage.getBreakfastCalories();
        Assert.assertEquals(diaryPage.getItemCalories(), breakfastCalories, "Calories amount is not equal!");
        diaryPage.addLunch();
        double i2protein = diaryPage.getProtein();
        double i2carbs = diaryPage.getCarbs();
        double i2fats = diaryPage.getFats();
        double i2sugar = diaryPage.getSugar();
        diaryPage.save();
        diaryPage.quickAddLunch(randAmount);
        int lunchCalories = diaryPage.getLunchCalories();
        diaryPage.addExercise();
        Assert.assertEquals(diaryPage.getItemsCalories(), lunchCalories, "Calories amount is not equal!");
        ProfilePageBase profilePage = diaryPage.openProfile();
        Assert.assertTrue(profilePage.isPageOpened(), "Profile page isn't opened");
        profilePage.openNutrition();
        int totalCalories = profilePage.sumCalories(breakfastCalories, lunchCalories);
        Assert.assertEquals(totalCalories, profilePage.getTotalCalories(), "Calories total amount is not equal!");
        int breakPercentage = profilePage.countBreakfastPercentage(breakfastCalories, totalCalories);
        Assert.assertEquals(profilePage.getBreakfastPercentage(), breakPercentage, "Breakfast calories percentage is not equal!");
        Assert.assertEquals(profilePage.getLunchPercentage(), profilePage.countLunchPercentage(breakPercentage), "Lunch calories percentage is not equal!");
        profilePage.openNutrients();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(profilePage.getProtein(),profilePage.sumNutrients(i1protein, i2protein), "Protein amount is not equal!");
        softAssert.assertEquals(profilePage.getCarbs(),profilePage.sumNutrients(i1carbs, i2carbs), "Carbs amount is not equal!");
        softAssert.assertEquals(profilePage.getSugar(),profilePage.sumNutrients(i1sugar, i2sugar), "Sugar amount is not equal!");
        softAssert.assertEquals(profilePage.getFats(),profilePage.sumNutrients(i1fats, i2fats), "Fats amount is not equal!");
        softAssert.assertAll();
        profilePage.openMacros();
        double totalMacros = profilePage.getTotalMacros(i1carbs,i1fats,i1protein, i2carbs, i2fats, i2protein);
        int carbsPercentage = profilePage.countCarbsPercentage(profilePage.sumNutrients(i1carbs, i2carbs), totalMacros);
        int fatsPercentage = profilePage.countCarbsPercentage(profilePage.sumNutrients(i1fats, i2fats), totalMacros);
        softAssert.assertEquals(profilePage.getCarbsPercentage(), carbsPercentage, "Carbs percentage is not equal!");
        softAssert.assertEquals(profilePage.getFatPercentage(), fatsPercentage, "Fat percentage is not equal!");
        softAssert.assertEquals(profilePage.getProteinPercentage(), profilePage.countProteinPercentage(carbsPercentage, fatsPercentage), "Protein percentage is not equal!");
        softAssert.assertAll();
    }

    @Test()
    @TestPriority(Priority.P2)
    public void testLogInUser() {
        MyWelcomePageBase welcomePage = initPage(getDriver(), MyWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        MyLogInPageBase loginPage = welcomePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Log in page isn't opened");
        HomePageBase homePage = loginPage.login(randEmail, randPasswd);
    }

    @Test()
    @TestPriority(Priority.P3)
    public void testShortPassword() {
        MyWelcomePageBase welcomePage = initPage(getDriver(), MyWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        SignUpPageBase signUpPage = welcomePage.clickSignUpBtn();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up page isn't opened");
        signUpPage.signUp();
        signUpPage.pickGoals();
        signUpPage.enterPersonalInfo();
        signUpPage.enterWeight();
        Assert.assertTrue(signUpPage.enterShortPassword(randEmail, randShortPasswd),"Alert is not present!");
        Assert.assertEquals(signUpPage.shortPasswordAlert(),"Password is too short. Minimum is 10 characters." ,"Message is not present!");
    }

    @Test()
    @TestPriority(Priority.P1)
    public void testAddStatus() {
        MyWelcomePageBase welcomePage = initPage(getDriver(), MyWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        SignUpPageBase signUpPage = welcomePage.clickSignUpBtn();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up page isn't opened");
        signUpPage.signUp();
        signUpPage.pickGoals();
        signUpPage.enterPersonalInfo();
        signUpPage.enterWeight();
        HomePageBase homePage = signUpPage.enterDetails(randEmail, randPasswd);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        Assert.assertEquals(homePage.addStatus(STATUS), STATUS, "Status contents are not the same");
    }
}
