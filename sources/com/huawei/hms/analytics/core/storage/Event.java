package com.huawei.hms.analytics.core.storage;

import com.braze.models.FeatureFlag;
import com.huawei.hms.analytics.core.log.HiLog;
import org.json.JSONException;
import org.json.JSONObject;

public class Event implements Cloneable {
    private static final String TAG = "EventBean";
    private String associationid;
    private String content;
    private String evtid;
    private String evttime;
    private String evttype;

    /* renamed from: id  reason: collision with root package name */
    private Long f47914id;
    private String pid;
    private String pushEvtFlag;
    private String serviceTag;
    private String sessionName;
    private String sessionid;

    public Event() {
    }

    public Event(Long l11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f47914id = l11;
        this.evtid = str;
        this.evttype = str2;
        this.content = str3;
        this.evttime = str4;
        this.serviceTag = str5;
        this.sessionid = str6;
        this.sessionName = str7;
        this.associationid = str8;
        this.pid = str9;
    }

    public Event clone() {
        return (Event) super.clone();
    }

    public void formJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.evtid = jSONObject.optString("event");
            this.evttime = jSONObject.optString("eventtime");
            this.evttype = jSONObject.optString("type");
            this.content = jSONObject.optString(FeatureFlag.PROPERTIES);
            this.sessionid = jSONObject.optString("first_session_event");
            this.sessionName = jSONObject.optString("event_session_name");
            this.associationid = jSONObject.optString("id", "");
            this.pid = jSONObject.optString("pid", "");
        }
    }

    public String getAssociationid() {
        return this.associationid;
    }

    public String getContent() {
        return this.content;
    }

    public String getEvtId() {
        return this.evtid;
    }

    public String getEvtTime() {
        return this.evttime;
    }

    public String getEvtType() {
        return this.evttype;
    }

    public Long getId() {
        return this.f47914id;
    }

    public String getPid() {
        return this.pid;
    }

    public String getPushEvtFlag() {
        return this.pushEvtFlag;
    }

    public String getServiceTag() {
        return this.serviceTag;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public void setAssociationid(String str) {
        this.associationid = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEvtId(String str) {
        this.evtid = str;
    }

    public void setEvtTime(String str) {
        this.evttime = str;
    }

    public void setEvtType(String str) {
        this.evttype = str;
    }

    public void setId(Long l11) {
        this.f47914id = l11;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPushEvtFlag(String str) {
        this.pushEvtFlag = str;
    }

    public void setServiceTag(String str) {
        this.serviceTag = str;
    }

    public void setSessionName(String str) {
        this.sessionName = str;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", (Object) this.evttype);
            jSONObject.put("eventtime", (Object) this.evttime);
            jSONObject.put("event", (Object) this.evtid);
            jSONObject.put("id", (Object) this.associationid);
            jSONObject.put("pid", (Object) this.pid);
            jSONObject.put("event_session_name", (Object) this.sessionName);
            jSONObject.put("first_session_event", (Object) this.sessionid);
            String str = this.content;
            if (str != null) {
                if (!str.isEmpty()) {
                    jSONObject.put(FeatureFlag.PROPERTIES, (Object) new JSONObject(this.content));
                    return jSONObject;
                }
            }
            HiLog.w(TAG, "content is empty: evtId:" + this.evtid);
            return null;
        } catch (JSONException unused) {
            HiLog.e(TAG, "event put params JSONException");
            return null;
        }
    }
}
