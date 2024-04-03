package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TransactionState {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private String appData;
    private long bytesReceived = 0;
    private long bytesSent = 0;
    private String carrier = "unknown";
    private String contentType;
    private long endTime = 0;
    private int errorCode = 0;
    private String httpMethod;
    private Map<String, String> params = new HashMap();
    private long startTime = System.currentTimeMillis();
    private State state = State.READY;
    private int statusCode = 0;
    private TraceContext trace;
    private TransactionData transactionData;
    private String url;
    private String wanType = "unknown";

    public enum State {
        READY,
        SENT,
        COMPLETE
    }

    public TransactionState() {
        TraceMachine.enterNetworkSegment("External/unknownhost");
    }

    public static boolean isRequestError(int i11) {
        return ((long) i11) >= 400;
    }

    public static boolean isRequestFailure(int i11) {
        return i11 != 0;
    }

    public TransactionData end() {
        if (!isComplete()) {
            this.state = State.COMPLETE;
            this.endTime = System.currentTimeMillis();
            TraceMachine.exitMethod();
        }
        return toTransactionData();
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public String getContentType() {
        return this.contentType;
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

    public int getStatusCode() {
        return this.statusCode;
    }

    public TraceContext getTrace() {
        return this.trace;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isComplete() {
        return this.state == State.COMPLETE;
    }

    public boolean isErrorOrFailure() {
        return isRequestError() || isRequestFailure();
    }

    public boolean isRequestError() {
        return isRequestError(this.statusCode);
    }

    public boolean isRequestFailure() {
        return isRequestFailure(this.errorCode);
    }

    public boolean isSent() {
        State state2 = this.state;
        return state2 == State.SENT || state2 == State.COMPLETE;
    }

    public void setAppData(String str) {
        if (!isComplete()) {
            this.appData = str;
            TraceMachine.setCurrentTraceParam("encoded_app_data", str);
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setAppData(...) called on TransactionState in " + obj + " state");
    }

    public void setBytesReceived(long j11) {
        if (!isComplete()) {
            this.bytesReceived = j11;
            TraceMachine.setCurrentTraceParam("bytes_received", Long.valueOf(j11));
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setBytesReceived(...) called on TransactionState in " + obj + " state");
    }

    public void setBytesSent(long j11) {
        if (!isComplete()) {
            this.bytesSent = j11;
            TraceMachine.setCurrentTraceParam("bytes_sent", Long.valueOf(j11));
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setBytesSent(...) called on TransactionState in " + obj + " state");
    }

    public void setCarrier(String str) {
        if (!isSent()) {
            this.carrier = str;
            TraceMachine.setCurrentTraceParam("carrier", str);
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setCarrier(...) called on TransactionState in " + obj + " state");
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setErrorCode(int i11) {
        if (!isComplete()) {
            this.errorCode = i11;
            TraceMachine.setCurrentTraceParam("error_code", Integer.valueOf(i11));
            return;
        }
        TransactionData transactionData2 = this.transactionData;
        if (transactionData2 != null) {
            transactionData2.setErrorCode(i11);
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setErrorCode(...) called on TransactionState in " + obj + " state");
    }

    public void setHttpMethod(String str) {
        if (!isSent()) {
            this.httpMethod = str;
            TraceMachine.setCurrentTraceParam("http_method", str);
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setHttpMethod(...) called on TransactionState in " + obj + " state");
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public State setState(State state2) {
        this.state = state2;
        return state2;
    }

    public void setStatusCode(int i11) {
        if (!isComplete()) {
            this.statusCode = i11;
            TraceMachine.setCurrentTraceParam("status_code", Integer.valueOf(i11));
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setStatusCode(...) called on TransactionState in " + obj + " state");
    }

    public void setTrace(TraceContext traceContext) {
        if (!isSent()) {
            this.trace = traceContext;
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setCatPayload(...) called on TransactionState in " + obj + " state");
    }

    public void setUrl(String str) {
        String sanitizeUrl = Util.sanitizeUrl(str);
        if (sanitizeUrl != null) {
            if (!isSent()) {
                this.url = sanitizeUrl;
                try {
                    String host = new URL(sanitizeUrl).getHost();
                    TraceMachine.setCurrentDisplayName("External/" + host);
                } catch (MalformedURLException unused) {
                    AgentLog agentLog = log;
                    agentLog.error("unable to parse host name from " + sanitizeUrl);
                }
                TraceMachine.setCurrentTraceParam("uri", sanitizeUrl);
                return;
            }
            AgentLog agentLog2 = log;
            String obj = this.state.toString();
            agentLog2.debug("setUrl(...) called on TransactionState in " + obj + " state");
        }
    }

    public void setWanType(String str) {
        if (!isSent()) {
            this.wanType = str;
            TraceMachine.setCurrentTraceParam("wan_type", str);
            return;
        }
        AgentLog agentLog = log;
        String obj = this.state.toString();
        agentLog.debug("setWanType(...) called on TransactionState in " + obj + " state");
    }

    public String toString() {
        String str = this.url;
        String str2 = this.httpMethod;
        int i11 = this.statusCode;
        int i12 = this.errorCode;
        long j11 = this.bytesSent;
        long j12 = this.bytesReceived;
        long j13 = this.startTime;
        long j14 = this.endTime;
        String str3 = this.appData;
        String str4 = this.carrier;
        String str5 = this.wanType;
        State state2 = this.state;
        String str6 = this.contentType;
        TransactionData transactionData2 = this.transactionData;
        return "TransactionState{url='" + str + "', httpMethod='" + str2 + "', statusCode=" + i11 + ", errorCode=" + i12 + ", bytesSent=" + j11 + ", bytesReceived=" + j12 + ", startTime=" + j13 + ", endTime=" + j14 + ", appData='" + str3 + "', carrier='" + str4 + "', wanType='" + str5 + "', state=" + state2 + ", contentType='" + str6 + "', transactionData=" + transactionData2 + "}";
    }

    public TransactionData toTransactionData() {
        float f11;
        if (!isComplete()) {
            log.debug("toTransactionData() called on incomplete TransactionState");
        }
        if (this.url == null) {
            log.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
            return null;
        }
        long j11 = this.endTime;
        long j12 = this.startTime;
        float f12 = ((float) (j11 - j12)) / 1000.0f;
        if (f12 < 0.0f) {
            AgentLog agentLog = log;
            agentLog.error("Invalid response duration detected: start[" + j12 + "] end[" + j11 + "]");
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_RESPONSE_TIME_INVALID_DURATION);
            f11 = 0.0f;
        } else {
            f11 = f12;
        }
        if (this.transactionData == null) {
            this.transactionData = new TransactionData(this.url, this.httpMethod, this.carrier, f11, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.appData, this.wanType, this.trace, "", this.params, (Map<String, Object>) null);
        }
        return this.transactionData;
    }
}
