package com.uxcam.internals;

import java.nio.ByteBuffer;

public class ay extends am {
    public ay() {
        super(new da("crgn"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
    }
}
