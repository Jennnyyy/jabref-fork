package org.jabref.logic.layout.format;

import org.jabref.logic.layout.LayoutFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorLastFirstTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {

            // Empty case
            "'';''",

            // Single Names
            "Someone, Van Something;Van Something Someone",

            // Two names
            "von Neumann, John and Black Brown, Peter;John von Neumann and Black Brown, Peter",

            // Three names
            "von Neumann, John and Smith, John and Black Brown, Peter;von Neumann, John and Smith, John and Black Brown, Peter",
            "von Neumann, John and Smith, John and Black Brown, Peter;John von Neumann and John Smith and Black Brown, Peter"
    })
    void format(String expected, String input) {
        LayoutFormatter a = new AuthorLastFirst();
        assertEquals(expected, a.format(input));
    }
}
