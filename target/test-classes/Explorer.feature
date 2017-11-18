#Author: kamrulislam.anik@gmail.com
Feature: Explorer Login Test

  Background: 
    Given Explorer only validation

  @iebrowser
  Scenario: User navigate to Explorer login page
    When Navigate to login with Explorer
    Then Click the login button with Explorer
