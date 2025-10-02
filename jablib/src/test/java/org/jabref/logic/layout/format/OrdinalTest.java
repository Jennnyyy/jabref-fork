package org.jabref.logic.layout.format;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrdinalTest {

    @Test
    void empty() {
        assertEquals("", new Ordinal().format(""));
    }

    @Test
    void testNull() {
        assertNull(new Ordinal().format(null));
    }

    @ParameterizedTest
    @CsvSource({
            // Single Digit
            "1st,1",
            "2nd,2",
            "3rd,3",
            "4th,4",
            // Multi Digit
            "11th,11",
            "111th,111",
            "21st,21",
            // Already Ordinals
            "1st,1st",
            "111th,111th",
            "22nd,22nd",
    })
    void formatsNumbersAsOrdinals(String expected, String input) {
        assertEquals(expected, new Ordinal().format(input));
    }

    @ParameterizedTest
    @CsvSource({
            "1st edn.,1 edn.",
            "1st edition,1st edition",
            "The 2nd conference on 3rd.14th,The 2 conference on 3.14"
    })
    void fullSentence(String expected, String input) {
        assertEquals(expected, new Ordinal().format(input));
    }

    @ParameterizedTest
    @CsvSource({
            "abCD eFg,abCD eFg"
    })
    void letters(String expected, String input) {
        assertEquals(expected, new Ordinal().format(input));
    }
}


