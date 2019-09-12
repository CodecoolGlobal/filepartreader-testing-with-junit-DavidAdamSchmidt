package com.codecool.filepathreader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileWordAnalyzer {

    private FilePathReader filePathReader;

    public FileWordAnalyzer(FilePathReader filePathReader) {
        this.filePathReader = filePathReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        try {
            String text = filePathReader.readLines();
            text = text.replaceAll("\\.", "");
            text = text.toLowerCase();
            List<String> words = Arrays.asList(text.split("\\s+"));
            words.sort(Comparator.naturalOrder());
            return words;

        } catch (IOException e) {
            return null;
        }
    }
}
