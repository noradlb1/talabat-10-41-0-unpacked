package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 4, byteBuffer);
        return this;
    }

    public float get(int i11) {
        return this.f35915a.getFloat(a(i11));
    }
}
