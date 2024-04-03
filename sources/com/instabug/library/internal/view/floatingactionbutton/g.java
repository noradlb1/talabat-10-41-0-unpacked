package com.instabug.library.internal.view.floatingactionbutton;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

class g extends Shape {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f51268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f51269c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f51270d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f51271e;

    public g(i iVar, float f11, float f12, float f13) {
        this.f51271e = iVar;
        this.f51268b = f11;
        this.f51269c = f12;
        this.f51270d = f13;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(this.f51268b);
        float f11 = this.f51269c;
        canvas.drawCircle(f11, f11, this.f51270d / 2.0f, paint);
        if (this.f51271e.f51272m == h.RECORDING) {
            this.f51271e.a((String) null, false);
        } else {
            this.f51271e.a("", false);
        }
    }
}
