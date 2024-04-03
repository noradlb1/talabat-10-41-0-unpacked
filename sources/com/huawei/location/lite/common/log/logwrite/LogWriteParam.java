package com.huawei.location.lite.common.log.logwrite;

public class LogWriteParam {
    private int fileExpiredTime;
    private int fileNum;
    private int fileSize;
    private String logPath;

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
