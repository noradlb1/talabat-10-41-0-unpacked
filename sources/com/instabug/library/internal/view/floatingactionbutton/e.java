package com.instabug.library.internal.view.floatingactionbutton;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import androidx.core.view.ViewCompat;

class e extends Shape {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f51262b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f51263c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f51264d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f51265e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f51266f;

    public e(f fVar, float f11, float f12, float f13, float f14) {
        this.f51266f = fVar;
        this.f51262b = f11;
        this.f51263c = f12;
        this.f51264d = f13;
        this.f51265e = f14;
    }

    public void draw(Canvas canvas, Paint paint) {
        if (this.f51266f.f51267m) {
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(this.f51262b);
            float f11 = this.f51263c;
            canvas.drawCircle(f11, f11, this.f51264d / 2.0f, paint);
            return;
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(this.f51262b);
        paint.setStyle(Paint.Style.STROKE);
        float f12 = this.f51263c;
        canvas.drawCircle(f12, f12, this.f51264d / 2.0f, paint);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(this.f51262b);
        float f13 = this.f51262b;
        float f14 = this.f51265e;
        canvas.drawLine(0.0f, f13, f14, f14 + f13, paint);
    }
}
