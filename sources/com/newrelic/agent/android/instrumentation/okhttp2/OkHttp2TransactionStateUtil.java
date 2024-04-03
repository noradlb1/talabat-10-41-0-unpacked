package com.newrelic.agent.android.instrumentation.okhttp2;

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
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.TreeMap;
import okio.Buffer;

public class OkHttp2TransactionStateUtil extends TransactionStateUtil {
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
                    if (response.body() != null) {
                        ResponseBody body = response.body();
                        ByteBuffer wrap = ByteBuffer.wrap(body.bytes());
                        response = response.newBuilder().body(new PrebufferedResponseBody(body, new Buffer().write(wrap.array()))).build();
                        str = new String(wrap.array());
                    } else if (response.message() != null) {
                        TransactionStateUtil.log.debug("Missing response body, using response message");
                        str = response.message();
                    }
                } catch (Exception unused) {
                    if (response.message() != null) {
                        TransactionStateUtil.log.debug("Missing response body, using response message");
                        str = response.message();
                    }
                }
                end.setResponseBody(str);
                end.getParams().putAll(treeMap);
                response = setDistributedTraceHeaders(transactionState, response);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(end));
        }
        return response;
    }

    private static long exhaustiveContentLength(Response response) {
        long j11 = -1;
        if (response == null) {
            return -1;
        }
        if (response.body() != null) {
            try {
                j11 = response.body().contentLength();
            } catch (IOException e11) {
                AgentLog agentLog = TransactionStateUtil.log;
                String obj = e11.toString();
                agentLog.debug("Failed to parse content length: " + obj);
            }
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
                } catch (NumberFormatException e12) {
                    AgentLog agentLog2 = TransactionStateUtil.log;
                    String obj2 = e12.toString();
                    agentLog2.debug("Failed to parse content length: " + obj2);
                    return j11;
                }
            } else if (networkResponse.body() == null) {
                return j11;
            } else {
                try {
                    return networkResponse.body().contentLength();
                } catch (IOException e13) {
                    AgentLog agentLog3 = TransactionStateUtil.log;
                    String obj3 = e13.toString();
                    agentLog3.debug("Failed to parse network response content length: " + obj3);
                    e13.printStackTrace();
                    return j11;
                }
            }
        } else {
            try {
                return Long.parseLong(header);
            } catch (NumberFormatException e14) {
                AgentLog agentLog4 = TransactionStateUtil.log;
                String obj4 = e14.toString();
                agentLog4.debug("Failed to parse content length: " + obj4);
                return j11;
            }
        }
    }

    public static void inspectAndInstrument(TransactionState transactionState, Request request) {
        if (request == null) {
            TransactionStateUtil.log.debug("Missing request");
            return;
        }
        if (!transactionState.isSent()) {
            TransactionStateUtil.inspectAndInstrument(transactionState, request.urlString(), request.method());
        }
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
        String str = "";
        long j11 = 0;
        if (response == null) {
            TransactionStateUtil.log.debug("Missing response");
            i11 = 500;
        } else {
            Request request = response.request();
            if (!(request == null || request.url() == null)) {
                String url = request.url().toString();
                if (!url.isEmpty()) {
                    TransactionStateUtil.inspectAndInstrument(transactionState, url, request.method());
                }
            }
            i11 = -1;
            try {
                str = response.header(Constants.Network.APP_DATA_HEADER);
                i11 = response.code();
                j11 = exhaustiveContentLength(response);
            } catch (Exception unused) {
                TransactionStateUtil.log.debug("OkHttp2TransactionStateUtil: Missing body or content length");
            }
        }
        TransactionStateUtil.inspectAndInstrumentResponse(transactionState, str, (int) j11, i11);
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
                }
                TraceContext.reportSupportabilityMetrics();
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
                    for (TraceHeader next : trace.getHeaders()) {
                        newBuilder = newBuilder.header(next.getHeaderName(), next.getHeaderValue());
                    }
                }
                TraceContext.reportSupportabilityMetrics();
                return newBuilder.build();
            } catch (Exception e11) {
                TransactionStateUtil.log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e11);
                TraceContext.reportSupportabilityExceptionMetric(e11);
            }
        }
        return response;
    }
}
