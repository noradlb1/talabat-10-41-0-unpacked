package com.instabug.survey.ui.custom;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AttrResolver;
import com.instabug.survey.R;
import java.util.ArrayList;
import wd.a;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public abstract class e extends View {
    @NonNull
    public Path A;
    @NonNull
    public Path B;
    @NonNull
    public CornerPathEffect C;
    @NonNull
    public CornerPathEffect D;
    public float E;
    public float F;
    public float H;

    /* renamed from: b  reason: collision with root package name */
    public int f52443b;

    /* renamed from: c  reason: collision with root package name */
    public int f52444c;

    /* renamed from: d  reason: collision with root package name */
    public int f52445d = 11;

    /* renamed from: e  reason: collision with root package name */
    public int f52446e = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52447f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f52448g = -1;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private d f52449h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52450i = false;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f52451j = new ArrayList();
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    public int f52452k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    public int f52453l;
    @ColorInt

    /* renamed from: m  reason: collision with root package name */
    public int f52454m;
    @ColorInt

    /* renamed from: n  reason: collision with root package name */
    public int f52455n;
    @ColorInt

    /* renamed from: o  reason: collision with root package name */
    public int f52456o;
    @ColorInt

    /* renamed from: p  reason: collision with root package name */
    public int f52457p;
    @ColorInt

    /* renamed from: q  reason: collision with root package name */
    public int f52458q;
    @ColorInt

    /* renamed from: r  reason: collision with root package name */
    public int f52459r;
    @ColorInt

    /* renamed from: s  reason: collision with root package name */
    public int f52460s;
    @ColorInt

    /* renamed from: t  reason: collision with root package name */
    public int f52461t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    public Paint f52462u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public Paint f52463v;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public Paint f52464w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public Paint f52465x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    public Paint f52466y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    public Path f52467z;

    public e(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet);
    }

    public e(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(attributeSet);
    }

    @TargetApi(21)
    public e(Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        e(attributeSet);
    }

    public static float a(Context context, float f11) {
        return f11 * context.getResources().getDisplayMetrics().density;
    }

    private void a(Canvas canvas) {
        this.f52463v.setStrokeWidth(a(getContext(), 2.0f));
        this.f52463v.setStyle(Paint.Style.STROKE);
        this.f52463v.setColor(getBorderColor());
        this.f52463v.setPathEffect(this.D);
        canvas.drawRect((float) this.f52458q, (float) Math.floor(((double) this.f52460s) / 1.7d), (float) (getWidth() - this.f52458q), (float) this.f52460s, this.f52463v);
    }

    public static float b(Context context, float f11) {
        return f11 / context.getResources().getDisplayMetrics().density;
    }

    private void b() {
        this.f52447f = true;
        invalidate();
    }

    private void b(float f11, float f12) {
        int i11 = 0;
        this.f52447f = false;
        int i12 = this.f52446e;
        if (i12 == -1 || !((Rect) this.f52451j.get(i12)).contains((int) f11, (int) f12)) {
            while (i11 < this.f52445d) {
                if (this.f52451j.size() <= i11 || !((Rect) this.f52451j.get(i11)).contains((int) f11, (int) f12)) {
                    i11++;
                } else if (this.f52446e != i11) {
                    if (this.f52450i) {
                        this.f52448g = 10 - i11;
                    } else {
                        this.f52448g = i11;
                    }
                    this.f52446e = i11;
                    invalidate();
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private void c() {
        d dVar = this.f52449h;
        if (dVar != null) {
            dVar.c(this.f52448g);
        }
    }

    private void e(Canvas canvas) {
        if (this.f52446e != -1) {
            this.A.reset();
            this.f52464w.setColor(getIndicatorViewBackgroundColor());
            this.f52464w.setPathEffect(this.C);
            float f11 = (float) ((Rect) this.f52451j.get(this.f52446e)).left;
            float f12 = (float) ((Rect) this.f52451j.get(this.f52446e)).right;
            float f13 = (float) ((Rect) this.f52451j.get(this.f52446e)).top;
            int i11 = this.f52459r;
            int i12 = this.f52461t;
            if (i11 > i12) {
                float f14 = ((float) (i11 - i12)) / 2.0f;
                f11 += f14;
                f12 -= f14;
            }
            float f15 = (float) this.f52458q;
            float f16 = f11 - f15;
            float f17 = f15 + f12;
            this.A.moveTo(f16, f13);
            this.A.lineTo(f16, ((float) this.f52460s) / 1.7f);
            this.A.lineTo(f11, (((float) this.f52460s) / 1.7f) + ((float) this.f52458q));
            this.A.lineTo(f11, (float) this.f52460s);
            this.A.lineTo(f12, (float) this.f52460s);
            this.A.lineTo(f12, (((float) this.f52460s) / 1.7f) + ((float) this.f52458q));
            this.A.lineTo(f17, ((float) this.f52460s) / 1.7f);
            this.A.lineTo(f17, 0.0f);
            this.A.close();
            canvas.drawPath(this.A, this.f52464w);
            this.f52466y.setColor(getIndicatorViewTextColor());
            this.f52466y.setTextAlign(Paint.Align.CENTER);
            this.f52466y.setTextSize(this.F);
            this.f52466y.setTypeface(Typeface.defaultFromStyle(1));
            canvas.drawText(String.valueOf(this.f52448g), f11 + ((f12 - f11) / 2.0f), (((float) this.f52460s) / 1.7f) / 1.5f, this.f52466y);
        }
    }

    public int a(float f11, float f12) {
        for (int i11 = 0; i11 < this.f52451j.size(); i11++) {
            Rect rect = (Rect) this.f52451j.get(i11);
            if (rect != null && rect.contains((int) f11, (int) f12)) {
                return i11;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    public Rect a(int i11) {
        Rect rect = new Rect((Rect) this.f52451j.get(i11));
        rect.top = (int) Math.floor(((double) this.f52460s) / 1.7d);
        return rect;
    }

    public void a(@IntRange(from = 0, to = 11) int i11, boolean z11) {
        setScore(i11);
        if (z11) {
            c();
        }
    }

    public abstract void d();

    public void e(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.NpsView);
            this.f52445d = obtainStyledAttributes.getInt(R.styleable.NpsView_nps_count, 11);
            this.E = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.NpsView_nps_num_text_size, (int) b(getContext(), 40.0f));
            this.f52458q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NpsView_nps_selected_view_edge_size, (int) b(getContext(), 30.0f));
            this.F = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.NpsView_nps_selected_num_text_size, (int) b(getContext(), 20.0f));
            this.f52461t = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NpsView_nps_selected_rect_size, (int) b(getContext(), 100.0f));
            this.H = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.NpsView_nps_rect_corners_radius, 2);
            if (this.f52445d == 0) {
                this.f52445d = 1;
            }
            setCirclesRectColor(AttrResolver.resolveAttributeColor(getContext(), R.attr.survey_nps_circles_container_background));
            setBorderColor(AttrResolver.resolveAttributeColor(getContext(), R.attr.survey_nps_circles_container_border_background));
            setNumbersColor(AttrResolver.resolveAttributeColor(getContext(), R.attr.survey_nps_numbers_color));
            if (!isInEditMode()) {
                setIndicatorViewBackgroundColor(InstabugCore.getPrimaryColor());
            }
            setIndicatorViewTextColor(-1);
            setIndicatorViewCircleColor(-1);
            obtainStyledAttributes.recycle();
            this.A = new Path();
            this.B = new Path();
            this.f52467z = new Path();
            this.f52463v = new Paint(1);
            this.f52462u = new TextPaint(1);
            this.f52464w = new Paint(1);
            this.f52465x = new Paint(1);
            this.f52466y = new TextPaint(1);
            this.C = new CornerPathEffect(a(getContext(), 4.0f));
            this.D = new CornerPathEffect(this.H);
            b bVar = new b(new c(this));
            ViewCompat.setAccessibilityDelegate(this, bVar);
            setOnHoverListener(new a(bVar));
        }
    }

    public abstract void f(Canvas canvas);

    public abstract void g(Canvas canvas);

    public int getBorderColor() {
        return this.f52453l;
    }

    public int getCirclesRectColor() {
        return this.f52452k;
    }

    public int getIndicatorViewBackgroundColor() {
        return this.f52454m;
    }

    public int getIndicatorViewCircleColor() {
        return this.f52457p;
    }

    public int getIndicatorViewTextColor() {
        return this.f52456o;
    }

    public int getNumbersColor() {
        return this.f52455n;
    }

    public int getScore() {
        return this.f52446e;
    }

    public abstract void h(Canvas canvas);

    public abstract boolean i();

    public abstract boolean j();

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean z11 = true;
        if (getLayoutDirection() != 1) {
            z11 = false;
        }
        this.f52450i = z11;
        d();
        g(canvas);
        if (j()) {
            a(canvas);
        }
        f(canvas);
        if (this.f52447f) {
            h(canvas);
        } else if (i()) {
            e(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            super.onMeasure(r6, r7)
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 != r3) goto L_0x001c
        L_0x0019:
            r5.f52443b = r6
            goto L_0x0027
        L_0x001c:
            r4 = 500(0x1f4, float:7.0E-43)
            if (r0 != r2) goto L_0x0025
            int r6 = java.lang.Math.min(r4, r6)
            goto L_0x0019
        L_0x0025:
            r5.f52443b = r4
        L_0x0027:
            if (r1 != r3) goto L_0x002c
            r5.f52444c = r7
            goto L_0x0036
        L_0x002c:
            r6 = 280(0x118, float:3.92E-43)
            if (r0 != r2) goto L_0x0034
            int r6 = java.lang.Math.min(r6, r7)
        L_0x0034:
            r5.f52444c = r6
        L_0x0036:
            android.content.Context r6 = r5.getContext()
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            float r6 = r6.fontScale
            int r7 = r5.f52444c
            float r7 = (float) r7
            float r7 = r7 * r6
            int r6 = java.lang.Math.round(r7)
            int r7 = r5.f52443b
            int r7 = java.lang.Math.abs(r7)
            r5.f52443b = r7
            int r6 = java.lang.Math.abs(r6)
            r5.f52444c = r6
            int r7 = r6 + -2
            r5.f52460s = r7
            int r7 = r5.f52443b
            r5.setMeasuredDimension(r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.custom.e.onMeasure(int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r5 != 6) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            float r1 = r5.getY()
            int r5 = r5.getActionMasked()
            r2 = 1
            if (r5 == 0) goto L_0x0029
            if (r5 == r2) goto L_0x0022
            r3 = 2
            if (r5 == r3) goto L_0x001e
            r3 = 3
            if (r5 == r3) goto L_0x0022
            r3 = 5
            if (r5 == r3) goto L_0x0029
            r0 = 6
            if (r5 == r0) goto L_0x0022
            goto L_0x003b
        L_0x001e:
            r4.b((float) r0, (float) r1)
            goto L_0x003b
        L_0x0022:
            r4.b()
            r4.c()
            goto L_0x003b
        L_0x0029:
            r4.b((float) r0, (float) r1)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "onTouchEvent: NPS view touch rect : "
            r5.append(r0)
            int r0 = r4.f52446e
            r5.append(r0)
        L_0x003b:
            r4.invalidate()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.custom.e.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBorderColor(@ColorInt int i11) {
        this.f52453l = i11;
    }

    public void setCirclesRectColor(int i11) {
        this.f52452k = i11;
    }

    public void setIndicatorViewBackgroundColor(@ColorInt int i11) {
        this.f52454m = i11;
    }

    public void setIndicatorViewCircleColor(int i11) {
        this.f52457p = i11;
    }

    public void setIndicatorViewTextColor(int i11) {
        this.f52456o = i11;
    }

    public void setNumbersColor(@ColorInt int i11) {
        this.f52455n = i11;
    }

    public void setOnSelectionListener(@NonNull d dVar) {
        this.f52449h = dVar;
    }

    public void setScore(@IntRange(from = 0, to = 11) int i11) {
        this.f52446e = i11;
        this.f52448g = i11;
        this.f52447f = true;
        postInvalidate();
    }
}
