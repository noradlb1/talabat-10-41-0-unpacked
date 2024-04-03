package com.uxcam.internals;

import java.nio.ByteBuffer;

public class bw extends am {
    public bw() {
        super(new da("fiel"));
    }

    public void a(ByteBuffer byteBuffer) {
        byte b11 = (byte) 0;
        byteBuffer.put(b11);
        byteBuffer.put(b11);
    }
}
