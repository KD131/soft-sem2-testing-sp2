package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsStepdefs {
    private String inputString;
    private String reversedString;
    private String upperCaseString;
    private String lowerCaseString;

    @Given("I have a string {string}")
    public void iHaveAString(String arg0) {
        inputString = arg0;
    }

    @When("I reverse the string")
    public void iReverseTheString() {
        reversedString = StringUtils.reverse(inputString);
    }

    @Then("I get the reversed string, {string}")
    public void iGetTheReversedString(String arg0) {
        assertEquals(arg0, reversedString);
    }

    @When("I convert the string to upper case")
    public void iConvertTheStringToUpperCase() {
        upperCaseString = StringUtils.upperCase(inputString);
    }

    @Then("I get the upper case string, {string}")
    public void iGetTheUpperCaseString(String arg0) {
        assertEquals(arg0, upperCaseString);
    }

    @When("I convert the string to lower case")
    public void iConvertTheStringToLowerCase() {
        lowerCaseString = StringUtils.lowerCase(inputString);
    }

    @Then("I get the lower case string, {string}")
    public void iGetTheLowerCaseString(String arg0) {
        assertEquals(arg0, lowerCaseString);
    }
}
