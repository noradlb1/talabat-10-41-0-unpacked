package com.uxcam.internals;

import java.nio.ByteBuffer;

public class bg extends ci {

    /* renamed from: c  reason: collision with root package name */
    public aa[] f13063c;

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public int f13064a;

        /* renamed from: b  reason: collision with root package name */
        public int f13065b;

        public aa(int i11, int i12) {
            this.f13064a = i11;
            this.f13065b = i12;
        }
    }

    public bg() {
        super(new da("ctts"));
    }

    public void a(ByteBuffer byteBuffer) {
        int i11 = 0;
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(this.f13063c.length);
        while (true) {
            aa[] aaVarArr = this.f13063c;
            if (i11 < aaVarArr.length) {
                byteBuffer.putInt(aaVarArr[i11].f13064a);
                byteBuffer.putInt(this.f13063c[i11].f13065b);
                i11++;
            } else {
                return;
            }
        }
    }

    public bg(aa[] aaVarArr) {
        super(new da("ctts"));
        this.f13063c = aaVarArr;
    }
}
