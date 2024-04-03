package com.uxcam.internals;

import java.nio.ByteBuffer;

public class gv extends ci {

    /* renamed from: c  reason: collision with root package name */
    public aa[] f13506c;

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public int f13507a;

        /* renamed from: b  reason: collision with root package name */
        public int f13508b;

        public aa(int i11, int i12) {
            this.f13507a = i11;
            this.f13508b = i12;
        }
    }

    public gv(aa[] aaVarArr) {
        super(new da("stts"));
        this.f13506c = aaVarArr;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(this.f13506c.length);
        for (aa aaVar : this.f13506c) {
            byteBuffer.putInt(aaVar.f13507a);
            byteBuffer.putInt(aaVar.f13508b);
        }
    }

    public gv() {
        super(new da("stts"));
    }
}
