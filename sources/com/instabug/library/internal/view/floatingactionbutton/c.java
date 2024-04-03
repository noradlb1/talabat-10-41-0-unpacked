package com.instabug.library.internal.view.floatingactionbutton;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

class c extends LayerDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final int f51250a;

    public c(int i11, Drawable... drawableArr) {
        super(drawableArr);
        this.f51250a = i11;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f51250a, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
