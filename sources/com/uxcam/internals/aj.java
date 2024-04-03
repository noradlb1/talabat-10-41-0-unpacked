package com.uxcam.internals;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public class aj {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f12990a;

    /* renamed from: b  reason: collision with root package name */
    public int f12991b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f12992c = b();

    public aj(ByteBuffer byteBuffer) {
        this.f12990a = byteBuffer;
        byteBuffer.position();
    }

    public int a() {
        int i11 = this.f12992c;
        int i12 = i11 >>> 31;
        this.f12992c = i11 << 1;
        int i13 = this.f12991b + 1;
        this.f12991b = i13;
        if (i13 == 32) {
            this.f12992c = b();
        }
        return i12;
    }

    public final int b() {
        if (this.f12990a.remaining() >= 4) {
            this.f12991b -= 32;
            return ((this.f12990a.get() & 255) << Ascii.CAN) | ((this.f12990a.get() & 255) << Ascii.DLE) | ((this.f12990a.get() & 255) << 8) | (this.f12990a.get() & 255);
        }
        this.f12991b -= this.f12990a.remaining() << 3;
        byte b11 = 0;
        if (this.f12990a.hasRemaining()) {
            b11 = 0 | (this.f12990a.get() & 255);
        }
        int i11 = b11 << 8;
        if (this.f12990a.hasRemaining()) {
            i11 |= this.f12990a.get() & 255;
        }
        int i12 = i11 << 8;
        if (this.f12990a.hasRemaining()) {
            i12 |= this.f12990a.get() & 255;
        }
        int i13 = i12 << 8;
        return this.f12990a.hasRemaining() ? i13 | (this.f12990a.get() & 255) : i13;
    }

    public int a(int i11) {
        if (i11 <= 24) {
            while (true) {
                int i12 = this.f12991b;
                if (i12 + i11 <= 32) {
                    return this.f12992c >>> (32 - i11);
                }
                this.f12991b = i12 - 8;
                this.f12992c |= (this.f12990a.hasRemaining() ? this.f12990a.get() & 255 : 0) << this.f12991b;
            }
        } else {
            throw new IllegalArgumentException("Can not check more then 24 bit");
        }
    }

    public int b(int i11) {
        if (i11 <= 32) {
            int i12 = this.f12991b;
            int i13 = 0;
            if (i11 + i12 > 31) {
                i11 -= 32 - i12;
                i13 = ((this.f12992c >>> i12) | 0) << i11;
                this.f12991b = 32;
                this.f12992c = b();
            }
            if (i11 == 0) {
                return i13;
            }
            int i14 = this.f12992c;
            int i15 = i13 | (i14 >>> (32 - i11));
            this.f12992c = i14 << i11;
            this.f12991b += i11;
            return i15;
        }
        throw new IllegalArgumentException("Can not read more then 32 bit");
    }
}
