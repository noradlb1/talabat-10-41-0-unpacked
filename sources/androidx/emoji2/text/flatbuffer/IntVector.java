package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class IntVector extends BaseVector {
    public IntVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 4, byteBuffer);
        return this;
    }

    public int get(int i11) {
        return this.f35915a.getInt(a(i11));
    }

    public long getAsUnsigned(int i11) {
        return ((long) get(i11)) & 4294967295L;
    }
}
