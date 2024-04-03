package com.bumptech.glide.util;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class ExceptionPassthroughInputStream extends InputStream {
    @GuardedBy("POOL")
    private static final Queue<ExceptionPassthroughInputStream> POOL = Util.createQueue(0);
    private IOException exception;
    private InputStream wrapped;

    public static void clearQueue() {
        synchronized (POOL) {
            while (true) {
                Queue<ExceptionPassthroughInputStream> queue = POOL;
                if (!queue.isEmpty()) {
                    queue.remove();
                }
            }
        }
    }

    @NonNull
    public static ExceptionPassthroughInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionPassthroughInputStream poll;
        Queue<ExceptionPassthroughInputStream> queue = POOL;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionPassthroughInputStream();
        }
        poll.setInputStream(inputStream);
        return poll;
    }

    public int available() throws IOException {
        return this.wrapped.available();
    }

    public void close() throws IOException {
        this.wrapped.close();
    }

    @Nullable
    public IOException getException() {
        return this.exception;
    }

    public void mark(int i11) {
        this.wrapped.mark(i11);
    }

    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    public int read() throws IOException {
        try {
            return this.wrapped.read();
        } catch (IOException e11) {
            this.exception = e11;
            throw e11;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionPassthroughInputStream> queue = POOL;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.wrapped.reset();
    }

    public void setInputStream(@NonNull InputStream inputStream) {
        this.wrapped = inputStream;
    }

    public long skip(long j11) throws IOException {
        try {
            return this.wrapped.skip(j11);
        } catch (IOException e11) {
            this.exception = e11;
            throw e11;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.wrapped.read(bArr);
        } catch (IOException e11) {
            this.exception = e11;
            throw e11;
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        try {
            return this.wrapped.read(bArr, i11, i12);
        } catch (IOException e11) {
            this.exception = e11;
            throw e11;
        }
    }
}
