package com.uxcam.internals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import org.jetbrains.annotations.NotNull;

public final class cd {

    /* renamed from: a  reason: collision with root package name */
    public final cc f13115a;

    public cd(@NotNull cc ccVar) {
        this.f13115a = ccVar;
    }

    public final void a(Canvas canvas, cb cbVar) {
        View view = cbVar.f13108a;
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            Rect rect = cbVar.f13109b;
            Bitmap createBitmap = Bitmap.createBitmap(rect.right - rect.left, rect.bottom - rect.top, Bitmap.Config.ARGB_8888);
            cbVar.f13108a.draw(new Canvas(createBitmap));
            Rect rect2 = cbVar.f13109b;
            canvas.drawBitmap(createBitmap, (float) rect2.left, (float) rect2.top, new Paint());
            createBitmap.recycle();
        }
    }
}
