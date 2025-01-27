@smoke
Feature: User should enter site with correct credentials

  Scenario Outline: Creation of the new user for specific site
    Given user should enter the URL
    And User will pass the payload with all details
    When User hit the specific "<end_point>"
    Then we are going to validate the specific "<status_code>"

    Examples: 
      | end_point | status_code |
      | post      |         200 |
