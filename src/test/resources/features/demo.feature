Feature: Fill a simple form with excel data
  Scenario: Facebook login
    When I enter into facebook url
    And enter username and password with excel row "1" dataset
    Then success login
  Scenario Outline: Data driven with excel and data
    When I enter into facebook url
    And enter username and password with excel row "<row_index>" dataset
    Then success login message
  Examples:
    |row_index|
    |2|
    |3|
