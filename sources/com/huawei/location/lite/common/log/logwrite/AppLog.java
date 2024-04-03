package com.huawei.location.lite.common.log.logwrite;

public class AppLog {
    private String fileType;
    private String level;
    private String msg;
    private String tag;

    /* renamed from: tr  reason: collision with root package name */
    private Throwable f50148tr;

    public AppLog(String str, String str2) {
        this.msg = str;
        this.fileType = str2;
    }

    public AppLog(String str, String str2, String str3, String str4, Throwable th2) {
        this.level = str;
        this.tag = str2;
        this.msg = str3;
        this.fileType = str4;
        this.f50148tr = th2;
    }

    public AppLog(String str, String str2, String str3, Throwable th2) {
        this.level = str;
        this.tag = str2;
        this.msg = str3;
        this.f50148tr = th2;
        this.fileType = LogWriteConstants.LOG_TYPE;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTag() {
        return this.tag;
    }

    public Throwable getTr() {
        return this.f50148tr;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTr(Throwable th2) {
        this.f50148tr = th2;
    }
}
