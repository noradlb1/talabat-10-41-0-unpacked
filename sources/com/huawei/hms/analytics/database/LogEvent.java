package com.huawei.hms.analytics.database;

public class LogEvent {
    private String hij;
    private String ijk;
    private Long ikl;
    private String klm;
    private Long lmn;

    public LogEvent() {
    }

    public LogEvent(Long l11, String str, Long l12, String str2, String str3) {
        this.lmn = l11;
        this.klm = str;
        this.ikl = l12;
        this.ijk = str2;
        this.hij = str3;
    }

    public Long getConfigId() {
        return this.ikl;
    }

    public String getContent() {
        return this.ijk;
    }

    public String getEventId() {
        return this.hij;
    }

    public String getEvtTime() {
        return this.klm;
    }

    public Long getId() {
        return this.lmn;
    }

    public void setConfigId(Long l11) {
        this.ikl = l11;
    }

    public void setContent(String str) {
        this.ijk = str;
    }

    public void setEventId(String str) {
        this.hij = str;
    }

    public void setEvtTime(String str) {
        this.klm = str;
    }

    public void setId(Long l11) {
        this.lmn = l11;
    }
}
