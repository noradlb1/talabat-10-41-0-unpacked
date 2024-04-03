package com.uxcam.internals;

import java.nio.ByteBuffer;

public class fg extends ci {

    /* renamed from: c  reason: collision with root package name */
    public int[] f13310c;

    public fg() {
        super(new da("stsz"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f13310c.length);
        for (int i11 : this.f13310c) {
            byteBuffer.putInt((int) ((long) i11));
        }
    }
}
