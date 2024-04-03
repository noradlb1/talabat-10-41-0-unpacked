package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 1, byteBuffer);
        return this;
    }

    public byte get(int i11) {
        return this.f35915a.get(a(i11));
    }

    public int getAsUnsigned(int i11) {
        return get(i11) & 255;
    }
}
