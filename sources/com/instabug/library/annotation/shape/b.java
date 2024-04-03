package com.instabug.library.annotation.shape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.instabug.library.annotation.a;
import com.instabug.library.annotation.d;
import com.instabug.library.annotation.utility.c;
import com.instabug.library.settings.SettingsManager;

public class b extends c {

    /* renamed from: e  reason: collision with root package name */
    private final Context f34154e;

    public b(@Nullable Bitmap bitmap, Context context) {
        super(-65536);
        this.f34154e = context;
        if (bitmap != null) {
            this.f34155l = com.instabug.library.annotation.utility.b.a(bitmap, 18, context);
            a(true);
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public Path a(d dVar) {
        return null;
    }

    public void a(@Nullable Bitmap bitmap) {
        if (bitmap != null) {
            this.f34155l = com.instabug.library.annotation.utility.b.a(bitmap, 18, this.f34154e);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(Canvas canvas, Bitmap bitmap, float f11, float f12) {
        canvas.drawBitmap(bitmap, f11, f12, (Paint) null);
    }

    public void a(d dVar, d dVar2, boolean z11) {
        dVar2.b(dVar);
    }

    public void a(Canvas canvas, d dVar, a[] aVarArr) {
        PointF[] c11 = dVar.c();
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            aVarArr[i11].b(c11[i11]);
            aVarArr[i11].a(SettingsManager.getInstance().getPrimaryColor());
            aVarArr[i11].a(canvas);
        }
    }

    public void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        c.a(canvas, pointF, pointF2, this.f34163b);
        c.a(canvas, pointF, pointF4, this.f34163b);
        c.a(canvas, pointF2, pointF3, this.f34163b);
        c.a(canvas, pointF3, pointF4, this.f34163b);
    }
}
