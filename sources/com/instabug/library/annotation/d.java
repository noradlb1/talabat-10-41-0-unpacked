package com.instabug.library.annotation;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.io.Serializable;

public class d extends RectF implements Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public b f34102a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public c f34103b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f34104c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public c f34105d;

    /* renamed from: e  reason: collision with root package name */
    public PointF f34106e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    public PointF f34107f = new PointF();

    /* renamed from: g  reason: collision with root package name */
    public PointF f34108g = new PointF();

    /* renamed from: h  reason: collision with root package name */
    public PointF f34109h = new PointF();

    /* renamed from: i  reason: collision with root package name */
    public boolean f34110i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f34111j = true;

    public d() {
    }

    private void a(d dVar) {
        if (dVar == null) {
            this.bottom = 0.0f;
            this.right = 0.0f;
            this.top = 0.0f;
            this.left = 0.0f;
            this.f34104c = null;
            this.f34102a = null;
            this.f34105d = null;
            this.f34103b = null;
            this.f34106e.set(0.0f, 0.0f);
            this.f34107f.set(0.0f, 0.0f);
            this.f34108g.set(0.0f, 0.0f);
            this.f34109h.set(0.0f, 0.0f);
            this.f34110i = false;
            this.f34111j = true;
            return;
        }
        this.left = dVar.left;
        this.top = dVar.top;
        this.right = dVar.right;
        this.bottom = dVar.bottom;
        this.f34102a = dVar.f34102a;
        this.f34103b = dVar.f34103b;
        this.f34104c = dVar.f34104c;
        this.f34105d = dVar.f34105d;
        this.f34106e.set(dVar.f34106e);
        this.f34107f.set(dVar.f34107f);
        this.f34108g.set(dVar.f34108g);
        this.f34109h.set(dVar.f34109h);
        this.f34110i = dVar.f34110i;
        this.f34111j = dVar.f();
    }

    public void b(d dVar) {
        a(dVar);
    }

    public PointF[] c() {
        return new PointF[]{d(), e(), b(), a()};
    }

    public PointF d() {
        return new PointF(this.left, this.top);
    }

    public PointF e() {
        return new PointF(this.right, this.top);
    }

    public boolean f() {
        return this.f34111j;
    }

    public PointF b() {
        return new PointF(this.right, this.bottom);
    }

    public d(d dVar) {
        a(dVar);
    }

    public d(float f11, float f12, float f13, float f14) {
        super(f11, f12, f13, f14);
    }

    public PointF a() {
        return new PointF(this.left, this.bottom);
    }

    public void a(boolean z11) {
        this.f34111j = z11;
    }
}
