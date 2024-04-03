package com.instabug.library.annotation.utility;

import java.io.Serializable;

public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private float f34170a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f34171b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f34172c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f34173d = 0.0f;

    public float a() {
        float f11 = this.f34172c;
        if (f11 != 0.0f) {
            float f12 = this.f34170a;
            if (f12 != 0.0f) {
                return f11 / f12;
            }
        }
        return 1.0f;
    }

    public float b() {
        float f11 = this.f34173d;
        if (f11 != 0.0f) {
            float f12 = this.f34171b;
            if (f12 != 0.0f) {
                return f11 / f12;
            }
        }
        return 1.0f;
    }

    public void c(float f11) {
        d(this.f34173d);
        this.f34173d = f11;
    }

    public void d(float f11) {
        this.f34171b = f11;
    }

    public void a(float f11) {
        this.f34170a = f11;
    }

    public void b(float f11) {
        a(this.f34172c);
        this.f34172c = f11;
    }
}
