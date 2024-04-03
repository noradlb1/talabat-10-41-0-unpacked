package com.huawei.location.lite.common.log.logwrite;

import java.io.BufferedWriter;

public class FileParam {
    private String fileDirPath;
    private String fileName;
    private boolean isFirstWrite;
    private boolean isNeedCheck;
    private BufferedWriter writer;

    public FileParam() {
        this.isFirstWrite = true;
    }

    public FileParam(String str, String str2, boolean z11, boolean z12, BufferedWriter bufferedWriter) {
        this.fileDirPath = str;
        this.fileName = str2;
        this.isNeedCheck = z11;
        this.isFirstWrite = z12;
        this.writer = bufferedWriter;
    }

    public String getFileDirPath() {
        return this.fileDirPath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public BufferedWriter getWriter() {
        return this.writer;
    }

    public boolean isFirstWrite() {
        return this.isFirstWrite;
    }

    public boolean isNeedCheck() {
        return this.isNeedCheck;
    }

    public void setFileDirPath(String str) {
        this.fileDirPath = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFirstWrite(boolean z11) {
        this.isFirstWrite = z11;
    }

    public void setNeedCheck(boolean z11) {
        this.isNeedCheck = z11;
    }

    public void setWriter(BufferedWriter bufferedWriter) {
        this.writer = bufferedWriter;
    }
}
