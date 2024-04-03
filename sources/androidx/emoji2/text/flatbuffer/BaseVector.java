package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class BaseVector {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f35915a;
    private int element_size;
    private int length;
    private int vector;

    public int a(int i11) {
        return this.vector + (i11 * this.element_size);
    }

    public void b(int i11, int i12, ByteBuffer byteBuffer) {
        this.f35915a = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i11;
            this.length = byteBuffer.getInt(i11 - 4);
            this.element_size = i12;
            return;
        }
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        b(0, 0, (ByteBuffer) null);
    }
}
