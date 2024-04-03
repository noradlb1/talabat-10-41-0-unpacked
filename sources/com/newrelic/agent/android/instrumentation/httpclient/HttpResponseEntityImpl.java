package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

@Deprecated
public final class HttpResponseEntityImpl implements HttpEntity, StreamCompleteListener {
    private static final String ENCODING_CHUNKED = "chunked";
    private static final String TRANSFER_ENCODING_HEADER = "Transfer-Encoding";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final long contentLengthFromHeader;
    private CountingInputStream contentStream;
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpResponseEntityImpl(HttpEntity httpEntity, TransactionState transactionState2, long j11) {
        this.impl = httpEntity;
        this.transactionState = transactionState2;
        this.contentLengthFromHeader = j11;
    }

    private void addTransactionAndErrorData(TransactionState transactionState2) {
        String str;
        Header contentType;
        TransactionData end = transactionState2.end();
        if (end != null) {
            if (transactionState2.isErrorOrFailure()) {
                try {
                    InputStream content = getContent();
                    if (content instanceof CountingInputStream) {
                        str = ((CountingInputStream) content).getBufferAsString();
                        contentType = this.impl.getContentType();
                        TreeMap treeMap = new TreeMap();
                        if (!(contentType == null || contentType.getValue() == null || "".equals(contentType.getValue()))) {
                            treeMap.put("content_type", contentType.getValue());
                        }
                        long bytesReceived = transactionState2.getBytesReceived();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(bytesReceived);
                        treeMap.put(Constants.Transactions.CONTENT_LENGTH, sb2.toString());
                        end.setResponseBody(str);
                        end.setParams(treeMap);
                    }
                } catch (Exception e11) {
                    AgentLog agentLog = log;
                    agentLog.error("HttpResponseEntityImpl: " + e11);
                }
                str = "";
                contentType = this.impl.getContentType();
                TreeMap treeMap2 = new TreeMap();
                treeMap2.put("content_type", contentType.getValue());
                long bytesReceived2 = transactionState2.getBytesReceived();
                StringBuilder sb22 = new StringBuilder();
                sb22.append(bytesReceived2);
                treeMap2.put(Constants.Transactions.CONTENT_LENGTH, sb22.toString());
                end.setResponseBody(str);
                end.setParams(treeMap2);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(end));
        }
    }

    public void consumeContent() throws IOException {
        try {
            this.impl.consumeContent();
        } catch (IOException e11) {
            handleException(e11);
            throw e11;
        }
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        CountingInputStream countingInputStream = this.contentStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        try {
            AbstractHttpMessage abstractHttpMessage = this.impl;
            boolean z11 = true;
            if (abstractHttpMessage instanceof AbstractHttpMessage) {
                Header lastHeader = abstractHttpMessage.getLastHeader("Transfer-Encoding");
                if (lastHeader != null && ENCODING_CHUNKED.equalsIgnoreCase(lastHeader.getValue())) {
                    z11 = false;
                }
            } else if (abstractHttpMessage instanceof HttpEntityWrapper) {
                z11 = true ^ ((HttpEntityWrapper) abstractHttpMessage).isChunked();
            }
            try {
                CountingInputStream countingInputStream2 = new CountingInputStream(this.impl.getContent(), z11);
                this.contentStream = countingInputStream2;
                countingInputStream2.addStreamCompleteListener(this);
            } catch (IllegalArgumentException e11) {
                log.error("HttpResponseEntityImpl: " + e11.toString());
            }
            return this.contentStream;
        } catch (IOException e12) {
            handleException(e12);
            throw e12;
        }
    }

    public Header getContentEncoding() {
        return this.impl.getContentEncoding();
    }

    public long getContentLength() {
        return this.impl.getContentLength();
    }

    public Header getContentType() {
        return this.impl.getContentType();
    }

    public void handleException(Exception exc) {
        handleException(exc, (Long) null);
    }

    public boolean isChunked() {
        return this.impl.isChunked();
    }

    public boolean isRepeatable() {
        return this.impl.isRepeatable();
    }

    public boolean isStreaming() {
        return this.impl.isStreaming();
    }

    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        if (!this.transactionState.isComplete()) {
            long j11 = this.contentLengthFromHeader;
            if (j11 >= 0) {
                this.transactionState.setBytesReceived(j11);
            } else {
                this.transactionState.setBytesReceived(streamCompleteEvent.getBytes());
            }
            addTransactionAndErrorData(this.transactionState);
        }
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, streamCompleteEvent.getException());
        if (!this.transactionState.isComplete()) {
            this.transactionState.setBytesReceived(streamCompleteEvent.getBytes());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(java.io.OutputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            com.newrelic.agent.android.instrumentation.TransactionState r0 = r6.transactionState
            boolean r0 = r0.isComplete()
            if (r0 != 0) goto L_0x004a
            r0 = 0
            com.newrelic.agent.android.instrumentation.io.CountingOutputStream r1 = new com.newrelic.agent.android.instrumentation.io.CountingOutputStream     // Catch:{ IOException -> 0x003b }
            r1.<init>(r7)     // Catch:{ IOException -> 0x003b }
            org.apache.http.HttpEntity r7 = r6.impl     // Catch:{ IOException -> 0x0038 }
            r7.writeTo(r1)     // Catch:{ IOException -> 0x0038 }
            com.newrelic.agent.android.instrumentation.TransactionState r7 = r6.transactionState
            boolean r7 = r7.isComplete()
            if (r7 != 0) goto L_0x004f
            long r2 = r6.contentLengthFromHeader
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0029
            com.newrelic.agent.android.instrumentation.TransactionState r7 = r6.transactionState
            r7.setBytesReceived(r2)
            goto L_0x0032
        L_0x0029:
            com.newrelic.agent.android.instrumentation.TransactionState r7 = r6.transactionState
            long r0 = r1.getCount()
            r7.setBytesReceived(r0)
        L_0x0032:
            com.newrelic.agent.android.instrumentation.TransactionState r7 = r6.transactionState
            r6.addTransactionAndErrorData(r7)
            goto L_0x004f
        L_0x0038:
            r7 = move-exception
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r7 = move-exception
        L_0x003c:
            if (r0 == 0) goto L_0x0049
            long r0 = r0.getCount()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r6.handleException(r7, r0)
        L_0x0049:
            throw r7
        L_0x004a:
            org.apache.http.HttpEntity r0 = r6.impl
            r0.writeTo(r7)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.instrumentation.httpclient.HttpResponseEntityImpl.writeTo(java.io.OutputStream):void");
    }

    public void handleException(Exception exc, Long l11) {
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, exc);
        if (!this.transactionState.isComplete()) {
            if (l11 != null) {
                this.transactionState.setBytesReceived(l11.longValue());
            }
            TransactionData end = this.transactionState.end();
            if (end != null) {
                end.setResponseBody(exc.toString());
                TaskQueue.queue(new HttpTransactionMeasurement(end));
            }
        }
    }
}
