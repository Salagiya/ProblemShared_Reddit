package com.reddit.pages;

import com.reddit.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(id = "login-username")
    WebElement userName;

    @CacheLookup
    @FindBy(id = "login-password")
    WebElement passWord;

    @CacheLookup
    @FindBy(xpath = "//input[@id='header-search-bar']")
    WebElement searchField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='_1QVrieUoti9cxiQSRw314E sb9GBNKICO504iABZENf3']")
    WebElement searchedField;

    public void sendTextToUsernameField() {
        sendTextToElement(userName, "SureAd3953");
    }

    public void sendTextToPasswordField() {
        sendTextToElement(passWord, "Daylight3953");
    }
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public void clickOnLoginBtnJs() {
        WebElement loginBtn = (WebElement) jse.executeScript("return document.querySelector(\"body > shreddit-app > shreddit-overlay-display\").shadowRoot.querySelector(\"shreddit-signup-drawer\").shadowRoot.querySelector(\"shreddit-drawer > div > shreddit-async-loader > div > shreddit-slotter\").shadowRoot.querySelector(\"#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.w-100 > faceplate-tracker > button > span\")");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
    }
    public void enterTextInSearchFieldAndEnter(){
        sendTextToElement(searchField,"sports");
        clickOnElement(searchedField);
    }
}
