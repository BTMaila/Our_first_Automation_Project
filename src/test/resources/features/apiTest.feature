Feature: Category Page Test

  Scenario: Check category page returns HTTP 200
    Given I perform a GET request to "https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20_27"
    Then the response status code should be 200
