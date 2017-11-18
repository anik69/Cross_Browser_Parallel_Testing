#Author: kamrulislam.anik@gmail.com
Feature: Chrome Login Test

  Background: 
    Given Chrome only validation

  @chrome
  Scenario: User navigate to Chrome login page
    When Navigate to login with Chrome
    Then Click the login button with Chrome

  Scenario: User click Remember
    Then Click Remember button
