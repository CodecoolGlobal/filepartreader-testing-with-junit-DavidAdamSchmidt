package com.codecool.filepathreader;

import java.io.IOException;
import java.util.Arrays;

public class FileWordAnalyzer {

    private FilePathReader filePathReader;

    public FileWordAnalyzer(FilePathReader filePathReader) {
        this.filePathReader = filePathReader;
    }

    public String[] getWordsOrderedAlphabetically() {
        try {
            String text = filePathReader.readLines();
            text = text.replaceAll("\\.", "");
            text = text.toLowerCase();
            String[] words = text.split("\\s+");
            Arrays.sort(words);
            return words;

        } catch (IOException e) {
            return null;
        }
    }
}
