package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReversalStepdefs {
    private String stringToReverse;
    private String reversedString;

    @Given("I have a string {string}")
    public void iHaveAString(String arg0) {
        stringToReverse = arg0;
    }

    @When("I reverse the string")
    public void iReverseTheString() {
        reversedString = StringUtils.reverse(stringToReverse);
    }

    @Then("I should get {string}")
    public void iShouldGet(String arg0) {
        assertEquals(arg0, reversedString);
    }
}
