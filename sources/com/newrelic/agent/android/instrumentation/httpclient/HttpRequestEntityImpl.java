package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

@Deprecated
public final class HttpRequestEntityImpl implements HttpEntity, StreamCompleteListener {
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpRequestEntityImpl(HttpEntity httpEntity, TransactionState transactionState2) {
        this.impl = httpEntity;
        this.transactionState = transactionState2;
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
        try {
            if (this.transactionState.isSent()) {
                return this.impl.getContent();
            }
            CountingInputStream countingInputStream = new CountingInputStream(this.impl.getContent());
            countingInputStream.addStreamCompleteListener(this);
            return countingInputStream;
        } catch (IOException e11) {
            handleException(e11);
            throw e11;
        } catch (IllegalStateException e12) {
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
        this.transactionState.setBytesSent(streamCompleteEvent.getBytes());
    }

    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        handleException(streamCompleteEvent.getException(), Long.valueOf(streamCompleteEvent.getBytes()));
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.transactionState.isSent()) {
                CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
                this.impl.writeTo(countingOutputStream);
                this.transactionState.setBytesSent(countingOutputStream.getCount());
                return;
            }
            this.impl.writeTo(outputStream);
        } catch (IOException e11) {
            handleException(e11);
            throw e11;
        }
    }

    public void handleException(Exception exc, Long l11) {
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, exc);
        if (!this.transactionState.isComplete()) {
            if (l11 != null) {
                this.transactionState.setBytesSent(l11.longValue());
            }
            TransactionData end = this.transactionState.end();
            if (end != null) {
                end.setResponseBody(exc.toString());
                TaskQueue.queue(new HttpTransactionMeasurement(end));
            }
        }
    }
}
