Feature: TC12

@Smoke
Scenario: to test the login with valid credentials
Given I open the browser
When I click on Sign i link
And I enter username "automationwithpankaj@gmail.com"
And I enter Password "test@1234"
And I click on Sign In
Then Validate login is successfull