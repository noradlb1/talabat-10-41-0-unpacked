package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i11, int i12, ByteBuffer byteBuffer) {
        b(i11, i12, byteBuffer);
        return this;
    }

    public Table get(Table table, int i11) {
        return Table.g(table, a(i11), this.f35915a);
    }
}
