package org.pages;

import org.framework.AbstractScreen;
import org.framework.Element;

public class LoginPage extends AbstractScreen {
    Element userNameInput = new Element().byId("user-name");
    Element passwordInput = new Element().byId("password");
    Element loginButton = new Element().byId("login-button");
    Element logotype = new Element().byXpath("//div[@class='login_logo']");
    Element error = new Element().byXpath("//div[@class='error-message-container error']");

    @Override
    public boolean isOpened() {
        return logotype.getElement().isDisplayed();
    }

    public LoginPage typeName(String name) {
        userNameInput.type(name);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordInput.type(password);
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.mouseOverAndClick();
        return new MainPage();
    }

    public boolean isErrorMessageDisplayed() {
        return error.getElement().isDisplayed();
    }

    public String getErrorText() {
        return error.getText();
    }
}