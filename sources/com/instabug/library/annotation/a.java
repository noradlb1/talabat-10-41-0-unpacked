package com.instabug.library.annotation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f34099a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private PointF f34100b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private int f34101c;

    public void a(int i11) {
        this.f34101c = i11;
    }

    public void b(PointF pointF) {
        this.f34100b = pointF;
    }

    public void a(float f11, float f12) {
        this.f34100b = new PointF(f11, f12);
    }

    public boolean a(PointF pointF) {
        PointF pointF2 = this.f34100b;
        float f11 = pointF2.x - pointF.x;
        float f12 = pointF2.y - pointF.y;
        return (f11 * f11) + (f12 * f12) <= 1764.0f;
    }

    public void a(Canvas canvas) {
        this.f34099a.setColor(this.f34101c);
        this.f34099a.setStyle(Paint.Style.FILL);
        PointF pointF = this.f34100b;
        canvas.drawCircle(pointF.x, pointF.y, 12.0f, this.f34099a);
        this.f34099a.setColor(-1);
        this.f34099a.setStyle(Paint.Style.STROKE);
        this.f34099a.setStrokeWidth(2.0f);
        PointF pointF2 = this.f34100b;
        canvas.drawCircle(pointF2.x, pointF2.y, 12.0f, this.f34099a);
    }
}
