Feature: RestAssured Script Response logging for future Date

  Scenario: Validation of response code when future date is passed
    Given API for foreign Exchange
    When posted with future date information
    Then validate positive response code received
