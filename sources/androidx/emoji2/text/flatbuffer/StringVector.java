package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i11, int i12, ByteBuffer byteBuffer) {
        b(i11, i12, byteBuffer);
        return this;
    }

    public String get(int i11) {
        return Table.f(a(i11), this.f35915a, this.utf8);
    }
}
