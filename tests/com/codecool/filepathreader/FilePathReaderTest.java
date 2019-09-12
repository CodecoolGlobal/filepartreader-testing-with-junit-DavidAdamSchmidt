package com.codecool.filepathreader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FilePathReaderTest {

    private String filePath = "test.txt";

    @Test
    public void testDoesConstructorSetInvalidValues() {
        FilePathReader fpr = new FilePathReader();
        String expected = "-1-1-1";
        String outcome = fpr.getFilePath() + fpr.getFromLine() + fpr.getToLine();
        assertEquals(expected, outcome);
    }

    @Test
    public void testSetup_correctValues() {
        Integer fromLine = 5, toLine = 10;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(filePath, fromLine, toLine);
        Object[] expected = new Object[]{
                filePath, fromLine, toLine
        };
        Object[] outcome = new Object[]{
                fpr.getFilePath(), fpr.getFromLine(), fpr.getToLine()
        };
        assertArrayEquals(expected, outcome);
    }

    @Test
    public void testSetup_toLineSmallerThanFromLine_throwsException() {
        Integer fromLine = 5, toLine = 4;
        FilePathReader fpr = new FilePathReader();
        assertThrows(IllegalArgumentException.class,
                () -> fpr.setup(filePath, fromLine, toLine));
    }

    @Test
    public void testSetup_fromLineSmallerThan1_throwsException() {
        Integer fromLine = 0, toLine = 4;
        FilePathReader fpr = new FilePathReader();
        assertThrows(IllegalArgumentException.class,
                () -> fpr.setup(filePath, fromLine, toLine));
    }

    @Test
    public void testRead_validFilePath() throws IOException {
        Integer fromLine = 1, toLine = 1;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(filePath, fromLine, toLine);
        Path path = FileSystems.getDefault().getPath(filePath);
        String text = new String(Files.readAllBytes(path));
        assertEquals(text, fpr.read());
    }

    @Test
    public void testRead_invalidFilePath_throwsException() {
        String invalidFilePath = "";
        Integer fromLine = 1, toLine = 1;
        FilePathReader fpr = new FilePathReader();
        fpr.setup(invalidFilePath, fromLine, toLine);
        assertThrows(IOException.class, fpr::read);
    }
}