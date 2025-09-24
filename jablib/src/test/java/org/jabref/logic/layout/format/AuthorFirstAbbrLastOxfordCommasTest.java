package org.jabref.logic.layout.format;

import org.jabref.logic.layout.LayoutFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorFirstAbbrLastOxfordCommasTest {

    /**
     * Test method for {@link org.jabref.logic.layout.format.AuthorFirstAbbrLastOxfordCommas#format(java.lang.String)}.
     */
    @ParameterizedTest
    @CsvSource(delimiter=';', value={
            "'';''",
            "V. S. Someone;Someone, Van Something",
            "J. von Neumann and P. Black Brown;John von Neumann and Black Brown, Peter",
            "J. von Neumann, J. Smith, and P. Black Brown;von Neumann, John and Smith, John and Black Brown, Peter",
            "J. von Neumann, J. Smith, and P. Black Brown;John von Neumann and John Smith and Black Brown, Peter"
    })
    void format(String expected, String input) {
        LayoutFormatter a = new AuthorFirstAbbrLastOxfordCommas();

        assertEquals(expected, a.format(input));
    }
}
