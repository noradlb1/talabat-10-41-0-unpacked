package com.apptimize;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.io.ByteArrayOutputStream;

public class jn {

    /* renamed from: a  reason: collision with root package name */
    private jm f43120a = new jm();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ByteArrayOutputStream f43121a;

        /* renamed from: b  reason: collision with root package name */
        public Rect f43122b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43123c = false;

        /* renamed from: d  reason: collision with root package name */
        public double f43124d = 1.0d;

        public a() {
        }
    }

    private Bitmap a(Bitmap bitmap, double d11) {
        return Bitmap.createScaledBitmap(bitmap, (int) ((((double) bitmap.getWidth()) * d11) + 0.5d), (int) ((((double) bitmap.getHeight()) * d11) + 0.5d), true);
    }

    private double b(Bitmap bitmap) {
        return 700.0d / ((double) Math.max(bitmap.getWidth(), bitmap.getHeight()));
    }

    private a a(Bitmap bitmap, double d11, Rect rect, boolean z11, int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
        a aVar = new a();
        aVar.f43121a = byteArrayOutputStream;
        aVar.f43122b = rect;
        aVar.f43124d = d11;
        aVar.f43123c = z11;
        return aVar;
    }

    public a a(Bitmap bitmap, boolean z11) {
        double b11 = b(bitmap);
        int i11 = z11 ? 30 : 80;
        Bitmap a11 = a(bitmap, b11);
        return a(a11, b11, new Rect(0, 0, a11.getWidth(), a11.getHeight()), true, i11);
    }

    public a a(Bitmap bitmap) {
        double b11 = b(bitmap);
        Bitmap a11 = a(bitmap, b11);
        Rect a12 = this.f43120a.a(a11);
        if (a12 == null) {
            return null;
        }
        return a(a(a11, a12), b11, a12, false, 80);
    }

    private Bitmap a(Bitmap bitmap, Rect rect) {
        int i11 = rect.left;
        int i12 = rect.top;
        return Bitmap.createBitmap(bitmap, i11, i12, rect.right - i11, rect.bottom - i12);
    }
}
