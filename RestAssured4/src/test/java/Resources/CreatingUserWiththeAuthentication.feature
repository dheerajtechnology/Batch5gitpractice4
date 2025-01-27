@sanity
Feature: Creation of the User with AuthenticationDetails

  Scenario Outline: validate the user creation with authenticationdetails
    Given user should enter the URL
    And User will pass the payload with authentication details
    When user will hit the  endpoint of the API as "<endpoint>"
    Then we are going to validate as the specific "<status_code>"

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
