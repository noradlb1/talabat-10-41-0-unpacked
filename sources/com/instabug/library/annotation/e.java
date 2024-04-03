package com.instabug.library.annotation;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.instabug.library.annotation.shape.a;
import com.instabug.library.annotation.shape.g;
import java.io.Serializable;
import java.util.Stack;

public class e implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public volatile g f34112b;

    /* renamed from: c  reason: collision with root package name */
    public g f34113c;

    /* renamed from: d  reason: collision with root package name */
    public d f34114d = new d();

    /* renamed from: e  reason: collision with root package name */
    private Stack f34115e = new Stack();

    /* renamed from: f  reason: collision with root package name */
    public d f34116f = new d();

    public e(g gVar) {
        this.f34112b = gVar;
        this.f34113c = gVar;
    }

    public boolean a(PointF pointF) {
        if (this.f34116f.f()) {
            return this.f34112b.a(pointF, this.f34114d);
        }
        return false;
    }

    public g b() {
        return this.f34112b;
    }

    public void c(d dVar) {
        this.f34114d = dVar;
        this.f34116f.b(dVar);
    }

    public void d() {
        a(new d(this.f34114d));
    }

    public void b(d dVar) {
        this.f34112b.a(dVar, this.f34114d, false);
    }

    private void a(d dVar) {
        if (this.f34116f != null) {
            this.f34115e.push(new d(this.f34116f));
        }
        this.f34116f = dVar;
    }

    public void b(Canvas canvas) {
        this.f34112b.a(canvas, this.f34114d.d(), this.f34114d.e(), this.f34114d.b(), this.f34114d.a());
    }

    public void c(Canvas canvas) {
        if (this.f34116f.f()) {
            canvas.save();
            this.f34112b.a(canvas, this.f34114d, this.f34116f);
            canvas.restore();
        }
    }

    public void a(boolean z11) {
        d dVar = new d(this.f34114d);
        dVar.a(z11);
        a(dVar);
    }

    public boolean c() {
        return this.f34116f.f();
    }

    public boolean a() {
        if (this.f34115e.size() <= 0) {
            return false;
        }
        this.f34116f = (d) this.f34115e.pop();
        if (this.f34115e.size() == 0) {
            this.f34112b = this.f34113c;
        }
        this.f34112b.a(this.f34116f, this.f34114d, true);
        return true;
    }

    public void a(int i11, int i12) {
        this.f34112b.a(this.f34114d, this.f34116f, i11, i12);
    }

    public void a(Canvas canvas, a... aVarArr) {
        this.f34112b.a(canvas, this.f34114d, aVarArr);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(g gVar, d dVar) {
        a(new d(dVar));
        this.f34112b = gVar;
        if (gVar instanceof a) {
            this.f34114d = dVar;
        }
    }
}
