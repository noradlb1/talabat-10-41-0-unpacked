package org.tukaani.xz.rangecoder;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.CorruptedInputException;

public final class RangeDecoderFromBuffer extends RangeDecoder {
    private static final int INIT_SIZE = 5;
    private final byte[] buf;
    private int pos;

    public RangeDecoderFromBuffer(int i11, ArrayCache arrayCache) {
        byte[] byteArray = arrayCache.getByteArray(i11 - 5, false);
        this.buf = byteArray;
        this.pos = byteArray.length;
    }

    public boolean isFinished() {
        return this.pos == this.buf.length && this.f63484b == 0;
    }

    public void normalize() throws IOException {
        int i11 = this.f63483a;
        if ((-16777216 & i11) == 0) {
            try {
                byte[] bArr = this.buf;
                int i12 = this.pos;
                this.pos = i12 + 1;
                this.f63484b = (this.f63484b << 8) | (bArr[i12] & 255);
                this.f63483a = i11 << 8;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new CorruptedInputException();
            }
        }
    }

    public void prepareInputBuffer(DataInputStream dataInputStream, int i11) throws IOException {
        if (i11 < 5) {
            throw new CorruptedInputException();
        } else if (dataInputStream.readUnsignedByte() == 0) {
            this.f63484b = dataInputStream.readInt();
            this.f63483a = -1;
            int i12 = i11 - 5;
            byte[] bArr = this.buf;
            int length = bArr.length - i12;
            this.pos = length;
            dataInputStream.readFully(bArr, length, i12);
        } else {
            throw new CorruptedInputException();
        }
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }
}
