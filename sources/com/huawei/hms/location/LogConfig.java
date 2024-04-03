package com.huawei.hms.location;

public class LogConfig {
    private int fileExpiredTime;
    private int fileNum;
    private int fileSize;
    private String logPath;

    public LogConfig() {
    }

    public LogConfig(String str) {
        this.logPath = str;
    }

    public LogConfig(String str, int i11, int i12, int i13) {
        this.logPath = str;
        this.fileSize = i11;
        this.fileNum = i12;
        this.fileExpiredTime = i13;
    }

    public int getFileExpiredTime() {
        return this.fileExpiredTime;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void setFileExpiredTime(int i11) {
        this.fileExpiredTime = i11;
    }

    public void setFileNum(int i11) {
        this.fileNum = i11;
    }

    public void setFileSize(int i11) {
        this.fileSize = i11;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }
}
