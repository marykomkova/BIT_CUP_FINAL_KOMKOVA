package org.services;

import org.framework.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;
import org.pages.MainPage;

public class LoginManager {

    public enum Users {
        STANDART_USER,
        LOCKED_OUT_USER,
        PROBLEM_USER,
        PERFORMANCE_GLITCH_USER;
    }
    private static final String SWAG_LABS_LINK = "https://www.saucedemo.com/";
    private static final String PASSWORD = "secret_sauce";
    MainPage mainPage = new MainPage();
    static WebDriver driver = WebDriverSingleton.getInstance().getDriver();

    public static void openSwagLabs() {
        driver.get(SWAG_LABS_LINK);
    }

    public MainPage loginByUserType(Users user) {
        return new LoginPage().typeName(getUserNameByType(user))
                .typePassword(PASSWORD)
                .clickLoginButton();
    }

    public LoginPage logout() {
        mainPage.clickMenuButton();
        mainPage.clickMenuItemByName(MainPage.MenuItems.LOGOUT);
        return new LoginPage();
    }

    public String getUserNameByType(Users user) {
        switch (user) {
            case STANDART_USER:
                return "standard_user";
            case LOCKED_OUT_USER:
                return "locked_out_user";
            case PROBLEM_USER:
                return "problem_user";
            case PERFORMANCE_GLITCH_USER:
                return "performance_glitch_user";
            default: return "";
        }
    }

}
