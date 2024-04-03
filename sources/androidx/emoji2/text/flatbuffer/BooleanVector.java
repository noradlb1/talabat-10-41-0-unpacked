package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class BooleanVector extends BaseVector {
    public BooleanVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 1, byteBuffer);
        return this;
    }

    public boolean get(int i11) {
        return this.f35915a.get(a(i11)) != 0;
    }
}
