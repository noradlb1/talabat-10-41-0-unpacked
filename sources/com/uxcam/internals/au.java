package com.uxcam.internals;

import java.nio.ByteBuffer;

public class au extends ci {

    /* renamed from: c  reason: collision with root package name */
    public long[] f13034c;

    public au() {
        super(new da("co64", 0));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(this.f13034c.length);
        for (long putLong : this.f13034c) {
            byteBuffer.putLong(putLong);
        }
    }
}
