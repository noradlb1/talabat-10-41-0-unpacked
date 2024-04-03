package com.instabug.library.annotation.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.instabug.library.annotation.utility.c;

public class d extends f {
    public d(@ColorInt int i11, float f11, int i12) {
        super(i11, f11, i12);
    }

    private void c(Canvas canvas, com.instabug.library.annotation.d dVar) {
        canvas.drawPath(a(dVar), this.f34165k);
    }

    public void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        c.a(canvas, pointF, pointF2, this.f34163b);
        c.a(canvas, pointF, pointF4, this.f34163b);
        c.a(canvas, pointF2, pointF3, this.f34163b);
        c.a(canvas, pointF3, pointF4, this.f34163b);
    }

    public void b(com.instabug.library.annotation.d dVar) {
        com.instabug.library.annotation.d dVar2 = dVar;
        this.f34162m.reset();
        int i11 = this.f34161l;
        if (i11 == 0 || i11 == 180) {
            this.f34162m.addOval(dVar2, Path.Direction.CW);
            return;
        }
        PointF a11 = c.a(dVar2.f34106e, dVar2.f34107f);
        PointF a12 = c.a(dVar2.f34106e, a11);
        PointF a13 = c.a(dVar2.f34107f, a11);
        PointF a14 = c.a(dVar2.f34107f, dVar2.f34108g);
        PointF a15 = c.a(dVar2.f34107f, a14);
        PointF a16 = c.a(dVar2.f34108g, a14);
        PointF a17 = c.a(dVar2.f34108g, dVar2.f34109h);
        PointF a18 = c.a(dVar2.f34108g, a17);
        PointF a19 = c.a(dVar2.f34109h, a17);
        PointF a21 = c.a(dVar2.f34109h, dVar2.f34106e);
        PointF a22 = c.a(dVar2.f34109h, a21);
        PointF a23 = c.a(dVar2.f34106e, a21);
        this.f34162m.moveTo(a11.x, a11.y);
        PointF pointF = a11;
        this.f34162m.cubicTo(a13.x, a13.y, a15.x, a15.y, a14.x, a14.y);
        this.f34162m.cubicTo(a16.x, a16.y, a18.x, a18.y, a17.x, a17.y);
        this.f34162m.cubicTo(a19.x, a19.y, a22.x, a22.y, a21.x, a21.y);
        PointF pointF2 = pointF;
        this.f34162m.cubicTo(a23.x, a23.y, a12.x, a12.y, pointF2.x, pointF2.y);
        this.f34162m.close();
    }

    public void d(Canvas canvas, com.instabug.library.annotation.d dVar) {
        c(canvas, dVar);
    }
}
