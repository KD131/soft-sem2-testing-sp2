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
}