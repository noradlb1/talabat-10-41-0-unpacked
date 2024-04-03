package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import net.bytebuddy.utility.JavaConstant;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public float G;
    public int H = 0;
    public int I = 0;
    public HashMap<View, ViewState> J = new HashMap<>();
    public Rect K = new Rect();
    public TransitionState L = TransitionState.UNDEFINED;
    public Model M = new Model();
    public ArrayList<Integer> N = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public MotionScene f10916b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f10917c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f10918d = null;

    /* renamed from: e  reason: collision with root package name */
    public float f10919e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f10920f = -1;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<View, MotionController> f10921g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public float f10922h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f10923i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f10924j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10925k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f10926l = false;
    private float lastPos;
    private float lastY;

    /* renamed from: m  reason: collision with root package name */
    public int f10927m = 0;
    private long mAnimationStartTime = 0;
    /* access modifiers changed from: private */
    public int mBeginState = -1;
    private RectF mBoundsCheck = new RectF();
    private DecelerateInterpolator mDecelerateLogic = new DecelerateInterpolator();
    private ArrayList<MotionHelper> mDecoratorsHelpers = null;
    private boolean mDelayedApply = false;
    private DesignTool mDesignTool;
    /* access modifiers changed from: private */
    public int mEndState = -1;
    private int mFrames = 0;
    private boolean mInLayout = false;
    /* access modifiers changed from: private */
    public boolean mInRotation = false;
    private boolean mInteractionEnabled = true;
    private Matrix mInverseMatrix = null;
    private boolean mKeepAnimating = false;
    private KeyCache mKeyCache = new KeyCache();
    private long mLastDrawTime = -1;
    private float mLastFps = 0.0f;
    /* access modifiers changed from: private */
    public int mLastHeightMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mLastWidthMeasureSpec = 0;
    private float mListenerPosition = 0.0f;
    private int mListenerState = 0;
    private boolean mNeedsFireTransitionCompleted = false;
    private Runnable mOnComplete = null;
    private ArrayList<MotionHelper> mOnHideHelpers = null;
    private ArrayList<MotionHelper> mOnShowHelpers = null;
    /* access modifiers changed from: private */
    public int mPreRotateHeight;
    /* access modifiers changed from: private */
    public int mPreRotateWidth;
    private int mPreviouseRotation;
    private View mRegionView = null;
    private int[] mScheduledTransitionTo = null;
    /* access modifiers changed from: private */
    public StateCache mStateCache;
    private StopLogic mStopLogic = new StopLogic();
    private boolean mTemporalInterpolator = false;
    private float mTransitionDuration = 1.0f;
    private boolean mTransitionInstantly;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners = null;

    /* renamed from: n  reason: collision with root package name */
    public DevModeDraw f10928n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f10929o = true;

    /* renamed from: p  reason: collision with root package name */
    public int f10930p;

    /* renamed from: q  reason: collision with root package name */
    public int f10931q;

    /* renamed from: r  reason: collision with root package name */
    public int f10932r;

    /* renamed from: s  reason: collision with root package name */
    public int f10933s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f10934t = false;

    /* renamed from: u  reason: collision with root package name */
    public float f10935u;

    /* renamed from: v  reason: collision with root package name */
    public float f10936v;

    /* renamed from: w  reason: collision with root package name */
    public long f10937w;

    /* renamed from: x  reason: collision with root package name */
    public float f10938x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f10939y = false;

    /* renamed from: z  reason: collision with root package name */
    public boolean f10940z = false;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10946a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10946a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10946a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10946a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10946a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass5.<clinit>():void");
        }
    }

    public class DecelerateInterpolator extends MotionInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public float f10947a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f10948b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f10949c;

        public DecelerateInterpolator() {
        }

        public void config(float f11, float f12, float f13) {
            this.f10947a = f11;
            this.f10948b = f12;
            this.f10949c = f13;
        }

        public float getInterpolation(float f11) {
            float f12;
            float f13;
            float f14 = this.f10947a;
            if (f14 > 0.0f) {
                float f15 = this.f10949c;
                if (f14 / f15 < f11) {
                    f11 = f14 / f15;
                }
                MotionLayout.this.f10919e = f14 - (f15 * f11);
                f12 = (f14 * f11) - (((f15 * f11) * f11) / 2.0f);
                f13 = this.f10948b;
            } else {
                float f16 = this.f10949c;
                if ((-f14) / f16 < f11) {
                    f11 = (-f14) / f16;
                }
                MotionLayout.this.f10919e = (f16 * f11) + f14;
                f12 = (f14 * f11) + (((f16 * f11) * f11) / 2.0f);
                f13 = this.f10948b;
            }
            return f12 + f13;
        }

        public float getVelocity() {
            return MotionLayout.this.f10919e;
        }
    }

    public class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;

        /* renamed from: a  reason: collision with root package name */
        public float[] f10951a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f10952b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f10953c;

        /* renamed from: d  reason: collision with root package name */
        public Path f10954d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f10955e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f10956f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f10957g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f10958h;

        /* renamed from: i  reason: collision with root package name */
        public Paint f10959i;

        /* renamed from: j  reason: collision with root package name */
        public final int f10960j = -21965;

        /* renamed from: k  reason: collision with root package name */
        public final int f10961k = -2067046;

        /* renamed from: l  reason: collision with root package name */
        public final int f10962l = -13391360;

        /* renamed from: m  reason: collision with root package name */
        public final int f10963m = 1996488704;
        private float[] mRectangle;

        /* renamed from: n  reason: collision with root package name */
        public final int f10964n = 10;

        /* renamed from: o  reason: collision with root package name */
        public DashPathEffect f10965o;

        /* renamed from: p  reason: collision with root package name */
        public int f10966p;

        /* renamed from: q  reason: collision with root package name */
        public Rect f10967q = new Rect();

        /* renamed from: r  reason: collision with root package name */
        public boolean f10968r = false;

        /* renamed from: s  reason: collision with root package name */
        public int f10969s = 1;

        public DevModeDraw() {
            Paint paint = new Paint();
            this.f10955e = paint;
            paint.setAntiAlias(true);
            this.f10955e.setColor(-21965);
            this.f10955e.setStrokeWidth(2.0f);
            this.f10955e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f10956f = paint2;
            paint2.setAntiAlias(true);
            this.f10956f.setColor(-2067046);
            this.f10956f.setStrokeWidth(2.0f);
            this.f10956f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f10957g = paint3;
            paint3.setAntiAlias(true);
            this.f10957g.setColor(-13391360);
            this.f10957g.setStrokeWidth(2.0f);
            this.f10957g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f10958h = paint4;
            paint4.setAntiAlias(true);
            this.f10958h.setColor(-13391360);
            this.f10958h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint5 = new Paint();
            this.f10959i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f10965o = dashPathEffect;
            this.f10957g.setPathEffect(dashPathEffect);
            this.f10953c = new float[100];
            this.f10952b = new int[50];
            if (this.f10968r) {
                this.f10955e.setStrokeWidth(8.0f);
                this.f10959i.setStrokeWidth(8.0f);
                this.f10956f.setStrokeWidth(8.0f);
                this.f10969s = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.f10951a, this.f10955e);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z11 = false;
            boolean z12 = false;
            for (int i11 = 0; i11 < this.f10966p; i11++) {
                int i12 = this.f10952b[i11];
                if (i12 == 1) {
                    z11 = true;
                }
                if (i12 == 0) {
                    z12 = true;
                }
            }
            if (z11) {
                drawPathRelative(canvas);
            }
            if (z12) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.f10951a;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[fArr.length - 2];
            float f14 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f11, f13), Math.max(f12, f14), Math.max(f11, f13), Math.max(f12, f14), this.f10957g);
            canvas.drawLine(Math.min(f11, f13), Math.min(f12, f14), Math.min(f11, f13), Math.max(f12, f14), this.f10957g);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f11, float f12) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f10951a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float min = Math.min(f13, f15);
            float max = Math.max(f14, f16);
            float min2 = f11 - Math.min(f13, f15);
            float max2 = Math.max(f14, f16) - f12;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f15 - f13))) + 0.5d))) / 100.0f);
            a(str, this.f10958h);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.f10967q.width() / 2))) + min, f12 - 20.0f, this.f10958h);
            canvas.drawLine(f11, f12, Math.min(f13, f15), f12, this.f10957g);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f16 - f14))) + 0.5d))) / 100.0f);
            a(str2, this.f10958h);
            canvas2.drawText(str2, f11 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.f10967q.height() / 2))), this.f10958h);
            canvas.drawLine(f11, f12, f11, Math.max(f14, f16), this.f10957g);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.f10951a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f10957g);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f11, float f12) {
            float[] fArr = this.f10951a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f13 - f15), (double) (f14 - f16));
            float f17 = f15 - f13;
            float f18 = f16 - f14;
            float f19 = (((f11 - f13) * f17) + ((f12 - f14) * f18)) / (hypot * hypot);
            float f21 = f13 + (f17 * f19);
            float f22 = f14 + (f19 * f18);
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f21, f22);
            float hypot2 = (float) Math.hypot((double) (f21 - f11), (double) (f22 - f12));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            a(str, this.f10958h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.f10967q.width() / 2)), -20.0f, this.f10958h);
            canvas.drawLine(f11, f12, f21, f22, this.f10957g);
        }

        private void drawPathScreenTicks(Canvas canvas, float f11, float f12, int i11, int i12) {
            Canvas canvas2 = canvas;
            String str = "" + (((float) ((int) (((double) (((f11 - ((float) (i11 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i11)))) + 0.5d))) / 100.0f);
            a(str, this.f10958h);
            canvas2.drawText(str, ((f11 / 2.0f) - ((float) (this.f10967q.width() / 2))) + 0.0f, f12 - 20.0f, this.f10958h);
            canvas.drawLine(f11, f12, Math.min(0.0f, 1.0f), f12, this.f10957g);
            String str2 = "" + (((float) ((int) (((double) (((f12 - ((float) (i12 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i12)))) + 0.5d))) / 100.0f);
            a(str2, this.f10958h);
            canvas2.drawText(str2, f11 + 5.0f, 0.0f - ((f12 / 2.0f) - ((float) (this.f10967q.height() / 2))), this.f10958h);
            canvas.drawLine(f11, f12, f11, Math.max(0.0f, 1.0f), this.f10957g);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.f10954d.reset();
            for (int i11 = 0; i11 <= 50; i11++) {
                motionController.d(((float) i11) / ((float) 50), this.mRectangle, 0);
                Path path = this.f10954d;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f10954d;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f10954d;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f10954d;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f10954d.close();
            }
            this.f10955e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f10954d, this.f10955e);
            canvas.translate(-2.0f, -2.0f);
            this.f10955e.setColor(-65536);
            canvas.drawPath(this.f10954d, this.f10955e);
        }

        private void drawTicks(Canvas canvas, int i11, int i12, MotionController motionController) {
            int i13;
            int i14;
            float f11;
            float f12;
            Canvas canvas2 = canvas;
            int i15 = i11;
            MotionController motionController2 = motionController;
            View view = motionController2.f10905b;
            if (view != null) {
                i14 = view.getWidth();
                i13 = motionController2.f10905b.getHeight();
            } else {
                i14 = 0;
                i13 = 0;
            }
            for (int i16 = 1; i16 < i12 - 1; i16++) {
                if (i15 != 4 || this.f10952b[i16 - 1] != 0) {
                    float[] fArr = this.f10953c;
                    int i17 = i16 * 2;
                    float f13 = fArr[i17];
                    float f14 = fArr[i17 + 1];
                    this.f10954d.reset();
                    this.f10954d.moveTo(f13, f14 + 10.0f);
                    this.f10954d.lineTo(f13 + 10.0f, f14);
                    this.f10954d.lineTo(f13, f14 - 10.0f);
                    this.f10954d.lineTo(f13 - 10.0f, f14);
                    this.f10954d.close();
                    int i18 = i16 - 1;
                    motionController2.i(i18);
                    if (i15 == 4) {
                        int i19 = this.f10952b[i18];
                        if (i19 == 1) {
                            drawPathRelativeTicks(canvas2, f13 - 0.0f, f14 - 0.0f);
                        } else if (i19 == 0) {
                            drawPathCartesianTicks(canvas2, f13 - 0.0f, f14 - 0.0f);
                        } else if (i19 == 2) {
                            f12 = f14;
                            f11 = f13;
                            drawPathScreenTicks(canvas, f13 - 0.0f, f14 - 0.0f, i14, i13);
                            canvas2.drawPath(this.f10954d, this.f10959i);
                        }
                        f12 = f14;
                        f11 = f13;
                        canvas2.drawPath(this.f10954d, this.f10959i);
                    } else {
                        f12 = f14;
                        f11 = f13;
                    }
                    if (i15 == 2) {
                        drawPathRelativeTicks(canvas2, f11 - 0.0f, f12 - 0.0f);
                    }
                    if (i15 == 3) {
                        drawPathCartesianTicks(canvas2, f11 - 0.0f, f12 - 0.0f);
                    }
                    if (i15 == 6) {
                        drawPathScreenTicks(canvas, f11 - 0.0f, f12 - 0.0f, i14, i13);
                    }
                    canvas2.drawPath(this.f10954d, this.f10959i);
                }
            }
            float[] fArr2 = this.f10951a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f10956f);
                float[] fArr3 = this.f10951a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f10956f);
            }
        }

        private void drawTranslation(Canvas canvas, float f11, float f12, float f13, float f14) {
            canvas.drawRect(f11, f12, f13, f14, this.f10957g);
            canvas.drawLine(f11, f12, f13, f14, this.f10957g);
        }

        public void a(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f10967q);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i11, int i12) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i12 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + CertificateUtil.DELIMITER + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f10958h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f10955e);
                }
                for (MotionController next : hashMap.values()) {
                    int drawPath = next.getDrawPath();
                    if (i12 > 0 && drawPath == 0) {
                        drawPath = 1;
                    }
                    if (drawPath != 0) {
                        this.f10966p = next.b(this.f10953c, this.f10952b);
                        if (drawPath >= 1) {
                            int i13 = i11 / 16;
                            float[] fArr = this.f10951a;
                            if (fArr == null || fArr.length != i13 * 2) {
                                this.f10951a = new float[(i13 * 2)];
                                this.f10954d = new Path();
                            }
                            int i14 = this.f10969s;
                            canvas.translate((float) i14, (float) i14);
                            this.f10955e.setColor(1996488704);
                            this.f10959i.setColor(1996488704);
                            this.f10956f.setColor(1996488704);
                            this.f10957g.setColor(1996488704);
                            next.c(this.f10951a, i13);
                            drawAll(canvas, drawPath, this.f10966p, next);
                            this.f10955e.setColor(-21965);
                            this.f10956f.setColor(-2067046);
                            this.f10959i.setColor(-2067046);
                            this.f10957g.setColor(-13391360);
                            int i15 = this.f10969s;
                            canvas.translate((float) (-i15), (float) (-i15));
                            drawAll(canvas, drawPath, this.f10966p, next);
                            if (drawPath == 5) {
                                drawRectangle(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void drawAll(Canvas canvas, int i11, int i12, MotionController motionController) {
            if (i11 == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i11 == 2) {
                drawPathRelative(canvas);
            }
            if (i11 == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i11, i12, motionController);
        }
    }

    public class Model {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidgetContainer f10971a = new ConstraintWidgetContainer();

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidgetContainer f10972b = new ConstraintWidgetContainer();

        /* renamed from: c  reason: collision with root package name */
        public ConstraintSet f10973c = null;

        /* renamed from: d  reason: collision with root package name */
        public ConstraintSet f10974d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f10975e;

        /* renamed from: f  reason: collision with root package name */
        public int f10976f;

        public Model() {
        }

        private void computeStartEndSize(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int i18;
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f10920f == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.f10972b;
                ConstraintSet constraintSet = this.f10974d;
                if (constraintSet == null || constraintSet.mRotate == 0) {
                    i16 = i11;
                } else {
                    i16 = i12;
                }
                if (constraintSet == null || constraintSet.mRotate == 0) {
                    i17 = i12;
                } else {
                    i17 = i11;
                }
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, i16, i17);
                ConstraintSet constraintSet2 = this.f10973c;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f10971a;
                    int i19 = constraintSet2.mRotate;
                    if (i19 == 0) {
                        i18 = i11;
                    } else {
                        i18 = i12;
                    }
                    if (i19 == 0) {
                        i11 = i12;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i18, i11);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.f10973c;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f10971a;
                int i21 = constraintSet3.mRotate;
                if (i21 == 0) {
                    i14 = i11;
                } else {
                    i14 = i12;
                }
                if (i21 == 0) {
                    i15 = i12;
                } else {
                    i15 = i11;
                }
                motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i14, i15);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f10972b;
            ConstraintSet constraintSet4 = this.f10974d;
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i13 = i11;
            } else {
                i13 = i12;
            }
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i11 = i12;
            }
            motionLayout5.resolveSystem(constraintWidgetContainer4, optimizationLevel, i13, i11);
        }

        @SuppressLint({"LogConditional"})
        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            String str2;
            String str3;
            String str4;
            String str5 = str + " " + Debug.getName((View) constraintWidgetContainer.getCompanionWidget());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str5);
            sb2.append("  ========= ");
            sb2.append(constraintWidgetContainer);
            int size = constraintWidgetContainer.getChildren().size();
            for (int i11 = 0; i11 < size; i11++) {
                String str6 = str5 + "[" + i11 + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i11);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                ConstraintAnchor constraintAnchor = constraintWidget.mTop.mTarget;
                String str7 = JavaConstant.Dynamic.DEFAULT_NAME;
                if (constraintAnchor != null) {
                    str2 = "T";
                } else {
                    str2 = str7;
                }
                sb3.append(str2);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                if (constraintWidget.mBottom.mTarget != null) {
                    str3 = "B";
                } else {
                    str3 = str7;
                }
                sb5.append(str3);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (constraintWidget.mLeft.mTarget != null) {
                    str4 = "L";
                } else {
                    str4 = str7;
                }
                sb7.append(str4);
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(sb8);
                if (constraintWidget.mRight.mTarget != null) {
                    str7 = "R";
                }
                sb9.append(str7);
                String sb10 = sb9.toString();
                View view = (View) constraintWidget.getCompanionWidget();
                String name2 = Debug.getName(view);
                if (view instanceof TextView) {
                    name2 = name2 + "(" + ((TextView) view).getText() + ")";
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str6);
                sb11.append("  ");
                sb11.append(name2);
                sb11.append(" ");
                sb11.append(constraintWidget);
                sb11.append(" ");
                sb11.append(sb10);
            }
            StringBuilder sb12 = new StringBuilder();
            sb12.append(str5);
            sb12.append(" done. ");
        }

        @SuppressLint({"LogConditional"})
        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            if (layoutParams.startToStart != -1) {
                str2 = "SS";
            } else {
                str2 = "__";
            }
            sb2.append(str2);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            String str13 = "|__";
            if (layoutParams.startToEnd != -1) {
                str3 = "|SE";
            } else {
                str3 = str13;
            }
            sb4.append(str3);
            String sb5 = sb4.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb5);
            if (layoutParams.endToStart != -1) {
                str4 = "|ES";
            } else {
                str4 = str13;
            }
            sb6.append(str4);
            String sb7 = sb6.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(sb7);
            if (layoutParams.endToEnd != -1) {
                str5 = "|EE";
            } else {
                str5 = str13;
            }
            sb8.append(str5);
            String sb9 = sb8.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb9);
            if (layoutParams.leftToLeft != -1) {
                str6 = "|LL";
            } else {
                str6 = str13;
            }
            sb10.append(str6);
            String sb11 = sb10.toString();
            StringBuilder sb12 = new StringBuilder();
            sb12.append(sb11);
            if (layoutParams.leftToRight != -1) {
                str7 = "|LR";
            } else {
                str7 = str13;
            }
            sb12.append(str7);
            String sb13 = sb12.toString();
            StringBuilder sb14 = new StringBuilder();
            sb14.append(sb13);
            if (layoutParams.rightToLeft != -1) {
                str8 = "|RL";
            } else {
                str8 = str13;
            }
            sb14.append(str8);
            String sb15 = sb14.toString();
            StringBuilder sb16 = new StringBuilder();
            sb16.append(sb15);
            if (layoutParams.rightToRight != -1) {
                str9 = "|RR";
            } else {
                str9 = str13;
            }
            sb16.append(str9);
            String sb17 = sb16.toString();
            StringBuilder sb18 = new StringBuilder();
            sb18.append(sb17);
            if (layoutParams.topToTop != -1) {
                str10 = "|TT";
            } else {
                str10 = str13;
            }
            sb18.append(str10);
            String sb19 = sb18.toString();
            StringBuilder sb20 = new StringBuilder();
            sb20.append(sb19);
            if (layoutParams.topToBottom != -1) {
                str11 = "|TB";
            } else {
                str11 = str13;
            }
            sb20.append(str11);
            String sb21 = sb20.toString();
            StringBuilder sb22 = new StringBuilder();
            sb22.append(sb21);
            if (layoutParams.bottomToTop != -1) {
                str12 = "|BT";
            } else {
                str12 = str13;
            }
            sb22.append(str12);
            String sb23 = sb22.toString();
            StringBuilder sb24 = new StringBuilder();
            sb24.append(sb23);
            if (layoutParams.bottomToBottom != -1) {
                str13 = "|BB";
            }
            sb24.append(str13);
            String sb25 = sb24.toString();
            StringBuilder sb26 = new StringBuilder();
            sb26.append(str);
            sb26.append(sb25);
        }

        @SuppressLint({"LogConditional"})
        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            String str7 = "B";
            String str8 = "__";
            if (constraintWidget.mTop.mTarget != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("T");
                if (constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    str6 = "T";
                } else {
                    str6 = str7;
                }
                sb3.append(str6);
                str2 = sb3.toString();
            } else {
                str2 = str8;
            }
            sb2.append(str2);
            String sb4 = sb2.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            if (constraintWidget.mBottom.mTarget != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str7);
                if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    str7 = "T";
                }
                sb6.append(str7);
                str3 = sb6.toString();
            } else {
                str3 = str8;
            }
            sb5.append(str3);
            String sb7 = sb5.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(sb7);
            String str9 = "R";
            if (constraintWidget.mLeft.mTarget != null) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("L");
                if (constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str5 = "L";
                } else {
                    str5 = str9;
                }
                sb9.append(str5);
                str4 = sb9.toString();
            } else {
                str4 = str8;
            }
            sb8.append(str4);
            String sb10 = sb8.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            if (constraintWidget.mRight.mTarget != null) {
                StringBuilder sb12 = new StringBuilder();
                sb12.append(str9);
                if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str9 = "L";
                }
                sb12.append(str9);
                str8 = sb12.toString();
            }
            sb11.append(str8);
            String sb13 = sb11.toString();
            StringBuilder sb14 = new StringBuilder();
            sb14.append(str);
            sb14.append(sb13);
            sb14.append(" ---  ");
            sb14.append(constraintWidget);
        }

        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.mRotate == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f10972b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    Helper helper = (Helper) next3;
                    ((ConstraintHelper) next3.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        public void a(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.core.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Placeholder) {
                    constraintWidget = new Placeholder();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                ((ConstraintWidget) hashMap.get(next2)).copy(next2, hashMap);
            }
        }

        public ConstraintWidget b(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget = children.get(i11);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x013d A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void build() {
            /*
                r18 = this;
                r0 = r18
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r2 = r2.f10921g
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r5 = 0
            L_0x0017:
                if (r5 >= r1) goto L_0x0037
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionController r7 = new androidx.constraintlayout.motion.widget.MotionController
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r8 = r8.f10921g
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0017
            L_0x0037:
                r5 = 0
            L_0x0038:
                if (r5 >= r1) goto L_0x0143
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r7 = r7.f10921g
                java.lang.Object r7 = r7.get(r6)
                r13 = r7
                androidx.constraintlayout.motion.widget.MotionController r13 = (androidx.constraintlayout.motion.widget.MotionController) r13
                if (r13 != 0) goto L_0x0051
                r16 = r2
                goto L_0x013d
            L_0x0051:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.f10973c
                java.lang.String r14 = ")"
                java.lang.String r15 = " ("
                java.lang.String r12 = "no widget for  "
                java.lang.String r11 = "MotionLayout"
                if (r7 == 0) goto L_0x00b2
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f10971a
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.b(r7, r6)
                if (r7 == 0) goto L_0x007d
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r7 = r8.toRect(r7)
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.f10973c
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r13.t(r7, r8, r9, r10)
                goto L_0x00e1
            L_0x007d:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.f10927m
                if (r7 == 0) goto L_0x00e1
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getLocation()
                r7.append(r8)
                r7.append(r12)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getName(r6)
                r7.append(r8)
                r7.append(r15)
                java.lang.Class r8 = r6.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r14)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r11, r7)
                goto L_0x00e1
            L_0x00b2:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r7 = r7.mInRotation
                if (r7 == 0) goto L_0x00e1
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.utils.ViewState> r7 = r7.J
                java.lang.Object r7 = r7.get(r6)
                r8 = r7
                androidx.constraintlayout.motion.utils.ViewState r8 = (androidx.constraintlayout.motion.utils.ViewState) r8
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r7.I
                int r16 = r7.mPreRotateWidth
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r17 = r7.mPreRotateHeight
                r7 = r13
                r9 = r6
                r4 = r11
                r11 = r16
                r16 = r2
                r2 = r12
                r12 = r17
                r7.setStartState(r8, r9, r10, r11, r12)
                goto L_0x00e5
            L_0x00e1:
                r16 = r2
                r4 = r11
                r2 = r12
            L_0x00e5:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.f10974d
                if (r7 == 0) goto L_0x013d
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f10972b
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.b(r7, r6)
                if (r7 == 0) goto L_0x0109
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r2 = r2.toRect(r7)
                androidx.constraintlayout.widget.ConstraintSet r4 = r0.f10974d
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.getHeight()
                r13.r(r2, r4, r6, r7)
                goto L_0x013d
            L_0x0109:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.f10927m
                if (r7 == 0) goto L_0x013d
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getLocation()
                r7.append(r8)
                r7.append(r2)
                java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r6)
                r7.append(r2)
                r7.append(r15)
                java.lang.Class r2 = r6.getClass()
                java.lang.String r2 = r2.getName()
                r7.append(r2)
                r7.append(r14)
                java.lang.String r2 = r7.toString()
                android.util.Log.e(r4, r2)
            L_0x013d:
                int r5 = r5 + 1
                r2 = r16
                goto L_0x0038
            L_0x0143:
                r16 = r2
                r4 = 0
            L_0x0146:
                if (r4 >= r1) goto L_0x0167
                r2 = r3[r4]
                r5 = r16
                java.lang.Object r2 = r5.get(r2)
                androidx.constraintlayout.motion.widget.MotionController r2 = (androidx.constraintlayout.motion.widget.MotionController) r2
                int r6 = r2.getAnimateRelativeTo()
                r7 = -1
                if (r6 == r7) goto L_0x0162
                java.lang.Object r6 = r5.get(r6)
                androidx.constraintlayout.motion.widget.MotionController r6 = (androidx.constraintlayout.motion.widget.MotionController) r6
                r2.setupRelative(r6)
            L_0x0162:
                int r4 = r4 + 1
                r16 = r5
                goto L_0x0146
            L_0x0167:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.build():void");
        }

        public void c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f10973c = constraintSet;
            this.f10974d = constraintSet2;
            this.f10971a = new ConstraintWidgetContainer();
            this.f10972b = new ConstraintWidgetContainer();
            this.f10971a.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.f10972b.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.f10971a.removeAllChildren();
            this.f10972b.removeAllChildren();
            a(MotionLayout.this.mLayoutWidget, this.f10971a);
            a(MotionLayout.this.mLayoutWidget, this.f10972b);
            if (((double) MotionLayout.this.f10923i) > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.f10971a, constraintSet);
                }
                setupConstraintWidget(this.f10972b, constraintSet2);
            } else {
                setupConstraintWidget(this.f10972b, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.f10971a, constraintSet);
                }
            }
            this.f10971a.setRtl(MotionLayout.this.isRtl());
            this.f10971a.updateHierarchy();
            this.f10972b.setRtl(MotionLayout.this.isRtl());
            this.f10972b.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f10971a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.f10972b.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f10971a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.f10972b.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i11, int i12) {
            return (i11 == this.f10975e && i12 == this.f10976f) ? false : true;
        }

        public void measure(int i11, int i12) {
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.E = mode;
            motionLayout.F = mode2;
            motionLayout.getOptimizationLevel();
            computeStartEndSize(i11, i12);
            if ((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                computeStartEndSize(i11, i12);
                MotionLayout.this.A = this.f10971a.getWidth();
                MotionLayout.this.B = this.f10971a.getHeight();
                MotionLayout.this.C = this.f10972b.getWidth();
                MotionLayout.this.D = this.f10972b.getHeight();
                MotionLayout motionLayout2 = MotionLayout.this;
                if (motionLayout2.A == motionLayout2.C && motionLayout2.B == motionLayout2.D) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                motionLayout2.f10940z = z14;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i13 = motionLayout3.A;
            int i14 = motionLayout3.B;
            int i15 = motionLayout3.E;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                i13 = (int) (((float) i13) + (motionLayout3.G * ((float) (motionLayout3.C - i13))));
            }
            int i16 = i13;
            int i17 = motionLayout3.F;
            if (i17 == Integer.MIN_VALUE || i17 == 0) {
                i14 = (int) (((float) i14) + (motionLayout3.G * ((float) (motionLayout3.D - i14))));
            }
            int i18 = i14;
            if (this.f10971a.isWidthMeasuredTooSmall() || this.f10972b.isWidthMeasuredTooSmall()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (this.f10971a.isHeightMeasuredTooSmall() || this.f10972b.isHeightMeasuredTooSmall()) {
                z13 = true;
            } else {
                z13 = false;
            }
            MotionLayout.this.resolveMeasuredDimension(i11, i12, i16, i18, z12, z13);
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i11, int i12) {
            this.f10975e = i11;
            this.f10976f = i12;
        }
    }

    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i11);

        void computeCurrentVelocity(int i11, float f11);

        float getXVelocity();

        float getXVelocity(int i11);

        float getYVelocity();

        float getYVelocity(int i11);

        void recycle();
    }

    public class StateCache {

        /* renamed from: a  reason: collision with root package name */
        public float f10980a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        public float f10981b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        public int f10982c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f10983d = -1;

        /* renamed from: e  reason: collision with root package name */
        public final String f10984e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        public final String f10985f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        public final String f10986g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        public final String f10987h = "motion.EndState";

        public StateCache() {
        }

        public void a() {
            int i11 = this.f10982c;
            if (!(i11 == -1 && this.f10983d == -1)) {
                if (i11 == -1) {
                    MotionLayout.this.transitionToState(this.f10983d);
                } else {
                    int i12 = this.f10983d;
                    if (i12 == -1) {
                        MotionLayout.this.setState(i11, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i11, i12);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.f10981b)) {
                MotionLayout.this.setProgress(this.f10980a, this.f10981b);
                this.f10980a = Float.NaN;
                this.f10981b = Float.NaN;
                this.f10982c = -1;
                this.f10983d = -1;
            } else if (!Float.isNaN(this.f10980a)) {
                MotionLayout.this.setProgress(this.f10980a);
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f10980a);
            bundle.putFloat("motion.velocity", this.f10981b);
            bundle.putInt("motion.StartState", this.f10982c);
            bundle.putInt("motion.EndState", this.f10983d);
            return bundle;
        }

        public void recordState() {
            this.f10983d = MotionLayout.this.mEndState;
            this.f10982c = MotionLayout.this.mBeginState;
            this.f10981b = MotionLayout.this.getVelocity();
            this.f10980a = MotionLayout.this.getProgress();
        }

        public void setEndState(int i11) {
            this.f10983d = i11;
        }

        public void setProgress(float f11) {
            this.f10980a = f11;
        }

        public void setStartState(int i11) {
            this.f10982c = i11;
        }

        public void setTransitionState(Bundle bundle) {
            this.f10980a = bundle.getFloat("motion.progress");
            this.f10981b = bundle.getFloat("motion.velocity");
            this.f10982c = bundle.getInt("motion.StartState");
            this.f10983d = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f11) {
            this.f10981b = f11;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11);

        void onTransitionCompleted(MotionLayout motionLayout, int i11);

        void onTransitionStarted(MotionLayout motionLayout, int i11, int i12);

        void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11);
    }

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private boolean callTransformedTouchEvent(View view, MotionEvent motionEvent, float f11, float f12) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f11, f12);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f11, -f12);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f11, f12);
        if (this.mInverseMatrix == null) {
            this.mInverseMatrix = new Matrix();
        }
        matrix.invert(this.mInverseMatrix);
        obtain.transform(this.mInverseMatrix);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void checkStructure() {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int u11 = motionScene.u();
        MotionScene motionScene2 = this.f10916b;
        checkStructure(u11, motionScene2.h(motionScene2.u()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.f10916b.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            MotionScene.Transition transition = this.f10916b.f11010b;
            checkStructure(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            String name2 = Debug.getName(getContext(), startConstraintSetId);
            String name3 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + name2 + "->" + name3);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + name2 + "->" + name3);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.f10916b.h(startConstraintSetId) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + name2);
            }
            if (this.f10916b.h(endConstraintSetId) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + name2);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            MotionController motionController = this.f10921g.get(childAt);
            if (motionController != null) {
                motionController.s(childAt);
            }
        }
    }

    @SuppressLint({"LogConditional"})
    private void debugPos() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append(Debug.getLocation());
            sb2.append(" ");
            sb2.append(Debug.getName(this));
            sb2.append(" ");
            sb2.append(Debug.getName(getContext(), this.f10920f));
            sb2.append(" ");
            sb2.append(Debug.getName(childAt));
            sb2.append(childAt.getLeft());
            sb2.append(" ");
            sb2.append(childAt.getTop());
        }
    }

    private void evaluateLayout() {
        float f11;
        boolean z11;
        float signum = Math.signum(this.f10924j - this.f10923i);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f10917c;
        if (!(interpolator instanceof StopLogic)) {
            f11 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
        } else {
            f11 = 0.0f;
        }
        float f12 = this.f10923i + f11;
        if (this.mTransitionInstantly) {
            f12 = this.f10924j;
        }
        int i11 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i11 <= 0 || f12 < this.f10924j) && (signum > 0.0f || f12 > this.f10924j)) {
            z11 = false;
        } else {
            f12 = this.f10924j;
            z11 = true;
        }
        if (interpolator != null && !z11) {
            if (this.mTemporalInterpolator) {
                f12 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
            } else {
                f12 = interpolator.getInterpolation(f12);
            }
        }
        if ((i11 > 0 && f12 >= this.f10924j) || (signum <= 0.0f && f12 <= this.f10924j)) {
            f12 = this.f10924j;
        }
        this.G = f12;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f10918d;
        if (interpolator2 != null) {
            f12 = interpolator2.getInterpolation(f12);
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            MotionController motionController = this.f10921g.get(childAt);
            if (motionController != null) {
                motionController.n(childAt, f12, nanoTime2, this.mKeyCache);
            }
        }
        if (this.f10940z) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerPosition != this.f10922h) {
            if (this.mListenerState != -1) {
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
                this.f10939y = true;
            }
            this.mListenerState = -1;
            float f11 = this.f10922h;
            this.mListenerPosition = f11;
            TransitionListener transitionListener2 = this.mTransitionListener;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f11);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList3 = this.mTransitionListeners;
            if (copyOnWriteArrayList3 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.f10922h);
                }
            }
            this.f10939y = true;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, i11, i12);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i11, i12);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handlesTouchEvent(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.handlesTouchEvent(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.mBoundsCheck
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.mBoundsCheck
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r8 = r7.callTransformedTouchEvent(r10, r11, r8, r9)
            if (r8 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r1 = r0
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.handlesTouchEvent(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i11;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z11 = true;
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f10916b = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.f10920f = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.f10924j = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f10925k = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z11 = obtainStyledAttributes.getBoolean(index, z11);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.f10927m == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i11 = 2;
                        } else {
                            i11 = 0;
                        }
                        this.f10927m = i11;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.f10927m = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f10916b == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z11) {
                this.f10916b = null;
            }
        }
        if (this.f10927m != 0) {
            checkStructure();
        }
        if (this.f10920f == -1 && (motionScene = this.f10916b) != null) {
            this.f10920f = motionScene.u();
            this.mBeginState = this.f10916b.u();
            this.mEndState = this.f10916b.j();
        }
    }

    private void processTransitionCompleted() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) {
            this.f10939y = false;
            Iterator<Integer> it = this.N.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, next.intValue());
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTransitionCompleted(this, next.intValue());
                    }
                }
            }
            this.N.clear();
        }
    }

    /* access modifiers changed from: private */
    public void setupMotionViews() {
        boolean z11;
        float f11;
        float f12;
        int childCount = getChildCount();
        this.M.build();
        boolean z12 = true;
        this.f10925k = true;
        SparseArray sparseArray = new SparseArray();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            sparseArray.put(childAt.getId(), this.f10921g.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.f10916b.gatPathMotionArc();
        if (gatPathMotionArc != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController = this.f10921g.get(getChildAt(i13));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f10921g.size()];
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            MotionController motionController2 = this.f10921g.get(getChildAt(i15));
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i14] = motionController2.getAnimateRelativeTo();
                i14++;
            }
        }
        if (this.mDecoratorsHelpers != null) {
            for (int i16 = 0; i16 < i14; i16++) {
                MotionController motionController3 = this.f10921g.get(findViewById(iArr[i16]));
                if (motionController3 != null) {
                    this.f10916b.getKeyFrames(motionController3);
                }
            }
            Iterator<MotionHelper> it = this.mDecoratorsHelpers.iterator();
            while (it.hasNext()) {
                it.next().onPreSetup(this, this.f10921g);
            }
            for (int i17 = 0; i17 < i14; i17++) {
                MotionController motionController4 = this.f10921g.get(findViewById(iArr[i17]));
                if (motionController4 != null) {
                    motionController4.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < i14; i18++) {
                MotionController motionController5 = this.f10921g.get(findViewById(iArr[i18]));
                if (motionController5 != null) {
                    this.f10916b.getKeyFrames(motionController5);
                    motionController5.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            MotionController motionController6 = this.f10921g.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.f10916b.getKeyFrames(motionController6);
                motionController6.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.f10916b.getStaggered();
        if (staggered != 0.0f) {
            if (((double) staggered) < 0.0d) {
                z11 = true;
            } else {
                z11 = false;
            }
            float abs = Math.abs(staggered);
            float f13 = -3.4028235E38f;
            float f14 = Float.MAX_VALUE;
            int i21 = 0;
            float f15 = -3.4028235E38f;
            float f16 = Float.MAX_VALUE;
            while (true) {
                if (i21 >= childCount) {
                    z12 = false;
                    break;
                }
                MotionController motionController7 = this.f10921g.get(getChildAt(i21));
                if (!Float.isNaN(motionController7.f10909f)) {
                    break;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                if (z11) {
                    f12 = finalY - finalX;
                } else {
                    f12 = finalY + finalX;
                }
                f16 = Math.min(f16, f12);
                f15 = Math.max(f15, f12);
                i21++;
            }
            if (z12) {
                for (int i22 = 0; i22 < childCount; i22++) {
                    MotionController motionController8 = this.f10921g.get(getChildAt(i22));
                    if (!Float.isNaN(motionController8.f10909f)) {
                        f14 = Math.min(f14, motionController8.f10909f);
                        f13 = Math.max(f13, motionController8.f10909f);
                    }
                }
                while (i11 < childCount) {
                    MotionController motionController9 = this.f10921g.get(getChildAt(i11));
                    if (!Float.isNaN(motionController9.f10909f)) {
                        motionController9.f10911h = 1.0f / (1.0f - abs);
                        if (z11) {
                            motionController9.f10910g = abs - (((f13 - motionController9.f10909f) / (f13 - f14)) * abs);
                        } else {
                            motionController9.f10910g = abs - (((motionController9.f10909f - f14) * abs) / (f13 - f14));
                        }
                    }
                    i11++;
                }
                return;
            }
            while (i11 < childCount) {
                MotionController motionController10 = this.f10921g.get(getChildAt(i11));
                float finalX2 = motionController10.getFinalX();
                float finalY2 = motionController10.getFinalY();
                if (z11) {
                    f11 = finalY2 - finalX2;
                } else {
                    f11 = finalY2 + finalX2;
                }
                motionController10.f10911h = 1.0f / (1.0f - abs);
                motionController10.f10910g = abs - (((f11 - f16) * abs) / (f15 - f16));
                i11++;
            }
        }
    }

    /* access modifiers changed from: private */
    public Rect toRect(ConstraintWidget constraintWidget) {
        this.K.top = constraintWidget.getY();
        this.K.left = constraintWidget.getX();
        Rect rect = this.K;
        int width = constraintWidget.getWidth();
        Rect rect2 = this.K;
        rect.right = width + rect2.left;
        int height = constraintWidget.getHeight();
        Rect rect3 = this.K;
        rect2.bottom = height + rect3.top;
        return rect3;
    }

    private static boolean willJump(float f11, float f12, float f13) {
        if (f11 > 0.0f) {
            float f14 = f11 / f13;
            return f12 + ((f11 * f14) - (((f13 * f14) * f14) / 2.0f)) > 1.0f;
        }
        float f15 = (-f11) / f13;
        return f12 + ((f11 * f15) + (((f13 * f15) * f15) / 2.0f)) < 0.0f;
    }

    public void A(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            MotionController motionController = this.f10921g.get(getChildAt(i11));
            if (motionController != null) {
                motionController.f(z11);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x020b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B(boolean r23) {
        /*
            r22 = this;
            r0 = r22
            long r1 = r0.mTransitionLastTime
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            long r1 = r22.getNanoTime()
            r0.mTransitionLastTime = r1
        L_0x0010:
            float r1 = r0.f10923i
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = -1
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L_0x0020
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r0.f10920f = r4
        L_0x0020:
            boolean r3 = r0.mKeepAnimating
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.f10925k
            if (r3 == 0) goto L_0x023f
            if (r23 != 0) goto L_0x0032
            float r3 = r0.f10924j
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x023f
        L_0x0032:
            float r3 = r0.f10924j
            float r3 = r3 - r1
            float r1 = java.lang.Math.signum(r3)
            long r8 = r22.getNanoTime()
            android.view.animation.Interpolator r3 = r0.f10917c
            boolean r10 = r3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0051
            long r12 = r0.mTransitionLastTime
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.mTransitionDuration
            float r10 = r10 / r12
            goto L_0x0052
        L_0x0051:
            r10 = r2
        L_0x0052:
            float r12 = r0.f10923i
            float r12 = r12 + r10
            boolean r13 = r0.mTransitionInstantly
            if (r13 == 0) goto L_0x005b
            float r12 = r0.f10924j
        L_0x005b:
            int r13 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            float r14 = r0.f10924j
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x006f
        L_0x0065:
            int r14 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
            float r14 = r0.f10924j
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
        L_0x006f:
            float r12 = r0.f10924j
            r0.f10925k = r7
            r14 = r6
            goto L_0x0076
        L_0x0075:
            r14 = r7
        L_0x0076:
            r0.f10923i = r12
            r0.f10922h = r12
            r0.mTransitionLastTime = r8
            r15 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r3 == 0) goto L_0x0103
            if (r14 != 0) goto L_0x0103
            boolean r14 = r0.mTemporalInterpolator
            if (r14 == 0) goto L_0x00e4
            long r4 = r0.mAnimationStartTime
            long r4 = r8 - r4
            float r4 = (float) r4
            float r4 = r4 * r11
            float r3 = r3.getInterpolation(r4)
            android.view.animation.Interpolator r4 = r0.f10917c
            androidx.constraintlayout.motion.utils.StopLogic r5 = r0.mStopLogic
            r10 = 2
            if (r4 != r5) goto L_0x00a2
            boolean r4 = r5.isStopped()
            if (r4 == 0) goto L_0x00a0
            r4 = r10
            goto L_0x00a3
        L_0x00a0:
            r4 = r6
            goto L_0x00a3
        L_0x00a2:
            r4 = r7
        L_0x00a3:
            r0.f10923i = r3
            r0.mTransitionLastTime = r8
            android.view.animation.Interpolator r5 = r0.f10917c
            boolean r8 = r5 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.MotionInterpolator r5 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r5
            float r5 = r5.getVelocity()
            r0.f10919e = r5
            float r8 = java.lang.Math.abs(r5)
            float r9 = r0.mTransitionDuration
            float r8 = r8 * r9
            int r8 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r8 > 0) goto L_0x00c4
            if (r4 != r10) goto L_0x00c4
            r0.f10925k = r7
        L_0x00c4:
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d4
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x00d4
            r0.f10923i = r8
            r0.f10925k = r7
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x00d4:
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e2
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00e2
            r0.f10923i = r2
            r0.f10925k = r7
            r12 = r2
            goto L_0x0106
        L_0x00e2:
            r12 = r3
            goto L_0x0106
        L_0x00e4:
            float r3 = r3.getInterpolation(r12)
            android.view.animation.Interpolator r4 = r0.f10917c
            boolean r5 = r4 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r5 == 0) goto L_0x00f7
            androidx.constraintlayout.motion.widget.MotionInterpolator r4 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r4
            float r4 = r4.getVelocity()
            r0.f10919e = r4
            goto L_0x0101
        L_0x00f7:
            float r12 = r12 + r10
            float r4 = r4.getInterpolation(r12)
            float r4 = r4 - r3
            float r4 = r4 * r1
            float r4 = r4 / r10
            r0.f10919e = r4
        L_0x0101:
            r12 = r3
            goto L_0x0105
        L_0x0103:
            r0.f10919e = r10
        L_0x0105:
            r4 = r7
        L_0x0106:
            float r3 = r0.f10919e
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x0115
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r3)
        L_0x0115:
            if (r4 == r6) goto L_0x013e
            if (r13 <= 0) goto L_0x011f
            float r3 = r0.f10924j
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0129
        L_0x011f:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x012d
            float r3 = r0.f10924j
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x012d
        L_0x0129:
            float r12 = r0.f10924j
            r0.f10925k = r7
        L_0x012d:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0137
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x013e
        L_0x0137:
            r0.f10925k = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
        L_0x013e:
            int r3 = r22.getChildCount()
            r0.mKeepAnimating = r7
            long r4 = r22.getNanoTime()
            r0.G = r12
            android.view.animation.Interpolator r8 = r0.f10918d
            if (r8 != 0) goto L_0x0150
            r8 = r12
            goto L_0x0154
        L_0x0150:
            float r8 = r8.getInterpolation(r12)
        L_0x0154:
            android.view.animation.Interpolator r9 = r0.f10918d
            if (r9 == 0) goto L_0x016c
            float r10 = r0.mTransitionDuration
            float r10 = r1 / r10
            float r10 = r10 + r12
            float r9 = r9.getInterpolation(r10)
            r0.f10919e = r9
            android.view.animation.Interpolator r10 = r0.f10918d
            float r10 = r10.getInterpolation(r12)
            float r9 = r9 - r10
            r0.f10919e = r9
        L_0x016c:
            r9 = r7
        L_0x016d:
            if (r9 >= r3) goto L_0x0195
            android.view.View r10 = r0.getChildAt(r9)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r11 = r0.f10921g
            java.lang.Object r11 = r11.get(r10)
            r16 = r11
            androidx.constraintlayout.motion.widget.MotionController r16 = (androidx.constraintlayout.motion.widget.MotionController) r16
            if (r16 == 0) goto L_0x0192
            boolean r11 = r0.mKeepAnimating
            androidx.constraintlayout.core.motion.utils.KeyCache r15 = r0.mKeyCache
            r17 = r10
            r18 = r8
            r19 = r4
            r21 = r15
            boolean r10 = r16.n(r17, r18, r19, r21)
            r10 = r10 | r11
            r0.mKeepAnimating = r10
        L_0x0192:
            int r9 = r9 + 1
            goto L_0x016d
        L_0x0195:
            if (r13 <= 0) goto L_0x019d
            float r3 = r0.f10924j
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x01a7
        L_0x019d:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01a9
            float r3 = r0.f10924j
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01a9
        L_0x01a7:
            r3 = r6
            goto L_0x01aa
        L_0x01a9:
            r3 = r7
        L_0x01aa:
            boolean r4 = r0.mKeepAnimating
            if (r4 != 0) goto L_0x01b9
            boolean r4 = r0.f10925k
            if (r4 != 0) goto L_0x01b9
            if (r3 == 0) goto L_0x01b9
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r4)
        L_0x01b9:
            boolean r4 = r0.f10940z
            if (r4 == 0) goto L_0x01c0
            r22.requestLayout()
        L_0x01c0:
            boolean r4 = r0.mKeepAnimating
            r3 = r3 ^ r6
            r3 = r3 | r4
            r0.mKeepAnimating = r3
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01e4
            int r3 = r0.mBeginState
            r4 = -1
            if (r3 == r4) goto L_0x01e4
            int r4 = r0.f10920f
            if (r4 == r3) goto L_0x01e4
            r0.f10920f = r3
            androidx.constraintlayout.motion.widget.MotionScene r4 = r0.f10916b
            androidx.constraintlayout.widget.ConstraintSet r3 = r4.h(r3)
            r3.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x01e4:
            double r3 = (double) r12
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0202
            int r3 = r0.f10920f
            int r4 = r0.mEndState
            if (r3 == r4) goto L_0x0202
            r0.f10920f = r4
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.f10916b
            androidx.constraintlayout.widget.ConstraintSet r3 = r3.h(r4)
            r3.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x0202:
            boolean r3 = r0.mKeepAnimating
            if (r3 != 0) goto L_0x0221
            boolean r3 = r0.f10925k
            if (r3 == 0) goto L_0x020b
            goto L_0x0221
        L_0x020b:
            if (r13 <= 0) goto L_0x0213
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x021b
        L_0x0213:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0224
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0224
        L_0x021b:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            goto L_0x0224
        L_0x0221:
            r22.invalidate()
        L_0x0224:
            boolean r3 = r0.mKeepAnimating
            if (r3 != 0) goto L_0x023f
            boolean r3 = r0.f10925k
            if (r3 != 0) goto L_0x023f
            if (r13 <= 0) goto L_0x0234
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x023c
        L_0x0234:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x023f
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x023f
        L_0x023c:
            r22.I()
        L_0x023f:
            float r1 = r0.f10923i
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0253
            int r1 = r0.f10920f
            int r2 = r0.mEndState
            if (r1 == r2) goto L_0x024e
            goto L_0x024f
        L_0x024e:
            r6 = r7
        L_0x024f:
            r0.f10920f = r2
        L_0x0251:
            r7 = r6
            goto L_0x0262
        L_0x0253:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0262
            int r1 = r0.f10920f
            int r2 = r0.mBeginState
            if (r1 == r2) goto L_0x025e
            goto L_0x025f
        L_0x025e:
            r6 = r7
        L_0x025f:
            r0.f10920f = r2
            goto L_0x0251
        L_0x0262:
            boolean r1 = r0.mNeedsFireTransitionCompleted
            r1 = r1 | r7
            r0.mNeedsFireTransitionCompleted = r1
            if (r7 == 0) goto L_0x0270
            boolean r1 = r0.mInLayout
            if (r1 != 0) goto L_0x0270
            r22.requestLayout()
        L_0x0270:
            float r1 = r0.f10923i
            r0.f10922h = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.B(boolean):void");
    }

    public void C() {
        int i11;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.f10920f;
            if (!this.N.isEmpty()) {
                ArrayList<Integer> arrayList = this.N;
                i11 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i11 = -1;
            }
            int i12 = this.f10920f;
            if (!(i11 == i12 || i12 == -1)) {
                this.N.add(Integer.valueOf(i12));
            }
        }
        processTransitionCompleted();
        Runnable runnable = this.mOnComplete;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr != null && this.H > 0) {
            transitionToState(iArr[0]);
            int[] iArr2 = this.mScheduledTransitionTo;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.H--;
        }
    }

    public void D(int i11, float f11, float f12, float f13, float[] fArr) {
        String str;
        HashMap<View, MotionController> hashMap = this.f10921g;
        View viewById = getViewById(i11);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.h(f11, f12, f13, fArr);
            float y11 = viewById.getY();
            this.lastPos = f11;
            this.lastY = y11;
            return;
        }
        if (viewById == null) {
            str = "" + i11;
        } else {
            str = viewById.getContext().getResources().getResourceName(i11);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + str);
    }

    public String E(int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i11);
    }

    public MotionController F(int i11) {
        return this.f10921g.get(findViewById(i11));
    }

    public int G(String str) {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    public MotionTracker H() {
        return MyTracker.obtain();
    }

    public void I() {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            if (motionScene.f(this, this.f10920f)) {
                requestLayout();
                return;
            }
            int i11 = this.f10920f;
            if (i11 != -1) {
                this.f10916b.addOnClickListeners(this, i11);
            }
            if (this.f10916b.C()) {
                this.f10916b.B();
            }
        }
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new CopyOnWriteArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    public boolean applyViewTransition(int i11, MotionController motionController) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i11, motionController);
        }
        return false;
    }

    public ConstraintSet cloneConstraintSet(int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet h11 = motionScene.h(i11);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(h11);
        return constraintSet;
    }

    public void dispatchDraw(Canvas canvas) {
        String str;
        ViewTransitionController viewTransitionController;
        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
        if (arrayList != null) {
            Iterator<MotionHelper> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onPreDraw(canvas);
            }
        }
        B(false);
        MotionScene motionScene = this.f10916b;
        if (!(motionScene == null || (viewTransitionController = motionScene.f11011c) == null)) {
            viewTransitionController.c();
        }
        super.dispatchDraw(canvas);
        if (this.f10916b != null) {
            if ((this.f10927m & 1) == 1 && !isInEditMode()) {
                this.mFrames++;
                long nanoTime = getNanoTime();
                long j11 = this.mLastDrawTime;
                if (j11 != -1) {
                    long j12 = nanoTime - j11;
                    if (j12 > 200000000) {
                        this.mLastFps = ((float) ((int) ((((float) this.mFrames) / (((float) j12) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.mFrames = 0;
                        this.mLastDrawTime = nanoTime;
                    }
                } else {
                    this.mLastDrawTime = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
                sb2.append(Debug.getState(this, this.mEndState));
                sb2.append(" (progress: ");
                sb2.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb2.append(" ) state=");
                int i11 = this.f10920f;
                if (i11 == -1) {
                    str = AdError.UNDEFINED_DOMAIN;
                } else {
                    str = Debug.getState(this, i11);
                }
                sb2.append(str);
                String sb3 = sb2.toString();
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawText(sb3, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb3, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.f10927m > 1) {
                if (this.f10928n == null) {
                    this.f10928n = new DevModeDraw();
                }
                this.f10928n.draw(canvas, this.f10921g, this.f10916b.getDuration(), this.f10927m);
            }
            ArrayList<MotionHelper> arrayList2 = this.mDecoratorsHelpers;
            if (arrayList2 != null) {
                Iterator<MotionHelper> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onPostDraw(canvas);
                }
            }
        }
    }

    public void enableTransition(int i11, boolean z11) {
        MotionScene.Transition transition = getTransition(i11);
        if (z11) {
            transition.setEnabled(true);
            return;
        }
        MotionScene motionScene = this.f10916b;
        if (transition == motionScene.f11010b) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.f10920f).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.f10916b.f11010b = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i11, boolean z11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            motionScene.enableViewTransition(i11, z11);
        }
    }

    public void fireTrigger(int i11, boolean z11, float f11) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i11, z11, f11);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i11, z11, f11);
            }
        }
    }

    public ConstraintSet getConstraintSet(int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            return null;
        }
        return motionScene.h(i11);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public int getCurrentState() {
        return this.f10920f;
    }

    public void getDebugMode(boolean z11) {
        int i11;
        if (z11) {
            i11 = 2;
        } else {
            i11 = 1;
        }
        this.f10927m = i11;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f10923i;
    }

    public MotionScene getScene() {
        return this.f10916b;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.f10924j;
    }

    public MotionScene.Transition getTransition(int i11) {
        return this.f10916b.getTransitionById(i11);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.f10919e;
    }

    public void getViewVelocity(View view, float f11, float f12, float[] fArr, int i11) {
        float f13;
        float f14 = this.f10919e;
        float f15 = this.f10923i;
        if (this.f10917c != null) {
            float signum = Math.signum(this.f10924j - f15);
            float interpolation = this.f10917c.getInterpolation(this.f10923i + EPSILON);
            f13 = this.f10917c.getInterpolation(this.f10923i);
            f14 = (signum * ((interpolation - f13) / EPSILON)) / this.mTransitionDuration;
        } else {
            f13 = f15;
        }
        Interpolator interpolator = this.f10917c;
        if (interpolator instanceof MotionInterpolator) {
            f14 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.f10921g.get(view);
        if ((i11 & 1) == 0) {
            motionController.m(f13, view.getWidth(), view.getHeight(), f11, f12, fArr);
        } else {
            motionController.h(f13, f11, f12, fArr);
        }
        if (i11 < 2) {
            fArr[0] = fArr[0] * f14;
            fArr[1] = fArr[1] * f14;
        }
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public boolean isViewTransitionEnabled(int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i11);
        }
        return false;
    }

    public void jumpToState(int i11) {
        if (!isAttachedToWindow()) {
            this.f10920f = i11;
        }
        if (this.mBeginState == i11) {
            setProgress(0.0f);
        } else if (this.mEndState == i11) {
            setProgress(1.0f);
        } else {
            setTransition(i11, i11);
        }
    }

    public void loadLayoutDescription(int i11) {
        int i12;
        MotionScene.Transition transition;
        if (i11 != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i11);
                this.f10916b = motionScene;
                if (this.f10920f == -1) {
                    this.f10920f = motionScene.u();
                    this.mBeginState = this.f10916b.u();
                    this.mEndState = this.f10916b.j();
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    if (display == null) {
                        i12 = 0;
                    } else {
                        i12 = display.getRotation();
                    }
                    this.mPreviouseRotation = i12;
                    MotionScene motionScene2 = this.f10916b;
                    if (motionScene2 != null) {
                        ConstraintSet h11 = motionScene2.h(this.f10920f);
                        this.f10916b.z(this);
                        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                        if (arrayList != null) {
                            Iterator<MotionHelper> it = arrayList.iterator();
                            while (it.hasNext()) {
                                it.next().onFinishedMotionScene(this);
                            }
                        }
                        if (h11 != null) {
                            h11.applyTo(this);
                        }
                        this.mBeginState = this.f10920f;
                    }
                    I();
                    StateCache stateCache = this.mStateCache;
                    if (stateCache == null) {
                        MotionScene motionScene3 = this.f10916b;
                        if (motionScene3 != null && (transition = motionScene3.f11010b) != null && transition.getAutoTransition() == 4) {
                            transitionToEnd();
                            setState(TransitionState.SETUP);
                            setState(TransitionState.MOVING);
                        }
                    } else if (this.mDelayedApply) {
                        post(new Runnable() {
                            public void run() {
                                MotionLayout.this.mStateCache.a();
                            }
                        });
                    } else {
                        stateCache.a();
                    }
                } else {
                    this.f10916b = null;
                }
            } catch (Exception e11) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e11);
            } catch (Exception e12) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e12);
            }
        } else {
            this.f10916b = null;
        }
    }

    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i11;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.mPreviouseRotation = display.getRotation();
        }
        MotionScene motionScene = this.f10916b;
        if (!(motionScene == null || (i11 = this.f10920f) == -1)) {
            ConstraintSet h11 = motionScene.h(i11);
            this.f10916b.z(this);
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onFinishedMotionScene(this);
                }
            }
            if (h11 != null) {
                h11.applyTo(this);
            }
            this.mBeginState = this.f10920f;
        }
        I();
        StateCache stateCache = this.mStateCache;
        if (stateCache == null) {
            MotionScene motionScene2 = this.f10916b;
            if (motionScene2 != null && (transition = motionScene2.f11010b) != null && transition.getAutoTransition() == 4) {
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.mDelayedApply) {
            post(new Runnable() {
                public void run() {
                    MotionLayout.this.mStateCache.a();
                }
            });
        } else {
            stateCache.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int g11;
        RectF f11;
        MotionScene motionScene = this.f10916b;
        if (motionScene != null && this.mInteractionEnabled) {
            ViewTransitionController viewTransitionController = motionScene.f11011c;
            if (viewTransitionController != null) {
                viewTransitionController.i(motionEvent);
            }
            MotionScene.Transition transition = this.f10916b.f11010b;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (f11 = touchResponse.f(this, new RectF())) == null || f11.contains(motionEvent.getX(), motionEvent.getY())) && (g11 = touchResponse.g()) != -1)) {
                View view = this.mRegionView;
                if (view == null || view.getId() != g11) {
                    this.mRegionView = findViewById(g11);
                }
                View view2 = this.mRegionView;
                if (view2 != null) {
                    this.mBoundsCheck.set((float) view2.getLeft(), (float) this.mRegionView.getTop(), (float) this.mRegionView.getRight(), (float) this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent((float) this.mRegionView.getLeft(), (float) this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.mInLayout = true;
        try {
            if (this.f10916b == null) {
                super.onLayout(z11, i11, i12, i13, i14);
                return;
            }
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (!(this.f10932r == i15 && this.f10933s == i16)) {
                rebuildScene();
                B(true);
            }
            this.f10932r = i15;
            this.f10933s = i16;
            this.f10930p = i15;
            this.f10931q = i16;
            this.mInLayout = false;
        } finally {
            this.mInLayout = false;
        }
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        if (this.f10916b == null) {
            super.onMeasure(i11, i12);
            return;
        }
        boolean z12 = false;
        if (this.mLastWidthMeasureSpec == i11 && this.mLastHeightMeasureSpec == i12) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            I();
            processTransitionCompleted();
            z11 = true;
        }
        if (this.mDirtyHierarchy) {
            z11 = true;
        }
        this.mLastWidthMeasureSpec = i11;
        this.mLastHeightMeasureSpec = i12;
        int u11 = this.f10916b.u();
        int j11 = this.f10916b.j();
        if ((z11 || this.M.isNotConfiguredWith(u11, j11)) && this.mBeginState != -1) {
            super.onMeasure(i11, i12);
            this.M.c(this.mLayoutWidget, this.f10916b.h(u11), this.f10916b.h(j11));
            this.M.reEvaluateState();
            this.M.setMeasuredId(u11, j11);
        } else {
            if (z11) {
                super.onMeasure(i11, i12);
            }
            z12 = true;
        }
        if (this.f10940z || z12) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i13 = this.E;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                int i14 = this.A;
                width = (int) (((float) i14) + (this.G * ((float) (this.C - i14))));
                requestLayout();
            }
            int i15 = this.F;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                int i16 = this.B;
                height = (int) (((float) i16) + (this.G * ((float) (this.D - i16))));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    public boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z11) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull View view, float f11, float f12) {
        return false;
    }

    public void onNestedPreScroll(@NonNull final View view, int i11, int i12, @NonNull int[] iArr, int i13) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int g11;
        MotionScene motionScene = this.f10916b;
        if (motionScene != null && (transition = motionScene.f11010b) != null && transition.isEnabled()) {
            int i14 = -1;
            if (!transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null || (g11 = touchResponse.g()) == -1 || view.getId() == g11) {
                if (motionScene.n()) {
                    TouchResponse touchResponse2 = transition.getTouchResponse();
                    if (!(touchResponse2 == null || (touchResponse2.getFlags() & 4) == 0)) {
                        i14 = i12;
                    }
                    float f11 = this.f10922h;
                    if ((f11 == 1.0f || f11 == 0.0f) && view.canScrollVertically(i14)) {
                        return;
                    }
                }
                if (!(transition.getTouchResponse() == null || (transition.getTouchResponse().getFlags() & 1) == 0)) {
                    float o11 = motionScene.o((float) i11, (float) i12);
                    float f12 = this.f10923i;
                    if ((f12 <= 0.0f && o11 < 0.0f) || (f12 >= 1.0f && o11 > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() {
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                }
                float f13 = this.f10922h;
                long nanoTime = getNanoTime();
                float f14 = (float) i11;
                this.f10935u = f14;
                float f15 = (float) i12;
                this.f10936v = f15;
                this.f10938x = (float) (((double) (nanoTime - this.f10937w)) * 1.0E-9d);
                this.f10937w = nanoTime;
                motionScene.w(f14, f15);
                if (f13 != this.f10922h) {
                    iArr[0] = i11;
                    iArr[1] = i12;
                }
                B(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.f10934t = true;
                }
            }
        }
    }

    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15) {
    }

    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (!(!this.f10934t && i11 == 0 && i12 == 0)) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
        }
        this.f10934t = false;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11, int i12) {
        this.f10937w = getNanoTime();
        this.f10938x = 0.0f;
        this.f10935u = 0.0f;
        this.f10936v = 0.0f;
    }

    public void onRtlPropertiesChanged(int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11, int i12) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.f10916b;
        if (motionScene == null || (transition = motionScene.f11010b) == null || transition.getTouchResponse() == null || (this.f10916b.f11010b.getTouchResponse().getFlags() & 2) != 0) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(@NonNull View view, int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            float f11 = this.f10938x;
            if (f11 != 0.0f) {
                motionScene.x(this.f10935u / f11, this.f10936v / f11);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.C()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.f10916b.f11010b;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f10916b.y(motionEvent, getCurrentState(), this);
        if (this.f10916b.f11010b.isTransitionFlag(4)) {
            return this.f10916b.f11010b.getTouchResponse().h();
        }
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.M.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.f10940z && this.f10920f == -1 && (motionScene = this.f10916b) != null && (transition = motionScene.f11010b) != null) {
            int layoutDuringTransition = transition.getLayoutDuringTransition();
            if (layoutDuringTransition != 0) {
                if (layoutDuringTransition == 2) {
                    int childCount = getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        this.f10921g.get(getChildAt(i11)).remeasure();
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    @RequiresApi(api = 17)
    public void rotateTo(int i11, int i12) {
        int i13 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int rotation = getDisplay().getRotation();
        if ((rotation + 1) % 4 <= (this.mPreviouseRotation + 1) % 4) {
            i13 = 2;
        }
        this.I = i13;
        this.mPreviouseRotation = rotation;
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            ViewState viewState = this.J.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                this.J.put(childAt, viewState);
            }
            viewState.getState(childAt);
        }
        this.mBeginState = -1;
        this.mEndState = i11;
        this.f10916b.A(-1, i11);
        this.M.c(this.mLayoutWidget, (ConstraintSet) null, this.f10916b.h(this.mEndState));
        this.f10922h = 0.0f;
        this.f10923i = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() {
            public void run() {
                boolean unused = MotionLayout.this.mInRotation = false;
            }
        });
        if (i12 > 0) {
            this.mTransitionDuration = ((float) i12) / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i11) {
        if (getCurrentState() == -1) {
            transitionToState(i11);
            return;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null) {
            this.mScheduledTransitionTo = new int[4];
        } else if (iArr.length <= this.H) {
            this.mScheduledTransitionTo = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mScheduledTransitionTo;
        int i12 = this.H;
        this.H = i12 + 1;
        iArr2[i12] = i11;
    }

    public void setDebugMode(int i11) {
        this.f10927m = i11;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z11) {
        this.mDelayedApply = z11;
    }

    public void setInteractionEnabled(boolean z11) {
        this.mInteractionEnabled = z11;
    }

    public void setInterpolatedProgress(float f11) {
        if (this.f10916b != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.f10916b.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f11));
                return;
            }
        }
        setProgress(f11);
    }

    public void setOnHide(float f11) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mOnHideHelpers.get(i11).setProgress(f11);
            }
        }
    }

    public void setOnShow(float f11) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mOnShowHelpers.get(i11).setProgress(f11);
            }
        }
    }

    public void setProgress(float f11, float f12) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f11);
            this.mStateCache.setVelocity(f12);
            return;
        }
        setProgress(f11);
        setState(TransitionState.MOVING);
        this.f10919e = f12;
        float f13 = 0.0f;
        int i11 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i11 != 0) {
            if (i11 > 0) {
                f13 = 1.0f;
            }
            y(f13);
        } else if (f11 != 0.0f && f11 != 1.0f) {
            if (f11 > 0.5f) {
                f13 = 1.0f;
            }
            y(f13);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.f10916b = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    public void setStartState(int i11) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i11);
            this.mStateCache.setEndState(i11);
            return;
        }
        this.f10920f = i11;
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.f10920f != -1) {
            TransitionState transitionState3 = this.L;
            this.L = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                fireTransitionChange();
            }
            int i11 = AnonymousClass5.f10946a[transitionState3.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (transitionState == transitionState4) {
                    fireTransitionChange();
                }
                if (transitionState == transitionState2) {
                    C();
                }
            } else if (i11 == 3 && transitionState == transitionState2) {
                C();
            }
        }
    }

    public void setTransition(int i11, int i12) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i11);
            this.mStateCache.setEndState(i12);
            return;
        }
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            this.mBeginState = i11;
            this.mEndState = i12;
            motionScene.A(i11, i12);
            this.M.c(this.mLayoutWidget, this.f10916b.h(i11), this.f10916b.h(i12));
            rebuildScene();
            this.f10923i = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            motionScene.setDuration(i11);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.a();
        }
    }

    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.f10923i + " Dpos/Dt:" + this.f10919e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r10 != 7) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void touchAnimateTo(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f10916b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r9.f10923i
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r9.mTemporalInterpolator = r0
            long r1 = r9.getNanoTime()
            r9.mAnimationStartTime = r1
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.f10916b
            int r1 = r1.getDuration()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.mTransitionDuration = r1
            r9.f10924j = r11
            r9.f10925k = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x0093
            if (r10 == r0) goto L_0x0093
            if (r10 == r4) goto L_0x0093
            r5 = 4
            if (r10 == r5) goto L_0x0081
            r5 = 5
            if (r10 == r5) goto L_0x003b
            if (r10 == r3) goto L_0x0093
            if (r10 == r2) goto L_0x0093
            goto L_0x00f1
        L_0x003b:
            float r10 = r9.f10923i
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f10916b
            float r0 = r0.l()
            boolean r10 = willJump(r12, r10, r0)
            if (r10 == 0) goto L_0x005c
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            float r11 = r9.f10923i
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f10916b
            float r0 = r0.l()
            r10.config(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            r9.f10917c = r10
            goto L_0x00f1
        L_0x005c:
            androidx.constraintlayout.motion.utils.StopLogic r2 = r9.mStopLogic
            float r3 = r9.f10923i
            float r6 = r9.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r7 = r10.l()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r8 = r10.m()
            r4 = r11
            r5 = r12
            r2.config(r3, r4, r5, r6, r7, r8)
            r9.f10919e = r1
            int r10 = r9.f10920f
            r9.f10924j = r11
            r9.f10920f = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.mStopLogic
            r9.f10917c = r10
            goto L_0x00f1
        L_0x0081:
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            float r11 = r9.f10923i
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f10916b
            float r0 = r0.l()
            r10.config(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            r9.f10917c = r10
            goto L_0x00f1
        L_0x0093:
            if (r10 == r0) goto L_0x009f
            if (r10 != r2) goto L_0x0098
            goto L_0x009f
        L_0x0098:
            if (r10 == r4) goto L_0x009c
            if (r10 != r3) goto L_0x00a0
        L_0x009c:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a0
        L_0x009f:
            r11 = r1
        L_0x00a0:
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            int r10 = r10.g()
            if (r10 != 0) goto L_0x00c0
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.mStopLogic
            float r1 = r9.f10923i
            float r4 = r9.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r5 = r10.l()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r6 = r10.m()
            r2 = r11
            r3 = r12
            r0.config(r1, r2, r3, r4, r5, r6)
            goto L_0x00e7
        L_0x00c0:
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.mStopLogic
            float r1 = r9.f10923i
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r4 = r10.r()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r5 = r10.s()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r6 = r10.q()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            float r7 = r10.t()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f10916b
            int r8 = r10.p()
            r2 = r11
            r3 = r12
            r0.springConfig(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00e7:
            int r10 = r9.f10920f
            r9.f10924j = r11
            r9.f10920f = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.mStopLogic
            r9.f10917c = r10
        L_0x00f1:
            r10 = 0
            r9.mTransitionInstantly = r10
            long r10 = r9.getNanoTime()
            r9.mAnimationStartTime = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f11, float f12) {
        if (this.f10916b != null && this.f10923i != f11) {
            this.mTemporalInterpolator = true;
            this.mAnimationStartTime = getNanoTime();
            this.mTransitionDuration = ((float) this.f10916b.getDuration()) / 1000.0f;
            this.f10924j = f11;
            this.f10925k = true;
            this.mStopLogic.springConfig(this.f10923i, f11, f12, this.f10916b.r(), this.f10916b.s(), this.f10916b.q(), this.f10916b.t(), this.f10916b.p());
            int i11 = this.f10920f;
            this.f10924j = f11;
            this.f10920f = i11;
            this.f10917c = this.mStopLogic;
            this.mTransitionInstantly = false;
            this.mAnimationStartTime = getNanoTime();
            invalidate();
        }
    }

    public void transitionToEnd() {
        y(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToStart() {
        y(0.0f);
    }

    public void transitionToState(int i11) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i11);
            return;
        }
        transitionToState(i11, -1, -1);
    }

    public void updateState(int i11, ConstraintSet constraintSet) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            motionScene.setConstraintSet(i11, constraintSet);
        }
        updateState();
        if (this.f10920f == i11) {
            constraintSet.applyTo(this);
        }
    }

    public void updateStateAnimate(int i11, ConstraintSet constraintSet, int i12) {
        if (this.f10916b != null && this.f10920f == i11) {
            int i13 = R.id.view_transition;
            updateState(i13, getConstraintSet(i11));
            setState(i13, -1, -1);
            updateState(i11, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.f10916b, i13, i11);
            transition.setDuration(i12);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i11, View... viewArr) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            motionScene.viewTransition(i11, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    public void y(float f11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            float f12 = this.f10923i;
            float f13 = this.f10922h;
            if (f12 != f13 && this.mTransitionInstantly) {
                this.f10923i = f13;
            }
            float f14 = this.f10923i;
            if (f14 != f11) {
                this.mTemporalInterpolator = false;
                this.f10924j = f11;
                this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
                setProgress(this.f10924j);
                this.f10917c = null;
                this.f10918d = this.f10916b.getInterpolator();
                this.mTransitionInstantly = false;
                this.mAnimationStartTime = getNanoTime();
                this.f10925k = true;
                this.f10922h = f14;
                this.f10923i = f14;
                invalidate();
            }
        }
    }

    public void z(boolean z11) {
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            motionScene.disableAutoTransition(z11);
        }
    }

    public static class MyTracker implements MotionTracker {

        /* renamed from: me  reason: collision with root package name */
        private static MyTracker f10978me = new MyTracker();

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f10979a;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            f10978me.f10979a = VelocityTracker.obtain();
            return f10978me;
        }

        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public void clear() {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        public void computeCurrentVelocity(int i11) {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i11);
            }
        }

        public float getXVelocity() {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public float getYVelocity() {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public void recycle() {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10979a = null;
            }
        }

        public void computeCurrentVelocity(int i11, float f11) {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i11, f11);
            }
        }

        public float getXVelocity(int i11) {
            VelocityTracker velocityTracker = this.f10979a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i11);
            }
            return 0.0f;
        }

        public float getYVelocity(int i11) {
            if (this.f10979a != null) {
                return getYVelocity(i11);
            }
            return 0.0f;
        }
    }

    public void transitionToEnd(Runnable runnable) {
        y(1.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToState(int i11, int i12) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i11);
            return;
        }
        transitionToState(i11, -1, -1, i12);
    }

    public void updateState() {
        this.M.c(this.mLayoutWidget, this.f10916b.h(this.mBeginState), this.f10916b.h(this.mEndState));
        rebuildScene();
    }

    public void setState(int i11, int i12, int i13) {
        setState(TransitionState.SETUP);
        this.f10920f = i11;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i11, (float) i12, (float) i13);
            return;
        }
        MotionScene motionScene = this.f10916b;
        if (motionScene != null) {
            motionScene.h(i11).applyTo(this);
        }
    }

    public void setProgress(float f11) {
        int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i11 < 0 || f11 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f11);
            return;
        }
        if (i11 <= 0) {
            if (this.f10923i == 1.0f && this.f10920f == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.f10920f = this.mBeginState;
            if (this.f10923i == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f11 >= 1.0f) {
            if (this.f10923i == 0.0f && this.f10920f == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.f10920f = this.mEndState;
            if (this.f10923i == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f10920f = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f10916b != null) {
            this.mTransitionInstantly = true;
            this.f10924j = f11;
            this.f10922h = f11;
            this.mTransitionLastTime = -1;
            this.mAnimationStartTime = -1;
            this.f10917c = null;
            this.f10925k = true;
            invalidate();
        }
    }

    public void transitionToState(int i11, int i12, int i13) {
        transitionToState(i11, i12, i13, -1);
    }

    public void transitionToState(int i11, int i12, int i13, int i14) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.f10916b;
        if (!(motionScene == null || (stateSet = motionScene.f11009a) == null || (convertToConstraintSet = stateSet.convertToConstraintSet(this.f10920f, i11, (float) i12, (float) i13)) == -1)) {
            i11 = convertToConstraintSet;
        }
        int i15 = this.f10920f;
        if (i15 != i11) {
            if (this.mBeginState == i11) {
                y(0.0f);
                if (i14 > 0) {
                    this.mTransitionDuration = ((float) i14) / 1000.0f;
                }
            } else if (this.mEndState == i11) {
                y(1.0f);
                if (i14 > 0) {
                    this.mTransitionDuration = ((float) i14) / 1000.0f;
                }
            } else {
                this.mEndState = i11;
                if (i15 != -1) {
                    setTransition(i15, i11);
                    y(1.0f);
                    this.f10923i = 0.0f;
                    transitionToEnd();
                    if (i14 > 0) {
                        this.mTransitionDuration = ((float) i14) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.mTemporalInterpolator = false;
                this.f10924j = 1.0f;
                this.f10922h = 0.0f;
                this.f10923i = 0.0f;
                this.mTransitionLastTime = getNanoTime();
                this.mAnimationStartTime = getNanoTime();
                this.mTransitionInstantly = false;
                this.f10917c = null;
                if (i14 == -1) {
                    this.mTransitionDuration = ((float) this.f10916b.getDuration()) / 1000.0f;
                }
                this.mBeginState = -1;
                this.f10916b.A(-1, this.mEndState);
                SparseArray sparseArray = new SparseArray();
                if (i14 == 0) {
                    this.mTransitionDuration = ((float) this.f10916b.getDuration()) / 1000.0f;
                } else if (i14 > 0) {
                    this.mTransitionDuration = ((float) i14) / 1000.0f;
                }
                int childCount = getChildCount();
                this.f10921g.clear();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = getChildAt(i16);
                    this.f10921g.put(childAt, new MotionController(childAt));
                    sparseArray.put(childAt.getId(), this.f10921g.get(childAt));
                }
                this.f10925k = true;
                this.M.c(this.mLayoutWidget, (ConstraintSet) null, this.f10916b.h(i11));
                rebuildScene();
                this.M.build();
                computeCurrentPositions();
                int width = getWidth();
                int height = getHeight();
                if (this.mDecoratorsHelpers != null) {
                    for (int i17 = 0; i17 < childCount; i17++) {
                        MotionController motionController = this.f10921g.get(getChildAt(i17));
                        if (motionController != null) {
                            this.f10916b.getKeyFrames(motionController);
                        }
                    }
                    Iterator<MotionHelper> it = this.mDecoratorsHelpers.iterator();
                    while (it.hasNext()) {
                        it.next().onPreSetup(this, this.f10921g);
                    }
                    for (int i18 = 0; i18 < childCount; i18++) {
                        MotionController motionController2 = this.f10921g.get(getChildAt(i18));
                        if (motionController2 != null) {
                            motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
                        }
                    }
                } else {
                    for (int i19 = 0; i19 < childCount; i19++) {
                        MotionController motionController3 = this.f10921g.get(getChildAt(i19));
                        if (motionController3 != null) {
                            this.f10916b.getKeyFrames(motionController3);
                            motionController3.setup(width, height, this.mTransitionDuration, getNanoTime());
                        }
                    }
                }
                float staggered = this.f10916b.getStaggered();
                if (staggered != 0.0f) {
                    float f11 = Float.MAX_VALUE;
                    float f12 = -3.4028235E38f;
                    for (int i21 = 0; i21 < childCount; i21++) {
                        MotionController motionController4 = this.f10921g.get(getChildAt(i21));
                        float finalY = motionController4.getFinalY() + motionController4.getFinalX();
                        f11 = Math.min(f11, finalY);
                        f12 = Math.max(f12, finalY);
                    }
                    for (int i22 = 0; i22 < childCount; i22++) {
                        MotionController motionController5 = this.f10921g.get(getChildAt(i22));
                        float finalX = motionController5.getFinalX();
                        float finalY2 = motionController5.getFinalY();
                        motionController5.f10911h = 1.0f / (1.0f - staggered);
                        motionController5.f10910g = staggered - ((((finalX + finalY2) - f11) * staggered) / (f12 - f11));
                    }
                }
                this.f10922h = 0.0f;
                this.f10923i = 0.0f;
                this.f10925k = true;
                invalidate();
            }
        }
    }

    public void setTransition(int i11) {
        float f11;
        if (this.f10916b != null) {
            MotionScene.Transition transition = getTransition(i11);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i12 = this.f10920f;
            float f12 = 0.0f;
            if (i12 == this.mBeginState) {
                f11 = 0.0f;
            } else {
                f11 = i12 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.f10916b.setTransition(transition);
            this.M.c(this.mLayoutWidget, this.f10916b.h(this.mBeginState), this.f10916b.h(this.mEndState));
            rebuildScene();
            if (this.f10923i != f11) {
                if (f11 == 0.0f) {
                    A(true);
                    this.f10916b.h(this.mBeginState).applyTo(this);
                } else if (f11 == 1.0f) {
                    A(false);
                    this.f10916b.h(this.mEndState).applyTo(this);
                }
            }
            if (!Float.isNaN(f11)) {
                f12 = f11;
            }
            this.f10923i = f12;
            if (Float.isNaN(f11)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Debug.getLocation());
                sb2.append(" transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f11);
        }
    }

    private void checkStructure(int i11, ConstraintSet constraintSet) {
        String name2 = Debug.getName(getContext(), i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + name2 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.getConstraint(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + name2 + " NO CONSTRAINTS for " + Debug.getName(childAt));
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i13 = 0; i13 < knownIds.length; i13++) {
            int i14 = knownIds[i13];
            String name3 = Debug.getName(getContext(), i14);
            if (findViewById(knownIds[i13]) == null) {
                Log.w("MotionLayout", "CHECK: " + name2 + " NO View matches id " + name3);
            }
            if (constraintSet.getHeight(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + name2 + "(" + name3 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + name2 + "(" + name3 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    public void setTransition(MotionScene.Transition transition) {
        this.f10916b.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.f10920f == this.f10916b.j()) {
            this.f10923i = 1.0f;
            this.f10922h = 1.0f;
            this.f10924j = 1.0f;
        } else {
            this.f10923i = 0.0f;
            this.f10922h = 0.0f;
            this.f10924j = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1 : getNanoTime();
        int u11 = this.f10916b.u();
        int j11 = this.f10916b.j();
        if (u11 != this.mBeginState || j11 != this.mEndState) {
            this.mBeginState = u11;
            this.mEndState = j11;
            this.f10916b.A(u11, j11);
            this.M.c(this.mLayoutWidget, this.f10916b.h(this.mBeginState), this.f10916b.h(this.mEndState));
            this.M.setMeasuredId(this.mBeginState, this.mEndState);
            this.M.reEvaluateState();
            rebuildScene();
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }
}
