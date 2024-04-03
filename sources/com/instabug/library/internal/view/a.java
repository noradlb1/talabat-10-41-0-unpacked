package com.instabug.library.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.TypedValue;
import android.widget.TextView;
import com.instabug.library.annotation.utility.c;

public class a extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private RectF f51237a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f51238b;

    /* renamed from: c  reason: collision with root package name */
    private float f51239c;

    /* renamed from: d  reason: collision with root package name */
    private PointF f51240d;

    /* renamed from: e  reason: collision with root package name */
    private PointF f51241e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f51242f;

    /* renamed from: g  reason: collision with root package name */
    private Path f51243g;

    /* renamed from: h  reason: collision with root package name */
    private float f51244h;

    public a(Context context) {
        super(context);
        a();
    }

    private void a() {
        setTextColor(-1);
        this.f51237a = new RectF();
        Paint paint = new Paint(1);
        this.f51238b = paint;
        paint.setColor(-12303292);
        this.f51238b.setStyle(Paint.Style.FILL);
        float applyDimension = TypedValue.applyDimension(1, 7.0f, getContext().getResources().getDisplayMetrics());
        this.f51239c = applyDimension;
        this.f51244h = applyDimension / 2.0f;
        int i11 = (int) applyDimension;
        double d11 = (double) applyDimension;
        double d12 = 1.5d * d11;
        setPadding((int) d12, i11, (int) (d12 + d11), i11);
        this.f51240d = new PointF();
        this.f51241e = new PointF();
        this.f51242f = new PointF();
        this.f51243g = new Path();
    }

    public void onDraw(Canvas canvas) {
        RectF rectF = this.f51237a;
        float f11 = this.f51244h;
        canvas.drawRoundRect(rectF, f11, f11, this.f51238b);
        canvas.drawPath(this.f51243g, this.f51238b);
        super.onDraw(canvas);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredHeight);
        RectF rectF = this.f51237a;
        float f11 = (float) measuredWidth;
        rectF.right = f11 - this.f51239c;
        rectF.bottom = (float) measuredHeight;
        PointF pointF = this.f51240d;
        pointF.x = f11;
        pointF.y = rectF.centerY();
        float cos = (float) (((double) this.f51239c) / Math.cos(45.0d));
        c.a(cos, 225.0f, this.f51240d, this.f51241e);
        c.a(cos, 135.0f, this.f51240d, this.f51242f);
        Path path = this.f51243g;
        PointF pointF2 = this.f51241e;
        path.moveTo(pointF2.x, pointF2.y);
        Path path2 = this.f51243g;
        PointF pointF3 = this.f51240d;
        path2.lineTo(pointF3.x, pointF3.y);
        Path path3 = this.f51243g;
        PointF pointF4 = this.f51242f;
        path3.lineTo(pointF4.x, pointF4.y);
        this.f51243g.close();
    }
}
