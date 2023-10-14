Feature: String Lower Case

  Scenario Outline: String Lower Case
    Given I have a string "<string>"
    When I convert the string to lower case
    Then I get the lower case string, "<result>"
    Examples:
      | string          | result          |
      | HELLO           | hello           |
      | Hello           | hello           |
      | hello           | hello           |
      | HeLLo World     | hello world     |
      | 12345           | 12345           |
      | !@#$%           | !@#$%           |
      | MORE MixEd CASe | more mixed case |