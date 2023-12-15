package com.reddit.pages;

import com.reddit.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportsPage extends Utility {
    private static final Logger log = LogManager.getLogger(SportsPage.class.getName());

    public SportsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h3[contains(@class,'_eYtD2XCVieq6emjKBH3m _2SdHzo12ISmrC8H86TgSCp')]")
    WebElement topPostTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@id='vote-arrows-t3_18ib2er']//button[@data-click-id='upvote']")
    WebElement secondPostVoteButton;

    public void printTopPostTitle() {
        String topPostTitleText = topPostTitle.getText();
        System.out.println("Top-most post title: " + topPostTitleText);
    }

    public void downVoteTheSecondPost() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        String currentButtonState = secondPostVoteButton.getAttribute("data-click-id");
        System.out.println(currentButtonState);

        if (currentButtonState.contains("upvoted")) {
            // If already upvoted, downvote
            secondPostVoteButton.click(); // Perform downvote action
            System.out.println("Downvoted the second post.");
        } else {
            // If not upvoted, upvote
            secondPostVoteButton.click(); // Perform upvote action
            System.out.println("Upvoted the second post.");
        }
    }
}