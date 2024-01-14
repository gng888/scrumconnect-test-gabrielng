@roverInitial
Feature: Rover Initialization (Task A)

  Scenario: Initialize Rover with direction and position
    Given a Rover is ready for deployment
    When the Rover's position is set to 1, 2, "N"
    Then the Rover should be at position 1, 2, facing "N"