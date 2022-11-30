package org.framework;

import org.openqa.selenium.WebDriver;

public abstract class AbstractScreen {

    WebDriver driver = WebDriverSingleton.getInstance().getDriver();

    public abstract boolean isOpened();
}
