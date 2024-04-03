package com.instabug.survey.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.survey.R;
import wd.b;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public abstract class j extends View {
    private Paint A;
    private Paint B;
    private Paint C;
    private float D;
    private int E = 5;
    private float F = 2.14748365E9f;
    private float G = 2.14748365E9f;
    private float H = ((float) ((int) c(4.0f, 0)));
    private final Rect[] I = new Rect[5];
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int f52473a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private int f52474b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f52475c;
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    private int f52476d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    private int f52477e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int f52478f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private int f52479g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    private int f52480h;

    /* renamed from: i  reason: collision with root package name */
    private float f52481i;

    /* renamed from: j  reason: collision with root package name */
    private float f52482j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private f f52483k;

    /* renamed from: l  reason: collision with root package name */
    private float f52484l;

    /* renamed from: m  reason: collision with root package name */
    private float f52485m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f52486n;

    /* renamed from: o  reason: collision with root package name */
    private float f52487o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private g f52488p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private View.OnClickListener f52489q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f52490r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private float[] f52491s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private RectF f52492t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private RectF f52493u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private Canvas f52494v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private Bitmap f52495w;

    /* renamed from: x  reason: collision with root package name */
    private Path f52496x;

    /* renamed from: y  reason: collision with root package name */
    private Paint f52497y;

    /* renamed from: z  reason: collision with root package name */
    private CornerPathEffect f52498z;

    public j(Context context) {
        super(context);
        b();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        b();
    }

    public j(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
        b();
    }

    private float a(float f11) {
        if (f11 < 0.0f) {
            Log.w("RatingView", String.format("Assigned rating is less than 0 (%f < 0), I will set it to exactly 0", new Object[]{Float.valueOf(f11)}));
            return 0.0f;
        } else if (f11 <= ((float) this.E)) {
            return f11;
        } else {
            Log.w("RatingView", String.format("Assigned rating is greater than numberOfStars (%f > %d), I will set it to exactly numberOfStars", new Object[]{Float.valueOf(f11), Integer.valueOf(this.E)}));
            return (float) this.E;
        }
    }

    private float a(int i11, int i12) {
        float f11 = this.G;
        if (f11 != 2.14748365E9f) {
            float a11 = (float) a(this.G, this.E, this.H, true);
            if (((float) b(f11, this.E, this.H, true)) < ((float) i11) && a11 < ((float) i12)) {
                return this.G;
            }
        }
        float f12 = this.H;
        int i13 = this.E;
        return Math.min((((float) ((i11 - getPaddingLeft()) - getPaddingRight())) - (f12 * ((float) (i13 - 1)))) / ((float) i13), (float) ((i12 - getPaddingTop()) - getPaddingBottom()));
    }

    private int a(float f11, int i11, float f12, boolean z11) {
        return Math.round(f11) + (z11 ? getPaddingTop() + getPaddingBottom() : 0);
    }

    private void a() {
        int i11;
        Resources resources;
        this.f52473a = getResources().getColor(R.color.survey_rate_star_border);
        this.f52474b = getResources().getColor(R.color.survey_rate_selected);
        if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            resources = getResources();
            i11 = R.color.survey_rate_unselected_light;
        } else {
            resources = getResources();
            i11 = R.color.survey_rate_unselected_dark;
        }
        int color = resources.getColor(i11);
        this.f52476d = color;
        this.f52475c = 0;
        this.f52477e = this.f52473a;
        this.f52478f = this.f52474b;
        this.f52480h = color;
        this.f52479g = 0;
        this.E = 5;
        this.H = (float) ((int) c(16.0f, 0));
        this.G = (float) ((int) c(InstabugDeviceProperties.isTablet(getContext()) ? 80.0f : 52.0f, 0));
        this.F = 2.14748365E9f;
        this.f52481i = 1.0f;
        this.f52484l = getStarBorderWidth();
        this.f52485m = getStarCornerRadius();
        this.f52482j = 0.0f;
        this.f52486n = d();
        this.f52483k = f.a(f.Left.f52471e);
    }

    private void a(Canvas canvas) {
        float f11 = this.f52482j;
        RectF rectF = this.f52492t;
        if (rectF != null) {
            float f12 = rectF.left;
            float f13 = rectF.top;
            float f14 = f11;
            for (int i11 = 0; i11 < this.E; i11++) {
                int i12 = (f14 > 1.0f ? 1 : (f14 == 1.0f ? 0 : -1));
                f fVar = f.Left;
                if (i12 >= 0) {
                    a(canvas, f12, f13, 1.0f, fVar);
                    f14 -= 1.0f;
                } else {
                    a(canvas, f12, f13, f14, fVar);
                    if (this.f52486n) {
                        canvas.drawPath(this.f52496x, this.A);
                    }
                    f14 = 0.0f;
                }
                f12 += this.H + this.f52487o;
            }
        }
    }

    private void a(Canvas canvas, float f11, float f12, float f13, f fVar) {
        float f14 = this.f52487o * f13;
        if (this.f52491s != null) {
            this.f52496x.reset();
            Path path = this.f52496x;
            float[] fArr = this.f52491s;
            path.moveTo(fArr[0] + f11, fArr[1] + f12);
            int i11 = 2;
            while (true) {
                float[] fArr2 = this.f52491s;
                if (i11 >= fArr2.length) {
                    break;
                }
                this.f52496x.lineTo(fArr2[i11] + f11, fArr2[i11 + 1] + f12);
                i11 += 2;
            }
            this.f52496x.close();
            canvas.drawPath(this.f52496x, this.f52497y);
            if (fVar == f.Left) {
                float f15 = f11 + f14;
                float f16 = this.f52487o;
                canvas.drawRect(f11, f12, f15 + (0.02f * f16), f12 + f16, this.C);
                float f17 = this.f52487o;
                canvas.drawRect(f15, f12, f11 + f17, f12 + f17, this.B);
                return;
            }
            float f18 = this.f52487o;
            float f19 = f11 + f18;
            canvas.drawRect(f19 - ((0.02f * f18) + f14), f12, f19, f12 + f18, this.C);
            float f21 = this.f52487o;
            canvas.drawRect(f11, f12, (f11 + f21) - f14, f12 + f21, this.B);
        }
    }

    private int b(float f11, int i11, float f12, boolean z11) {
        return Math.round((f11 * ((float) i11)) + (f12 * ((float) (i11 - 1)))) + (z11 ? getPaddingLeft() + getPaddingRight() : 0);
    }

    private void b() {
        this.f52496x = new Path();
        this.f52498z = new CornerPathEffect(this.f52485m);
        Paint paint = new Paint(5);
        this.f52497y = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f52497y.setAntiAlias(true);
        this.f52497y.setDither(true);
        this.f52497y.setStrokeJoin(Paint.Join.ROUND);
        this.f52497y.setStrokeCap(Paint.Cap.ROUND);
        this.f52497y.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f52497y.setPathEffect(this.f52498z);
        Paint paint2 = new Paint(5);
        this.A = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.A.setStrokeJoin(Paint.Join.ROUND);
        this.A.setStrokeCap(Paint.Cap.ROUND);
        this.A.setStrokeWidth(this.f52484l);
        this.A.setPathEffect(this.f52498z);
        Paint paint3 = new Paint(5);
        this.B = paint3;
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        this.B.setAntiAlias(true);
        this.B.setDither(true);
        this.B.setStrokeJoin(Paint.Join.ROUND);
        this.B.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint(5);
        this.C = paint4;
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        this.C.setAntiAlias(true);
        this.C.setDither(true);
        this.C.setStrokeJoin(Paint.Join.ROUND);
        this.C.setStrokeCap(Paint.Cap.ROUND);
        this.D = TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
        b bVar = new b(new k(this));
        ViewCompat.setAccessibilityDelegate(this, bVar);
        setOnHoverListener(new b(bVar));
    }

    private void b(float f11, float f12) {
        float f13;
        if (this.f52483k != f.Left) {
            f11 = ((float) getWidth()) - f11;
        }
        RectF rectF = this.f52492t;
        if (rectF != null) {
            float f14 = rectF.left;
            if (f11 < f14) {
                this.f52482j = 0.0f;
            } else if (f11 > rectF.right) {
                this.f52482j = (float) this.E;
            } else {
                float width = (((float) this.E) / rectF.width()) * (f11 - f14);
                this.f52482j = width;
                float f15 = this.f52481i;
                float f16 = width % f15;
                float f17 = width - f16;
                if (f16 < f15 / 4.0f) {
                    this.f52482j = f17;
                    f13 = Math.max(0.0f, f17);
                } else {
                    float f18 = f17 + f15;
                    this.f52482j = f18;
                    f13 = Math.min((float) this.E, f18);
                }
                this.f52482j = f13;
            }
        }
    }

    private void b(int i11, int i12) {
        Bitmap bitmap = this.f52495w;
        if (bitmap != null) {
            bitmap.recycle();
        }
        if (i11 > 0 && i12 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.f52495w = createBitmap;
            if (createBitmap != null) {
                createBitmap.eraseColor(0);
                this.f52494v = new Canvas(this.f52495w);
            }
        }
    }

    private void b(Canvas canvas) {
        float f11 = this.f52482j;
        RectF rectF = this.f52492t;
        if (rectF != null) {
            float f12 = rectF.right - this.f52487o;
            float f13 = rectF.top;
            float f14 = f11;
            for (int i11 = 0; i11 < this.E; i11++) {
                int i12 = (f14 > 1.0f ? 1 : (f14 == 1.0f ? 0 : -1));
                f fVar = f.Right;
                if (i12 >= 0) {
                    a(canvas, f12, f13, 1.0f, fVar);
                    f14 -= 1.0f;
                } else {
                    a(canvas, f12, f13, f14, fVar);
                    if (this.f52486n) {
                        canvas.drawPath(this.f52496x, this.A);
                    }
                    f14 = 0.0f;
                }
                f12 -= this.H + this.f52487o;
            }
        }
    }

    private void c() {
        PorterDuffXfermode porterDuffXfermode;
        Paint paint;
        PorterDuffXfermode porterDuffXfermode2;
        Paint paint2;
        PorterDuffXfermode porterDuffXfermode3;
        Paint paint3;
        if (this.f52490r) {
            this.A.setColor(this.f52477e);
            this.C.setColor(this.f52478f);
            if (this.f52478f != 0) {
                paint3 = this.C;
                porterDuffXfermode3 = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
            } else {
                paint3 = this.C;
                porterDuffXfermode3 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            }
            paint3.setXfermode(porterDuffXfermode3);
            this.B.setColor(this.f52480h);
            if (this.f52480h != 0) {
                paint = this.B;
                porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
            } else {
                paint = this.B;
                porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            }
        } else {
            this.A.setColor(this.f52473a);
            this.C.setColor(this.f52474b);
            if (this.f52474b != 0) {
                paint2 = this.C;
                porterDuffXfermode2 = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
            } else {
                paint2 = this.C;
                porterDuffXfermode2 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            }
            paint2.setXfermode(porterDuffXfermode2);
            this.B.setColor(this.f52476d);
            if (this.f52476d != 0) {
                paint = this.B;
                porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
            } else {
                paint = this.B;
                porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
            }
        }
        paint.setXfermode(porterDuffXfermode);
    }

    private void c(int i11, int i12) {
        float b11 = (float) b(this.f52487o, this.E, this.H, false);
        float a11 = (float) a(this.f52487o, this.E, this.H, false);
        float paddingLeft = ((((float) ((i11 - getPaddingLeft()) - getPaddingRight())) / 2.0f) - (b11 / 2.0f)) + ((float) getPaddingLeft());
        float paddingTop = ((((float) ((i12 - getPaddingTop()) - getPaddingBottom())) / 2.0f) - (a11 / 2.0f)) + ((float) getPaddingTop());
        RectF rectF = new RectF(paddingLeft, paddingTop, b11 + paddingLeft, a11 + paddingTop);
        this.f52492t = rectF;
        float width = rectF.width() * 0.05f;
        RectF rectF2 = this.f52492t;
        this.f52493u = new RectF(rectF2.left - width, rectF2.top, rectF2.right + width, rectF2.bottom);
        float f11 = this.f52487o;
        float f12 = 0.2f * f11;
        float f13 = 0.35f * f11;
        float f14 = 0.5f * f11;
        float f15 = 0.05f * f11;
        float f16 = 0.03f * f11;
        float f17 = 0.38f * f11;
        float f18 = 0.32f * f11;
        float pointsLowerDeviation = getPointsLowerDeviation();
        float pointsUpperDeviation = getPointsUpperDeviation();
        float lowerInnerPointsYUpperDeviation = getLowerInnerPointsYUpperDeviation();
        float f19 = f17 * pointsLowerDeviation;
        float f21 = this.f52487o;
        float f22 = f21 - f16;
        float f23 = 0.6f * f11 * lowerInnerPointsYUpperDeviation;
        float f24 = f21 - f15;
        this.f52491s = new float[]{f16, f17, (f16 + f13) * pointsLowerDeviation, f19, f14, f15, (f22 - f13) * pointsUpperDeviation, f19, f22, f17, (f21 - f18) * pointsUpperDeviation, f23, f21 - f12, f24, f14, (f21 - (f11 * 0.27f)) * pointsUpperDeviation, f12, f24, f18 * pointsLowerDeviation, f23};
    }

    public int a(float f11, float f12) {
        int i11 = 0;
        while (true) {
            Rect[] rectArr = this.I;
            if (i11 >= rectArr.length) {
                return Integer.MIN_VALUE;
            }
            Rect rect = rectArr[i11];
            if (rect != null && rect.contains((int) f11, (int) f12)) {
                return i11 + 1;
            }
            i11++;
        }
    }

    @Nullable
    public Rect a(int i11) {
        int i12 = i11 > 0 ? i11 - 1 : i11;
        RectF rectF = this.f52492t;
        if (rectF == null) {
            return null;
        }
        float f11 = rectF.left + (((float) i12) * (this.H + this.f52487o));
        float f12 = rectF.top;
        Rect rect = new Rect();
        rect.top = (int) f12;
        rect.left = (int) f11;
        float f13 = this.f52487o;
        rect.bottom = (int) (f12 + f13);
        rect.right = (int) (f11 + f13);
        this.I[i11 - 1] = rect;
        return rect;
    }

    public void a(float f11, boolean z11) {
        g gVar;
        this.f52482j = a(f11);
        invalidate();
        if (z11 && (gVar = this.f52488p) != null) {
            gVar.a(this, f11, false);
        }
    }

    public float c(float f11, @Dimension int i11) {
        DisplayMetrics displayMetrics;
        int i12;
        if (i11 != 0) {
            i12 = 2;
            if (i11 != 2) {
                return f11;
            }
            displayMetrics = getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
            i12 = 1;
        }
        return TypedValue.applyDimension(i12, f11, displayMetrics);
    }

    public abstract boolean d();

    @ColorInt
    public int getFillColor() {
        return this.f52474b;
    }

    public f getGravity() {
        return this.f52483k;
    }

    public abstract float getLowerInnerPointsYUpperDeviation();

    public abstract float getPointsLowerDeviation();

    public abstract float getPointsUpperDeviation();

    public float getRating() {
        return this.f52482j;
    }

    public abstract float getStarBorderWidth();

    public abstract float getStarCornerRadius();

    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        int height = getHeight();
        if (getWidth() != 0 && height != 0 && (canvas2 = this.f52494v) != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            c();
            if (this.f52483k == f.Left) {
                a(this.f52494v);
            } else {
                b(this.f52494v);
            }
            canvas.drawColor(this.f52490r ? this.f52479g : this.f52475c);
            Bitmap bitmap = this.f52495w;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        int width = getWidth();
        int height = getHeight();
        float f11 = this.F;
        if (f11 == 2.14748365E9f) {
            f11 = a(width, height);
        }
        this.f52487o = f11;
        c(width, height);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                float f11 = this.F;
                if (f11 == 2.14748365E9f) {
                    f11 = this.G;
                    if (f11 == 2.14748365E9f) {
                        f11 = this.D;
                    }
                }
                size = Math.min(b(f11, this.E, this.H, true), size);
            } else {
                float f12 = this.F;
                if (f12 == 2.14748365E9f) {
                    f12 = this.G;
                    if (f12 == 2.14748365E9f) {
                        f12 = this.D;
                    }
                }
                size = b(f12, this.E, this.H, true);
            }
        }
        float f13 = this.H;
        int i14 = this.E;
        float paddingLeft = (((float) ((size - getPaddingLeft()) - getPaddingRight())) - (((float) (i14 - 1)) * f13)) / ((float) i14);
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                float f14 = this.F;
                if (f14 == 2.14748365E9f) {
                    f14 = this.G;
                    if (f14 == 2.14748365E9f) {
                        i13 = a(paddingLeft, i14, f13, true);
                        size2 = Math.min(i13, size2);
                    }
                }
                i13 = a(f14, i14, f13, true);
                size2 = Math.min(i13, size2);
            } else {
                float f15 = this.F;
                if (f15 == 2.14748365E9f) {
                    f15 = this.G;
                    if (f15 == 2.14748365E9f) {
                        size2 = a(paddingLeft, i14, f13, true);
                    }
                }
                size2 = a(f15, i14, f13, true);
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null) {
            i iVar = (i) parcelable;
            super.onRestoreInstanceState(iVar.getSuperState());
            a(iVar.f52472a, false);
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            return null;
        }
        float unused = new i(onSaveInstanceState).f52472a = getRating();
        return null;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        b(i11, i12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r6 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r6 != null) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0036
            if (r0 == r2) goto L_0x0018
            r3 = 2
            if (r0 == r3) goto L_0x0036
            r6 = 3
            if (r0 == r6) goto L_0x0013
            goto L_0x0055
        L_0x0013:
            com.instabug.survey.ui.custom.g r6 = r5.f52488p
            if (r6 == 0) goto L_0x0033
            goto L_0x002e
        L_0x0018:
            float r0 = r6.getX()
            float r6 = r6.getY()
            r5.b((float) r0, (float) r6)
            android.view.View$OnClickListener r6 = r5.f52489q
            if (r6 == 0) goto L_0x002a
            r6.onClick(r5)
        L_0x002a:
            com.instabug.survey.ui.custom.g r6 = r5.f52488p
            if (r6 == 0) goto L_0x0033
        L_0x002e:
            float r0 = r5.f52482j
            r6.a(r5, r0, r2)
        L_0x0033:
            r5.f52490r = r1
            goto L_0x0055
        L_0x0036:
            android.graphics.RectF r0 = r5.f52493u
            if (r0 == 0) goto L_0x0059
            float r3 = r6.getX()
            float r4 = r6.getY()
            boolean r0 = r0.contains(r3, r4)
            if (r0 == 0) goto L_0x0059
            r5.f52490r = r2
            float r0 = r6.getX()
            float r6 = r6.getY()
            r5.b((float) r0, (float) r6)
        L_0x0055:
            r5.invalidate()
            return r2
        L_0x0059:
            boolean r6 = r5.f52490r
            if (r6 == 0) goto L_0x0066
            com.instabug.survey.ui.custom.g r6 = r5.f52488p
            if (r6 == 0) goto L_0x0066
            float r0 = r5.f52482j
            r6.a(r5, r0, r2)
        L_0x0066:
            r5.f52490r = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.custom.j.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setFillColor(@ColorInt int i11) {
        this.f52474b = i11;
        invalidate();
    }

    public void setGravity(f fVar) {
        this.f52483k = fVar;
        invalidate();
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f52489q = onClickListener;
    }

    public void setOnRatingBarChangeListener(g gVar) {
        this.f52488p = gVar;
    }
}
