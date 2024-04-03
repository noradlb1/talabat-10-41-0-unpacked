package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpURLConnectionExtension extends HttpURLConnection {
    /* access modifiers changed from: private */
    public static final AgentLog log = AgentLogManager.getAgentLog();
    private CountingInputStream errorStream = null;
    /* access modifiers changed from: private */
    public final HttpURLConnection impl;
    private TransactionState transactionState;

    public HttpURLConnectionExtension(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.impl = httpURLConnection;
        this.transactionState = getTransactionState();
        TransactionStateUtil.setCrossProcessHeader(httpURLConnection);
        TransactionStateUtil.setTrace(this.transactionState);
        TransactionStateUtil.setDistributedTraceHeaders(this.transactionState, httpURLConnection);
    }

    private void checkResponse() {
        if (!getTransactionState().isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), this.impl);
        }
    }

    public void addRequestProperty(String str, String str2) {
        this.impl.addRequestProperty(str, str2);
        TransactionStateUtil.addHeadersAsCustomAttribute(this.transactionState, str, str2);
    }

    public void addTransactionAndErrorData(TransactionState transactionState2) {
        String str;
        String contentType;
        TransactionData end = transactionState2.end();
        if (end != null) {
            if (transactionState2.isErrorOrFailure()) {
                try {
                    InputStream errorStream2 = getErrorStream();
                    if (errorStream2 instanceof CountingInputStream) {
                        str = ((CountingInputStream) errorStream2).getBufferAsString();
                        TreeMap treeMap = new TreeMap();
                        contentType = this.impl.getContentType();
                        if (contentType != null && !"".equals(contentType)) {
                            treeMap.put("content_type", contentType);
                        }
                        long bytesReceived = transactionState2.getBytesReceived();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(bytesReceived);
                        treeMap.put(Constants.Transactions.CONTENT_LENGTH, sb2.toString());
                        end.setResponseBody(str);
                        end.getParams().putAll(treeMap);
                    }
                } catch (Exception e11) {
                    AgentLog agentLog = log;
                    agentLog.error("HttpURLConnectionExtension.addTransactionAndErrorData: " + e11);
                }
                str = "";
                TreeMap treeMap2 = new TreeMap();
                contentType = this.impl.getContentType();
                treeMap2.put("content_type", contentType);
                long bytesReceived2 = transactionState2.getBytesReceived();
                StringBuilder sb22 = new StringBuilder();
                sb22.append(bytesReceived2);
                treeMap2.put(Constants.Transactions.CONTENT_LENGTH, sb22.toString());
                end.setResponseBody(str);
                end.getParams().putAll(treeMap2);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(end));
        }
    }

    public void connect() throws IOException {
        getTransactionState();
        try {
            this.impl.connect();
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public void disconnect() {
        TransactionState transactionState2 = this.transactionState;
        if (transactionState2 != null && !transactionState2.isComplete()) {
            addTransactionAndErrorData(this.transactionState);
        }
        this.impl.disconnect();
    }

    public void error(Exception exc) {
        TransactionState transactionState2 = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(transactionState2, exc);
        if (!transactionState2.isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(transactionState2, this.impl);
            TransactionData end = transactionState2.end();
            if (end != null) {
                String obj = exc.toString();
                try {
                    InputStream errorStream2 = getErrorStream();
                    if (errorStream2 != null && (errorStream2 instanceof CountingInputStream)) {
                        obj = ((CountingInputStream) errorStream2).getBufferAsString();
                    }
                } catch (Exception e11) {
                    AgentLog agentLog = log;
                    agentLog.error("HttpsURLConnectionExtension.error: " + e11);
                }
                end.setResponseBody(obj);
                TaskQueue.queue(new HttpTransactionMeasurement(end));
            }
        }
    }

    public boolean getAllowUserInteraction() {
        return this.impl.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.impl.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        getTransactionState();
        try {
            Object content = this.impl.getContent();
            int contentLength = this.impl.getContentLength();
            if (contentLength >= 0) {
                TransactionState transactionState2 = getTransactionState();
                if (!transactionState2.isComplete()) {
                    transactionState2.setBytesReceived((long) contentLength);
                    addTransactionAndErrorData(transactionState2);
                }
            }
            return content;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public String getContentEncoding() {
        getTransactionState();
        String contentEncoding = this.impl.getContentEncoding();
        checkResponse();
        return contentEncoding;
    }

    public int getContentLength() {
        getTransactionState();
        int contentLength = this.impl.getContentLength();
        checkResponse();
        return contentLength;
    }

    public String getContentType() {
        getTransactionState();
        String contentType = this.impl.getContentType();
        checkResponse();
        return contentType;
    }

    public long getDate() {
        getTransactionState();
        long date = this.impl.getDate();
        checkResponse();
        return date;
    }

    public boolean getDefaultUseCaches() {
        return this.impl.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.impl.getDoInput();
    }

    public boolean getDoOutput() {
        return this.impl.getDoOutput();
    }

    public InputStream getErrorStream() {
        getTransactionState();
        try {
            CountingInputStream countingInputStream = this.errorStream;
            if (countingInputStream == null || countingInputStream.available() == 0) {
                this.errorStream = new CountingInputStream(this.impl.getErrorStream(), true);
            }
            return this.errorStream;
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("HttpsURLConnectionExtension: " + e11);
            return this.impl.getErrorStream();
        }
    }

    public long getExpiration() {
        getTransactionState();
        long expiration = this.impl.getExpiration();
        checkResponse();
        return expiration;
    }

    public String getHeaderField(int i11) {
        getTransactionState();
        String headerField = this.impl.getHeaderField(i11);
        checkResponse();
        return headerField;
    }

    public long getHeaderFieldDate(String str, long j11) {
        getTransactionState();
        long headerFieldDate = this.impl.getHeaderFieldDate(str, j11);
        checkResponse();
        return headerFieldDate;
    }

    public int getHeaderFieldInt(String str, int i11) {
        getTransactionState();
        int headerFieldInt = this.impl.getHeaderFieldInt(str, i11);
        checkResponse();
        return headerFieldInt;
    }

    public String getHeaderFieldKey(int i11) {
        getTransactionState();
        String headerFieldKey = this.impl.getHeaderFieldKey(i11);
        checkResponse();
        return headerFieldKey;
    }

    public Map<String, List<String>> getHeaderFields() {
        getTransactionState();
        Map<String, List<String>> headerFields = this.impl.getHeaderFields();
        checkResponse();
        return headerFields;
    }

    public long getIfModifiedSince() {
        getTransactionState();
        long ifModifiedSince = this.impl.getIfModifiedSince();
        checkResponse();
        return ifModifiedSince;
    }

    public InputStream getInputStream() throws IOException {
        final TransactionState transactionState2 = getTransactionState();
        try {
            CountingInputStream countingInputStream = new CountingInputStream(this.impl.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(transactionState2, this.impl);
            countingInputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!transactionState2.isComplete()) {
                        try {
                            transactionState2.setStatusCode(HttpURLConnectionExtension.this.impl.getResponseCode());
                        } catch (IOException unused) {
                            AgentLog b11 = HttpURLConnectionExtension.log;
                            b11.error("HttpURLConnectionExtension.getInputStream.streamComplete: " + streamCompleteEvent);
                        }
                        long contentLength = (long) HttpURLConnectionExtension.this.impl.getContentLength();
                        long bytes = streamCompleteEvent.getBytes();
                        if (contentLength < 0) {
                            contentLength = bytes;
                        }
                        transactionState2.setBytesReceived(contentLength);
                        HttpURLConnectionExtension.this.addTransactionAndErrorData(transactionState2);
                    }
                }

                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!transactionState2.isComplete()) {
                        transactionState2.setBytesReceived(streamCompleteEvent.getBytes());
                    }
                    HttpURLConnectionExtension.this.error(streamCompleteEvent.getException());
                }
            });
            return countingInputStream;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public boolean getInstanceFollowRedirects() {
        return this.impl.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        getTransactionState();
        long lastModified = this.impl.getLastModified();
        checkResponse();
        return lastModified;
    }

    public OutputStream getOutputStream() throws IOException {
        final TransactionState transactionState2 = getTransactionState();
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(this.impl.getOutputStream());
            countingOutputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!transactionState2.isComplete()) {
                        try {
                            transactionState2.setStatusCode(HttpURLConnectionExtension.this.impl.getResponseCode());
                        } catch (IOException unused) {
                            AgentLog b11 = HttpURLConnectionExtension.log;
                            b11.error("HttpURLConnectionExtension.getOutputStream.streamComplete: " + streamCompleteEvent);
                        }
                        String requestProperty = HttpURLConnectionExtension.this.impl.getRequestProperty("Content-Length");
                        long bytes = streamCompleteEvent.getBytes();
                        if (requestProperty != null) {
                            try {
                                bytes = Long.parseLong(requestProperty);
                            } catch (NumberFormatException e11) {
                                e11.printStackTrace();
                            }
                        }
                        transactionState2.setBytesSent(bytes);
                        HttpURLConnectionExtension.this.addTransactionAndErrorData(transactionState2);
                    }
                }

                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!transactionState2.isComplete()) {
                        transactionState2.setBytesSent(streamCompleteEvent.getBytes());
                    }
                    HttpURLConnectionExtension.this.error(streamCompleteEvent.getException());
                }
            });
            return countingOutputStream;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public Permission getPermission() throws IOException {
        return this.impl.getPermission();
    }

    public int getReadTimeout() {
        return this.impl.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.impl.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.impl.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.impl.getRequestProperty(str);
    }

    public int getResponseCode() throws IOException {
        getTransactionState();
        try {
            int responseCode = this.impl.getResponseCode();
            checkResponse();
            return responseCode;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public String getResponseMessage() throws IOException {
        getTransactionState();
        try {
            String responseMessage = this.impl.getResponseMessage();
            checkResponse();
            return responseMessage;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public TransactionState getTransactionState() {
        if (this.transactionState == null) {
            TransactionState transactionState2 = new TransactionState();
            this.transactionState = transactionState2;
            TransactionStateUtil.inspectAndInstrument(transactionState2, this.impl);
        }
        return this.transactionState;
    }

    public URL getURL() {
        return this.impl.getURL();
    }

    public boolean getUseCaches() {
        return this.impl.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z11) {
        this.impl.setAllowUserInteraction(z11);
    }

    public void setChunkedStreamingMode(int i11) {
        this.impl.setChunkedStreamingMode(i11);
    }

    public void setConnectTimeout(int i11) {
        this.impl.setConnectTimeout(i11);
    }

    public void setDefaultUseCaches(boolean z11) {
        this.impl.setDefaultUseCaches(z11);
    }

    public void setDoInput(boolean z11) {
        this.impl.setDoInput(z11);
    }

    public void setDoOutput(boolean z11) {
        this.impl.setDoOutput(z11);
    }

    public void setFixedLengthStreamingMode(int i11) {
        this.impl.setFixedLengthStreamingMode(i11);
    }

    public void setIfModifiedSince(long j11) {
        this.impl.setIfModifiedSince(j11);
    }

    public void setInstanceFollowRedirects(boolean z11) {
        this.impl.setInstanceFollowRedirects(z11);
    }

    public void setReadTimeout(int i11) {
        this.impl.setReadTimeout(i11);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        getTransactionState();
        try {
            this.impl.setRequestMethod(str);
        } catch (ProtocolException e11) {
            error(e11);
            throw e11;
        }
    }

    public void setRequestProperty(String str, String str2) {
        this.impl.setRequestProperty(str, str2);
        TransactionStateUtil.addHeadersAsCustomAttribute(this.transactionState, str, str2);
    }

    public void setUseCaches(boolean z11) {
        this.impl.setUseCaches(z11);
    }

    public String toString() {
        return this.impl.toString();
    }

    public boolean usingProxy() {
        return this.impl.usingProxy();
    }

    public String getHeaderField(String str) {
        getTransactionState();
        String headerField = this.impl.getHeaderField(str);
        checkResponse();
        return headerField;
    }

    public Object getContent(Class[] clsArr) throws IOException {
        getTransactionState();
        try {
            Object content = this.impl.getContent(clsArr);
            checkResponse();
            return content;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }
}
