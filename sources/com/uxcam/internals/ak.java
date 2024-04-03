package com.uxcam.internals;

import java.nio.ByteBuffer;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f12993a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12994b;

    /* renamed from: c  reason: collision with root package name */
    public int f12995c;

    /* renamed from: d  reason: collision with root package name */
    public int f12996d;

    public ak(ByteBuffer byteBuffer) {
        this.f12993a = byteBuffer;
        this.f12994b = byteBuffer.position();
    }

    public void a() {
        int i11 = (this.f12996d + 7) >> 3;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f12993a.put((byte) (this.f12995c >>> 24));
            this.f12995c <<= 8;
        }
    }

    public void b(int i11) {
        int i12 = this.f12995c;
        int i13 = this.f12996d;
        int i14 = (i11 << ((32 - i13) - 1)) | i12;
        this.f12995c = i14;
        int i15 = i13 + 1;
        this.f12996d = i15;
        if (i15 == 32) {
            a(i14);
            this.f12996d = 0;
            this.f12995c = 0;
        }
    }

    public ak(ByteBuffer byteBuffer, int i11, int i12, int i13) {
        this.f12993a = byteBuffer;
        this.f12996d = i11;
        this.f12995c = i12;
        this.f12994b = i13;
    }

    public final void a(int i11) {
        this.f12993a.put((byte) (i11 >>> 24));
        this.f12993a.put((byte) (i11 >> 16));
        this.f12993a.put((byte) (i11 >> 8));
        this.f12993a.put((byte) i11);
    }

    public final void a(int i11, int i12) {
        if (i12 > 32) {
            throw new IllegalArgumentException("Max 32 bit to write");
        } else if (i12 != 0) {
            int i13 = i11 & (-1 >>> (32 - i12));
            int i14 = this.f12996d;
            int i15 = 32 - i14;
            if (i15 >= i12) {
                int i16 = (i13 << (i15 - i12)) | this.f12995c;
                this.f12995c = i16;
                int i17 = i14 + i12;
                this.f12996d = i17;
                if (i17 == 32) {
                    a(i16);
                    this.f12996d = 0;
                    this.f12995c = 0;
                    return;
                }
                return;
            }
            int i18 = i12 - i15;
            int i19 = this.f12995c | (i13 >>> i18);
            this.f12995c = i19;
            a(i19);
            this.f12995c = i13 << (32 - i18);
            this.f12996d = i18;
        }
    }
}
