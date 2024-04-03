package com.uxcam.internals;

import java.nio.ByteBuffer;

public class fh extends ci {

    /* renamed from: c  reason: collision with root package name */
    public aa[] f13311c;

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public long f13312a;

        /* renamed from: b  reason: collision with root package name */
        public int f13313b;

        /* renamed from: c  reason: collision with root package name */
        public int f13314c;

        public aa(long j11, int i11, int i12) {
            this.f13312a = j11;
            this.f13313b = i11;
            this.f13314c = i12;
        }
    }

    public fh(aa[] aaVarArr) {
        super(new da("stsc"));
        this.f13311c = aaVarArr;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(this.f13311c.length);
        for (aa aaVar : this.f13311c) {
            byteBuffer.putInt((int) aaVar.f13312a);
            byteBuffer.putInt(aaVar.f13313b);
            byteBuffer.putInt(aaVar.f13314c);
        }
    }

    public fh() {
        super(new da("stsc"));
    }
}
