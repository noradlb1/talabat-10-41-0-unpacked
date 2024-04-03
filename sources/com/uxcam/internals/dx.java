package com.uxcam.internals;

import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.nio.ByteBuffer;

public class dx extends ci {

    /* renamed from: c  reason: collision with root package name */
    public long f13237c;

    /* renamed from: d  reason: collision with root package name */
    public long f13238d;

    /* renamed from: e  reason: collision with root package name */
    public int f13239e;

    /* renamed from: f  reason: collision with root package name */
    public long f13240f;

    /* renamed from: g  reason: collision with root package name */
    public int f13241g;

    /* renamed from: h  reason: collision with root package name */
    public int f13242h;

    public dx(int i11, long j11, int i12, long j12, long j13, int i13) {
        super(new da("mdhd"));
        this.f13239e = i11;
        this.f13240f = j11;
        this.f13241g = i12;
        this.f13237c = j12;
        this.f13238d = j13;
        this.f13242h = i13;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(gw.a(this.f13237c));
        byteBuffer.putInt(gw.a(this.f13238d));
        byteBuffer.putInt(this.f13239e);
        byteBuffer.putInt((int) this.f13240f);
        byteBuffer.putShort((short) this.f13241g);
        byteBuffer.putShort((short) this.f13242h);
    }

    public dx() {
        super(new da("mdhd"));
    }

    public void a(StringBuilder sb2) {
        super.a(sb2);
        sb2.append(": ");
        hc.a(this, sb2, "created", "modified", "timescale", "duration", ConstantsKt.ADJUST_LANGUAGE, "quality");
    }
}
