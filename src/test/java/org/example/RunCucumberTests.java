package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:features/StringReversal.feature",
                "classpath:features/StringUpperCase.feature",
                "classpath:features/StringLowerCase.feature"
        },
        glue = {"org.example"}
)
public class RunCucumberTests {
}
