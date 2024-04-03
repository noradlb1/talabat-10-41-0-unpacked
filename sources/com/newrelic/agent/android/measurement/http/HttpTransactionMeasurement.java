package com.newrelic.agent.android.measurement.http;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;
import java.util.Map;

public class HttpTransactionMeasurement extends BaseMeasurement {
    private final String appData;
    private final long bytesReceived;
    private final long bytesSent;
    private final int errorCode;
    private final String httpMethod;
    private Map<String, String> params;
    private String responseBody;
    private final int statusCode;
    private final double totalTime;
    private Map<String, Object> traceAttributes;
    private TraceContext traceContext;
    private String url;

    public HttpTransactionMeasurement(String str, String str2, int i11, int i12, long j11, double d11, long j12, long j13, String str3) {
        super(MeasurementType.Network);
        String sanitizeUrl = Util.sanitizeUrl(str);
        setName(sanitizeUrl);
        setScope(TraceMachine.getCurrentScope());
        setStartTime(j11);
        setEndTime(j11 + ((long) ((int) d11)));
        setExclusiveTime((long) ((int) (1000.0d * d11)));
        this.url = sanitizeUrl;
        this.httpMethod = str2;
        this.statusCode = i11;
        this.bytesSent = j12;
        this.bytesReceived = j13;
        this.totalTime = d11;
        this.appData = str3;
        this.errorCode = i12;
        this.responseBody = null;
        this.params = null;
        this.traceContext = null;
    }

    public double asDouble() {
        return this.totalTime;
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

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        String str = this.url;
        String str2 = this.httpMethod;
        double d11 = this.totalTime;
        int i11 = this.statusCode;
        int i12 = this.errorCode;
        long j11 = this.bytesSent;
        long j12 = this.bytesReceived;
        String str3 = this.appData;
        String str4 = this.responseBody;
        Map<String, String> map = this.params;
        return "HttpTransactionMeasurement{url='" + str + "', httpMethod='" + str2 + "', totalTime=" + d11 + ", statusCode=" + i11 + ", errorCode=" + i12 + ", bytesSent=" + j11 + ", bytesReceived=" + j12 + ", appData='" + str3 + "', responseBody='" + str4 + "', params='" + map + "'}";
    }

    public HttpTransactionMeasurement(String str, String str2, int i11, int i12, long j11, double d11, long j12, long j13, String str3, String str4) {
        this(str, str2, i11, i12, j11, d11, j12, j13, str3);
        this.responseBody = str4;
    }

    public HttpTransactionMeasurement(TransactionData transactionData) {
        this(transactionData.getUrl(), transactionData.getHttpMethod(), transactionData.getStatusCode(), transactionData.getErrorCode(), transactionData.getTimestamp(), (double) transactionData.getTime(), transactionData.getBytesSent(), transactionData.getBytesReceived(), transactionData.getAppData());
        this.responseBody = transactionData.getResponseBody();
        this.params = transactionData.getParams();
        this.traceContext = transactionData.getTraceContext();
        this.traceAttributes = transactionData.getTraceAttributes();
    }
}
