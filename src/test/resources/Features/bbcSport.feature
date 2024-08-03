Feature: BBC Sport Web Automation

  Scenario: Retrieve 3rd Place For Driver Standings During Las Vegas Grand Prix In 2023
    Given I navigate to the BBC Sport page
    When  I navigate to Formula 1 results page
    And   I confirmed that the results page has been displayed
    And   I navigate to the year on the results page
    And   I retrieve the 3rd place driver at the Las Vegas Grand Prix on 19 November 2023
    Then  I print the driver's name

  Scenario: Retrieve First 3 Results Of Search
    Given   I navigate to the BBC Sport page
    When    I search for "Sport in 2023"
    And     I retrieve the first 3 results of the search
    Then    I print the text under the hyperlink for each of these results