package com.newrelic.agent.android.instrumentation;

import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.instrumentation.httpclient.HttpRequestEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.ResponseHandlerImpl;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.text.MessageFormat;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

@Deprecated
public final class ApacheInstrumentation {
    protected static final AgentLog log = AgentLogManager.getAgentLog();

    private ApacheInstrumentation() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void addTransactionAndErrorData(com.newrelic.agent.android.instrumentation.TransactionState r6, org.apache.http.HttpResponse r7) {
        /*
            com.newrelic.agent.android.api.common.TransactionData r0 = r6.end()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r1 = r6.isErrorOrFailure()
            if (r1 == 0) goto L_0x00b2
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
            java.lang.String r2 = ""
            if (r7 == 0) goto L_0x0097
            org.apache.http.HttpEntity r3 = r7.getEntity()     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            if (r3 == 0) goto L_0x004b
            org.apache.http.HttpEntity r3 = r7.getEntity()     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            boolean r3 = r3 instanceof com.newrelic.agent.android.instrumentation.httpclient.HttpRequestEntityImpl     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            if (r3 != 0) goto L_0x0030
            com.newrelic.agent.android.instrumentation.httpclient.ContentBufferingResponseEntityImpl r3 = new com.newrelic.agent.android.instrumentation.httpclient.ContentBufferingResponseEntityImpl     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            org.apache.http.HttpEntity r4 = r7.getEntity()     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            r3.<init>(r4)     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            r7.setEntity(r3)     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
        L_0x0030:
            org.apache.http.HttpEntity r3 = r7.getEntity()     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            java.io.InputStream r3 = r3.getContent()     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            boolean r4 = r3 instanceof com.newrelic.agent.android.instrumentation.io.CountingInputStream     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            if (r4 == 0) goto L_0x0043
            com.newrelic.agent.android.instrumentation.io.CountingInputStream r3 = (com.newrelic.agent.android.instrumentation.io.CountingInputStream) r3     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            java.lang.String r3 = r3.getBufferAsString()     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            goto L_0x0069
        L_0x0043:
            com.newrelic.agent.android.logging.AgentLog r3 = log     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            java.lang.String r4 = "Unable to wrap content stream for entity"
            r3.error(r4)     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            goto L_0x0068
        L_0x004b:
            com.newrelic.agent.android.logging.AgentLog r3 = log     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            java.lang.String r4 = "null response entity. response-body will be reported empty"
            r3.debug(r4)     // Catch:{ IllegalStateException -> 0x005e, IOException -> 0x0053 }
            goto L_0x0068
        L_0x0053:
            r3 = move-exception
            com.newrelic.agent.android.logging.AgentLog r4 = log
            java.lang.String r3 = r3.toString()
            r4.error(r3)
            goto L_0x0068
        L_0x005e:
            r3 = move-exception
            com.newrelic.agent.android.logging.AgentLog r4 = log
            java.lang.String r3 = r3.toString()
            r4.error(r3)
        L_0x0068:
            r3 = r2
        L_0x0069:
            java.lang.String r4 = "Content-Type"
            org.apache.http.Header[] r7 = r7.getHeaders(r4)
            if (r7 == 0) goto L_0x0088
            int r4 = r7.length
            if (r4 <= 0) goto L_0x0088
            r4 = 0
            r5 = r7[r4]
            java.lang.String r5 = r5.getValue()
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0088
            r7 = r7[r4]
            java.lang.String r7 = r7.getValue()
            goto L_0x0089
        L_0x0088:
            r7 = 0
        L_0x0089:
            if (r7 == 0) goto L_0x0096
            int r2 = r7.length()
            if (r2 <= 0) goto L_0x0096
            java.lang.String r2 = "content_type"
            r1.put(r2, r7)
        L_0x0096:
            r2 = r3
        L_0x0097:
            long r6 = r6.getBytesReceived()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.String r7 = "content_length"
            r1.put(r7, r6)
            r0.setResponseBody(r2)
            r0.setParams(r1)
        L_0x00b2:
            com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement r6 = new com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement
            r6.<init>(r0)
            com.newrelic.agent.android.TaskQueue.queue(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.instrumentation.ApacheInstrumentation.addTransactionAndErrorData(com.newrelic.agent.android.instrumentation.TransactionState, org.apache.http.HttpResponse):void");
    }

    private static HttpUriRequest delegate(HttpUriRequest httpUriRequest, TransactionState transactionState) {
        return inspectAndInstrument(transactionState, httpUriRequest);
    }

    @ReplaceCallSite
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, httpRequest);
        }
        try {
            return delegate(FirebasePerfHttpClient.execute(httpClient, httpHost, delegate(httpHost, httpRequest, transactionState), httpContext), transactionState);
        } catch (IOException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        }
    }

    public static void httpClientError(TransactionState transactionState, Exception exc) {
        if (!transactionState.isComplete()) {
            TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
            TransactionData end = transactionState.end();
            if (end != null) {
                end.setResponseBody(exc.toString());
                TaskQueue.queue(new HttpTransactionMeasurement(end));
            }
        }
    }

    public static HttpRequest inspectAndInstrument(TransactionState transactionState, HttpHost httpHost, HttpRequest httpRequest) {
        RequestLine requestLine = httpRequest.getRequestLine();
        if (requestLine != null) {
            String uri = requestLine.getUri();
            boolean z11 = uri != null && uri.length() >= 10 && uri.substring(0, 10).indexOf("://") >= 0;
            if (!z11 && uri != null && httpHost != null) {
                String uri2 = httpHost.toURI();
                String str = "/";
                if (uri2.endsWith(str) || uri.startsWith(str)) {
                    str = "";
                }
                uri = uri2 + str + uri;
            } else if (!z11) {
                uri = null;
            }
            TransactionStateUtil.inspectAndInstrument(transactionState, uri, requestLine.getMethod());
        }
        setCrossProcessHeader(httpRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, httpRequest);
        }
        if (transactionState.getUrl() == null || transactionState.getHttpMethod() == null) {
            try {
                throw new Exception("TransactionData constructor was not provided with a valid URL, host or HTTP method");
            } catch (Exception e11) {
                log.error(MessageFormat.format("TransactionStateUtil.inspectAndInstrument(...) for {0} could not determine request URL or HTTP method [host={1}, requestLine={2}]", new Object[]{httpRequest.getClass().getCanonicalName(), httpHost, requestLine}), e11);
                return httpRequest;
            }
        } else {
            wrapRequestEntity(transactionState, httpRequest);
            return httpRequest;
        }
    }

    private static void setCrossProcessHeader(HttpRequest httpRequest) {
        String crossProcessId = Agent.getCrossProcessId();
        if (crossProcessId != null) {
            TraceMachine.setCurrentTraceParam("cross_process_data", crossProcessId);
            httpRequest.setHeader(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId);
        }
    }

    public static void setDistributedTraceHeaders(TransactionState transactionState, HttpRequest httpRequest) {
        if (transactionState.getTrace() != null) {
            try {
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    for (TraceHeader next : trace.getHeaders()) {
                        httpRequest.setHeader(next.getHeaderName(), next.getHeaderValue());
                    }
                    TraceContext.reportSupportabilityMetrics();
                }
            } catch (Exception e11) {
                log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e11);
                TraceContext.reportSupportabilityExceptionMetric(e11);
            }
        }
    }

    private static void wrapRequestEntity(TransactionState transactionState, HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            if (httpEntityEnclosingRequest.getEntity() != null) {
                httpEntityEnclosingRequest.setEntity(new HttpRequestEntityImpl(httpEntityEnclosingRequest.getEntity(), transactionState));
            }
        }
    }

    private static HttpRequest delegate(HttpHost httpHost, HttpRequest httpRequest, TransactionState transactionState) {
        return inspectAndInstrument(transactionState, httpHost, httpRequest);
    }

    private static HttpResponse delegate(HttpResponse httpResponse, TransactionState transactionState) {
        return inspectAndInstrument(transactionState, httpResponse);
    }

    private static <T> ResponseHandler<? extends T> delegate(ResponseHandler<? extends T> responseHandler, TransactionState transactionState) {
        return ResponseHandlerImpl.wrap(responseHandler, transactionState);
    }

    public static void setDistributedTraceHeaders(TransactionState transactionState, HttpResponse httpResponse) {
        if (transactionState.getTrace() != null) {
            try {
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    for (TraceHeader next : trace.getHeaders()) {
                        if (!httpResponse.containsHeader(next.getHeaderName())) {
                            httpResponse.setHeader(next.getHeaderName(), next.getHeaderValue());
                        }
                    }
                }
            } catch (Exception e11) {
                log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e11);
                TraceContext.reportSupportabilityExceptionMetric(e11);
            }
        }
    }

    @ReplaceCallSite
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, httpRequest);
        }
        try {
            return FirebasePerfHttpClient.execute(httpClient, httpHost, delegate(httpHost, httpRequest, transactionState), delegate(responseHandler, transactionState), httpContext);
        } catch (ClientProtocolException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        } catch (IOException e12) {
            httpClientError(transactionState, e12);
            throw e12;
        }
    }

    public static HttpUriRequest inspectAndInstrument(TransactionState transactionState, HttpUriRequest httpUriRequest) {
        setCrossProcessHeader(httpUriRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, (HttpRequest) httpUriRequest);
        }
        TransactionStateUtil.inspectAndInstrument(transactionState, httpUriRequest.getURI().toString(), httpUriRequest.getMethod());
        wrapRequestEntity(transactionState, httpUriRequest);
        return httpUriRequest;
    }

    @ReplaceCallSite
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, httpRequest);
        }
        try {
            return FirebasePerfHttpClient.execute(httpClient, httpHost, delegate(httpHost, httpRequest, transactionState), delegate(responseHandler, transactionState));
        } catch (ClientProtocolException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        } catch (IOException e12) {
            httpClientError(transactionState, e12);
            throw e12;
        }
    }

    public static HttpResponse inspectAndInstrument(TransactionState transactionState, HttpResponse httpResponse) {
        transactionState.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        Header[] headers = httpResponse.getHeaders(Constants.Network.APP_DATA_HEADER);
        if (headers != null && headers.length > 0 && !"".equals(headers[0].getValue())) {
            transactionState.setAppData(headers[0].getValue());
        }
        Header[] headers2 = httpResponse.getHeaders("Content-Length");
        if (headers2 != null && headers2.length > 0) {
            try {
                transactionState.setBytesReceived(Long.parseLong(headers2[0].getValue()));
                addTransactionAndErrorData(transactionState, httpResponse);
            } catch (NumberFormatException e11) {
                AgentLog agentLog = log;
                agentLog.warn("Failed to parse content length: " + e11);
            }
        } else if (httpResponse.getEntity() != null) {
            httpResponse.setEntity(new HttpResponseEntityImpl(httpResponse.getEntity(), transactionState, -1));
        } else {
            transactionState.setBytesReceived(0);
            addTransactionAndErrorData(transactionState, (HttpResponse) null);
        }
        setDistributedTraceHeaders(transactionState, httpResponse);
        return httpResponse;
    }

    @ReplaceCallSite
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, httpRequest);
        }
        try {
            return delegate(FirebasePerfHttpClient.execute(httpClient, httpHost, delegate(httpHost, httpRequest, transactionState)), transactionState);
        } catch (IOException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        }
    }

    @ReplaceCallSite
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpUriRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, (HttpRequest) httpUriRequest);
        }
        try {
            return delegate(FirebasePerfHttpClient.execute(httpClient, delegate(httpUriRequest, transactionState), httpContext), transactionState);
        } catch (IOException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        }
    }

    @ReplaceCallSite
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpUriRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, (HttpRequest) httpUriRequest);
        }
        try {
            return FirebasePerfHttpClient.execute(httpClient, delegate(httpUriRequest, transactionState), delegate(responseHandler, transactionState), httpContext);
        } catch (ClientProtocolException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        } catch (IOException e12) {
            httpClientError(transactionState, e12);
            throw e12;
        }
    }

    @ReplaceCallSite
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpUriRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, (HttpRequest) httpUriRequest);
        }
        try {
            return FirebasePerfHttpClient.execute(httpClient, delegate(httpUriRequest, transactionState), delegate(responseHandler, transactionState));
        } catch (ClientProtocolException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        } catch (IOException e12) {
            httpClientError(transactionState, e12);
            throw e12;
        }
    }

    @ReplaceCallSite
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        TransactionState transactionState = new TransactionState();
        setCrossProcessHeader(httpUriRequest);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TransactionStateUtil.setTrace(transactionState);
            setDistributedTraceHeaders(transactionState, (HttpRequest) httpUriRequest);
        }
        try {
            return delegate(FirebasePerfHttpClient.execute(httpClient, delegate(httpUriRequest, transactionState)), transactionState);
        } catch (IOException e11) {
            httpClientError(transactionState, e11);
            throw e11;
        }
    }
}
