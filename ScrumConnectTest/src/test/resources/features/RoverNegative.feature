@roverNegative
Feature: Rover Navigation - Negative Scenario

  Scenario Outline: Rover should not move out of the plateau boundaries facing - <facing>
    Given the plateau size is 5x5
    And a Rover is ready for deployment
    And a Rover is deployed at position <posX>, <posY>, "<facing>"
    When the Rover follows the instructions "<instruction>"
    Then the Rover should not move and stay at position <expectedPosX>, <expectedPosY>, facing "<expectedFacing>"
    And the Rover should report an error

    Examples:
      | posX | posY | facing | instruction | expectedPosX | expectedPosY | expectedFacing |
      | 4    | 4    | N      | MMMMMMMMM   | 4            | 4            | N              |
      | 2    | 0    | S      | MMMMMMMMM   | 2            | 0            | S              |
      | 4    | 3    | E      | MMMMMMMMM   | 4            | 3            | E              |
      | 1    | 0    | W      | MMMMMMMMM   | 1            | 0            | W              |