package com.uxcam.internals;

import java.nio.ByteBuffer;

public class cp extends ci {
    public cp(da daVar) {
        super(daVar);
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
    }

    public cp() {
        this(new da("gmin"));
    }
}
