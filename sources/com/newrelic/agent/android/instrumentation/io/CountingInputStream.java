package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class CountingInputStream extends InputStream implements StreamCompleteListenerSource {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ByteBuffer buffer;
    private long count;
    private final boolean enableBuffering;
    private final InputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    public CountingInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private boolean bufferEmpty() {
        return !this.buffer.hasRemaining();
    }

    private boolean bufferHasBytes(long j11) {
        return ((long) this.buffer.remaining()) >= j11;
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

    private int readBuffer() {
        if (bufferEmpty()) {
            return -1;
        }
        return this.buffer.get();
    }

    private int readBufferBytes(byte[] bArr) {
        return readBufferBytes(bArr, 0, bArr.length);
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.addStreamCompleteListener(streamCompleteListener);
    }

    public int available() throws IOException {
        int i11;
        if (this.enableBuffering) {
            i11 = this.buffer.remaining();
        } else {
            i11 = 0;
        }
        try {
            return i11 + this.impl.available();
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }

    public void close() throws IOException {
        try {
            this.impl.close();
            notifyStreamComplete();
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        } catch (Exception e12) {
            log.error(e12.getLocalizedMessage());
        }
    }

    public void fillBuffer() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null && byteBuffer.hasArray()) {
            synchronized (this.buffer) {
                int i11 = 0;
                while (true) {
                    try {
                        if (i11 >= this.buffer.capacity()) {
                            break;
                        }
                        int read = this.impl.read(this.buffer.array(), i11, this.buffer.capacity() - i11);
                        if (read <= 0) {
                            break;
                        }
                        i11 += read;
                    } catch (NoSuchMethodError e11) {
                        log.error(e11.toString());
                        try {
                            this.buffer.limit(i11);
                        } catch (NoSuchMethodError e12) {
                            log.error(e12.toString());
                            try {
                                this.buffer = ByteBuffer.wrap(this.buffer.array(), 0, i11);
                            } catch (IndexOutOfBoundsException e13) {
                                log.error(e13.toString());
                            }
                        }
                    } catch (Exception e14) {
                        log.error(e14.getLocalizedMessage());
                    }
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.limit(i11);
            }
        }
    }

    public String getBufferAsString() {
        String str;
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return "";
        }
        synchronized (byteBuffer) {
            byte[] bArr = new byte[this.buffer.limit()];
            for (int i11 = 0; i11 < this.buffer.limit(); i11++) {
                bArr[i11] = this.buffer.get(i11);
            }
            str = new String(bArr);
        }
        return str;
    }

    public void mark(int i11) {
        if (markSupported()) {
            this.impl.mark(i11);
        }
    }

    public boolean markSupported() {
        return this.impl.markSupported();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.enableBuffering
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.nio.ByteBuffer r0 = r6.buffer
            monitor-enter(r0)
            boolean r3 = r6.bufferHasBytes(r1)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            int r3 = r6.readBuffer()     // Catch:{ all -> 0x001e }
            if (r3 < 0) goto L_0x001a
            long r4 = r6.count     // Catch:{ all -> 0x001e }
            long r4 = r4 + r1
            r6.count = r4     // Catch:{ all -> 0x001e }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r3
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            goto L_0x0021
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        L_0x0021:
            java.io.InputStream r0 = r6.impl     // Catch:{ IOException -> 0x0033 }
            int r0 = r0.read()     // Catch:{ IOException -> 0x0033 }
            if (r0 < 0) goto L_0x002f
            long r3 = r6.count     // Catch:{ IOException -> 0x0033 }
            long r3 = r3 + r1
            r6.count = r3     // Catch:{ IOException -> 0x0033 }
            goto L_0x0032
        L_0x002f:
            r6.notifyStreamComplete()     // Catch:{ IOException -> 0x0033 }
        L_0x0032:
            return r0
        L_0x0033:
            r0 = move-exception
            r6.notifyStreamError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.instrumentation.io.CountingInputStream.read():int");
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.removeStreamCompleteListener(streamCompleteListener);
    }

    public void reset() throws IOException {
        if (markSupported()) {
            try {
                this.impl.reset();
            } catch (IOException e11) {
                notifyStreamError(e11);
                throw e11;
            }
        }
    }

    public long skip(long j11) throws IOException {
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes(j11)) {
                    ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position((int) j11);
                    this.count += j11;
                    return j11;
                }
                j11 -= (long) this.buffer.remaining();
                if (j11 > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    ByteBuffer byteBuffer3 = (ByteBuffer) byteBuffer2.position(byteBuffer2.remaining());
                } else {
                    throw new IOException("partial read from buffer (skip) failed");
                }
            }
        }
        try {
            long skip = this.impl.skip(j11);
            this.count += skip;
            return skip;
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }

    public CountingInputStream(InputStream inputStream, boolean z11) throws IOException {
        this(inputStream, z11, 4096);
    }

    private int readBufferBytes(byte[] bArr, int i11, int i12) {
        if (bufferEmpty()) {
            return -1;
        }
        int remaining = this.buffer.remaining();
        this.buffer.get(bArr, i11, i12);
        return remaining - this.buffer.remaining();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountingInputStream(InputStream inputStream, boolean z11, int i11) throws IOException {
        this(inputStream, z11 ? ByteBuffer.allocate(i11) : null);
    }

    public CountingInputStream(InputStream inputStream, ByteBuffer byteBuffer) throws IOException {
        this.count = 0;
        if (inputStream != null) {
            this.impl = inputStream;
            this.buffer = byteBuffer;
            boolean z11 = byteBuffer != null;
            this.enableBuffering = z11;
            this.listenerManager = new StreamCompleteListenerManager();
            if (z11) {
                fillBuffer();
                return;
            }
            return;
        }
        throw new IOException("CountingInputStream: input stream cannot be null");
    }

    public int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i11 = 0;
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes((long) length)) {
                    int readBufferBytes = readBufferBytes(bArr);
                    if (readBufferBytes >= 0) {
                        this.count += (long) readBufferBytes;
                        return readBufferBytes;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.buffer.remaining();
                if (remaining > 0) {
                    i11 = readBufferBytes(bArr, 0, remaining);
                    if (i11 >= 0) {
                        length -= i11;
                        this.count += (long) i11;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.impl.read(bArr, i11, length);
            if (read >= 0) {
                this.count += (long) read;
                return read + i11;
            } else if (i11 > 0) {
                return i11;
            } else {
                notifyStreamComplete();
                return read;
            }
        } catch (IOException e11) {
            log.error(e11.toString());
            System.out.println("NOTIFY STREAM ERROR: " + e11);
            e11.printStackTrace();
            notifyStreamError(e11);
            throw e11;
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes((long) i12)) {
                    int readBufferBytes = readBufferBytes(bArr, i11, i12);
                    if (readBufferBytes >= 0) {
                        this.count += (long) readBufferBytes;
                        return readBufferBytes;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.buffer.remaining();
                if (remaining > 0) {
                    i13 = readBufferBytes(bArr, i11, remaining);
                    if (i13 >= 0) {
                        i12 -= i13;
                        this.count += (long) i13;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.impl.read(bArr, i11 + i13, i12);
            if (read >= 0) {
                this.count += (long) read;
                return read + i13;
            } else if (i13 > 0) {
                return i13;
            } else {
                notifyStreamComplete();
                return read;
            }
        } catch (IOException e11) {
            notifyStreamError(e11);
            throw e11;
        }
    }
}
