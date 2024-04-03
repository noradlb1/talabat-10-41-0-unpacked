package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    @NonNull
    private final OutputStream out;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool2) {
        this(outputStream, arrayPool2, 65536);
    }

    private void flushBuffer() throws IOException {
        int i11 = this.index;
        if (i11 > 0) {
            this.out.write(this.buffer, 0, i11);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th2) {
            this.out.close();
            throw th2;
        }
    }

    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.buffer;
        int i12 = this.index;
        this.index = i12 + 1;
        bArr[i12] = (byte) i11;
        maybeFlushBuffer();
    }

    @VisibleForTesting
    public BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool2, int i11) {
        this.out = outputStream;
        this.arrayPool = arrayPool2;
        this.buffer = (byte[]) arrayPool2.get(i11, byte[].class);
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        do {
            int i14 = i12 - i13;
            int i15 = i11 + i13;
            int i16 = this.index;
            if (i16 != 0 || i14 < this.buffer.length) {
                int min = Math.min(i14, this.buffer.length - i16);
                System.arraycopy(bArr, i15, this.buffer, this.index, min);
                this.index += min;
                i13 += min;
                maybeFlushBuffer();
            } else {
                this.out.write(bArr, i15, i14);
                return;
            }
        } while (i13 < i12);
    }
}
