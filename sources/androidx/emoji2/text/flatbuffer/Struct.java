package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {

    /* renamed from: a  reason: collision with root package name */
    public int f35944a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f35945b;

    public void __reset() {
        a(0, (ByteBuffer) null);
    }

    public void a(int i11, ByteBuffer byteBuffer) {
        this.f35945b = byteBuffer;
        if (byteBuffer != null) {
            this.f35944a = i11;
        } else {
            this.f35944a = 0;
        }
    }
}
