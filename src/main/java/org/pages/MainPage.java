package org.pages;

import org.framework.AbstractScreen;
import org.framework.Element;

public class MainPage extends AbstractScreen {

    public enum MenuItems {
        ALL_ITEMS,
        ABOUT,
        LOGOUT,
        RESET_APP_STATE
    }
    private static final String MENU_BUTTON_PATTERN = "//a[@id='inventory_sidebar_link' and text()='%s']";
    private static final String GOOD_BY_NAME_PATTERN = "//div[@class='inventory_item_name' and text()='%s']//following::button[contains(@id, 'add-to-cart')]";
    Element logotype = new Element().byXpath("//div[@class='app_logo']");
    Element menuButton = new Element().byId("react-burger-menu-btn");
    Element basketButton = new Element().byXpath("//a[@class='shopping_cart_link']");

    @Override
    public boolean isOpened() {
        return logotype.getElement().isDisplayed();
    }

    public MainPage clickMenuButton() {
        menuButton.mouseOverAndClick();
        return this;
    }

    public void clickMenuItemByName(MenuItems item) {
        String itemName;
        switch (item) {
            case ALL_ITEMS:
                itemName = "All Items";
                break;
            case ABOUT:
                itemName = "About";
                break;
            case LOGOUT:
                itemName = "Logout";
                break;
            case RESET_APP_STATE:
                itemName = "Reset App State";
                break;
            default: itemName = "";
        }

        Element itemLink = new Element().byXpath(String.format(MENU_BUTTON_PATTERN, itemName));

        itemLink.mouseOverAndClick();
    }

    public MainPage clickGoodAddCartButtonByName(String good) {
        new Element().byXpath(String.format(GOOD_BY_NAME_PATTERN, good)).click();
        return this;
    }

    public BasketPage clickBasketButton() {
        basketButton.click();
        return new BasketPage();
    }
}
