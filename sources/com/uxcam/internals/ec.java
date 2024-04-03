package com.uxcam.internals;

import java.nio.ByteBuffer;

public class ec extends am {

    /* renamed from: b  reason: collision with root package name */
    public String f13251b;

    public ec() {
        super(new da("name"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(dh.a(this.f13251b));
        byteBuffer.putInt(0);
    }
}
