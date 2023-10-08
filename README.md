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

## 1. Reflections

### 1.1. Computer Mouse

> Identify the types of testing you would perform on a computer mouse, to make sure that it is of the highest quality.

### 1.2. Catastrophic Failure

> Find a story where a software system defect had a bad outcome. Describe what happened. Can you identify a test that would have prevented it?

Between 1985 and 1987, a software bug in Therac-25, a radiation therapy machine, killed 6 people.

The machine could do two kinds of treatment, X-ray (photon) and electron, with very different dosages.
It would use a turntable to mechanically switch between those modes, and also normal, visible light. It took 8 seconds to move this turntable.

It was fully controlled by software, and, in fact, earlier models _had_ hardware locks to prevent catastrophically high dosages,
but these safety measures were removed in the Therac-25 and replaced with software checks.

The machine was programmed by a single developer in assembly, and it was never tested until production when it was used on real patients in the hospital.

If an operator were to mistakenly initiate X-ray treatment and then correct the error within the 8 seconds it took to move the turntable,
those inputs would be ignored as the program wasn't meant to accept inputs in that phase. This is a _race condition_.

Patients could be prescribed electron therapy but receive X-rays roughly 100 times the intended dosage
because the machine had initially been set for X-ray, and the filter had not moved into place.

Machine displayed a `Malfunction 54` error message, which in the manual indicates a `dose input 2` error. This means either too high or too low dosage.


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
> Don’t use any built-in string utility – create your own. Remember, the exercise here is to use BDD, not to deliver a working utility without tests. If there are no tests in the solution, it won’t be accepted.

### 2.2. Bowling Game Kata

> Complete the Bowling Game Kata using BDD. The slides can be found here:  
> <http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt>

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

### 3.2. Mocking Frameworks

> Investigate mocking frameworks for your preferred language. Choose at least two frameworks, and answer the questions. (One could be Mockito, which we saw in class.)
>
> - What are their similarities?
> - What are their differences?
> - Which one would you prefer, if any, and why?
