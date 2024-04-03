package com.uxcam.internals;

import android.graphics.Point;
import android.graphics.Rect;

public class fl {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f13354g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public static fl f13355h;

    /* renamed from: a  reason: collision with root package name */
    public float f13356a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13357b = false;

    /* renamed from: c  reason: collision with root package name */
    public int f13358c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f13359d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f13360e;

    /* renamed from: f  reason: collision with root package name */
    public int f13361f;

    public fl(float f11, int i11, int i12) {
        this.f13356a = f11;
        this.f13360e = i11;
        this.f13361f = i12;
        a(new Rect());
    }

    public static fl a() {
        if (f13355h == null) {
            synchronized (f13354g) {
                if (f13355h == null) {
                    f13355h = new fl(1.0f, 0, -1);
                }
            }
        }
        return f13355h;
    }

    public final void a(Rect rect) {
        Point c11 = bm.c(ia.f13617c);
        int i11 = c11.y + rect.top;
        int i12 = c11.x;
        int i13 = 1;
        boolean z11 = i12 > i11;
        this.f13358c = i12;
        int i14 = gm.f13467p;
        if (i12 > i14) {
            this.f13358c = i14;
            this.f13356a = 1.0f;
            if (z11) {
                this.f13356a = ((float) i14) / ((float) i11);
            } else {
                this.f13356a = ((float) i14) / ((float) i12);
            }
        }
        float f11 = this.f13356a;
        int i15 = (int) (((float) i12) * f11);
        this.f13358c = i15;
        int i16 = (int) (((float) i11) * f11);
        this.f13359d = i16;
        if (z11) {
            this.f13359d = i15;
            this.f13358c = i16;
        }
        this.f13360e = ia.a(this.f13359d) - this.f13359d;
        gu.a("fl").getClass();
        if (this.f13361f == -1) {
            if (this.f13358c > this.f13359d) {
                i13 = 0;
            }
            this.f13361f = i13;
        }
    }
}
