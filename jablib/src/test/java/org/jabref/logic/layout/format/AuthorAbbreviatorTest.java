package org.jabref.logic.layout.format;

import org.jabref.logic.layout.LayoutFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Is the save as the AuthorLastFirstAbbreviator.
 */
class AuthorAbbreviatorTest {
    @ParameterizedTest
    @ValueSource(strings = { "", "Someone, Van Something", "Smith, John", "von Neumann, John and Smith, John and Black Brown, Peter"})
    void format(String input) {
        LayoutFormatter a = new AuthorLastFirstAbbreviator();
        LayoutFormatter b = new AuthorAbbreviator();

        assertEquals(b.format(input), a.format(input));
    }
}
