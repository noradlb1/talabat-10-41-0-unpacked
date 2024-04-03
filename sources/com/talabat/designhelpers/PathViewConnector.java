package com.talabat.designhelpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PathViewConnector extends View {

    /* renamed from: b  reason: collision with root package name */
    public Path f58264b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f58265c;

    public PathViewConnector(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f58264b, this.f58265c);
    }

    public PathViewConnector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PathViewConnector(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
