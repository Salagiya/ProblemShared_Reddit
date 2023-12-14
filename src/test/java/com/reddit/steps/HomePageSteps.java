package com.reddit.steps;

import com.reddit.pages.HomePage;
import com.reddit.pages.LoginPage;
import com.reddit.pages.SportsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {

    }

    @When("I accept cookies")
    public void iAcceptCookies() {
        new HomePage().clickOnAcceptAllCookiesBtnJs();

    }

    @And("I click on login link")
    public void iClickOnLoginLink() {
        new HomePage().clickOnLoginLink();
    }

    @And("I enter text to username field")
    public void iEnterTextToUsernameField() {
        new LoginPage().sendTextToUsernameField();
    }

    @And("I enter text in password field")
    public void iEnterTextInPasswordField() {
        new LoginPage().sendTextToPasswordField();
    }

    @And("I click on Login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginBtnJs();
    }

    @And("I search for subreddit called sports")
    public void iSearchForSubredditCalledSports() throws InterruptedException {
        Thread.sleep(1000);
        new LoginPage().enterTextInSearchFieldAndEnter();
    }

    @And("I print out the top most title")
    public void iPrintOutTheTopMostTitle() throws InterruptedException {
        Thread.sleep(1000);
        new SportsPage().printTopPostTitle();
    }

    @Then("I down vote the second post")
    public void iDownVoteTheSecondPost() throws InterruptedException {
        new SportsPage().downVoteTheSecondPost();
    }
}
