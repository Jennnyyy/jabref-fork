package org.jabref.logic.layout.format;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameFormatterTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "'';'';''",
            "Doe; Joe Doe; 1@*@{ll}",
            "moremoremoremore; Joe Doe and Mary Jane and Bruce Bar and Arthur Kay; 1@*@{ll}@@2@1..1@{ff}{ll}@2..2@ and {ff}{last}@@*@*@more",
            "Doe; Joe Doe; 1@*@{ll}@@2@1..1@{ff}{ll}@2..2@ and {ff}{last}@@*@*@more",
            "JoeDoe and MaryJ; Joe Doe and Mary Jane; 1@*@{ll}@@2@1..1@{ff}{ll}@2..2@ and {ff}{l}@@*@*@more",
            "Doe, Joe and Jane, M. and Kamp, J.~A.; Joe Doe and Mary Jane and John Arthur van Kamp; 1@*@{ll}, {ff}@@*@1@{ll}, {ff}@2..-1@ and {ll}, {f}.",
            "Doe Joe and Jane, M. and Kamp, J.~A.; Joe Doe and Mary Jane and John Arthur van Kamp; 1@*@{ll}, {ff}@@*@1@{ll} {ff}@2..-1@ and {ll}, {f}."
    })
    void formatStringStringBibtexEntry(String expected, String input, String formatString) {
        NameFormatter l = new NameFormatter();
        assertEquals(expected, l.format(input, formatString));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "'';''",
            "Vandekamp Mary~Ann; Mary Ann Vandekamp",
            "von Neumann John and Black~Brown, Peter; John von Neumann and Black Brown, Peter",
            "von Neumann John, Smith, John and Black~Brown, Peter; von Neumann, John and Smith, John and Black Brown, Peter",
            "von Neumann John, Smith, John and Black~Brown, Peter; John von Neumann and John Smith and Black Brown, Peter",
            "von Neumann John, Smith, John, Vandekamp, Mary~Ann and Black~Brown, Peter; von Neumann, John and Smith, John and Vandekamp, Mary Ann and Black Brown, Peter"
    })
    void format(String expected, String input) {
        NameFormatter a = new NameFormatter();

        String formatString = "1@1@{vv }{ll}{ ff}@@2@1@{vv }{ll}{ ff}@2@ and {vv }{ll}{, ff}@@*@1@{vv }{ll}{ ff}@2..-2@, {vv }{ll}{, ff}@-1@ and {vv }{ll}{, ff}";

        assertEquals(expected, a.format(input, formatString));
    }
}


