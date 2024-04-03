package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

public class RetrofitTransactionStateUtil extends TransactionStateUtil {
    public static void addTransactionAndErrorData(TransactionState transactionState, Response response) {
        TransactionData end = transactionState.end();
        if (end != null) {
            if (transactionState.isErrorOrFailure()) {
                String appDataHeader = getAppDataHeader(response.getHeaders(), "Content-Type");
                TreeMap treeMap = new TreeMap();
                if (appDataHeader != null && appDataHeader.length() > 0 && !"".equals(appDataHeader)) {
                    treeMap.put("content_type", appDataHeader);
                }
                long bytesReceived = transactionState.getBytesReceived();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(bytesReceived);
                treeMap.put(Constants.Transactions.CONTENT_LENGTH, sb2.toString());
                end.setParams(treeMap);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(end));
            setDistributedTraceHeaders(transactionState, response);
        }
    }

    private static String getAppDataHeader(List<Header> list, String str) {
        if (list == null) {
            return null;
        }
        for (Header next : list) {
            if (next.getName() != null && next.getName().equalsIgnoreCase(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public static void inspectAndInstrument(TransactionState transactionState, Request request) {
        transactionState.setUrl(request.getUrl());
        transactionState.setHttpMethod(request.getMethod());
        transactionState.setCarrier(Agent.getActiveNetworkCarrier());
        transactionState.setWanType(Agent.getActiveNetworkWanType());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, Response response) {
        String appDataHeader = getAppDataHeader(response.getHeaders(), Constants.Network.APP_DATA_HEADER);
        if (appDataHeader != null && !"".equals(appDataHeader)) {
            transactionState.setAppData(appDataHeader);
        }
        transactionState.setStatusCode(response.getStatus());
        long length = response.getBody().length();
        if (length >= 0) {
            transactionState.setBytesReceived(length);
        }
        addTransactionAndErrorData(transactionState, response);
    }

    public static Request setDistributedTraceHeaders(TransactionState transactionState, Request request) {
        ArrayList arrayList = new ArrayList(request.getHeaders());
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TraceContext startTrace = DistributedTracing.getInstance().startTrace(transactionState);
            transactionState.setTrace(startTrace);
            if (startTrace != null) {
                try {
                    for (TraceHeader next : startTrace.getHeaders()) {
                        arrayList.add(new Header(next.getHeaderName(), next.getHeaderValue()));
                    }
                } catch (Exception e11) {
                    TraceContext.reportSupportabilityExceptionMetric(e11);
                }
            }
            TraceContext.reportSupportabilityMetrics();
            return new Request(request.getMethod(), request.getUrl(), arrayList, request.getBody());
        }
        return request;
    }

    public static Response setDistributedTraceHeaders(TransactionState transactionState, Response response) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            ArrayList arrayList = new ArrayList(response.getHeaders());
            TraceContext startTrace = DistributedTracing.getInstance().startTrace(transactionState);
            transactionState.setTrace(startTrace);
            if (startTrace != null) {
                try {
                    for (TraceHeader next : startTrace.getHeaders()) {
                        arrayList.add(new Header(next.getHeaderName(), next.getHeaderValue()));
                    }
                } catch (Exception e11) {
                    TraceContext.reportSupportabilityExceptionMetric(e11);
                }
            }
            return new Response(response.getUrl(), response.getStatus(), response.getReason(), arrayList, response.getBody());
        }
        return response;
    }
}
