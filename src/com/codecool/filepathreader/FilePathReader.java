package com.codecool.filepathreader;

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
}
