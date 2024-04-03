package com.uxcam.internals;

import java.nio.ByteBuffer;

public class gx extends ci {

    /* renamed from: c  reason: collision with root package name */
    public short f13510c;

    /* renamed from: d  reason: collision with root package name */
    public short f13511d;

    /* renamed from: e  reason: collision with root package name */
    public short f13512e;

    /* renamed from: f  reason: collision with root package name */
    public short[] f13513f = new short[3];

    /* renamed from: g  reason: collision with root package name */
    public short[] f13514g = new short[3];

    /* renamed from: h  reason: collision with root package name */
    public String f13515h;

    public gx(da daVar) {
        super(daVar);
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putShort(this.f13510c);
        byteBuffer.putShort(this.f13511d);
        byteBuffer.putShort(this.f13512e);
        byteBuffer.putShort(0);
        byteBuffer.putShort(this.f13513f[0]);
        byteBuffer.putShort(this.f13513f[1]);
        byteBuffer.putShort(this.f13513f[2]);
        byteBuffer.putShort(this.f13514g[0]);
        byteBuffer.putShort(this.f13514g[1]);
        byteBuffer.putShort(this.f13514g[2]);
        String str = this.f13515h;
        byteBuffer.put((byte) str.length());
        byteBuffer.put(dh.a(str));
    }
}
