package org.jabref.logic.layout.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceUnicodeLigaturesFormatterTest {

    private ReplaceUnicodeLigaturesFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new ReplaceUnicodeLigaturesFormatter();
    }

    @ParameterizedTest
    @CsvSource({
            // No Ligatures
            "lorem ipsum,lorem ipsum",
            // Single Ligatures
            "AA,\uA732",
            "fi,ﬁ",
            "et,\uD83D\uDE70",
            // Ligature Sequences
            "aefffflstue,æﬀﬄﬆᵫ",
            // Sample Input
            "AEneas,Æneas"
    })
    void format_replaces_ligatures(String expected, String input) {
        assertEquals(expected, formatter.format(input));
    }
}
