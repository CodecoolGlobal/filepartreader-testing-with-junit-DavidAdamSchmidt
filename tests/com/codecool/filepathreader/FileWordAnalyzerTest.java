package com.codecool.filepathreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private String filePath = "test.txt";

    @Test
    public void testGetWordsOrderedAlphabetically_oneLine() {
        Integer fromLine = 2, toLine = 2;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        String[] expected = new String[]{
                "Aenean", "commodo", "dolor", "eget", "ligula"
        };
        String[] outcome = fwa.getWordsOrderedAlphabetically();
        assertArrayEquals(expected, outcome);
    }

    @Test
    public void testGetWordsOrderedAlphabetically_moreLines() {
        Integer fromLine = 9, toLine = 13;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        String[] expected = new String[]{
                "aenean", "cras", "dapibus", "dictum", "eleifend",
                "elementum", "eu", "felis", "integer", "mollis",
                "nisi", "nullam", "pede", "pretium", "semper",
                "tellus", "tincidunt", "vivamus", "vulputate"
        };
        String[] outcome = fwa.getWordsOrderedAlphabetically();
        assertArrayEquals(expected, outcome);
    }
}