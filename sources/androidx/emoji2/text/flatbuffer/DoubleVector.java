package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 8, byteBuffer);
        return this;
    }

    public double get(int i11) {
        return this.f35915a.getDouble(a(i11));
    }
}
