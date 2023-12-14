@bvt
Feature: Login Feature

  @smoke
  Scenario: User should navigate to login page successfully
    Given I am on homepage
    When  I accept cookies
    And   I click on login link
    And   I enter text to username field
    And   I enter text in password field
    And   I click on Login button
    And   I search for subreddit called sports
    And   I print out the top most title
    Then  I down vote the second post


