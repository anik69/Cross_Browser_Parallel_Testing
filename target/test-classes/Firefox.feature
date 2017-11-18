#Author: kamrulislam.anik@gmail.com
Feature: Firefox Login Test

  Background: 
    Given Firefox only validation

  @firefox
  Scenario: User navigate to Firefox login page
    When Navigate to login with Firefox
    Then Click the login button with Firefox
