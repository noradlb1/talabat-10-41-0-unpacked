package com.huawei.hms.analytics.database;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.LinkedHashMap;
import java.util.Map;

public class APIEvent {
    private String code;
    private String costTime;
    private String errorCode;
    private String eventCnt;
    private String eventId;

    /* renamed from: id  reason: collision with root package name */
    private Long f47917id;

    /* renamed from: name  reason: collision with root package name */
    private String f47918name;
    private String result;
    private String timestamp;
    private String type;

    public APIEvent() {
    }

    public APIEvent(Long l11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f47917id = l11;
        this.code = str;
        this.timestamp = str2;
        this.type = str3;
        this.f47918name = str4;
        this.result = str5;
        this.errorCode = str6;
        this.eventId = str7;
        this.eventCnt = str8;
        this.costTime = str9;
    }

    public APIEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.code = str;
        this.timestamp = str2;
        this.type = str3;
        this.f47918name = str4;
        this.result = str5;
        this.errorCode = str6;
        this.eventId = str7;
        this.eventCnt = str8;
        this.costTime = str9;
    }

    public String getCode() {
        return this.code;
    }

    public String getCostTime() {
        return this.costTime;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getEventCnt() {
        return this.eventCnt;
    }

    public String getEventId() {
        return this.eventId;
    }

    public Long getId() {
        return this.f47917id;
    }

    public String getName() {
        return this.f47918name;
    }

    public String getResult() {
        return this.result;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCostTime(String str) {
        this.costTime = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setEventCnt(String str) {
        this.eventCnt = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setId(Long l11) {
        this.f47917id = l11;
    }

    public void setName(String str) {
        this.f47918name = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Map toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("service", "AnalyticsKit");
        linkedHashMap.put("id", this.code);
        linkedHashMap.put("timestamp", this.timestamp);
        linkedHashMap.put("api_type", this.type);
        linkedHashMap.put("api_name", this.f47918name);
        linkedHashMap.put("result", this.result);
        linkedHashMap.put("error_code", this.errorCode);
        linkedHashMap.put("event_id", this.eventId);
        linkedHashMap.put("event_cnt", this.eventCnt);
        linkedHashMap.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.costTime);
        return linkedHashMap;
    }
}
