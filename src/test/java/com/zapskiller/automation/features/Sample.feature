Feature: Sample Feature File for Cucumber Framework Test

  This file is used for testing framework behavior

  @sanity
  Scenario: Google Homepage Navigation and Search Test
    Given I navigate to "https://www.yahoo.com"
    When I type "Automation" into "SearchFile" in "Homepage"
    Then I should be able to search the results