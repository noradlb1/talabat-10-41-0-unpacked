package com.uxcam.internals;

import com.talabat.NewRateActivity;
import java.nio.ByteBuffer;

public class ea extends ci {

    /* renamed from: c  reason: collision with root package name */
    public int f13243c;

    /* renamed from: d  reason: collision with root package name */
    public long f13244d;

    /* renamed from: e  reason: collision with root package name */
    public float f13245e;

    /* renamed from: f  reason: collision with root package name */
    public float f13246f;

    /* renamed from: g  reason: collision with root package name */
    public long f13247g;

    /* renamed from: h  reason: collision with root package name */
    public long f13248h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f13249i;

    /* renamed from: j  reason: collision with root package name */
    public int f13250j;

    public ea(int i11, long j11, float f11, float f12, long j12, long j13, int[] iArr, int i12) {
        super(new da("mvhd"));
        this.f13243c = i11;
        this.f13244d = j11;
        this.f13245e = f11;
        this.f13246f = f12;
        this.f13247g = j12;
        this.f13248h = j13;
        this.f13249i = iArr;
        this.f13250j = i12;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(gw.a(this.f13247g));
        byteBuffer.putInt(gw.a(this.f13248h));
        byteBuffer.putInt(this.f13243c);
        byteBuffer.putInt((int) this.f13244d);
        byteBuffer.putInt((int) (((double) this.f13245e) * 65536.0d));
        byteBuffer.putShort((short) ((int) (((double) this.f13246f) * 256.0d)));
        byteBuffer.put(new byte[10]);
        for (int i11 = 0; i11 < Math.min(9, this.f13249i.length); i11++) {
            byteBuffer.putInt(this.f13249i[i11]);
        }
        for (int min = Math.min(9, this.f13249i.length); min < 9; min++) {
            byteBuffer.putInt(0);
        }
        byteBuffer.put(new byte[24]);
        byteBuffer.putInt(this.f13250j);
    }

    public ea() {
        super(new da("mvhd"));
    }

    public void a(StringBuilder sb2) {
        super.a(sb2);
        sb2.append(": ");
        hc.a(this, sb2, "timescale", "duration", NewRateActivity.RATE, "volume", "created", "modified", "nextTrackId");
    }
}
