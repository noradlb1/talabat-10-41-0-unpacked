package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
    private static final int DEFAULT_SIZE = 256;
    private final ByteArrayPool mPool;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 256);
    }

    private void expand(int i11) {
        int i12 = this.count;
        if (i12 + i11 > this.buf.length) {
            byte[] buf = this.mPool.getBuf((i12 + i11) * 2);
            System.arraycopy(this.buf, 0, buf, 0, this.count);
            this.mPool.returnBuf(this.buf);
            this.buf = buf;
        }
    }

    public void close() throws IOException {
        this.mPool.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.mPool.returnBuf(this.buf);
    }

    public synchronized void write(byte[] bArr, int i11, int i12) {
        expand(i12);
        super.write(bArr, i11, i12);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i11) {
        this.mPool = byteArrayPool;
        this.buf = byteArrayPool.getBuf(Math.max(i11, 256));
    }

    public synchronized void write(int i11) {
        expand(1);
        super.write(i11);
    }
}
