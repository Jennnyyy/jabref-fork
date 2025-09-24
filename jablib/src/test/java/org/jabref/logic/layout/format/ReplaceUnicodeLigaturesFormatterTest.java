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
            "lorem ipsum,lorem ipsum"
    })
    void plainFormat(String expected, String input) {
        assertEquals(expected, formatter.format(input));
    }

    @ParameterizedTest
    @CsvSource({
            "AA,\uA732",
            "fi,ﬁ",
            "et,\uD83D\uDE70"
    })
    void singleLigatures(String expected, String input) {
        assertEquals(expected, formatter.format(input));
    }

    @ParameterizedTest
    @CsvSource({
            "aefffflstue,æﬀﬄﬆᵫ"
    })
    void ligatureSequence(String expected, String input) {
        assertEquals(expected, formatter.format(input));
    }

    @ParameterizedTest
    @CsvSource({
            "AEneas,Æneas"
    })
    void sampleInput(String expected, String input) {
        assertEquals(expected, formatter.format(input));
    }
}
