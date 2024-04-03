package com.uxcam.internals;

import java.nio.ByteBuffer;

public class gt extends ci {

    /* renamed from: c  reason: collision with root package name */
    public int[] f13501c;

    public gt() {
        super(new da("stss"));
    }

    public void a(ByteBuffer byteBuffer) {
        int i11 = 0;
        byteBuffer.putInt((this.f13131b & 16777215) | 0);
        byteBuffer.putInt(this.f13501c.length);
        while (true) {
            int[] iArr = this.f13501c;
            if (i11 < iArr.length) {
                byteBuffer.putInt(iArr[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    public gt(da daVar) {
        super(daVar);
    }
}
