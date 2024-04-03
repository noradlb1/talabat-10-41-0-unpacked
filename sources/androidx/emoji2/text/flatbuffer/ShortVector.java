package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UShort;

public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i11, ByteBuffer byteBuffer) {
        b(i11, 2, byteBuffer);
        return this;
    }

    public short get(int i11) {
        return this.f35915a.getShort(a(i11));
    }

    public int getAsUnsigned(int i11) {
        return get(i11) & UShort.MAX_VALUE;
    }
}
