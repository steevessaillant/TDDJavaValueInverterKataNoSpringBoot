Feature: Implement a Value converter for boolean, numbers and colors
  Scenario: Test with boolean
    Given I start the system
    When I pass
      | value |
      | false |
      | true  |
    Then I should obtain
      | value    |
      | true     |
      | false    |
  Scenario: Test with floats
    Given I start the system
    When I pass floats
      | value |
      | 1.1 |
      | -2.2  |
    Then I should obtain inverted floats
      | value    |
      | -1.1     |
      | 2.2      |

  Scenario: Test float inversion with null
    Given I start the system
    When I pass null
    Then I should obtain "Value was null, cannot pass a null value to this method"     |
