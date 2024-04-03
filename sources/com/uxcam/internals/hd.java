package com.uxcam.internals;

import java.nio.ByteBuffer;

public class hd extends ci {

    /* renamed from: c  reason: collision with root package name */
    public int f13537c;

    /* renamed from: d  reason: collision with root package name */
    public long f13538d;

    /* renamed from: e  reason: collision with root package name */
    public float f13539e;

    /* renamed from: f  reason: collision with root package name */
    public float f13540f;

    /* renamed from: g  reason: collision with root package name */
    public long f13541g;

    /* renamed from: h  reason: collision with root package name */
    public long f13542h;

    /* renamed from: i  reason: collision with root package name */
    public float f13543i;

    /* renamed from: j  reason: collision with root package name */
    public short f13544j;

    /* renamed from: k  reason: collision with root package name */
    public long f13545k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f13546l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hd(int i11, long j11, float f11, float f12, long j12, long j13, float f13, short s11, long j14, int[] iArr) {
        super(new da("tkhd"));
        this.f13537c = i11;
        this.f13538d = j11;
        this.f13539e = f11;
        this.f13540f = f12;
        this.f13541g = j12;
        this.f13542h = j13;
        this.f13543i = f13;
        this.f13544j = s11;
        this.f13545k = j14;
        this.f13546l = iArr;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(gw.a(this.f13541g));
        byteBuffer.putInt(gw.a(this.f13542h));
        byteBuffer.putInt(this.f13537c);
        byteBuffer.putInt(0);
        byteBuffer.putInt((int) this.f13538d);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.f13544j);
        byteBuffer.putShort((short) ((int) this.f13545k));
        byteBuffer.putShort((short) ((int) (((double) this.f13543i) * 256.0d)));
        byteBuffer.putShort(0);
        for (int i11 = 0; i11 < 9; i11++) {
            byteBuffer.putInt(this.f13546l[i11]);
        }
        byteBuffer.putInt((int) (this.f13539e * 65536.0f));
        byteBuffer.putInt((int) (this.f13540f * 65536.0f));
    }

    public hd() {
        super(new da("tkhd"));
    }

    public void a(StringBuilder sb2) {
        super.a(sb2);
        sb2.append(": ");
        hc.a(this, sb2, "trackId", "duration", "width", "height", "created", "modified", "volume", "layer", "altGroup");
    }
}
