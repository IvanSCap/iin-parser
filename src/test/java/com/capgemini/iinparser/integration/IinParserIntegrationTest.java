package com.capgemini.iinparser.integration;

import com.capgemini.iinparser.Main;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class IinParserIntegrationTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final String ERROR_MESSAGE = "Unsupported PAN format";

    @BeforeEach
    void setup(){
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(outputStream));
    }

    @Test
    void shouldReturnFormattedPanForVisa(){
        Main.main(new String[] { "4444444444444444" });
        String consoleOutput = outputStream.toString();
        String expectedOutput = "4444 4444 4444 4444";
        assertTrue(consoleOutput.contains(expectedOutput));
    }

    @Test
    void shouldReturnErrorTooLongPan(){
        Main.main(new String[] { "44444444444444444444" });
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(ERROR_MESSAGE));
    }

    @Test
    void shouldReturnErrorTooSmallPan(){
        Main.main(new String[] { "44" });
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(ERROR_MESSAGE));
    }

    @Test
    void shouldReturnFormattedPanForDiners(){
        Main.main(new String[] { "30122994494222" });
        String consoleOutput = outputStream.toString();
        String expectedOutput = "3012 299449 4222";
        assertTrue(consoleOutput.contains(expectedOutput));
    }

    @Test
    void shouldReturnFormattedPanForMaestro(){
        Main.main(new String[] { "5000015123563212456" });
        String consoleOutput = outputStream.toString();
        String expectedOutput = "5000 0151 2356 3212 456";
        assertTrue(consoleOutput.contains(expectedOutput));
    }

    @Test
    void shouldReturnNotChangedPan(){
        String expectedOutput = "444444444444444";
        Main.main(new String[] { expectedOutput });
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(expectedOutput));
    }

    @Test
    void shouldReturnDefaultPan(){
        String expectedOutput = "4444 4444 4444 4444";
        Main.main(new String[] { });
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(expectedOutput));
    }
}
