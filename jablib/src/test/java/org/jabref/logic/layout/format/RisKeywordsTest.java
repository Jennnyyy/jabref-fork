package org.jabref.logic.layout.format;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.jabref.logic.os.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class RisKeywordsTest {

    static Stream<Arguments> getKeywords() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("", null),
                Arguments.of("KW  - abcd", "abcd"),
                Arguments.of("KW  - abcd" + OS.NEWLINE + "KW  - efg", "abcd, efg"),
                Arguments.of("KW  - abcd" + OS.NEWLINE + "KW  - efg" + OS.NEWLINE
                        + "KW  - hij" + OS.NEWLINE + "KW  - klm", "abcd, efg, hij, klm")
        );
    }

    @ParameterizedTest
    @MethodSource("getKeywords")
    void differentNumOfKeywords(String expected, String input) {
        assertEquals(expected, new RisKeywords().format(input));
    }
}
