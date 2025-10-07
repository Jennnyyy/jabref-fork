package org.jabref.logic.layout.format;

import org.jabref.logic.layout.LayoutFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorLastFirstCommasTest {

    /**
     * Test method for {@link org.jabref.logic.layout.format.AuthorLastFirstCommas#format(java.lang.String)}.
     */
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            // Empty Case
            "'';''",
            // Single Names
            "Someone, Van Something;Van Something Someone",
            // Two names
            "von Neumann, John and Black Brown, Peter;John von Neumann and Black Brown, Peter",
            // Three names
            "von Neumann, John, Smith, John and Black Brown, Peter;von Neumann, John and Smith, John and Black Brown, Peter",
            "von Neumann, John, Smith, John and Black Brown, Peter; John von Neumann and John Smith and Black Brown, Peter"
    })
    void format(String expected, String input) {
        LayoutFormatter a = new AuthorLastFirstCommas();
        assertEquals(expected, a.format(input));
    }
}
