package org.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Element {
    private final WebDriver webDriver = WebDriverSingleton.getInstance().getDriver();
    private By locator;
    private WebElement element;

    public WebElement getElement() {
        return element;
    }

    public Element() {}

    //strategies

    public Element byXpath(String xpath) {
        locator = By.xpath(xpath);
        this.element = webDriver.findElement(locator);
        return this;
    }

    public Element byCss(String css) {
        locator = By.cssSelector(css);
        this.element = webDriver.findElement(locator);
        return this;
    }

    public Element byId(String id) {
        locator = By.id(id);
        this.element = webDriver.findElement(locator);
        return this;
    }

    //actions

    public Element click() {
        element.click();
        return this;
    }

    public Element mouseOver() {
        new Actions(webDriver).moveToElement(element).build().perform();
        return this;
    }

    public Element mouseOverAndClick() {
        mouseOver();
        click();
        return this;
    }

    public Element type(String text) {
        element.click();
        element.sendKeys(text);
        return this;
    }

    public String getText() {
        return element.getText();
    }

//    public boolean isDisplayed() {
//        boolean isDisplayed;
//        try {
//            isDisplayed = wait()
//        }
//    }
}
