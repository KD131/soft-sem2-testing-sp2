package org.example.bowlinggame;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameStepdefs {
    private Game g;

    @Given("a new bowling game")
    public void aNewBowlingGame() {
        g = new Game();
    }

    @When("I roll {int} times {int} pins")
    public void iRollTimesPins(int arg0, int arg1) {
        for (int i = 0; i < arg0; i++) {
            g.roll(arg1);
        }
    }

    @Then("my total score should be {int}")
    public void myTotalScoreShouldBe(int arg0) {
        assertEquals(arg0, g.score());
    }

    @When("I roll {int} pins")
    public void iRollPins(int arg0) {
        g.roll(arg0);
    }
}
