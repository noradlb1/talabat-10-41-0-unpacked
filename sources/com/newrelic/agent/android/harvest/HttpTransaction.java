package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Map;

public class HttpTransaction extends HarvestableArray {
    private String appData;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private int errorCode;
    private String httpMethod;
    private Map<String, String> params;
    private String responseBody;
    private int statusCode;
    private Long timestamp;
    private double totalTime;
    private Map<String, Object> traceAttributes;
    private TraceContext traceContext;
    private String url;
    private String wanType;

    public JsonArray asJsonArray() {
        JsonPrimitive jsonPrimitive;
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.url));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.carrier));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(Double.valueOf(this.totalTime)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Integer.valueOf(this.statusCode)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Integer.valueOf(this.errorCode)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.bytesSent)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.bytesReceived)));
        String str = this.appData;
        if (str == null) {
            jsonPrimitive = null;
        } else {
            jsonPrimitive = SafeJsonPrimitive.factory(str);
        }
        jsonArray.add((JsonElement) jsonPrimitive);
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.wanType));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.httpMethod));
        return jsonArray;
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
        return this.errorCode;
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

    public Long getTimestamp() {
        return this.timestamp;
    }

    public double getTotalTime() {
        return this.totalTime;
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

    public void setAppData(String str) {
        this.appData = str;
    }

    public void setBytesReceived(long j11) {
        this.bytesReceived = j11;
    }

    public void setBytesSent(long j11) {
        this.bytesSent = j11;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setErrorCode(int i11) {
        this.errorCode = i11;
    }

    public void setHttpMethod(String str) {
        this.httpMethod = str;
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

    public void setStatusCode(int i11) {
        this.statusCode = i11;
    }

    public void setTimestamp(Long l11) {
        this.timestamp = l11;
    }

    public void setTotalTime(double d11) {
        this.totalTime = d11;
    }

    public void setTraceAttributes(Map<String, Object> map) {
        this.traceAttributes = map;
    }

    public void setTraceContext(TraceContext traceContext2) {
        this.traceContext = traceContext2;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWanType(String str) {
        this.wanType = str;
    }

    public String toString() {
        String str = this.url;
        String str2 = this.carrier;
        String str3 = this.wanType;
        String str4 = this.httpMethod;
        double d11 = this.totalTime;
        int i11 = this.statusCode;
        int i12 = this.errorCode;
        long j11 = this.bytesSent;
        long j12 = this.bytesReceived;
        String str5 = this.appData;
        String str6 = this.responseBody;
        Map<String, String> map = this.params;
        Long l11 = this.timestamp;
        return "HttpTransaction{url='" + str + "', carrier='" + str2 + "', wanType='" + str3 + "', httpMethod='" + str4 + "', totalTime=" + d11 + ", statusCode=" + i11 + ", errorCode=" + i12 + ", bytesSent=" + j11 + ", bytesReceived=" + j12 + ", appData='" + str5 + "', responseBody='" + str6 + "', params='" + map + "', timestamp=" + l11 + "}";
    }
}
