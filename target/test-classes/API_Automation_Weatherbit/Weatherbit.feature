Feature: Validate weatherbit API

  Scenario: Validate current weather at weatherbit with valid latitude (40.730610) and longitude (-73.935242)
    Given Get detail current weather with valid latitude and longitude
    When Send request get current weather data
    Then Api should return response 200 OK
    And View current weather data json schema validation
    And Response body contain state code NY



  Scenario Outline: Validate three hourly forecast at weatherbit with postal code (28556)
    Given Get three hourly forecast with postal code
    When Send request get three hourly forecast
    Then Api should return response 200 OK
    And View three hourly forecast json schema validation
    And Response body should contain <timestamp_utc>
    Examples:
    |   timestamp_utc   |
    |2022-12-20T15:00:00|
    |2022-12-20T16:00:00|
    |2022-12-20T17:00:00|