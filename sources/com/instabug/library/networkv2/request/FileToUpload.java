package com.instabug.library.networkv2.request;

import androidx.annotation.NonNull;

public class FileToUpload {
    private final String fileName;
    private final String filePartName;
    private final String filePath;
    private final String fileType;

    public FileToUpload(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        this.filePartName = str;
        this.fileName = str2;
        this.filePath = str3;
        this.fileType = str4;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePartName() {
        return this.filePartName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileType() {
        return this.fileType;
    }
}
