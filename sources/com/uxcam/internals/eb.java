package com.uxcam.internals;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

public class eb {
    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.position() + byteBuffer2.arrayOffset(), Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
            return;
        }
        byte[] bArr = new byte[Math.min(byteBuffer2.remaining(), byteBuffer.remaining())];
        byteBuffer2.duplicate().get(bArr);
        byteBuffer.put(bArr);
    }

    public static void a(ByteBuffer byteBuffer, String str, int i11) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(dh.a(str));
        byteBuffer.position(byteBuffer.position() + Math.min(byteBuffer.remaining(), i11 - str.length()));
    }

    public static bx a(File file) {
        return new bx(new FileOutputStream(file).getChannel());
    }
}
