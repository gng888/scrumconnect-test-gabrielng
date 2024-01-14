@roverMovement
Feature: Rover Movement (Task B)

  Scenario: Move the Rover to a new position
    Given a Rover is ready for deployment
    And the Rover's position is set to 1, 2, "N"
    When the Rover moves forward
    Then the Rover should be at position 1, 3, facing "N"