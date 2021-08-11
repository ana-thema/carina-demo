package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.mobile.gui.pages.additional.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.ExerciseRoutinePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.MealsPage;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class iOSmfpTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
        diaryPage.addFood(Meals.BREAKFAST).addBreakfast(); // спросить про локатор
        MealsPageBase mealsPage = new MealsPage(getDriver());
        double i1protein = mealsPage.getNutrients(Nutrients.PROTEIN);
        double i1carbs = mealsPage.getNutrients(Nutrients.CARBS);
        double i1fats = mealsPage.getNutrients(Nutrients.FAT);
        double i1sugar = mealsPage.getNutrients(Nutrients.SUGAR);
        diaryPage.save();
        int breakfastCalories = diaryPage.getMealCalories(Meals.BREAKFAST);
        Assert.assertEquals(diaryPage.getItemCalories(), breakfastCalories, "Calories amount is not equal!");
        diaryPage.addFood(Meals.LUNCH).addLunch();
        double i2protein = mealsPage.getNutrients(Nutrients.PROTEIN);
        double i2carbs = mealsPage.getNutrients(Nutrients.CARBS);
        double i2fats = mealsPage.getNutrients(Nutrients.FAT);
        double i2sugar = mealsPage.getNutrients(Nutrients.SUGAR);
        diaryPage.save();
        diaryPage.addFood(Meals.LUNCH).quickAddLunch(randAmount);
        diaryPage.save();
        int lunchCalories = diaryPage.getMealCalories(Meals.LUNCH);
        Assert.assertEquals(diaryPage.getItemsCalories(), lunchCalories, "Calories amount is not equal!");
        diaryPage.clickExercise().addExercise();
        diaryPage.save();
        diaryPage.clickAlert();
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
        Macros macros = new Macros(i1carbs,i1fats,i1protein,i2carbs,i2fats,i2protein);
        double totalMacros = profilePage.getTotalMacros(macros);
        int carbsPercentage = profilePage.countCarbsPercentage(profilePage.sumNutrients(i1carbs, i2carbs), totalMacros);
        int fatsPercentage = profilePage.countCarbsPercentage(profilePage.sumNutrients(i1fats, i2fats), totalMacros);
        softAssert.assertEquals(profilePage.getCarbsPercentage(), carbsPercentage, "Carbs percentage is not equal!");
        softAssert.assertEquals(profilePage.getFatPercentage(), fatsPercentage, "Fat percentage is not equal!");
        softAssert.assertEquals(profilePage.getProteinPercentage(), profilePage.countProteinPercentage(carbsPercentage, fatsPercentage), "Protein percentage is not equal!");
        softAssert.assertAll();
    }

    @Test()
    @TestPriority(Priority.P1)
    public void testRemoveExercise() {
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
        ExerciseRoutinesPageBase exRoutinesPage = new ExerciseRoutinePage(getDriver());
        diaryPage.clickExercise().clickWorkoutRoutine();
        exRoutinesPage.addWorkoutRoutine1();
        exRoutinesPage.saveRoutine();
        exRoutinesPage.addWorkoutRoutine2();
        exRoutinesPage.saveRoutine();
        List<ExerciseRoutines> routinesList = exRoutinesPage.getRoutinesList();
        Assert.assertEquals(exRoutinesPage.getNumberOfRoutines(routinesList), 2);
        exRoutinesPage.openRoutineMenu();
        exRoutinesPage.clickEditBtn();
        List<Buttons> buttonsList = exRoutinesPage.getButtonsList();
        List<String> buttonsTitlesList = new ArrayList<>();
        for(Buttons n : buttonsList) {
            buttonsTitlesList.add(n.readTitle());}
        List<String> buttonsCheckList = new ArrayList<>();
        buttonsCheckList.add("Remove Exercise");
        buttonsCheckList.add("Duplicate Exercise");
        buttonsCheckList.add("Reorder Exercise");
        buttonsCheckList.add("Modify Stats");
        buttonsCheckList.add("Cancel");
        Assert.assertEquals(buttonsTitlesList, buttonsCheckList, "Buttons are not correct!");
        exRoutinesPage.removeBtnClick();
        List<Buttons> removalList = exRoutinesPage.getRemovalButtonsList();
        List<String> removalTitlesList = new ArrayList<>();
        for(Buttons r : removalList) {
            removalTitlesList.add(r.readTitle());}
        List<String> removalCheckList = new ArrayList<>();
        removalCheckList.add("Cancel");
        removalCheckList.add("Remove");
        Assert.assertEquals(removalTitlesList, removalCheckList, "Buttons are not correct!");
        exRoutinesPage.removeExercise();
        List<ExerciseRoutines> newRoutinesList = exRoutinesPage.getRoutinesList();
        Assert.assertEquals(exRoutinesPage.getNumberOfRoutines(newRoutinesList), 1);
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
