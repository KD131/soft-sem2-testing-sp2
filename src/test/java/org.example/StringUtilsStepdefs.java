package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsStepdefs {
    private String inputString;
    private String reversedString;

    @Given("I have a string {string}")
    public void iHaveAString(String arg0) {
        inputString = arg0;
    }

    @When("I reverse the string")
    public void iReverseTheString() {
        reversedString = StringUtils.reverse(inputString);
    }

    @Then("I should get {string}")
    public void iShouldGet(String arg0) {
        assertEquals(arg0, reversedString);
    }

    @When("I convert the string to upper case")
    public void iConvertTheStringToUpperCase() {
    }

    @Then("I get {string}")
    public void iGet(String arg0) {
    }
}
