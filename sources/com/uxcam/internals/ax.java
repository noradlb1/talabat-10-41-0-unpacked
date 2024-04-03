package com.uxcam.internals;

import java.nio.ByteBuffer;

public class ax extends ci {

    /* renamed from: c  reason: collision with root package name */
    public float f13035c;

    /* renamed from: d  reason: collision with root package name */
    public float f13036d;

    public ax(da daVar) {
        super(daVar);
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt((int) (this.f13035c * 65536.0f));
        byteBuffer.putInt((int) (this.f13036d * 65536.0f));
    }

    public ax() {
        super(new da("clef"));
    }

    public ax(da daVar, int i11, int i12) {
        super(daVar);
        this.f13035c = (float) i11;
        this.f13036d = (float) i12;
    }
}
