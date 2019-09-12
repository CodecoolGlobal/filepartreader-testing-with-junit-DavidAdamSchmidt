package com.codecool.filepathreader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePathReader filePathReader;

    public FileWordAnalyzer(FilePathReader filePathReader) {
        this.filePathReader = filePathReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        try {
            List<String> words = getWords();
            words.sort(Comparator.naturalOrder());
            return words;

        } catch (IOException e) {
            return null;
        }
    }

    public List<String> getWordsContainingSubstring(String subString) {
        try {
            List<String> words = getWords();
            return words
                    .stream()
                    .filter(word -> word.contains(subString))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    public List<String> getWordsWhichPalindromes() {
        try {
            List<String> words = getWords();
            return words
                    .stream()
                    .filter(this::isPalindrome)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    private List<String> getWords() throws IOException {
        String text = filePathReader.readLines();
        text = text.replaceAll("\\.", "");
        text = text.replaceAll(",", "");
        text = text.toLowerCase();
        return Arrays.asList(text.split("\\s+"));
    }

    private boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}