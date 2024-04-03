package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.util.TreeMap;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp3TransactionStateUtil extends TransactionStateUtil {
    public static Response addTransactionAndErrorData(TransactionState transactionState, Response response) {
        TransactionData end = transactionState.end();
        if (end != null) {
            if (response != null && transactionState.isErrorOrFailure()) {
                String header = response.header("Content-Type");
                TreeMap treeMap = new TreeMap();
                if (header != null && !header.isEmpty()) {
                    treeMap.put("content_type", header);
                }
                long bytesReceived = transactionState.getBytesReceived();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(bytesReceived);
                treeMap.put(Constants.Transactions.CONTENT_LENGTH, sb2.toString());
                String str = "";
                try {
                    long exhaustiveContentLength = exhaustiveContentLength(response);
                    if (exhaustiveContentLength > 0) {
                        str = response.peekBody(exhaustiveContentLength).string();
                    }
                } catch (Exception unused) {
                    if (response.message() != null) {
                        TransactionStateUtil.log.debug("Missing response body, using response message");
                        str = response.message();
                    }
                }
                end.setResponseBody(str);
                end.getParams().putAll(treeMap);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(end));
            setDistributedTraceHeaders(transactionState, response);
        }
        return response;
    }

    private static long exhaustiveContentLength(Response response) {
        long j11 = -1;
        if (response == null) {
            return -1;
        }
        if (response.body() != null) {
            j11 = response.body().contentLength();
        }
        if (j11 >= 0) {
            return j11;
        }
        String header = response.header("Content-Length");
        if (header == null || header.length() <= 0) {
            Response networkResponse = response.networkResponse();
            if (networkResponse == null) {
                return j11;
            }
            String header2 = networkResponse.header("Content-Length");
            if (header2 != null && header2.length() > 0) {
                try {
                    return Long.parseLong(header2);
                } catch (NumberFormatException e11) {
                    AgentLog agentLog = TransactionStateUtil.log;
                    agentLog.debug("Failed to parse network response content length: " + e11);
                    return j11;
                }
            } else if (networkResponse.body() != null) {
                return networkResponse.body().contentLength();
            } else {
                return j11;
            }
        } else {
            try {
                return Long.parseLong(header);
            } catch (NumberFormatException e12) {
                AgentLog agentLog2 = TransactionStateUtil.log;
                agentLog2.debug("Failed to parse content length: " + e12);
                return j11;
            }
        }
    }

    public static void inspectAndInstrument(TransactionState transactionState, Request request) {
        if (request == null) {
            TransactionStateUtil.log.debug("Missing request");
            return;
        }
        TransactionStateUtil.inspectAndInstrument(transactionState, request.url().toString(), request.method());
        try {
            RequestBody body = request.body();
            if (body != null && body.contentLength() > 0) {
                transactionState.setBytesSent(body.contentLength());
            }
        } catch (IOException e11) {
            AgentLog agentLog = TransactionStateUtil.log;
            agentLog.debug("Could not determine request length: " + e11);
        }
    }

    public static Response inspectAndInstrumentResponse(TransactionState transactionState, Response response) {
        int i11;
        String str;
        long j11;
        long j12 = 0;
        if (response == null) {
            TransactionStateUtil.log.debug("Missing response");
            str = "";
            i11 = 500;
        } else {
            Request request = response.request();
            if (!(request == null || request.url() == null)) {
                String httpUrl = request.url().toString();
                if (!httpUrl.isEmpty()) {
                    TransactionStateUtil.inspectAndInstrument(transactionState, httpUrl, request.method());
                }
            }
            str = response.header(Constants.Network.APP_DATA_HEADER);
            i11 = response.code();
            try {
                j11 = exhaustiveContentLength(response);
            } catch (Exception unused) {
                j11 = 0;
            }
            if (j11 < 0) {
                TransactionStateUtil.log.debug("OkHttp3TransactionStateUtil: Missing body or content length");
            }
            j12 = j11;
        }
        TransactionStateUtil.inspectAndInstrumentResponse(transactionState, str, (int) j12, i11);
        return addTransactionAndErrorData(transactionState, response);
    }

    public static Request setDistributedTraceHeaders(TransactionState transactionState, Request request) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            try {
                Request.Builder newBuilder = request.newBuilder();
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    for (TraceHeader next : trace.getHeaders()) {
                        newBuilder = newBuilder.header(next.getHeaderName(), next.getHeaderValue());
                    }
                    TraceContext.reportSupportabilityMetrics();
                }
                return newBuilder.build();
            } catch (Exception e11) {
                TransactionStateUtil.log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e11);
                TraceContext.reportSupportabilityExceptionMetric(e11);
            }
        }
        return request;
    }

    public static Response setDistributedTraceHeaders(TransactionState transactionState, Response response) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            try {
                Response.Builder newBuilder = response.newBuilder();
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    Headers headers = response.headers();
                    for (TraceHeader next : trace.getHeaders()) {
                        if (headers.get(next.getHeaderName()) == null) {
                            newBuilder = newBuilder.addHeader(next.getHeaderName(), next.getHeaderValue());
                        }
                    }
                }
                return newBuilder.build();
            } catch (Exception e11) {
                TransactionStateUtil.log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e11);
                TraceContext.reportSupportabilityExceptionMetric(e11);
            }
        }
        return response;
    }
}
