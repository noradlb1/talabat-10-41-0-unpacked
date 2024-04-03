package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

@Deprecated
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> QUEUE = Util.createQueue(0);
    private IOException exception;
    private InputStream wrapped;

    public static void clearQueue() {
        while (true) {
            Queue<ExceptionCatchingInputStream> queue = QUEUE;
            if (!queue.isEmpty()) {
                queue.remove();
            } else {
                return;
            }
        }
    }

    @NonNull
    public static ExceptionCatchingInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = QUEUE;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
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

    public int read(byte[] bArr) {
        try {
            return this.wrapped.read(bArr);
        } catch (IOException e11) {
            this.exception = e11;
            return -1;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionCatchingInputStream> queue = QUEUE;
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

    public long skip(long j11) {
        try {
            return this.wrapped.skip(j11);
        } catch (IOException e11) {
            this.exception = e11;
            return 0;
        }
    }

    public int read(byte[] bArr, int i11, int i12) {
        try {
            return this.wrapped.read(bArr, i11, i12);
        } catch (IOException e11) {
            this.exception = e11;
            return -1;
        }
    }

    public int read() {
        try {
            return this.wrapped.read();
        } catch (IOException e11) {
            this.exception = e11;
            return -1;
        }
    }
}
