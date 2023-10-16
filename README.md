# Assignment 2

- [1. Reflections](#1-reflections)
    - [1.1. Computer Mouse](#11-computer-mouse)
    - [1.2. Catastrophic Failure](#12-catastrophic-failure)
- [2. Two Katas](#2-two-katas)
    - [2.1. String Utility](#21-string-utility)
    - [2.2. Bowling Game Kata](#22-bowling-game-kata)
- [3. Investigation Of Tools](#3-investigation-of-tools)
    - [3.1. JUnit 5](#31-junit-5)
    - [3.2. Mocking Frameworks](#32-mocking-frameworks)
        - [3.2.1. Similarities](#321-similarities)
        - [3.2.2. Differences](#322-differences)
        - [3.2.3. Preference](#323-preference)

## 1. Reflections

### 1.1. Computer Mouse

> Identify the types of testing you would perform on a computer mouse, to make sure that it is of the highest quality.

I'm interpreting this as meaning the physical, peripheral device. Many tests can be applied to every button and whatnot
on the mouse.

I'm not 100% what category of test some of these would fall under. Some of it is just verifying some kind of
measurement.

- **Unit test**: Switches can trigger.
- **Integration test**: Pressing mouse buttons actually trigger the switches.
- Consistent and right amount of pressure to click, drag, and release.
- **Stress test**: Make sure it can withstand millions of clicks for a long lifetime.
    - (make sure the micro-switches aren't some cheap, Chinese crap, **Logitech**)
- **Usability**: Ergonomics, comfort, and loudness.
- Loudness can also be quantified with decibels and tested/regulated that way.
- Correct weight.
- Drag/friction on teflon feet.
- **Stress test**: Durability of feet.
- **Stress test**: Cable fraying.
- **Unit test**: Accuracy of laser/optical sensor.
    - Frequency
    - Wavelength
    - Poll rate
    - Lift height
- Make sure the laser isn't strong enough to cause eye injury.
- Make sure old mouse ball is returned to museum when you're done playing with it.

### 1.2. Catastrophic Failure

> Find a story where a software system defect had a bad outcome. Describe what happened. Can you identify a test that
> would have prevented it?

Between 1985 and 1987, a software bug in Therac-25, a radiation therapy machine, killed 6 people.

The machine could do two kinds of treatment, X-ray (photon) and electron, with very different dosages.
It would use a turntable to mechanically switch between those modes, and also normal, visible light. It took 8 seconds
to move this turntable.

It was fully controlled by software, and, in fact, earlier models _had_ hardware locks to prevent catastrophically high
dosages,
but these safety measures were removed in the Therac-25 and replaced with software checks.

The machine was programmed by a single developer in assembly, and it was never tested until production when it was used
on real patients in the hospital.

If an operator were to mistakenly initiate X-ray treatment and then correct the error within the 8 seconds it took to
move the turntable,
those inputs would be ignored as the program wasn't meant to accept inputs in that phase. This is a _race condition_.

Patients could be prescribed electron therapy but receive X-rays roughly 100 times the intended dosage
because the machine had initially been set for X-ray, and the filter had not moved into place.

Machine displayed a `Malfunction 54` error message, which in the manual indicates a `dose input 2` error. This means
either too high or too low dosage.

Tests that could've possibly prevented those deaths:

- **Pair programming** or any kind of **code review** during development.
- **Negative system tests**: Test everything that could possibly go wrong.
    - Give bad input and then try to correct it.
- **Fuzzing**: Keyboard smashing bad input could've produced the race condition.
- **Regression testing**: Make sure the machine still worked after removing the hardware safety measure.
- **Usability tests**. Maybe a user would've caused the race condition.
- More descriptive errors to show the **severity** of the error and understand what went wrong.

_Below image is a YouTube link._

[![how a simple bug in software ended 6 lives](https://i.ytimg.com/vi/41Gv-zzICIQ/maxresdefault.jpg)](https://youtu.be/41Gv-zzICIQ)

I'm not sure that I got all the details correct, but I tried my best. It's a truly horrifying story.

## 2. Two Katas

> Complete the following using BDD.

### 2.1. String Utility

> Use BDD to create a string utility with the following methods:
>
> - Reverse string (aBc -> cBa)
> - Capitalize string (aBc -> ABC)
> - Lowercase string (aBc -> abc)
>
> Don’t use any built-in string utility – create your own. Remember, the exercise here is to use BDD, not to deliver a
> working utility without tests. If there are no tests in the solution, it won’t be accepted.

- [Features](/src/test/resources/features)
- [Step definitions](/src/test/java/org/example/StringUtilsStepdefs.java)
- [Tests](/src/test/java/org/example/StringUtilsTest.java)
- [Code](/src/main/java/org/example/StringUtils.java)

### 2.2. Bowling Game Kata

> Complete the Bowling Game Kata using BDD. The slides can be found here:  
> <http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt>

- [Feature](/src/test/resources/features/BowlingGame.feature)
- [Step definitions](/src/test/java/org/example/bowlinggame/BowlingGameStepdefs.java)
- [Tests](/src/test/java/org/example/bowlinggame/BowlingGameTest.java)
- [Code](/src/main/java/org/example/bowlinggame/Game.java)

## 3. Investigation Of Tools

### 3.1. JUnit 5

> Investigate JUnit 5 (Jupiter). Explain the following, and how they are useful.
>
> - `@Tag`
> - `@Disabled`
> - `@RepeatedTest`
> - `@BeforeEach`, `@AfterEach`
> - `@BeforeAll`, `@AfterAll`
> - `@DisplayName`
> - `@Nested`
> - `assumeFalse`, `assumeTrue`

- `@Tag`: Applies a tag to a test. Can be used to filter tests and only execute a subset of tests that have a certain
  tag.
- `@Disabled`: Disables a test. Can be used to temporarily disable a test without deleting it. Shouldn't be overused. If
  a test fails, find out why and try to fix it. Don't just disable it. Can also be applied
  conditionally.
- `@RepeatedTest`: Repeats a test a certain amount of times. Can be used to check if a test is flaky, i.e. if it fails
  sometimes and passes other times.
- `@BeforeEach`, `@AfterEach`: Runs a method before/after each test. Can be used to set up and tear down test
  environment for each test. E.g. recreating test objects or populating a database, then deleting it after the test.
- `@BeforeAll`, `@AfterAll`: Same as above, but only runs once before/after all tests. Can be used to set up and tear
  down test environment for all tests. E.g. creating a database connection pool.
- `@DisplayName`: Sets a custom name for a test. Can be used to make test names more readable.
- `@Nested`: Creates a nested test class. Can be used to group tests together.
- `assumeFalse`, `assumeTrue`: Assumptions that must be correct for the test to run. Skips the test if assumptions fail.
  Can be used to skip tests that are not relevant for the current environment, e.g. specific OS or production stage.
  Failing the assumption
  just skips the test, it doesn't stop the build.

### 3.2. Mocking Frameworks

> Investigate mocking frameworks for your preferred language. Choose at least two frameworks, and answer the
> questions. (One could be Mockito, which we saw in class.)
>
> - What are their similarities?
> - What are their differences?
> - Which one would you prefer, if any, and why?

The ones I'll compare are [Mockito](https://site.mockito.org/), [JMockit](https://jmockit.github.io/),
and [EasyMock](https://easymock.org/). Very much inspired
by [this article](https://www.baeldung.com/mockito-vs-easymock-vs-jmockit).

#### 3.2.1. Similarities

They really are all quite similar in that they do much the same thing. They all create mock objects that can be injected
into the code under test.

They all specify what the mock object should do when a method is called and then verify that the method was called.

#### 3.2.2. Differences

The differences are pretty minor. It's mostly different names for the annotations and methods.

One notable difference in syntax is that JMockit uses `Expectations` and `Verifications` classes to define what a mock
object should do, whereas the other two use methods, `when` for Mockito, `expect` for EasyMock, and `verify` for both.

The `Expectation` object uses double braces syntax which stands out a bit.

Easymock uses the record/replay/verify pattern, whereas Mockito doesn't explicitly need a replay step.

#### 3.2.3. Preference

I'll prefer Mockito because it has by far the most stars on GitHub. This signifies a bigger community and greater
likelihood to be supported and maintained in the future. Additionally, it would be easier to find help and resources,
and other developers would be more likely to be familiar with it.

At the time of writing, Mockito is in the lead with 14.2k stars, EasyMock has 800, and JMockit has 451.
