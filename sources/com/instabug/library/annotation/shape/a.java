package com.instabug.library.annotation.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.instabug.library.annotation.b;
import com.instabug.library.annotation.d;
import com.instabug.library.annotation.utility.c;

public class a extends g {

    /* renamed from: d  reason: collision with root package name */
    private final Paint f34149d;

    /* renamed from: e  reason: collision with root package name */
    private PointF f34150e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f34151f;

    /* renamed from: g  reason: collision with root package name */
    private float f34152g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private String f34153h;

    public a(PointF pointF, PointF pointF2, @ColorInt int i11, float f11) {
        super(i11, f11);
        Paint paint = new Paint(1);
        this.f34149d = paint;
        paint.setColor(i11);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f11);
        this.f34150e = pointF;
        this.f34151f = pointF2;
    }

    public void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
    }

    public void a(@Nullable String str) {
        this.f34153h = str;
    }

    public void b(float f11, float f12, d dVar) {
        this.f34150e.set(f11, f12);
        b(dVar);
    }

    public void c(d dVar) {
        float max = Math.max(dVar.width(), dVar.height()) / 2.0f;
        float centerX = dVar.centerX() + max;
        PointF pointF = new PointF(dVar.centerX() - max, dVar.centerY());
        PointF pointF2 = new PointF(centerX, dVar.centerY());
        this.f34150e = c.a(dVar.centerX(), dVar.centerY(), this.f34152g, pointF);
        this.f34151f = c.a(dVar.centerX(), dVar.centerY(), this.f34152g, pointF2);
    }

    public void a(Canvas canvas, d dVar, d dVar2) {
        b bVar = dVar.f34102a;
        b bVar2 = b.RIGHT;
        if (bVar == bVar2) {
            this.f34150e.x = dVar.right;
        } else if (bVar == b.LEFT) {
            this.f34150e.x = dVar.left;
        }
        com.instabug.library.annotation.c cVar = dVar.f34103b;
        com.instabug.library.annotation.c cVar2 = com.instabug.library.annotation.c.TOP;
        if (cVar == cVar2) {
            this.f34150e.y = dVar.top;
        } else if (cVar == com.instabug.library.annotation.c.BOTTOM) {
            this.f34150e.y = dVar.bottom;
        }
        b bVar3 = dVar.f34104c;
        if (bVar3 == bVar2) {
            this.f34151f.x = dVar.right;
        } else if (bVar3 == b.LEFT) {
            this.f34151f.x = dVar.left;
        }
        com.instabug.library.annotation.c cVar3 = dVar.f34105d;
        if (cVar3 == cVar2) {
            this.f34151f.y = dVar.top;
        } else if (cVar3 == com.instabug.library.annotation.c.BOTTOM) {
            this.f34151f.y = dVar.bottom;
        }
        canvas.drawPath(a(dVar), this.f34149d);
    }

    private void b(d dVar) {
        PointF pointF = this.f34150e;
        float f11 = pointF.x;
        PointF pointF2 = this.f34151f;
        float f12 = pointF2.x;
        if (f11 < f12) {
            dVar.left = f11;
            dVar.right = f12;
            dVar.f34102a = b.LEFT;
            dVar.f34104c = b.RIGHT;
        } else {
            dVar.right = f11;
            dVar.left = f12;
            dVar.f34102a = b.RIGHT;
            dVar.f34104c = b.LEFT;
        }
        float f13 = pointF.y;
        float f14 = pointF2.y;
        if (f13 < f14) {
            dVar.top = f13;
            dVar.bottom = f14;
            dVar.f34103b = com.instabug.library.annotation.c.TOP;
            dVar.f34105d = com.instabug.library.annotation.c.BOTTOM;
            return;
        }
        dVar.bottom = f13;
        dVar.top = f14;
        dVar.f34103b = com.instabug.library.annotation.c.BOTTOM;
        dVar.f34105d = com.instabug.library.annotation.c.TOP;
    }

    public boolean a(PointF pointF, d dVar) {
        b(dVar);
        PointF pointF2 = this.f34151f;
        float f11 = pointF2.x;
        float f12 = pointF2.y;
        PointF pointF3 = this.f34150e;
        float a11 = c.a(f11, f12, pointF3.x, pointF3.y);
        float f13 = 90.0f + a11;
        PointF a12 = c.a(60.0f, f13, this.f34150e);
        float f14 = a11 + 270.0f;
        PointF a13 = c.a(60.0f, f14, this.f34150e);
        PointF a14 = c.a(60.0f, f14, this.f34151f);
        PointF a15 = c.a(60.0f, f13, this.f34151f);
        Region region = new Region();
        RectF rectF = new RectF();
        Path path = new Path();
        path.moveTo(a12.x, a12.y);
        path.lineTo(a13.x, a13.y);
        path.lineTo(a14.x, a14.y);
        path.lineTo(a15.x, a15.y);
        path.close();
        path.computeBounds(rectF, true);
        region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains((int) pointF.x, (int) pointF.y);
    }

    public void a(d dVar, d dVar2, boolean z11) {
        dVar2.b(dVar);
    }

    public void a(float f11, float f12, d dVar) {
        this.f34151f.set(f11, f12);
        b(dVar);
    }

    public void a(Canvas canvas, d dVar, com.instabug.library.annotation.a[] aVarArr) {
        int color = this.f34149d.getColor();
        aVarArr[0].b(this.f34150e);
        aVarArr[1].b(this.f34151f);
        for (int i11 = 0; i11 < 2; i11++) {
            aVarArr[i11].a(color);
            aVarArr[i11].a(canvas);
        }
    }

    public void a(d dVar, d dVar2, int i11, int i12) {
        float f11 = (float) i11;
        dVar.left = dVar2.left + f11;
        float f12 = (float) i12;
        dVar.top = dVar2.top + f12;
        dVar.right = dVar2.right + f11;
        dVar.bottom = dVar2.bottom + f12;
    }

    public Path a(d dVar) {
        Path path = new Path();
        PointF pointF = this.f34151f;
        float f11 = pointF.x;
        float f12 = pointF.y;
        PointF pointF2 = this.f34150e;
        float a11 = c.a(f11, f12, pointF2.x, pointF2.y);
        PointF a12 = c.a(60.0f, 225.0f + a11, this.f34151f);
        PointF a13 = c.a(60.0f, a11 + 135.0f, this.f34151f);
        PointF pointF3 = this.f34150e;
        path.moveTo(pointF3.x, pointF3.y);
        PointF pointF4 = this.f34151f;
        path.lineTo(pointF4.x + 1.0f, pointF4.y + 1.0f);
        if ("arrow".equals(this.f34153h)) {
            path.moveTo(a12.x, a12.y);
            PointF pointF5 = this.f34151f;
            path.lineTo(pointF5.x, pointF5.y);
            path.lineTo(a13.x, a13.y);
        }
        return path;
    }

    public void a(int i11) {
        this.f34152g = (float) i11;
    }
}
