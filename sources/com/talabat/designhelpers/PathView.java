package com.talabat.designhelpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PathView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Path f58262b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f58263c;

    public PathView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f58262b, this.f58263c);
    }

    public PathView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PathView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
