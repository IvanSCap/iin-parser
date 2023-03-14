package com.capgemini.iinparser.unit;

import com.capgemini.iinparser.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void shouldReturnGivenPan() {
        String expectedPan = "4444444444444444";

        String actualPan = Main.getPan(new String[]{expectedPan});

        assertEquals(expectedPan, actualPan);
    }

    @Test
    void shouldReturnDefaultPan() {
        String expectedPan = "4444444444444444";

        String actualPan = Main.getPan(new String[]{});

        assertEquals(expectedPan, actualPan);
    }
}
