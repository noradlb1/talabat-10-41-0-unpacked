package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class LongVector extends BaseVector {
    public LongVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 8, byteBuffer);
        return this;
    }

    public long get(int i11) {
        return this.f35915a.getLong(a(i11));
    }
}
