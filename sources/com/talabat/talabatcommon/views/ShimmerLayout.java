package com.talabat.talabatcommon.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.talabatcommon.R;
import hv.b;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 T2\u00020\u0001:\u0002STB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020\u0019H\u0002J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eH\u0014J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\u0018\u00104\u001a\u00020,2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\b\u00105\u001a\u00020'H\u0014J0\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0002J\b\u0010>\u001a\u00020'H\u0002J\u0010\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020'H\u0002J\b\u0010C\u001a\u00020'H\u0002J(\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020GH\u0002J\u000e\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020\u0007J\u000e\u0010N\u001a\u00020'2\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020\u0007H\u0016J\u0006\u0010Q\u001a\u00020'J\u0006\u0010R\u001a\u00020'R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/talabat/talabatcommon/views/ShimmerLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationStatus", "Lcom/talabat/talabatcommon/views/ShimmerLayout$AnimationStatus;", "autoStart", "", "mCanvasForRendering", "Landroid/graphics/Canvas;", "mDestinationBitmap", "Landroid/graphics/Bitmap;", "mLocalAvailableBitmap", "mLocalMaskBitmap", "mMaskAnimator", "Landroid/animation/ValueAnimator;", "mMaskOffsetX", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/Rect;", "mSourceMaskBitmap", "shimmerAngle", "shimmerAnimation", "Landroid/animation/Animator;", "getShimmerAnimation", "()Landroid/animation/Animator;", "shimmerAnimationDuration", "shimmerColor", "calculateMaskRect", "createBitmap", "width", "height", "dispatchDraw", "", "canvas", "dispatchDrawUsingBitmap", "distanceBetween", "p1", "Landroid/graphics/Point;", "p2", "drawMask", "renderCanvas", "getColor", "id", "getDestinationBitmap", "getSourceMaskBitmap", "getTopIntersection", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "reduceColorAlphaValueToZero", "actualColor", "releaseBitMaps", "removeGlobalLayoutListener", "listener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "resetIfStarted", "resetShimmering", "rotatePoint", "point", "degrees", "", "cx", "cy", "setShimmerAngle", "angle", "setShimmerAnimationDuration", "durationMillis", "setShimmerColor", "setVisibility", "visibility", "startShimmerAnimation", "stopShimmerAnimation", "AnimationStatus", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShimmerLayout extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_ANGLE = 20;
    private static final int DEFAULT_ANIMATION_DURATION = 1500;
    private static final int MAX_ANGLE_VALUE = 30;
    private static final int MIN_ANGLE_VALUE = 0;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private AnimationStatus animationStatus;
    private boolean autoStart;
    @Nullable
    private Canvas mCanvasForRendering;
    @Nullable
    private Bitmap mDestinationBitmap;
    @Nullable
    private Bitmap mLocalAvailableBitmap;
    @Nullable
    private Bitmap mLocalMaskBitmap;
    @Nullable
    private ValueAnimator mMaskAnimator;
    private int mMaskOffsetX;
    @NotNull
    private final Paint mMaskPaint;
    @Nullable
    private Rect mMaskRect;
    @Nullable
    private Bitmap mSourceMaskBitmap;
    private int shimmerAngle;
    private int shimmerAnimationDuration;
    private int shimmerColor;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/ShimmerLayout$AnimationStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "PENDING", "STARTED", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum AnimationStatus {
        IDLE,
        PENDING,
        STARTED
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/ShimmerLayout$Companion;", "", "()V", "DEFAULT_ANGLE", "", "DEFAULT_ANIMATION_DURATION", "MAX_ANGLE_VALUE", "MIN_ANGLE_VALUE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShimmerLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShimmerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShimmerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.animationStatus = AnimationStatus.IDLE;
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ShimmerLayout, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…           0, 0\n        )");
        try {
            this.shimmerAngle = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_angle, 20);
            this.shimmerAnimationDuration = obtainStyledAttributes.getInteger(R.styleable.ShimmerLayout_shimmer_animation_duration, 1500);
            this.shimmerColor = obtainStyledAttributes.getColor(R.styleable.ShimmerLayout_shimmer_color, getColor(R.color.default_shimmer_color));
            boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.ShimmerLayout_shimmer_auto_start, false);
            this.autoStart = z11;
            if (z11) {
                this.animationStatus = AnimationStatus.PENDING;
            }
            obtainStyledAttributes.recycle();
            setShimmerAngle(this.shimmerAngle);
            if (this.autoStart && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _get_shimmerAnimation_$lambda-0  reason: not valid java name */
    public static final void m5743_get_shimmerAnimation_$lambda0(float[] fArr, ShimmerLayout shimmerLayout, int i11, int i12, int i13, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(fArr, "$value");
        Intrinsics.checkNotNullParameter(shimmerLayout, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, Param.ANIMATION);
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            fArr[0] = floatValue;
            int i14 = (int) (((float) i11) + (((float) i12) * floatValue));
            shimmerLayout.mMaskOffsetX = i14;
            if (i14 + i13 >= 0) {
                shimmerLayout.invalidate();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final Rect calculateMaskRect() {
        int width = getWidth() / 2;
        if (this.shimmerAngle == 0) {
            double d11 = (double) width;
            return new Rect((int) (0.25d * d11), 0, (int) (d11 * 0.75d), getHeight());
        }
        int height = (int) (((double) getHeight()) * 0.5d);
        int i11 = (int) (((double) width) * 0.75d);
        Point point = new Point(i11, 0);
        Point point2 = new Point(i11, height);
        float f11 = (float) (width / 2);
        Point rotatePoint = rotatePoint(point, (float) this.shimmerAngle, f11, (float) (getHeight() / 2));
        Point rotatePoint2 = rotatePoint(point2, (float) this.shimmerAngle, f11, (float) (getHeight() / 2));
        Point topIntersection = getTopIntersection(rotatePoint, rotatePoint2);
        int height2 = (getHeight() / 2) - distanceBetween(rotatePoint2, topIntersection);
        int i12 = width - topIntersection.x;
        return new Rect(i12, height2, width - i12, getHeight() - height2);
    }

    private final Bitmap createBitmap(int i11, int i12) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n            Bitmap.cre…nfig.ARGB_8888)\n        }");
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            System.gc();
            Bitmap createBitmap2 = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap2, "{\n            System.gc(…nfig.ARGB_8888)\n        }");
            return createBitmap2;
        } catch (IllegalArgumentException unused2) {
            if (i11 < 0) {
                i11 = 1;
            }
            if (i12 < 0) {
                i12 = 1;
            }
            Bitmap createBitmap3 = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap3, "{\n            // Sometim…nfig.ARGB_8888)\n        }");
            return createBitmap3;
        }
    }

    private final void dispatchDrawUsingBitmap(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap destinationBitmap = getDestinationBitmap();
        this.mLocalAvailableBitmap = destinationBitmap;
        if (destinationBitmap != null) {
            if (this.mCanvasForRendering == null) {
                Bitmap bitmap = this.mLocalAvailableBitmap;
                Intrinsics.checkNotNull(bitmap);
                this.mCanvasForRendering = new Canvas(bitmap);
            }
            Canvas canvas2 = this.mCanvasForRendering;
            if (canvas2 != null) {
                drawMask(canvas2);
                canvas.save();
                int i11 = this.mMaskOffsetX;
                Rect rect = this.mMaskRect;
                Intrinsics.checkNotNull(rect);
                canvas.clipRect(i11, 0, rect.width() + i11, getHeight());
                Bitmap bitmap2 = this.mLocalAvailableBitmap;
                Intrinsics.checkNotNull(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
                this.mLocalAvailableBitmap = null;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Canvas");
        }
    }

    private final int distanceBetween(Point point, Point point2) {
        return (int) Math.ceil(Math.sqrt(Math.pow((double) (point.x - point2.x), 2.0d) + Math.pow((double) (point.y - point2.y), 2.0d)));
    }

    private final void drawMask(Canvas canvas) {
        Bitmap sourceMaskBitmap = getSourceMaskBitmap();
        this.mLocalMaskBitmap = sourceMaskBitmap;
        if (sourceMaskBitmap != null) {
            canvas.save();
            int i11 = this.mMaskOffsetX;
            Bitmap bitmap = this.mLocalMaskBitmap;
            Intrinsics.checkNotNull(bitmap);
            canvas.clipRect(i11, 0, bitmap.getWidth() + i11, getHeight());
            super.dispatchDraw(canvas);
            Bitmap bitmap2 = this.mLocalMaskBitmap;
            Intrinsics.checkNotNull(bitmap2);
            canvas.drawBitmap(bitmap2, (float) this.mMaskOffsetX, 0.0f, this.mMaskPaint);
            canvas.restore();
            this.mLocalMaskBitmap = null;
        }
    }

    private final int getColor(int i11) {
        return getContext().getColor(i11);
    }

    private final Bitmap getDestinationBitmap() {
        if (this.mDestinationBitmap == null) {
            this.mDestinationBitmap = createBitmap(getWidth(), getHeight());
        }
        return this.mDestinationBitmap;
    }

    private final Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.mMaskAnimator;
        if (valueAnimator == null) {
            if (this.mMaskRect == null) {
                this.mMaskRect = calculateMaskRect();
            }
            int width = getWidth();
            int i11 = -width;
            Rect rect = this.mMaskRect;
            Intrinsics.checkNotNull(rect);
            int width2 = rect.width();
            int i12 = width - i11;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mMaskAnimator = ofFloat;
            Intrinsics.checkNotNull(ofFloat);
            ofFloat.setDuration((long) this.shimmerAnimationDuration);
            ValueAnimator valueAnimator2 = this.mMaskAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.setRepeatCount(-1);
            ValueAnimator valueAnimator3 = this.mMaskAnimator;
            Intrinsics.checkNotNull(valueAnimator3);
            valueAnimator3.addUpdateListener(new b(new float[1], this, i11, i12, width2));
            ValueAnimator valueAnimator4 = this.mMaskAnimator;
            if (valueAnimator4 != null) {
                return valueAnimator4;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.animation.Animator");
        } else if (valueAnimator != null) {
            return valueAnimator;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.animation.Animator");
        }
    }

    private final Bitmap getSourceMaskBitmap() {
        Bitmap bitmap = this.mSourceMaskBitmap;
        if (bitmap == null) {
            Rect rect = this.mMaskRect;
            Intrinsics.checkNotNull(rect);
            int width = rect.width();
            int height = getHeight();
            int reduceColorAlphaValueToZero = reduceColorAlphaValueToZero(this.shimmerColor);
            Rect rect2 = this.mMaskRect;
            Intrinsics.checkNotNull(rect2);
            float f11 = (float) (-rect2.left);
            Rect rect3 = this.mMaskRect;
            Intrinsics.checkNotNull(rect3);
            int i11 = this.shimmerColor;
            LinearGradient linearGradient = new LinearGradient(f11, 0.0f, (float) (rect3.left + width), 0.0f, new int[]{reduceColorAlphaValueToZero, i11, i11, reduceColorAlphaValueToZero}, new float[]{0.25f, 0.47f, 0.53f, 0.75f}, Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(linearGradient);
            this.mSourceMaskBitmap = createBitmap(width, height);
            Bitmap bitmap2 = this.mSourceMaskBitmap;
            Intrinsics.checkNotNull(bitmap2);
            Canvas canvas = new Canvas(bitmap2);
            canvas.rotate((float) this.shimmerAngle, (float) (width / 2), (float) (height / 2));
            Rect rect4 = this.mMaskRect;
            Intrinsics.checkNotNull(rect4);
            Rect rect5 = this.mMaskRect;
            Intrinsics.checkNotNull(rect5);
            Rect rect6 = this.mMaskRect;
            Intrinsics.checkNotNull(rect6);
            Rect rect7 = this.mMaskRect;
            Intrinsics.checkNotNull(rect7);
            canvas.drawRect((float) (-rect4.left), (float) rect5.top, (float) (width + rect6.left), (float) rect7.bottom, paint);
            Bitmap bitmap3 = this.mSourceMaskBitmap;
            if (bitmap3 != null) {
                return bitmap3;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Bitmap");
        } else if (bitmap != null) {
            return bitmap;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Bitmap");
        }
    }

    private final Point getTopIntersection(Point point, Point point2) {
        double d11 = (double) point.x;
        double d12 = (double) (-point.y);
        double d13 = (((double) (-point2.y)) - d12) / (((double) point2.x) - d11);
        return new Point((int) ((((double) 0) - (d12 - (d11 * d13))) / d13), 0);
    }

    private final int reduceColorAlphaValueToZero(int i11) {
        return Color.argb(0, Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    private final void releaseBitMaps() {
        Bitmap bitmap = this.mSourceMaskBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            bitmap.recycle();
            this.mSourceMaskBitmap = null;
        }
        Bitmap bitmap2 = this.mDestinationBitmap;
        if (bitmap2 != null) {
            Intrinsics.checkNotNull(bitmap2);
            bitmap2.recycle();
            this.mDestinationBitmap = null;
        }
        this.mCanvasForRendering = null;
    }

    private final void removeGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private final void resetIfStarted() {
        if (this.animationStatus == AnimationStatus.STARTED) {
            resetShimmering();
            startShimmerAnimation();
        }
    }

    private final void resetShimmering() {
        ValueAnimator valueAnimator = this.mMaskAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.end();
            ValueAnimator valueAnimator2 = this.mMaskAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.removeAllUpdateListeners();
        }
        this.mMaskAnimator = null;
        this.animationStatus = AnimationStatus.IDLE;
        releaseBitMaps();
    }

    private final Point rotatePoint(Point point, float f11, float f12, float f13) {
        float[] fArr = {(float) point.x, (float) point.y};
        Matrix matrix = new Matrix();
        matrix.setRotate(f11, f12, f13);
        matrix.mapPoints(fArr);
        return new Point((int) fArr[0], (int) fArr[1]);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.animationStatus != AnimationStatus.STARTED || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            dispatchDrawUsingBitmap(canvas);
        }
    }

    public void onDetachedFromWindow() {
        resetShimmering();
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.animationStatus == AnimationStatus.PENDING) {
            startShimmerAnimation();
        }
    }

    public final void setShimmerAngle(int i11) {
        boolean z11;
        if (i11 < 0 || 30 < i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.shimmerAngle = i11;
            resetIfStarted();
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("shimmerAngle value must be between %d and %d", Arrays.copyOf(new Object[]{0, 30}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        throw new IllegalArgumentException(format.toString());
    }

    public final void setShimmerAnimationDuration(int i11) {
        this.shimmerAnimationDuration = i11;
        resetIfStarted();
    }

    public final void setShimmerColor(int i11) {
        this.shimmerColor = getColor(i11);
        resetIfStarted();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 != 0) {
            stopShimmerAnimation();
        } else if (this.autoStart) {
            startShimmerAnimation();
        }
    }

    public final void startShimmerAnimation() {
        AnimationStatus animationStatus2 = this.animationStatus;
        AnimationStatus animationStatus3 = AnimationStatus.STARTED;
        if (animationStatus2 != animationStatus3) {
            if (getWidth() == 0) {
                this.animationStatus = AnimationStatus.PENDING;
                return;
            }
            getShimmerAnimation().start();
            this.animationStatus = animationStatus3;
        }
    }

    public final void stopShimmerAnimation() {
        resetShimmering();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShimmerLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
