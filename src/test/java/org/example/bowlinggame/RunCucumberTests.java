package org.example.bowlinggame;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:features/BowlingGame.feature"
        },
        glue = {"org.example.bowlinggame"}
)
public class RunCucumberTests {
}
