package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.HttpHeaders;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class TransactionStateUtil {
    protected static final long CONTENTLENGTH_UNKNOWN = -1;
    protected static final AgentLog log = AgentLogManager.getAgentLog();

    public static void addHeadersAsCustomAttribute(TransactionState transactionState, String str, String str2) {
        if (!HttpHeaders.getInstance().getHttpHeaders().contains(str)) {
            return;
        }
        if (transactionState.getParams() != null) {
            transactionState.getParams().put(str, str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        transactionState.setParams(hashMap);
    }

    public static void inspectAndInstrument(TransactionState transactionState, String str, String str2) {
        transactionState.setUrl(str);
        transactionState.setHttpMethod(str2);
        transactionState.setCarrier(Agent.getActiveNetworkCarrier());
        transactionState.setWanType(Agent.getActiveNetworkWanType());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, String str, int i11, int i12) {
        if (str != null && !str.equals("")) {
            transactionState.setAppData(str);
        }
        if (i11 >= 0) {
            transactionState.setBytesReceived((long) i11);
        }
        transactionState.setStatusCode(i12);
    }

    public static void setCrossProcessHeader(HttpURLConnection httpURLConnection) {
        try {
            String crossProcessId = Agent.getCrossProcessId();
            if (crossProcessId != null) {
                httpURLConnection.setRequestProperty(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId);
            }
        } catch (Exception e11) {
            AgentLog agentLog = log;
            String localizedMessage = e11.getLocalizedMessage();
            agentLog.error("setCrossProcessHeader: " + localizedMessage);
        }
    }

    public static void setDistributedTraceHeaders(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            try {
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    for (TraceHeader next : trace.getHeaders()) {
                        httpURLConnection.addRequestProperty(next.getHeaderName(), next.getHeaderValue());
                    }
                    TraceContext.reportSupportabilityMetrics();
                }
            } catch (Exception e11) {
                log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e11);
                TraceContext.reportSupportabilityExceptionMetric(e11);
            }
        }
    }

    public static void setErrorCodeFromException(TransactionState transactionState, Exception exc) {
        int exceptionToErrorCode = ExceptionHelper.exceptionToErrorCode(exc);
        AgentLog agentLog = log;
        String name2 = exc.getClass().getName();
        agentLog.error("TransactionStateUtil: Attempting to convert network exception " + name2 + " to error code.");
        transactionState.setErrorCode(exceptionToErrorCode);
    }

    public static void setTrace(TransactionState transactionState) {
        if (transactionState.getTrace() == null) {
            transactionState.setTrace(DistributedTracing.getInstance().startTrace(transactionState));
        }
    }

    public static void inspectAndInstrument(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        inspectAndInstrument(transactionState, httpURLConnection.getURL().toString(), httpURLConnection.getRequestMethod());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        String str = null;
        int i11 = -1;
        int i12 = 0;
        try {
            i11 = httpURLConnection.getContentLength();
            i12 = httpURLConnection.getResponseCode();
            str = httpURLConnection.getHeaderField(Constants.Network.APP_DATA_HEADER);
        } catch (IllegalStateException e11) {
            AgentLog agentLog = log;
            String localizedMessage = e11.getLocalizedMessage();
            agentLog.debug("Failed to retrieve response data on a closed connection: " + localizedMessage);
        } catch (IOException e12) {
            AgentLog agentLog2 = log;
            String localizedMessage2 = e12.getLocalizedMessage();
            agentLog2.debug("Failed to retrieve response data due to an I/O exception: " + localizedMessage2);
        } catch (NullPointerException e13) {
            AgentLog agentLog3 = log;
            String localizedMessage3 = e13.getLocalizedMessage();
            agentLog3.error("Failed to retrieve response code due to underlying (Harmony?) NPE" + localizedMessage3);
        }
        inspectAndInstrumentResponse(transactionState, str, i11, i12);
    }
}
