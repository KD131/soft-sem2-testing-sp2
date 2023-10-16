Feature: Run a bowling game

  Scenario: Gutter game
    Given a new bowling game
    When I roll 20 times 0 pins
    Then my total score should be 0

  Scenario: All ones
    Given a new bowling game
    When I roll 20 times 1 pins
    Then my total score should be 20

  Scenario: One spare
    Given a new bowling game
    When I roll 1 pins
    And I roll 9 pins
    And I roll 1 pins
    And I roll 17 times 0 pins
    Then my total score should be 12

  Scenario: One strike
    Given a new bowling game
    When I roll 10 pins
    And I roll 1 pins
    And I roll 1 pins
    And I roll 16 times 0 pins
    Then my total score should be 14

  Scenario: Perfect game
    Given a new bowling game
    When I roll 12 times 10 pins
    Then my total score should be 300
