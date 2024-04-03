package com.instabug.library.annotation.shape;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.instabug.library.annotation.d;

public abstract class c extends g {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f34155l;

    public c(@ColorInt int i11) {
        super(i11, 0.0f);
    }

    public abstract void a(Canvas canvas, Bitmap bitmap, float f11, float f12);

    public void a(Canvas canvas, d dVar, d dVar2) {
        if (this.f34155l != null) {
            float f11 = dVar.left;
            float f12 = dVar.top;
            float width = dVar.width();
            float height = dVar.height();
            if (f11 < 0.0f) {
                width += f11;
                f11 = 0.0f;
            }
            if (f12 < 0.0f) {
                height += f12;
                f12 = 0.0f;
            }
            if (f11 + width > ((float) this.f34155l.getWidth())) {
                width = ((float) this.f34155l.getWidth()) - f11;
            }
            if (f12 + height > ((float) this.f34155l.getHeight())) {
                height = ((float) this.f34155l.getHeight()) - f12;
            }
            if (width > 0.0f && height > 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f34155l, (int) f11, (int) f12, (int) width, (int) height);
                float f13 = dVar.left;
                float f14 = dVar.top;
                if (f13 < 0.0f) {
                    f13 = dVar.right - ((float) createBitmap.getWidth());
                }
                if (dVar.top < 0.0f) {
                    f14 = dVar.bottom - ((float) createBitmap.getHeight());
                }
                a(canvas, createBitmap, f13, f14);
            }
        }
    }

    public boolean a(PointF pointF, d dVar) {
        RectF rectF = new RectF(dVar);
        float f11 = -(a() + 20.0f);
        rectF.inset(f11, f11);
        return rectF.contains((float) ((int) pointF.x), (float) ((int) pointF.y));
    }

    public void a(d dVar, d dVar2, int i11, int i12) {
        float f11 = (float) i11;
        dVar.left = dVar2.left + f11;
        float f12 = (float) i12;
        dVar.top = dVar2.top + f12;
        dVar.right = dVar2.right + f11;
        dVar.bottom = dVar2.bottom + f12;
    }
}
