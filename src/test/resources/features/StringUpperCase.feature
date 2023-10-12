Feature: String Upper Case
  Scenario Outline: String Upper Case
    Given I have a string "<string>"
    When I convert the string to upper case
    Then I get "<result>"
    Examples:
      | string | result |
      | hello  | HELLO  |
      | Hello  | HELLO  |
      | HELLO  | HELLO  |
      | HeLlO  | HELLO  |
      | some TeXt wiTh MiXeD cAsE | SOME TEXT WITH MIXED CASE |