package com.newrelic.agent.android.api.common;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionData {
    private final String appData;
    private final long bytesReceived;
    private final long bytesSent;
    private final String carrier;
    private int errorCode;
    private final Object errorCodeLock;
    private final String httpMethod;
    private Map<String, String> params;
    private String responseBody;
    private final int statusCode;
    private final float time;
    private final long timestamp;
    private Map<String, Object> traceAttributes;
    private final TraceContext traceContext;
    private final String url;
    private final String wanType;

    public TransactionData(String str, String str2, String str3, float f11, int i11, int i12, long j11, long j12, String str4, String str5, TraceContext traceContext2, Map<String, Object> map) {
        String str6 = str;
        this.errorCodeLock = new Object();
        int indexOf = str.indexOf(63);
        if (indexOf < 0 && (indexOf = str.indexOf(59)) < 0) {
            indexOf = str.length();
        }
        this.url = str.substring(0, indexOf);
        this.httpMethod = str2;
        this.carrier = str3;
        this.time = f11;
        this.statusCode = i11;
        this.errorCode = i12;
        this.bytesSent = j11;
        this.bytesReceived = j12;
        this.appData = str4;
        this.wanType = str5;
        this.timestamp = System.currentTimeMillis();
        this.responseBody = null;
        this.params = new HashMap();
        this.traceContext = traceContext2;
        this.traceAttributes = map;
    }

    public List<Object> asList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.url);
        arrayList.add(this.carrier);
        arrayList.add(Float.valueOf(this.time));
        arrayList.add(Integer.valueOf(this.statusCode));
        arrayList.add(Integer.valueOf(this.errorCode));
        arrayList.add(Long.valueOf(this.bytesSent));
        arrayList.add(Long.valueOf(this.bytesReceived));
        arrayList.add(this.appData);
        return arrayList;
    }

    public String getAppData() {
        return this.appData;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public int getErrorCode() {
        int i11;
        synchronized (this.errorCodeLock) {
            i11 = this.errorCode;
        }
        return i11;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public float getTime() {
        return this.time;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Map<String, Object> getTraceAttributes() {
        return this.traceAttributes;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWanType() {
        return this.wanType;
    }

    public void setErrorCode(int i11) {
        synchronized (this.errorCodeLock) {
            this.errorCode = i11;
        }
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setResponseBody(String str) {
        if (!FeatureFlag.featureEnabled(FeatureFlag.HttpResponseBodyCapture)) {
            return;
        }
        if (str == null || str.isEmpty()) {
            this.responseBody = null;
        } else {
            this.responseBody = str;
        }
    }

    public void setTraceAttributes(Map<String, Object> map) {
        this.traceAttributes = map;
    }

    public String toString() {
        long j11 = this.timestamp;
        String str = this.url;
        String str2 = this.httpMethod;
        String str3 = this.carrier;
        float f11 = this.time;
        int i11 = this.statusCode;
        int i12 = this.errorCode;
        Object obj = this.errorCodeLock;
        long j12 = this.bytesSent;
        long j13 = this.bytesReceived;
        String str4 = this.appData;
        String str5 = this.wanType;
        return "TransactionData{timestamp=" + j11 + ", url='" + str + "', httpMethod='" + str2 + "', carrier='" + str3 + "', time=" + f11 + ", statusCode=" + i11 + ", errorCode=" + i12 + ", errorCodeLock=" + obj + ", bytesSent=" + j12 + ", bytesReceived=" + j13 + ", appData='" + str4 + "', wanType='" + str5 + "'}";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransactionData(String str, String str2, String str3, float f11, int i11, int i12, long j11, long j12, String str4, String str5, TraceContext traceContext2, String str6, Map<String, String> map, Map<String, Object> map2) {
        this(str, str2, str3, f11, i11, i12, j11, j12, str4, str5, traceContext2, map2);
        this.responseBody = str6;
        this.params = map;
    }
}
