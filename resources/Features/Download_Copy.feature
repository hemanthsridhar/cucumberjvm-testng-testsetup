Feature: Download section
  In order to use Selenium in my project, I want to download Selenium language bindings
 
  Scenario: Java binding download link check
  Given I am on the Selenium homepage
    When I click Download tab
    Then I should see Java download link on Download page