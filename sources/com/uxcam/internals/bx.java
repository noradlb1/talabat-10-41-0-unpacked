package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class bx implements gb {

    /* renamed from: a  reason: collision with root package name */
    public final FileChannel f13097a;

    public bx(FileChannel fileChannel) {
        this.f13097a = fileChannel;
    }

    public void close() {
        this.f13097a.close();
    }

    public boolean isOpen() {
        return this.f13097a.isOpen();
    }

    public int read(ByteBuffer byteBuffer) {
        return this.f13097a.read(byteBuffer);
    }

    public int write(ByteBuffer byteBuffer) {
        return this.f13097a.write(byteBuffer);
    }
}
