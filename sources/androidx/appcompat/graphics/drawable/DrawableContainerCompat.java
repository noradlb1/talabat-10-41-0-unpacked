package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;
import net.bytebuddy.jar.asm.Opcodes;

public class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha = 255;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex = -1;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources getResources(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    public static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
            Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j11);
            }
        }

        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.mCallback;
            this.mCallback = null;
            return callback;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            this.mCallback = callback;
            return this;
        }
    }

    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        public int A = 0;
        public int B = 0;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a  reason: collision with root package name */
        public final DrawableContainerCompat f645a;

        /* renamed from: b  reason: collision with root package name */
        public Resources f646b;

        /* renamed from: c  reason: collision with root package name */
        public int f647c;

        /* renamed from: d  reason: collision with root package name */
        public int f648d;

        /* renamed from: e  reason: collision with root package name */
        public int f649e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f650f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable[] f651g;

        /* renamed from: h  reason: collision with root package name */
        public int f652h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f653i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f654j;

        /* renamed from: k  reason: collision with root package name */
        public Rect f655k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f656l = false;

        /* renamed from: m  reason: collision with root package name */
        public boolean f657m;

        /* renamed from: n  reason: collision with root package name */
        public int f658n;

        /* renamed from: o  reason: collision with root package name */
        public int f659o;

        /* renamed from: p  reason: collision with root package name */
        public int f660p;

        /* renamed from: q  reason: collision with root package name */
        public int f661q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f662r;

        /* renamed from: s  reason: collision with root package name */
        public int f663s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f664t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f665u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f666v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f667w;

        /* renamed from: x  reason: collision with root package name */
        public boolean f668x = true;

        /* renamed from: y  reason: collision with root package name */
        public boolean f669y;

        /* renamed from: z  reason: collision with root package name */
        public int f670z;

        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            Resources resources2;
            int i11;
            this.f645a = drawableContainerCompat;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else if (drawableContainerState != null) {
                resources2 = drawableContainerState.f646b;
            } else {
                resources2 = null;
            }
            this.f646b = resources2;
            if (drawableContainerState != null) {
                i11 = drawableContainerState.f647c;
            } else {
                i11 = 0;
            }
            int d11 = DrawableContainerCompat.d(resources, i11);
            this.f647c = d11;
            if (drawableContainerState != null) {
                this.f648d = drawableContainerState.f648d;
                this.f649e = drawableContainerState.f649e;
                this.f666v = true;
                this.f667w = true;
                this.f653i = drawableContainerState.f653i;
                this.f656l = drawableContainerState.f656l;
                this.f668x = drawableContainerState.f668x;
                this.f669y = drawableContainerState.f669y;
                this.f670z = drawableContainerState.f670z;
                this.A = drawableContainerState.A;
                this.B = drawableContainerState.B;
                this.C = drawableContainerState.C;
                this.D = drawableContainerState.D;
                this.E = drawableContainerState.E;
                this.F = drawableContainerState.F;
                this.G = drawableContainerState.G;
                this.H = drawableContainerState.H;
                this.I = drawableContainerState.I;
                if (drawableContainerState.f647c == d11) {
                    if (drawableContainerState.f654j) {
                        this.f655k = drawableContainerState.f655k != null ? new Rect(drawableContainerState.f655k) : rect;
                        this.f654j = true;
                    }
                    if (drawableContainerState.f657m) {
                        this.f658n = drawableContainerState.f658n;
                        this.f659o = drawableContainerState.f659o;
                        this.f660p = drawableContainerState.f660p;
                        this.f661q = drawableContainerState.f661q;
                        this.f657m = true;
                    }
                }
                if (drawableContainerState.f662r) {
                    this.f663s = drawableContainerState.f663s;
                    this.f662r = true;
                }
                if (drawableContainerState.f664t) {
                    this.f665u = drawableContainerState.f665u;
                    this.f664t = true;
                }
                Drawable[] drawableArr = drawableContainerState.f651g;
                this.f651g = new Drawable[drawableArr.length];
                this.f652h = drawableContainerState.f652h;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.f650f;
                if (sparseArray != null) {
                    this.f650f = sparseArray.clone();
                } else {
                    this.f650f = new SparseArray<>(this.f652h);
                }
                int i12 = this.f652h;
                for (int i13 = 0; i13 < i12; i13++) {
                    Drawable drawable = drawableArr[i13];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f650f.put(i13, constantState);
                        } else {
                            this.f651g[i13] = drawableArr[i13];
                        }
                    }
                }
                return;
            }
            this.f651g = new Drawable[10];
            this.f652h = 0;
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f650f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i11 = 0; i11 < size; i11++) {
                    this.f651g[this.f650f.keyAt(i11)] = prepareDrawable(this.f650f.valueAt(i11).newDrawable(this.f646b));
                }
                this.f650f = null;
            }
        }

        private Drawable prepareDrawable(Drawable drawable) {
            DrawableCompat.setLayoutDirection(drawable, this.f670z);
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f645a);
            return mutate;
        }

        @RequiresApi(21)
        public final void a(Resources.Theme theme) {
            if (theme != null) {
                createAllFutures();
                int i11 = this.f652h;
                Drawable[] drawableArr = this.f651g;
                for (int i12 = 0; i12 < i11; i12++) {
                    Drawable drawable = drawableArr[i12];
                    if (drawable != null && DrawableCompat.canApplyTheme(drawable)) {
                        DrawableCompat.applyTheme(drawableArr[i12], theme);
                        this.f649e |= drawableArr[i12].getChangingConfigurations();
                    }
                }
                g(Api21Impl.getResources(theme));
            }
        }

        public final int addChild(Drawable drawable) {
            int i11 = this.f652h;
            if (i11 >= this.f651g.length) {
                growArray(i11, i11 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f645a);
            this.f651g[i11] = drawable;
            this.f652h++;
            this.f649e = drawable.getChangingConfigurations() | this.f649e;
            d();
            this.f655k = null;
            this.f654j = false;
            this.f657m = false;
            this.f666v = false;
            return i11;
        }

        public void b() {
            this.f657m = true;
            createAllFutures();
            int i11 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            this.f659o = -1;
            this.f658n = -1;
            this.f661q = 0;
            this.f660p = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f658n) {
                    this.f658n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f659o) {
                    this.f659o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f660p) {
                    this.f660p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f661q) {
                    this.f661q = minimumHeight;
                }
            }
        }

        public final int c() {
            return this.f651g.length;
        }

        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i11 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f650f.get(i12);
                    if (constantState != null && Api21Impl.canApplyTheme(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.canApplyTheme(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canConstantState() {
            if (this.f666v) {
                return this.f667w;
            }
            createAllFutures();
            this.f666v = true;
            int i11 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getConstantState() == null) {
                    this.f667w = false;
                    return false;
                }
            }
            this.f667w = true;
            return true;
        }

        public void d() {
            this.f662r = false;
            this.f664t = false;
        }

        public void e() {
            int i11 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.f669y = true;
        }

        public final boolean f(int i11, int i12) {
            int i13 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            boolean z11 = false;
            for (int i14 = 0; i14 < i13; i14++) {
                Drawable drawable = drawableArr[i14];
                if (drawable != null) {
                    boolean layoutDirection = DrawableCompat.setLayoutDirection(drawable, i11);
                    if (i14 == i12) {
                        z11 = layoutDirection;
                    }
                }
            }
            this.f670z = i11;
            return z11;
        }

        public final void g(Resources resources) {
            if (resources != null) {
                this.f646b = resources;
                int d11 = DrawableContainerCompat.d(resources, this.f647c);
                int i11 = this.f647c;
                this.f647c = d11;
                if (i11 != d11) {
                    this.f657m = false;
                    this.f654j = false;
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f648d | this.f649e;
        }

        public final Drawable getChild(int i11) {
            int indexOfKey;
            Drawable drawable = this.f651g[i11];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f650f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i11)) < 0) {
                return null;
            }
            Drawable prepareDrawable = prepareDrawable(this.f650f.valueAt(indexOfKey).newDrawable(this.f646b));
            this.f651g[i11] = prepareDrawable;
            this.f650f.removeAt(indexOfKey);
            if (this.f650f.size() == 0) {
                this.f650f = null;
            }
            return prepareDrawable;
        }

        public final int getChildCount() {
            return this.f652h;
        }

        public final int getConstantHeight() {
            if (!this.f657m) {
                b();
            }
            return this.f659o;
        }

        public final int getConstantMinimumHeight() {
            if (!this.f657m) {
                b();
            }
            return this.f661q;
        }

        public final int getConstantMinimumWidth() {
            if (!this.f657m) {
                b();
            }
            return this.f660p;
        }

        public final Rect getConstantPadding() {
            Rect rect = null;
            if (this.f653i) {
                return null;
            }
            Rect rect2 = this.f655k;
            if (rect2 != null || this.f654j) {
                return rect2;
            }
            createAllFutures();
            Rect rect3 = new Rect();
            int i11 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i13 = rect3.left;
                    if (i13 > rect.left) {
                        rect.left = i13;
                    }
                    int i14 = rect3.top;
                    if (i14 > rect.top) {
                        rect.top = i14;
                    }
                    int i15 = rect3.right;
                    if (i15 > rect.right) {
                        rect.right = i15;
                    }
                    int i16 = rect3.bottom;
                    if (i16 > rect.bottom) {
                        rect.bottom = i16;
                    }
                }
            }
            this.f654j = true;
            this.f655k = rect;
            return rect;
        }

        public final int getConstantWidth() {
            if (!this.f657m) {
                b();
            }
            return this.f658n;
        }

        public final int getEnterFadeDuration() {
            return this.A;
        }

        public final int getExitFadeDuration() {
            return this.B;
        }

        public final int getOpacity() {
            int i11;
            if (this.f662r) {
                return this.f663s;
            }
            createAllFutures();
            int i12 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            if (i12 > 0) {
                i11 = drawableArr[0].getOpacity();
            } else {
                i11 = -2;
            }
            for (int i13 = 1; i13 < i12; i13++) {
                i11 = Drawable.resolveOpacity(i11, drawableArr[i13].getOpacity());
            }
            this.f663s = i11;
            this.f662r = true;
            return i11;
        }

        public void growArray(int i11, int i12) {
            Drawable[] drawableArr = new Drawable[i12];
            Drawable[] drawableArr2 = this.f651g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i11);
            }
            this.f651g = drawableArr;
        }

        public final boolean isConstantSize() {
            return this.f656l;
        }

        public final boolean isStateful() {
            if (this.f664t) {
                return this.f665u;
            }
            createAllFutures();
            int i11 = this.f652h;
            Drawable[] drawableArr = this.f651g;
            boolean z11 = false;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                } else if (drawableArr[i12].isStateful()) {
                    z11 = true;
                    break;
                } else {
                    i12++;
                }
            }
            this.f665u = z11;
            this.f664t = true;
            return z11;
        }

        public final void setConstantSize(boolean z11) {
            this.f656l = z11;
        }

        public final void setEnterFadeDuration(int i11) {
            this.A = i11;
        }

        public final void setExitFadeDuration(int i11) {
            this.B = i11;
        }

        public final void setVariablePadding(boolean z11) {
            this.f653i = z11;
        }
    }

    public static int d(@Nullable Resources resources, int i11) {
        if (resources != null) {
            i11 = resources.getDisplayMetrics().densityDpi;
        }
        return i11 == 0 ? Opcodes.IF_ICMPNE : i11;
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.mBlockInvalidateCallback.wrap(drawable.getCallback()));
        try {
            if (this.mDrawableContainerState.A <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState.E) {
                drawable.setColorFilter(drawableContainerState.D);
            } else {
                if (drawableContainerState.H) {
                    DrawableCompat.setTintList(drawable, drawableContainerState.F);
                }
                DrawableContainerState drawableContainerState2 = this.mDrawableContainerState;
                if (drawableContainerState2.I) {
                    DrawableCompat.setTintMode(drawable, drawableContainerState2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.f668x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            DrawableCompat.setAutoMirrored(drawable, this.mDrawableContainerState.C);
            Rect rect = this.mHotspotBounds;
            if (rect != null) {
                DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
        }
    }

    private boolean needsMirroring() {
        if (!isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.mHasAlpha = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.mCurrDrawable
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x0036
            long r9 = r13.mEnterAnimationEnd
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0038
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.mAlpha
            r3.setAlpha(r9)
            r13.mEnterAnimationEnd = r6
            goto L_0x0038
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r13.mDrawableContainerState
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.mAlpha
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L_0x0039
        L_0x0036:
            r13.mEnterAnimationEnd = r6
        L_0x0038:
            r3 = r8
        L_0x0039:
            android.graphics.drawable.Drawable r9 = r13.mLastDrawable
            if (r9 == 0) goto L_0x0061
            long r10 = r13.mExitAnimationEnd
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0063
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r8, r8)
            r0 = 0
            r13.mLastDrawable = r0
            r13.mExitAnimationEnd = r6
            goto L_0x0063
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.mDrawableContainerState
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.mAlpha
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0064
        L_0x0061:
            r13.mExitAnimationEnd = r6
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r14 == 0) goto L_0x0070
            if (r0 == 0) goto L_0x0070
            java.lang.Runnable r14 = r13.mAnimationRunnable
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.mDrawableContainerState.a(theme);
    }

    public DrawableContainerState b() {
        return this.mDrawableContainerState;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.mCurIndex;
    }

    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(int r10) {
        /*
            r9 = this;
            int r0 = r9.mCurIndex
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.mDrawableContainerState
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.mLastDrawable
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L_0x0029
            r9.mLastDrawable = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.mDrawableContainerState
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.mExitAnimationEnd = r0
            goto L_0x0035
        L_0x0029:
            r9.mLastDrawable = r4
            r9.mExitAnimationEnd = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.mDrawableContainerState
            int r1 = r0.f652h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.getChild(r10)
            r9.mCurrDrawable = r0
            r9.mCurIndex = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.mDrawableContainerState
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.mEnterAnimationEnd = r2
        L_0x0051:
            r9.initializeDrawableForDisplay(r0)
            goto L_0x005a
        L_0x0055:
            r9.mCurrDrawable = r4
            r10 = -1
            r9.mCurIndex = r10
        L_0x005a:
            long r0 = r9.mEnterAnimationEnd
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L_0x0067
            long r1 = r9.mExitAnimationEnd
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r10 = r9.mAnimationRunnable
            if (r10 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r10 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r10.<init>()
            r9.mAnimationRunnable = r10
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r10)
        L_0x0076:
            r9.a(r0)
        L_0x0079:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.e(int):boolean");
    }

    public void f(DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        int i11 = this.mCurIndex;
        if (i11 >= 0) {
            Drawable child = drawableContainerState.getChild(i11);
            this.mCurrDrawable = child;
            if (child != null) {
                initializeDrawableForDisplay(child);
            }
        }
        this.mLastDrawable = null;
    }

    public final void g(Resources resources) {
        this.mDrawableContainerState.g(resources);
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.mDrawableContainerState.canConstantState()) {
            return null;
        }
        this.mDrawableContainerState.f648d = getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.mDrawableContainerState.getOpacity();
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            Api21Impl.getOutline(drawable, outline);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        boolean z11;
        Rect constantPadding = this.mDrawableContainerState.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            if ((constantPadding.right | constantPadding.left | constantPadding.top | constantPadding.bottom) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                z11 = drawable.getPadding(rect);
            } else {
                z11 = super.getPadding(rect);
            }
        }
        if (needsMirroring()) {
            int i11 = rect.left;
            rect.left = rect.right;
            rect.right = i11;
        }
        return z11;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState != null) {
            drawableContainerState.d();
        }
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.C;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        boolean z11;
        Drawable drawable = this.mLastDrawable;
        boolean z12 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z11 = true;
        } else {
            z11 = false;
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0;
            z11 = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0;
        } else {
            z12 = z11;
        }
        if (z12) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            DrawableContainerState b11 = b();
            b11.e();
            f(b11);
            this.mMutated = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i11) {
        return this.mDrawableContainerState.f(i11, c());
    }

    public boolean onLevelChange(int i11) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i11);
        }
        return false;
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j11);
        }
    }

    public void setAlpha(int i11) {
        if (!this.mHasAlpha || this.mAlpha != i11) {
            this.mHasAlpha = true;
            this.mAlpha = i11;
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null) {
                return;
            }
            if (this.mEnterAnimationEnd == 0) {
                drawable.setAlpha(i11);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z11) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.C != z11) {
            drawableContainerState.C = z11;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z11);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.E = true;
        if (drawableContainerState.D != colorFilter) {
            drawableContainerState.D = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z11) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.f668x != z11) {
            drawableContainerState.f668x = z11;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z11);
            }
        }
    }

    public void setEnterFadeDuration(int i11) {
        this.mDrawableContainerState.A = i11;
    }

    public void setExitFadeDuration(int i11) {
        this.mDrawableContainerState.B = i11;
    }

    public void setHotspot(float f11, float f12) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f11, f12);
        }
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(i11, i12, i13, i14);
        } else {
            rect.set(i11, i12, i13, i14);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i11, i12, i13, i14);
        }
    }

    public void setTint(@ColorInt int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.H = true;
        if (drawableContainerState.F != colorStateList) {
            drawableContainerState.F = colorStateList;
            DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.I = true;
        if (drawableContainerState.G != mode) {
            drawableContainerState.G = mode;
            DrawableCompat.setTintMode(this.mCurrDrawable, mode);
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z11, z12);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z11, z12);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
