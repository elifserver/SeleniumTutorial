Feature: Skyscanner main page test

  Scenario: user fill the form of flights
    Given user views skyscanner_page
    When user clicks ONE_WAY
    And user enters LON on DEPARTURE area
    And user clicks LONDON_STANDON
    And user enters BAR on ARIVAL area
    And user clicks Barcelona
    And user clicks DatePicker
    And user clicks "30_April_2020"
    And user clicks DIRECT_FLIGHT
    Then user clicks SEARCH_BUTTON
    And user should see flight options

