package com.instabug.library.annotation.shape;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.instabug.library.annotation.a;
import com.instabug.library.annotation.d;
import java.io.Serializable;

public abstract class g implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f34163b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34164c = false;

    /* renamed from: k  reason: collision with root package name */
    public Paint f34165k;

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public g(@ColorInt int i11, float f11) {
        Paint paint = new Paint(1);
        this.f34165k = paint;
        paint.setColor(i11);
        this.f34165k.setStyle(Paint.Style.STROKE);
        this.f34165k.setStrokeWidth(f11);
        this.f34165k.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint(1);
        this.f34163b = paint2;
        paint2.setColor(Integer.MIN_VALUE);
    }

    public float a() {
        return this.f34165k.getStrokeWidth();
    }

    public abstract Path a(d dVar);

    public abstract void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4);

    public abstract void a(Canvas canvas, d dVar, d dVar2);

    public abstract void a(Canvas canvas, d dVar, a[] aVarArr);

    public abstract void a(d dVar, d dVar2, int i11, int i12);

    public abstract void a(d dVar, d dVar2, boolean z11);

    public abstract boolean a(PointF pointF, d dVar);

    public boolean b() {
        return this.f34164c;
    }

    public void a(boolean z11) {
        this.f34164c = z11;
    }
}
