package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class cy {
    public static ByteBuffer a(ByteBuffer byteBuffer) {
        byte b11 = -1;
        if (byteBuffer.hasRemaining()) {
            byte b12 = -1;
            while (true) {
                if (!byteBuffer.hasRemaining()) {
                    break;
                }
                b12 = (b12 << 8) | (byteBuffer.get() & 255);
                if ((b12 & 16777215) == 1) {
                    byteBuffer.position(byteBuffer.position());
                    break;
                }
            }
        }
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int position = byteBuffer.position();
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.BIG_ENDIAN);
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            b11 = (b11 << 8) | (byteBuffer.get() & 255);
            if ((b11 & 16777215) == 1) {
                byteBuffer.position(byteBuffer.position() - (b11 == 1 ? 4 : 3));
                slice.limit(byteBuffer.position() - position);
            }
        }
        return slice;
    }

    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte b11 = byteBuffer.get();
        byte b12 = byteBuffer.get();
        byteBuffer2.put(b11);
        byteBuffer2.put(b12);
        while (byteBuffer.hasRemaining()) {
            byte b13 = byteBuffer.get();
            if (b11 == 0 && b12 == 0 && (b13 & 255) <= 3) {
                byteBuffer2.put((byte) 3);
                b11 = 3;
            } else {
                b11 = b12;
            }
            byteBuffer2.put(b13);
            b12 = b13;
        }
    }
}
