package com.uxcam.internals;

import java.nio.ByteBuffer;

public class dp extends am {
    public dp() {
        super(new da("load"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
    }
}
