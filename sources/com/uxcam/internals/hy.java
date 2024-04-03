package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class hy extends ci {
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        Charset charset = StandardCharsets.UTF_8;
    }
}
