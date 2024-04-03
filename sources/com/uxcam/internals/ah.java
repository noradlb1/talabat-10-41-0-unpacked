package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class ah extends am {

    /* renamed from: b  reason: collision with root package name */
    public int f12983b;

    /* renamed from: c  reason: collision with root package name */
    public int f12984c;

    /* renamed from: d  reason: collision with root package name */
    public int f12985d;

    /* renamed from: e  reason: collision with root package name */
    public List f12986e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List f12987f = new ArrayList();

    public ah() {
        super(new da("avcC"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) this.f12983b);
        byteBuffer.put((byte) this.f12984c);
        byteBuffer.put((byte) this.f12985d);
        byteBuffer.put((byte) -1);
        byteBuffer.put((byte) (this.f12986e.size() | 224));
        for (ByteBuffer byteBuffer2 : this.f12986e) {
            byteBuffer.putShort((short) (byteBuffer2.remaining() + 1));
            byteBuffer.put(TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER);
            eb.a(byteBuffer, byteBuffer2);
        }
        byteBuffer.put((byte) this.f12987f.size());
        for (ByteBuffer byteBuffer3 : this.f12987f) {
            byteBuffer.putShort((short) ((byte) (byteBuffer3.remaining() + 1)));
            byteBuffer.put((byte) 104);
            eb.a(byteBuffer, byteBuffer3);
        }
    }
}
