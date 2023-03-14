package com.capgemini.iinparser.unit;

import com.capgemini.iinparser.model.IinRange;
import com.capgemini.iinparser.util.IinUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IinUtilTest {

    private IinUtil iinUtil;

    @BeforeEach
    void setUp() {
        iinUtil = new IinUtil();
    }

    @Test
    void panMatchesRangeReturnsTrue() {
        String pan = "1234567890123456";
        IinRange range = new IinRange("test", 16, 4, 1234, 1234, "#### #### #### ####");

        boolean result = iinUtil.matches(pan, range);

        assertTrue(result);
    }

    @Test
    void panDoesNotMatchRangeReturnsFalse() {
        String pan = "1234567890123456";
        IinRange range = new IinRange("test", 16, 4, 1235, 1236, "#### #### #### ####");

        boolean result = iinUtil.matches(pan, range);

        assertFalse(result);
    }

    @Test
    void panDoesNotMatchSizeReturnsFalse() {
        String pan = "12345678901234566666";
        IinRange range = new IinRange("test", 16, 4, 1235, 1236, "#### #### #### ####");

        boolean result = iinUtil.matches(pan, range);

        assertFalse(result);
    }

    @Test
    void returnsFormattedPan() {
        String pan = "1234567890123456";
        IinRange range = new IinRange("test", 16, 4, 1234, 1234, "#### #### #### ####");

        String formattedPan = iinUtil.formatPan(pan, range);

        assertEquals("1234 5678 9012 3456", formattedPan);
    }
}
