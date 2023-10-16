package org.example.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    void gutterGame() {
        Game g = new Game();
        for (int i = 0; i < 20; i++) {
            g.roll(0);
        }
        assertEquals(0, g.score());
    }

    @Test
    void allOnes() {
        Game g = new Game();
        for (int i = 0; i < 20; i++) {
            g.roll(1);
        }
        assertEquals(20, g.score());
    }
}
