package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProfilePageBase;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeNavigationBar[`name == 'More'`]")
    private ExtendedWebElement navigation;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Nutrition'`]")
    private ExtendedWebElement nutrition;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement total;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement breakPercentage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement lunchPercentage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'MFPSlidingTabBarTabView'`][2]")
    private ExtendedWebElement nutrients;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'MFPSlidingTabBarTabView'`][3]")
    private ExtendedWebElement macros;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement fat;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement carbs;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement sugar;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement protein;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'MacroLegendTableViewCell_total_label'`][1]")
    private ExtendedWebElement carbsPercentage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'MacroLegendTableViewCell_total_label'`][2]")
    private ExtendedWebElement fatPercentage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'MacroLegendTableViewCell_total_label'`][3]")
    private ExtendedWebElement proteinPercentage;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        driver.getPageSource();
        return navigation.isElementPresent();
    }

    @Override
    public void openNutrition() {
        nutrition.click();
    }

    @Override
    public int getTotalCalories() {
        String s = total.getElement().getText();
        return parseInt(s.replaceAll(",", ""));
    }

    @Override
    public int getBreakfastPercentage() {
        String s = breakPercentage.getElement().getText();
        int a = parseInt(s.substring(0, s.length() - 1));
        LOGGER.info("Breakfast Percentage: " + a);
        return a;
    }

    @Override
    public int countBreakfastPercentage(int breakCal, int total) {
        return Math.round(breakCal * 100 / total);
    }

    @Override
    public int getLunchPercentage() {
        String s = lunchPercentage.getElement().getText();
        int a = parseInt(s.substring(0, s.length() - 1));
        LOGGER.info("Lunch Percentage: " + a);
        return a;
    }

    @Override
    public int countLunchPercentage(int breakPercentage) {
        return 100 - breakPercentage;
    }

    @Override
    public int sumCalories(int breakCal, int lunchCal) {
        int a = breakCal + lunchCal;
        LOGGER.info("Total calories sum: " + a);
        return a;
    }

    @Override
    public double getFats() {
        return parseDouble(fat.getElement().getText());
    }

    @Override
    public double getCarbs() {
        return parseDouble(carbs.getElement().getText());
    }

    @Override
    public double sumNutrients(double i1, double i2) {
        double a = i1 + i2;
        if (a % 1 == 0.5) {
            return Math.round(a) - 1;
        } else {
            return Math.round(a);
        }
    }

    @Override
    public double getSugar() {
        return parseDouble(sugar.getElement().getText());
    }

    @Override
    public double getProtein() {
        return parseDouble(protein.getElement().getText());
    }

    @Override
    public void openNutrients() {
        nutrients.click();
    }

    @Override
    public int getCarbsPercentage() {
        String s = carbsPercentage.getElement().getText();
        int a = parseInt(s.substring(0, s.length() - 1));
        LOGGER.info("Carbs Percentage: " + a);
        return a;
    }

    @Override
    public int countCarbsPercentage(double carbs, double total) {
        double a = carbs * 100 / total;
        if (a - (int) a == 0.5) {
            return (int) Math.round(a) - 1;
        } else {
            return (int) Math.round(a);
        }
    }

    @Override
    public int getFatPercentage() {
        String s = fatPercentage.getElement().getText();
        int a = parseInt(s.substring(0, s.length() - 1));
        LOGGER.info("Fat Percentage: " + a);
        return a;
    }

    @Override
    public int countFatsPercentage(double fat, double total) {
        double a = fat * 100 / total;
        if (a - (int) a == 0.5) {
            return (int) Math.round(a) - 1;
        } else {
            return (int) Math.round(a);
        }
    }

    @Override
    public int getProteinPercentage() {
        String s = proteinPercentage.getElement().getText();
        int a = parseInt(s.substring(0, s.length() - 1));
        LOGGER.info("Protein Percentage: " + a);
        return a;
    }

    @Override
    public int countProteinPercentage(int carbsPercentage, int fatPercentage) {
        return 100 - carbsPercentage - fatPercentage;
    }

    @Override
    public double getTotalMacros(double i1carbs, double i1fats, double i1protein, double i2carbs, double i2fats, double i2protein) {
        return i1carbs + i1fats + i1protein + i2carbs + i2fats + i2protein;
    }

    @Override
    public void openMacros() {
        macros.click();
    }
}
