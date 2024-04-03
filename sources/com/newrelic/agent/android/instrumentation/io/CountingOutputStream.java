package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private long count = 0;
    private final OutputStream impl;
    private final StreamCompleteListenerManager listenerManager = new StreamCompleteListenerManager();

    public CountingOutputStream(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            this.impl = outputStream;
            return;
        }
        throw new IOException("CountingOutputStream: output stream cannot be null");
    }

    private void notifyStreamComplete() {
        if (!this.listenerManager.isComplete()) {
            this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
        }
    }

    private void notifyStreamError(Exception exc) {
        if (!this.listenerManager.isComplete()) {
            this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, exc));
        }
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.addStreamCompleteListener(streamCompleteListener);
    }

    public void close() throws IOException {
        try {
            this.impl.close();
            notifyStreamComplete();
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        } catch (Exception e12) {
            log.warn(e12.toString());
        }
    }

    public void flush() throws IOException {
        try {
            this.impl.flush();
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }

    public long getCount() {
        return this.count;
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.removeStreamCompleteListener(streamCompleteListener);
    }

    public void write(int i11) throws IOException {
        try {
            this.impl.write(i11);
            this.count++;
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.impl.write(bArr);
            this.count += (long) bArr.length;
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        try {
            this.impl.write(bArr, i11, i12);
            this.count += (long) i12;
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }
}
