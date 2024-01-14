package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marsrover.Plateau;
import marsrover.Rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class roverSteps {
    private Rover rover;
    private Plateau plateau;

    @Given("a Rover is ready for deployment")
    public void initializeRover() {
        rover = new Rover();
    }

    @When("the Rover's position is set to {int}, {int}, {string}")
    public void setRoverPosition(int x, int y, String orientation) {
        int facing = convertOrientation(orientation);
        rover.setPosition(x, y, facing);
    }

    @Then("the Rover should be at position {int}, {int}, facing {string}")
    public void verifyRoverPosition(int x, int y, String orientation) {
        int expectedFacing = convertOrientation(orientation);
        assertEquals(x, rover.getX());
        assertEquals(y, rover.getY());
        assertEquals(expectedFacing, rover.getFacing());
    }

    @When("the Rover moves forward")
    public void moveRoverForward() {
        rover.process("M");
    }

    @Given("the plateau size is {int}x{int}")
    public void setPlateauSize(int upperX, int upperY) {
        //Method is redundant currently, rover needs to be initialised with a Plateau size in constructor
        plateau = new Plateau();
        plateau.setPlateau(upperX, upperY);
    }

    @And("a Rover is deployed at position {int}, {int}, {string}")
    public void deployRover(int x, int y, String orientation) {
        int facing = convertOrientation(orientation);
        rover.setPosition(x, y, facing);
    }

    @When("the Rover follows the instructions {string}")
    public void followInstructions(String instructions) {
        rover.process(instructions);
    }

    @And("the Rover should not move and stay at position {int}, {int}, facing {string}")
    public void verifyRoverStaysAtPosition(int x, int y, String orientation) {
        int expectedFacing = convertOrientation(orientation);
        assertEquals(x, rover.getX());
        assertEquals(y, rover.getY());
        assertEquals(expectedFacing, rover.getFacing());
    }

    @And("the Rover should report an error")
    public void verifyRoverError() {
        // Rover class checking for errors/alerts ie: if rover moves out of plateau
        assertTrue(rover.hasErrors());
    }

    private int convertOrientation(String orientation) {
        switch (orientation) {
            case "N":
                return Rover.N;
            case "E":
                return Rover.E;
            case "S":
                return Rover.S;
            case "W":
                return Rover.W;
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }
}

