package com.uxcam.internals;

import java.nio.ByteBuffer;

public class im extends ci {

    /* renamed from: c  reason: collision with root package name */
    public int f13645c;

    /* renamed from: d  reason: collision with root package name */
    public int f13646d;

    /* renamed from: e  reason: collision with root package name */
    public int f13647e;

    /* renamed from: f  reason: collision with root package name */
    public int f13648f;

    public im() {
        super(new da("vmhd"));
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putShort((short) this.f13645c);
        byteBuffer.putShort((short) this.f13646d);
        byteBuffer.putShort((short) this.f13647e);
        byteBuffer.putShort((short) this.f13648f);
    }

    public im(int i11, int i12, int i13, int i14) {
        super(new da("vmhd"));
        this.f13645c = i11;
        this.f13646d = i12;
        this.f13647e = i13;
        this.f13648f = i14;
    }
}
