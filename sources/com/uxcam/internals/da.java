package com.uxcam.internals;

import java.nio.ByteBuffer;

public class da {

    /* renamed from: a  reason: collision with root package name */
    public final String f13186a;

    /* renamed from: b  reason: collision with root package name */
    public long f13187b;

    public da(String str) {
        this.f13186a = str;
    }

    public void a(ByteBuffer byteBuffer) {
        long j11 = this.f13187b;
        if (j11 > 4294967296L) {
            byteBuffer.putInt(1);
        } else {
            byteBuffer.putInt((int) j11);
        }
        byteBuffer.put(dh.a(this.f13186a));
        long j12 = this.f13187b;
        if (j12 > 4294967296L) {
            byteBuffer.putLong(j12);
        }
    }

    public da(String str, long j11) {
        this.f13187b = j11;
        this.f13186a = str;
    }
}
