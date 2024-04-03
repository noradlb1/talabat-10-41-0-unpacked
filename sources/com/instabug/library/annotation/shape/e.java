package com.instabug.library.annotation.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.instabug.library.annotation.d;
import com.instabug.library.annotation.utility.c;
import java.util.List;

public class e extends f {

    /* renamed from: f  reason: collision with root package name */
    private final RectF f34156f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f34157g;

    /* renamed from: h  reason: collision with root package name */
    private Path f34158h;

    /* renamed from: i  reason: collision with root package name */
    private Matrix f34159i = new Matrix();

    /* renamed from: j  reason: collision with root package name */
    private List f34160j;

    public e(Path path, float f11, Paint paint, List list) {
        super(paint.getColor(), f11, 0);
        this.f34158h = path;
        this.f34157g = new Paint(paint);
        this.f34160j = list;
        RectF rectF = new RectF();
        this.f34156f = rectF;
        path.computeBounds(rectF, true);
    }

    public void a(Canvas canvas, d dVar, d dVar2) {
        this.f34159i.reset();
        Path path = new Path(this.f34158h);
        this.f34159i.setRectToRect(this.f34156f, new RectF(dVar), Matrix.ScaleToFit.FILL);
        path.transform(this.f34159i);
        canvas.drawPath(path, this.f34157g);
    }

    public boolean a(PointF pointF, d dVar) {
        float f11 = pointF.x;
        float f12 = pointF.y;
        RectF rectF = new RectF(f11 - 50.0f, f12 - 50.0f, f11 + 50.0f, f12 + 50.0f);
        for (PointF pointF2 : this.f34160j) {
            float[] fArr = {pointF2.x, pointF2.y};
            float[] fArr2 = new float[2];
            this.f34159i.mapPoints(fArr2, fArr);
            if (rectF.contains(fArr2[0], fArr2[1])) {
                return true;
            }
        }
        return false;
    }

    public void a(d dVar, d dVar2, boolean z11) {
        if (Math.abs(dVar2.width() - dVar.width()) >= 1.0f || Math.abs(dVar2.height() - dVar.height()) >= 1.0f) {
            float max = Math.max(dVar.width() / dVar2.width(), dVar.height() / dVar2.height());
            Matrix matrix = new Matrix();
            matrix.postScale(max, max, dVar2.centerX(), dVar2.centerY());
            matrix.mapRect(dVar2);
            return;
        }
        dVar2.b(dVar);
    }

    public void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        c.a(canvas, pointF, pointF2, this.f34163b);
        c.a(canvas, pointF, pointF4, this.f34163b);
        c.a(canvas, pointF2, pointF3, this.f34163b);
        c.a(canvas, pointF3, pointF4, this.f34163b);
    }
}
