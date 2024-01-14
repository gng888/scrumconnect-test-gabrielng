@multipleRover
Feature: Mars Rover Navigation (Task C)

  Background:
    Given the plateau size is 5x5

  Scenario Outline: Given a set of instructions, navigate the plateau with multiple rovers
    Given a Rover is ready for deployment
    And a Rover is deployed at position <posX>, <posY>, "<facing>"
    When the Rover follows the instructions "<instruction>"
    Then the Rover should be at position <expectedPosX>, <expectedPostY>, facing "<expectedFacing>"

    Examples:
      | posX | posY | facing | instruction | expectedPosX | expectedPostY | expectedFacing |
      | 1    | 2    | N      | LMLMLMLMM   | 1            | 3             | N              |
      | 3    | 3    | E      | MMRMMRMRRM  | 5            | 1             | E              |