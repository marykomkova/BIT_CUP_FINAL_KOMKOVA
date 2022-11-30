package ui;

import org.junit.Assert;
import org.junit.Test;
import org.pages.LoginPage;
import org.services.LoginManager;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

public class CheckLoginPage extends BasePage {

    private static final LoginManager loginManager = new LoginManager();
    private static LoginPage loginPage = new LoginPage();

    @DataProvider(name="users-provider")
    public Object[][] successfulUsersForLogin() {
        return new Object[][]{{LoginManager.Users.STANDART_USER},
                {LoginManager.Users.PROBLEM_USER}, {LoginManager.Users.PERFORMANCE_GLITCH_USER}};
    }

    @Test//(dataProvider = "users-provider", dataProviderClass = DataProviders.class)
    public void checkThatSuccessfulUserCanLoginInAccount() {//LoginManager.Users user) {
        Assert.assertTrue(loginPage.isOpened());
        Assert.assertTrue(loginManager.loginByUserType(
                LoginManager.Users.STANDART_USER).isOpened());
    }

    @Test
    public void checkThatFailUserCannotLoginInAccount() {
        Assert.assertTrue(loginPage.isOpened());
        loginManager.loginByUserType(LoginManager.Users.LOCKED_OUT_USER);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message isn't displayed");
        softAssert.assertEquals(new LoginPage().getErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkThatUserCanLogout() {
        Assert.assertTrue(loginPage.isOpened());
        loginManager.loginByUserType(LoginManager.Users.STANDART_USER);
        Assert.assertTrue(loginManager.logout().isOpened());
    }

}
