package com.capgemini.iinparser.unit;

import com.capgemini.iinparser.domain.exception.PanFormatException;
import com.capgemini.iinparser.util.FormatUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatUtilTest {
    private FormatUtil formatUtil;

    @BeforeEach
    void setUp() throws IOException {
        formatUtil = new FormatUtil();
    }

    @Test
    void shouldFormatPanCorrectly() throws PanFormatException {
        String pan = "4444444444444444";
        String expectedFormattedPan = "4444 4444 4444 4444";

        String actualFormattedPan = formatUtil.format(pan);

        assertEquals(expectedFormattedPan, actualFormattedPan);
    }

    @Test
    void shouldThrowPanFormatExceptionForUnsupportedPan() {
        String pan = "1";

        assertThrows(PanFormatException.class, () -> formatUtil.format(pan));
    }
}
