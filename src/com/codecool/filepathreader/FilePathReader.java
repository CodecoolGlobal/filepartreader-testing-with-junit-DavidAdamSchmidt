package com.codecool.filepathreader;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePathReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePathReader() {
        this.filePath = "-1";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine is smaller than fromLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine is smaller than 1");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        Path path = FileSystems.getDefault().getPath(filePath);
        return new String(Files.readAllBytes(path));
    }

    public String readLines() throws IOException {
        String[] allLines = read().split("\n");
        int size = toLine - fromLine + 1;
        String[] applicableLines = new String[size];
        System.arraycopy(allLines, fromLine - 1, applicableLines, 0, size);
        return String.join("\n", applicableLines);
    }
}
