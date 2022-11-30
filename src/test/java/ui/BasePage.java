package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.framework.WebDriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.services.LoginManager;

public class BasePage {

    private static final LoginManager loginManager = new LoginManager();

    @BeforeClass
    public static void setupDriver() {
        WebDriverManager.iedriver().setup();
        WebDriverSingleton.getInstance().getDriver()
                .manage().window().maximize();
        loginManager.openSwagLabs();
    }

    @AfterClass
    public static void closeDriver() {
        WebDriverSingleton.closeWebBrowser();
    }
}
