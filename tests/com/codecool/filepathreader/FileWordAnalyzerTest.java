package com.codecool.filepathreader;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private String filePath = "test.txt";

    @Test
    public void testGetWordsOrderedAlphabetically_oneLine() {
        Integer fromLine = 2, toLine = 2;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        List<String> expected = Arrays.asList(
                "aenean", "commodo", "dolor", "eget", "ligula"
        );
        List<String> outcome = fwa.getWordsOrderedAlphabetically();
        assertEquals(expected, outcome);
    }

    @Test
    public void testGetWordsOrderedAlphabetically_moreLines() {
        Integer fromLine = 9, toLine = 13;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        List<String> expected = Arrays.asList(
                "aenean", "cras", "dapibus", "dictum", "eleifend",
                "elementum", "eu", "felis", "integer", "mollis",
                "nisi", "nullam", "pede", "pretium", "semper",
                "tellus", "tincidunt", "vivamus", "vulputate"
        );
        List<String> outcome = fwa.getWordsOrderedAlphabetically();
        assertEquals(expected, outcome);
    }
}