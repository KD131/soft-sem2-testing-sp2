Feature: String Reversal

  Scenario Outline: Reverse a string
    Given I have a string "<string>"
    When I reverse the string
    Then I should get "<reversed_string>"

    Examples:
      | string | reversed_string |
      | hello  | olleh           |
      | world  | dlrow           |
      | Foo    | ooF             |
      | Hello World | dlroW olleH |
      | Goodbye Cruel World | dlroW leurC eybdooG |