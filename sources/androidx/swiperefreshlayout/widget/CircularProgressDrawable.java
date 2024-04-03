package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = {-16777216};
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f37631b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37632c;
    private Animator mAnimator;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public static class Ring {

        /* renamed from: a  reason: collision with root package name */
        public final RectF f37637a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public final Paint f37638b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f37639c;

        /* renamed from: d  reason: collision with root package name */
        public final Paint f37640d;

        /* renamed from: e  reason: collision with root package name */
        public float f37641e;

        /* renamed from: f  reason: collision with root package name */
        public float f37642f;

        /* renamed from: g  reason: collision with root package name */
        public float f37643g;

        /* renamed from: h  reason: collision with root package name */
        public float f37644h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f37645i;

        /* renamed from: j  reason: collision with root package name */
        public int f37646j;

        /* renamed from: k  reason: collision with root package name */
        public float f37647k;

        /* renamed from: l  reason: collision with root package name */
        public float f37648l;

        /* renamed from: m  reason: collision with root package name */
        public float f37649m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f37650n;

        /* renamed from: o  reason: collision with root package name */
        public Path f37651o;

        /* renamed from: p  reason: collision with root package name */
        public float f37652p;

        /* renamed from: q  reason: collision with root package name */
        public float f37653q;

        /* renamed from: r  reason: collision with root package name */
        public int f37654r;

        /* renamed from: s  reason: collision with root package name */
        public int f37655s;

        /* renamed from: t  reason: collision with root package name */
        public int f37656t;

        /* renamed from: u  reason: collision with root package name */
        public int f37657u;

        public Ring() {
            Paint paint = new Paint();
            this.f37638b = paint;
            Paint paint2 = new Paint();
            this.f37639c = paint2;
            Paint paint3 = new Paint();
            this.f37640d = paint3;
            this.f37641e = 0.0f;
            this.f37642f = 0.0f;
            this.f37643g = 0.0f;
            this.f37644h = 5.0f;
            this.f37652p = 1.0f;
            this.f37656t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A(int i11) {
            this.f37640d.setColor(i11);
        }

        public void B(float f11) {
            this.f37653q = f11;
        }

        public void C(int i11) {
            this.f37657u = i11;
        }

        public void D(ColorFilter colorFilter) {
            this.f37638b.setColorFilter(colorFilter);
        }

        public void E(int i11) {
            this.f37646j = i11;
            this.f37657u = this.f37645i[i11];
        }

        public void F(@NonNull int[] iArr) {
            this.f37645i = iArr;
            E(0);
        }

        public void G(float f11) {
            this.f37642f = f11;
        }

        public void H(float f11) {
            this.f37643g = f11;
        }

        public void I(boolean z11) {
            if (this.f37650n != z11) {
                this.f37650n = z11;
            }
        }

        public void J(float f11) {
            this.f37641e = f11;
        }

        public void K(Paint.Cap cap) {
            this.f37638b.setStrokeCap(cap);
        }

        public void L(float f11) {
            this.f37644h = f11;
            this.f37638b.setStrokeWidth(f11);
        }

        public void M() {
            this.f37647k = this.f37641e;
            this.f37648l = this.f37642f;
            this.f37649m = this.f37643g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f37637a;
            float f11 = this.f37653q;
            float f12 = (this.f37644h / 2.0f) + f11;
            if (f11 <= 0.0f) {
                f12 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f37654r) * this.f37652p) / 2.0f, this.f37644h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f12, ((float) rect.centerY()) - f12, ((float) rect.centerX()) + f12, ((float) rect.centerY()) + f12);
            float f13 = this.f37641e;
            float f14 = this.f37643g;
            float f15 = (f13 + f14) * 360.0f;
            float f16 = ((this.f37642f + f14) * 360.0f) - f15;
            this.f37638b.setColor(this.f37657u);
            this.f37638b.setAlpha(this.f37656t);
            float f17 = this.f37644h / 2.0f;
            rectF.inset(f17, f17);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f37640d);
            float f18 = -f17;
            rectF.inset(f18, f18);
            canvas.drawArc(rectF, f15, f16, false, this.f37638b);
            b(canvas, f15, f16, rectF);
        }

        public void b(Canvas canvas, float f11, float f12, RectF rectF) {
            if (this.f37650n) {
                Path path = this.f37651o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f37651o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f37651o.moveTo(0.0f, 0.0f);
                this.f37651o.lineTo(((float) this.f37654r) * this.f37652p, 0.0f);
                Path path3 = this.f37651o;
                float f13 = this.f37652p;
                path3.lineTo((((float) this.f37654r) * f13) / 2.0f, ((float) this.f37655s) * f13);
                this.f37651o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f37654r) * this.f37652p) / 2.0f), rectF.centerY() + (this.f37644h / 2.0f));
                this.f37651o.close();
                this.f37639c.setColor(this.f37657u);
                this.f37639c.setAlpha(this.f37656t);
                canvas.save();
                canvas.rotate(f11 + f12, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f37651o, this.f37639c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f37656t;
        }

        public float d() {
            return (float) this.f37655s;
        }

        public float e() {
            return this.f37652p;
        }

        public float f() {
            return (float) this.f37654r;
        }

        public int g() {
            return this.f37640d.getColor();
        }

        public float h() {
            return this.f37653q;
        }

        public int[] i() {
            return this.f37645i;
        }

        public float j() {
            return this.f37642f;
        }

        public int k() {
            return this.f37645i[l()];
        }

        public int l() {
            return (this.f37646j + 1) % this.f37645i.length;
        }

        public float m() {
            return this.f37643g;
        }

        public boolean n() {
            return this.f37650n;
        }

        public float o() {
            return this.f37641e;
        }

        public int p() {
            return this.f37645i[this.f37646j];
        }

        public float q() {
            return this.f37648l;
        }

        public float r() {
            return this.f37649m;
        }

        public float s() {
            return this.f37647k;
        }

        public Paint.Cap t() {
            return this.f37638b.getStrokeCap();
        }

        public float u() {
            return this.f37644h;
        }

        public void v() {
            E(l());
        }

        public void w() {
            this.f37647k = 0.0f;
            this.f37648l = 0.0f;
            this.f37649m = 0.0f;
            J(0.0f);
            G(0.0f);
            H(0.0f);
        }

        public void x(int i11) {
            this.f37656t = i11;
        }

        public void y(float f11, float f12) {
            this.f37654r = (int) f11;
            this.f37655s = (int) f12;
        }

        public void z(float f11) {
            if (f11 != this.f37652p) {
                this.f37652p = f11;
            }
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.mRing = ring;
        ring.F(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float f11, Ring ring) {
        b(f11, ring);
        ring.J(ring.s() + (((ring.q() - 0.01f) - ring.s()) * f11));
        ring.G(ring.q());
        ring.H(ring.r() + ((((float) (Math.floor((double) (ring.r() / 0.8f)) + 1.0d)) - ring.r()) * f11));
    }

    private int evaluateColorChange(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) (((float) (((i12 >> 24) & 255) - i13)) * f11))) << 24) | ((i14 + ((int) (((float) (((i12 >> 16) & 255) - i14)) * f11))) << 16) | ((i15 + ((int) (((float) (((i12 >> 8) & 255) - i15)) * f11))) << 8) | (i16 + ((int) (f11 * ((float) ((i12 & 255) - i16)))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f11) {
        this.mRotation = f11;
    }

    private void setSizeParameters(float f11, float f12, float f13, float f14) {
        Ring ring = this.mRing;
        float f15 = this.mResources.getDisplayMetrics().density;
        ring.L(f12 * f15);
        ring.B(f11 * f15);
        ring.E(0);
        ring.y(f13 * f15, f14 * f15);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.b(floatValue, ring);
                CircularProgressDrawable.this.a(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.a(1.0f, ring, true);
                ring.M();
                ring.v();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.f37632c) {
                    circularProgressDrawable.f37632c = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    ring.I(false);
                    return;
                }
                circularProgressDrawable.f37631b += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.f37631b = 0.0f;
            }
        });
        this.mAnimator = ofFloat;
    }

    public void a(float f11, Ring ring, boolean z11) {
        float f12;
        float f13;
        if (this.f37632c) {
            applyFinishTranslation(f11, ring);
        } else if (f11 != 1.0f || z11) {
            float r11 = ring.r();
            if (f11 < 0.5f) {
                f12 = ring.s();
                f13 = (MATERIAL_INTERPOLATOR.getInterpolation(f11 / 0.5f) * 0.79f) + 0.01f + f12;
            } else {
                float s11 = ring.s() + 0.79f;
                float f14 = s11;
                f12 = s11 - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f11 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f13 = f14;
            }
            float f15 = r11 + (RING_ROTATION * f11);
            float f16 = (f11 + this.f37631b) * GROUP_FULL_ROTATION;
            ring.J(f12);
            ring.G(f13);
            ring.H(f15);
            setRotation(f16);
        }
    }

    public void b(float f11, Ring ring) {
        if (f11 > 0.75f) {
            ring.C(evaluateColorChange((f11 - 0.75f) / 0.25f, ring.p(), ring.k()));
        } else {
            ring.C(ring.p());
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.a(canvas, bounds);
        canvas.restore();
    }

    public int getAlpha() {
        return this.mRing.c();
    }

    public boolean getArrowEnabled() {
        return this.mRing.n();
    }

    public float getArrowHeight() {
        return this.mRing.d();
    }

    public float getArrowScale() {
        return this.mRing.e();
    }

    public float getArrowWidth() {
        return this.mRing.f();
    }

    public int getBackgroundColor() {
        return this.mRing.g();
    }

    public float getCenterRadius() {
        return this.mRing.h();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.i();
    }

    public float getEndTrim() {
        return this.mRing.j();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.m();
    }

    public float getStartTrim() {
        return this.mRing.o();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.t();
    }

    public float getStrokeWidth() {
        return this.mRing.u();
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void setAlpha(int i11) {
        this.mRing.x(i11);
        invalidateSelf();
    }

    public void setArrowDimensions(float f11, float f12) {
        this.mRing.y(f11, f12);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z11) {
        this.mRing.I(z11);
        invalidateSelf();
    }

    public void setArrowScale(float f11) {
        this.mRing.z(f11);
        invalidateSelf();
    }

    public void setBackgroundColor(int i11) {
        this.mRing.A(i11);
        invalidateSelf();
    }

    public void setCenterRadius(float f11) {
        this.mRing.B(f11);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.D(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mRing.F(iArr);
        this.mRing.E(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f11) {
        this.mRing.H(f11);
        invalidateSelf();
    }

    public void setStartEndTrim(float f11, float f12) {
        this.mRing.J(f11);
        this.mRing.G(f12);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.mRing.K(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f11) {
        this.mRing.L(f11);
        invalidateSelf();
    }

    public void setStyle(int i11) {
        if (i11 == 0) {
            setSizeParameters(CENTER_RADIUS_LARGE, 3.0f, 12.0f, 6.0f);
        } else {
            setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void start() {
        this.mAnimator.cancel();
        this.mRing.M();
        if (this.mRing.j() != this.mRing.o()) {
            this.f37632c = true;
            this.mAnimator.setDuration(666);
            this.mAnimator.start();
            return;
        }
        this.mRing.E(0);
        this.mRing.w();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.I(false);
        this.mRing.E(0);
        this.mRing.w();
        invalidateSelf();
    }
}
