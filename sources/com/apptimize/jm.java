package com.apptimize;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;

public class jm {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43116a = "jm";

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer[] f43117b = new ByteBuffer[2];

    /* renamed from: c  reason: collision with root package name */
    private int f43118c = 1;

    /* renamed from: d  reason: collision with root package name */
    private Rect f43119d = new Rect();

    private void b(Bitmap bitmap) {
        int height = bitmap.getHeight() * bitmap.getRowBytes();
        this.f43117b[0] = ByteBuffer.allocate(height);
        this.f43117b[1] = ByteBuffer.allocate(height);
        bitmap.copyPixelsToBuffer(this.f43117b[0]);
        this.f43117b[0].rewind();
        this.f43118c = 1;
        this.f43119d = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    private boolean c(Bitmap bitmap) {
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (rect.width() == this.f43119d.width() && rect.height() == this.f43119d.height()) {
            return true;
        }
        return false;
    }

    public Rect a(Bitmap bitmap) {
        int height = bitmap.getHeight() * bitmap.getRowBytes();
        ByteBuffer byteBuffer = this.f43117b[0];
        if (byteBuffer == null || height != byteBuffer.capacity() || !c(bitmap)) {
            b(bitmap);
            return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        bitmap.copyPixelsToBuffer(this.f43117b[this.f43118c]);
        this.f43117b[this.f43118c].rewind();
        this.f43118c = 1 - this.f43118c;
        Rect a11 = a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes(), bitmap.getRowBytes() / bitmap.getWidth());
        this.f43117b[0].rewind();
        this.f43117b[1].rewind();
        return a11;
    }

    private Rect a(int i11, int i12, int i13, int i14) {
        int i15 = Integer.MAX_VALUE;
        int i16 = Integer.MAX_VALUE;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < this.f43117b[0].capacity(); i19++) {
            if (this.f43117b[0].get() != this.f43117b[1].get()) {
                int i21 = (i19 % i13) / i14;
                i15 = Math.min(i21, i15);
                i17 = Math.max(i21, i17);
                int i22 = i19 / i13;
                i16 = Math.min(i22, i16);
                i18 = Math.max(i22, i18);
            }
        }
        if (i15 > i17 || i16 > i18) {
            return null;
        }
        return new Rect(i15, i16, Math.min(i11, i17 + 1), Math.min(i12, i18 + 1));
    }
}
