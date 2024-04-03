package com.instabug.library.internal.view.floatingactionbutton;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;

class j extends Shape {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f51276b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f51277c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f51278d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f51279e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k f51280f;

    public j(k kVar, float f11, float f12, float f13, float f14) {
        this.f51280f = kVar;
        this.f51276b = f11;
        this.f51277c = f12;
        this.f51278d = f13;
        this.f51279e = f14;
    }

    public void draw(Canvas canvas, Paint paint) {
        if (this.f51280f.isEnabled()) {
            paint.setColor(-65536);
        } else {
            paint.setColor(Color.parseColor("#D1D1D6"));
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f51276b);
        float f11 = this.f51277c;
        canvas.drawCircle(f11, f11, this.f51278d / 2.0f, paint);
        paint.setStyle(Paint.Style.FILL);
        float f12 = this.f51279e;
        RectF rectF = new RectF(0.0f, 0.0f, f12, f12);
        float f13 = this.f51276b / 2.0f;
        rectF.inset(f13, f13);
        canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
    }
}
