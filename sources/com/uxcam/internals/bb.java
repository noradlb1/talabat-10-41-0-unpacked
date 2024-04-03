package com.uxcam.internals;

import java.nio.ByteBuffer;

public class bb extends am {
    public bb() {
        super(new da("colr"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(dh.a("nclc"));
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
    }
}
