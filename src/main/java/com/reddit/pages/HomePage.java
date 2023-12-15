package com.reddit.pages;

import com.reddit.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    public void clickOnAcceptAllCookiesBtnJs() {
        WebElement acceptCookie = (WebElement) jse.executeScript("return document.querySelector(\"body > shreddit-app > shreddit-async-loader:nth-child(6) > reddit-cookie-banner\").shadowRoot.querySelector(\"#accept-all-cookies-button > button > span > span\")");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptCookie);
    }

    @CacheLookup
    @FindBy(xpath = "(//span[@class='flex items-center gap-xs'])[3]")
    WebElement loginLink;

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }
}




