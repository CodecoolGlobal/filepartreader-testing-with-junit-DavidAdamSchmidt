package com.codecool.filepathreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePathReaderTest {

    @Test
    public void testDoesConstructorSetInvalidValues() {
        FilePathReader fpr = new FilePathReader();
        String expected = "-1-1-1";
        String outcome = fpr.getFilePath() + fpr.getFromLine() + fpr.getToLine();
        assertEquals(expected, outcome);
    }
}