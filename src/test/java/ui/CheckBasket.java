package ui;

import org.junit.Assert;
import org.junit.Test;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.services.LoginManager;
import org.testng.asserts.SoftAssert;

public class CheckBasket extends BasePage {

    private final LoginPage loginPage = new LoginPage();
    private final LoginManager loginManager = new LoginManager();

    private MainPage mainPage;

    @Test
    public void checkThatGoodAddedToBasket() {
        Assert.assertTrue(loginPage.isOpened());
        mainPage = loginManager.loginByUserType(LoginManager.Users.STANDART_USER);
        Assert.assertTrue(mainPage.isOpened());
        mainPage.clickGoodAddCartButtonByName("Sauce Labs Backpack");
        mainPage.clickBasketButton();
    }
}
