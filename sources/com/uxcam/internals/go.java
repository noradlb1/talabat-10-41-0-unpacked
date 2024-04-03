package com.uxcam.internals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.uxcam.internals.gs;

public class go implements gs.ac {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f13484a;

    /* renamed from: b  reason: collision with root package name */
    public int f13485b = 0;

    public go() {
        Paint paint = new Paint();
        this.f13484a = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextSize(22.0f);
    }

    public boolean a(Canvas canvas, long j11, long j12) {
        Bitmap bitmap;
        this.f13484a.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f13484a);
        al a11 = al.a();
        if (a11.f12999a.isEmpty()) {
            bitmap = null;
        } else {
            bitmap = a11.f12999a.remove();
        }
        if (bitmap == null) {
            bitmap = al.a().f13000b;
        }
        boolean z11 = true;
        if (bitmap != null) {
            this.f13485b++;
            bitmap.getByteCount();
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            z11 = false;
        }
        if (!z11) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        return fn.f13378i;
    }
}
