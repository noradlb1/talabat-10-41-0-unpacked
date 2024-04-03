package com.uxcam.internals;

import java.nio.ByteBuffer;

public class ff extends ed {

    /* renamed from: c  reason: collision with root package name */
    public short f13309c;

    public ff(da daVar) {
        super(daVar);
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[]{0, 0, 0, 0, 0, 0});
        byteBuffer.putShort(this.f13309c);
    }

    public void c(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
    }

    public ff(da daVar, short s11) {
        super(daVar);
        this.f13309c = s11;
    }
}
