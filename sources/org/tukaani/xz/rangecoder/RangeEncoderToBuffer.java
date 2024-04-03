package org.tukaani.xz.rangecoder;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.ArrayCache;

public final class RangeEncoderToBuffer extends RangeEncoder {
    private final byte[] buf;
    private int bufPos;

    public RangeEncoderToBuffer(int i11, ArrayCache arrayCache) {
        this.buf = arrayCache.getByteArray(i11, false);
        reset();
    }

    public void a(int i11) {
        byte[] bArr = this.buf;
        int i12 = this.bufPos;
        this.bufPos = i12 + 1;
        bArr[i12] = (byte) i11;
    }

    public int finish() {
        try {
            super.finish();
            return this.bufPos;
        } catch (IOException unused) {
            throw new Error();
        }
    }

    public int getPendingSize() {
        return ((this.bufPos + ((int) this.f63485a)) + 5) - 1;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void reset() {
        super.reset();
        this.bufPos = 0;
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.bufPos);
    }
}
