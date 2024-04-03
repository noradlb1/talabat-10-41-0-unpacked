package com.instabug.library.annotation.shape;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.annotation.Nullable;
import com.instabug.library.annotation.a;
import com.instabug.library.annotation.d;
import com.instabug.library.annotation.utility.b;
import com.instabug.library.annotation.utility.c;
import com.instabug.library.settings.SettingsManager;

public class h extends c {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private PointF f34166e;

    /* renamed from: f  reason: collision with root package name */
    private float f34167f;

    /* renamed from: g  reason: collision with root package name */
    private float f34168g;

    /* renamed from: h  reason: collision with root package name */
    private float f34169h;

    public h(@Nullable Bitmap bitmap) {
        super(-65536);
        this.f34155l = bitmap;
        a(true);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public Path a(d dVar) {
        return null;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f34155l = bitmap;
    }

    public void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(Canvas canvas, Bitmap bitmap, float f11, float f12) {
        this.f34169h = (float) Math.min(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        this.f34167f = (((float) bitmap.getWidth()) / 2.0f) + f11;
        this.f34168g = (((float) bitmap.getHeight()) / 2.0f) + f12;
        this.f34166e = c.a(this.f34169h, 45.0f, new PointF(this.f34167f, this.f34168g));
        canvas.drawBitmap(b.a(b.a(bitmap, 200)), f11, f12, (Paint) null);
    }

    public boolean a(PointF pointF, d dVar) {
        Region region = new Region();
        RectF rectF = new RectF();
        Path path = new Path();
        path.addCircle(this.f34167f, this.f34168g, this.f34169h, Path.Direction.CW);
        path.computeBounds(rectF, true);
        region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains((int) pointF.x, (int) pointF.y);
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

    public void a(Canvas canvas, d dVar, a[] aVarArr) {
        PointF pointF = this.f34166e;
        if (pointF == null) {
            pointF = dVar.b();
        }
        aVarArr[2].b(pointF);
        aVarArr[2].a(SettingsManager.getInstance().getPrimaryColor());
        aVarArr[2].a(canvas);
    }
}
