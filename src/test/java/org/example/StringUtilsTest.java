package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @Test
    void reverseSingleWord() {
        String input = "Hello";
        String expected = "olleH";
        String actual = StringUtils.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    void reverseMultipleWords() {
        String input = "Hello World";
        String expected = "dlroW olleH";
        String actual = StringUtils.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    void reverseEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringUtils.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    void reverseNullString() {
        String input = null;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.reverse(input);
        });
    }

    @Test
    void upperCaseSingleWord() {
        String input = "Hello";
        String expected = "HELLO";
        String actual = StringUtils.upperCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void upperCaseMultipleWords() {
        String input = "Hello World";
        String expected = "HELLO WORLD";
        String actual = StringUtils.upperCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void upperCaseEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringUtils.upperCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void upperCaseNullString() {
        String input = null;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.upperCase(input);
        });
    }

    @Test
    void upperCaseMixedCaseString() {
        String input = "HeLlO wOrLd";
        String expected = "HELLO WORLD";
        String actual = StringUtils.upperCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void upperCaseNonAsciiString() {
        String input = "Rüdölf med den røde næse";
        String expected = "RÜDÖLF MED DEN RØDE NÆSE";
        String actual = StringUtils.upperCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void lowerCaseSingleWord() {
        String input = "Hello";
        String expected = "hello";
        String actual = StringUtils.lowerCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void lowerCaseMultipleWords() {
        String input = "Hello World";
        String expected = "hello world";
        String actual = StringUtils.lowerCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void lowerCaseEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringUtils.lowerCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void lowerCaseNullString() {
        String input = null;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.lowerCase(input);
        });
    }

    @Test
    void lowerCaseMixedCaseString() {
        String input = "HeLlO wOrLd";
        String expected = "hello world";
        String actual = StringUtils.lowerCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void lowerCaseNonAsciiString() {
        String input = "RÜdÖLF mED dEn rØde nÆSE";
        String expected = "rüdölf med den røde næse";
        String actual = StringUtils.lowerCase(input);
        assertEquals(expected, actual);
    }
}