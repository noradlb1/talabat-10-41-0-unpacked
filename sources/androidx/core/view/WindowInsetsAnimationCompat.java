package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;

        /* renamed from: b  reason: collision with root package name */
        public WindowInsets f11504b;
        private final int mDispatchMode;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public Callback(int i11) {
            this.mDispatchMode = i11;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    public static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;
        @Nullable
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        public Impl(int i11, @Nullable Interpolator interpolator, long j11) {
            this.mTypeMask = i11;
            this.mInterpolator = interpolator;
            this.mDurationMillis = j11;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.mFraction);
            }
            return this.mFraction;
        }

        @Nullable
        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float f11) {
            this.mAlpha = f11;
        }

        public void setFraction(float f11) {
            this.mFraction = f11;
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl {

        @RequiresApi(21)
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;

            /* renamed from: a  reason: collision with root package name */
            public final Callback f11505a;
            private WindowInsetsCompat mLastInsets;

            public Impl21OnApplyWindowInsetsListener(@NonNull View view, @NonNull Callback callback) {
                WindowInsetsCompat windowInsetsCompat;
                this.f11505a = callback;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
                if (rootWindowInsets != null) {
                    windowInsetsCompat = new WindowInsetsCompat.Builder(rootWindowInsets).build();
                } else {
                    windowInsetsCompat = null;
                }
                this.mLastInsets = windowInsetsCompat;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                final View view2 = view;
                WindowInsets windowInsets2 = windowInsets;
                if (!view.isLaidOut()) {
                    this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets2, view2);
                    return Impl21.g(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets2, view2);
                if (this.mLastInsets == null) {
                    this.mLastInsets = ViewCompat.getRootWindowInsets(view);
                }
                if (this.mLastInsets == null) {
                    this.mLastInsets = windowInsetsCompat;
                    return Impl21.g(view, windowInsets);
                }
                Callback h11 = Impl21.h(view);
                if (h11 != null && Objects.equals(h11.f11504b, windowInsets2)) {
                    return Impl21.g(view, windowInsets);
                }
                final int a11 = Impl21.a(windowInsetsCompat, this.mLastInsets);
                if (a11 == 0) {
                    return Impl21.g(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(a11, new DecelerateInterpolator(), 160);
                windowInsetsAnimationCompat.setFraction(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                BoundsCompat b11 = Impl21.b(windowInsetsCompat, windowInsetsCompat2, a11);
                Impl21.d(view2, windowInsetsAnimationCompat, windowInsets2, false);
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                final WindowInsetsCompat windowInsetsCompat3 = windowInsetsCompat;
                final View view3 = view;
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        windowInsetsAnimationCompat2.setFraction(valueAnimator.getAnimatedFraction());
                        Impl21.e(view3, Impl21.i(windowInsetsCompat3, windowInsetsCompat2, windowInsetsAnimationCompat2.getInterpolatedFraction(), a11), Collections.singletonList(windowInsetsAnimationCompat2));
                    }
                });
                duration.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        windowInsetsAnimationCompat.setFraction(1.0f);
                        Impl21.c(view2, windowInsetsAnimationCompat);
                    }
                });
                final View view4 = view;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat3 = windowInsetsAnimationCompat;
                final BoundsCompat boundsCompat = b11;
                final ValueAnimator valueAnimator = duration;
                OneShotPreDrawListener.add(view2, new Runnable() {
                    public void run() {
                        Impl21.f(view4, windowInsetsAnimationCompat3, boundsCompat);
                        valueAnimator.start();
                    }
                });
                this.mLastInsets = windowInsetsCompat;
                return Impl21.g(view, windowInsets);
            }
        }

        public Impl21(int i11, @Nullable Interpolator interpolator, long j11) {
            super(i11, interpolator, j11);
        }

        @SuppressLint({"WrongConstant"})
        public static int a(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2) {
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if (!windowInsetsCompat.getInsets(i12).equals(windowInsetsCompat2.getInsets(i12))) {
                    i11 |= i12;
                }
            }
            return i11;
        }

        @NonNull
        public static BoundsCompat b(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2, int i11) {
            Insets insets = windowInsetsCompat.getInsets(i11);
            Insets insets2 = windowInsetsCompat2.getInsets(i11);
            return new BoundsCompat(Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
        }

        public static void c(@NonNull View view, @NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback h11 = h(view);
            if (h11 != null) {
                h11.onEnd(windowInsetsAnimationCompat);
                if (h11.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    c(viewGroup.getChildAt(i11), windowInsetsAnimationCompat);
                }
            }
        }

        @NonNull
        private static View.OnApplyWindowInsetsListener createProxyListener(@NonNull View view, @NonNull Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }

        public static void d(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z11) {
            Callback h11 = h(view);
            if (h11 != null) {
                h11.f11504b = windowInsets;
                if (!z11) {
                    h11.onPrepare(windowInsetsAnimationCompat);
                    if (h11.getDispatchMode() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    d(viewGroup.getChildAt(i11), windowInsetsAnimationCompat, windowInsets, z11);
                }
            }
        }

        public static void e(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
            Callback h11 = h(view);
            if (h11 != null) {
                windowInsetsCompat = h11.onProgress(windowInsetsCompat, list);
                if (h11.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    e(viewGroup.getChildAt(i11), windowInsetsCompat, list);
                }
            }
        }

        public static void f(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback h11 = h(view);
            if (h11 != null) {
                h11.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (h11.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    f(viewGroup.getChildAt(i11), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        @NonNull
        public static WindowInsets g(@NonNull View view, @NonNull WindowInsets windowInsets) {
            if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        @Nullable
        public static Callback h(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f11505a;
            }
            return null;
        }

        @SuppressLint({"WrongConstant"})
        public static WindowInsetsCompat i(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f11, int i11) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) == 0) {
                    builder.setInsets(i12, windowInsetsCompat.getInsets(i12));
                } else {
                    Insets insets = windowInsetsCompat.getInsets(i12);
                    Insets insets2 = windowInsetsCompat2.getInsets(i12);
                    float f12 = 1.0f - f11;
                    builder.setInsets(i12, WindowInsetsCompat.b(insets, (int) (((double) (((float) (insets.left - insets2.left)) * f12)) + 0.5d), (int) (((double) (((float) (insets.top - insets2.top)) * f12)) + 0.5d), (int) (((double) (((float) (insets.right - insets2.right)) * f12)) + 0.5d), (int) (((double) (((float) (insets.bottom - insets2.bottom)) * f12)) + 0.5d)));
                }
            }
            return builder.build();
        }

        public static void setCallback(@NonNull View view, @Nullable Callback callback) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (callback == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, (Object) null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener createProxyListener = createProxyListener(view, callback);
            view.setTag(R.id.tag_window_insets_animation_callback, createProxyListener);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(createProxyListener);
            }
        }
    }

    public WindowInsetsAnimationCompat(int i11, @Nullable Interpolator interpolator, long j11) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(i11, interpolator, j11);
        } else {
            this.mImpl = new Impl21(i11, interpolator, j11);
        }
    }

    public static void a(@NonNull View view, @Nullable Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setCallback(view, callback);
        } else {
            Impl21.setCallback(view, callback);
        }
    }

    @RequiresApi(30)
    public static WindowInsetsAnimationCompat b(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.mImpl.setAlpha(f11);
    }

    public void setFraction(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.mImpl.setFraction(f11);
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl {
        @NonNull
        private final WindowInsetsAnimation mWrapped;

        @RequiresApi(30)
        public static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations = new HashMap<>();
            private final Callback mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            public ProxyCallback(@NonNull Callback callback) {
                super(callback.getDispatchMode());
                this.mCompat = callback;
            }

            @NonNull
            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat b11 = WindowInsetsAnimationCompat.b(windowInsetsAnimation);
                this.mAnimations.put(windowInsetsAnimation, b11);
                return b11;
            }

            public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(windowInsetsAnimation));
                this.mAnimations.remove(windowInsetsAnimation);
            }

            public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(windowInsetsAnimation));
            }

            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.mTmpRunningAnimations;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.mTmpRunningAnimations = arrayList2;
                    this.mRORunningAnimations = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(windowInsetsAnimation);
                    windowInsetsAnimationCompat.setFraction(windowInsetsAnimation.getFraction());
                    this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                }
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.mRORunningAnimations).toWindowInsets();
            }

            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation.Bounds bounds) {
                return this.mCompat.onStart(getWindowInsetsAnimationCompat(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }

        public Impl30(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
            super(0, (Interpolator) null, 0);
            this.mWrapped = windowInsetsAnimation;
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds createPlatformBounds(@NonNull BoundsCompat boundsCompat) {
            return new WindowInsetsAnimation.Bounds(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
        }

        @NonNull
        public static Insets getHigherBounds(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        @NonNull
        public static Insets getLowerBounds(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(@NonNull View view, @Nullable Callback callback) {
            ProxyCallback proxyCallback;
            if (callback != null) {
                proxyCallback = new ProxyCallback(callback);
            } else {
                proxyCallback = null;
            }
            view.setWindowInsetsAnimationCallback(proxyCallback);
        }

        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Nullable
        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        public void setFraction(float f11) {
            this.mWrapped.setFraction(f11);
        }

        public Impl30(int i11, Interpolator interpolator, long j11) {
            this(new WindowInsetsAnimation(i11, interpolator, j11));
        }
    }

    public static final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        public BoundsCompat(@NonNull Insets insets, @NonNull Insets insets2) {
            this.mLowerBound = insets;
            this.mUpperBound = insets2;
        }

        @RequiresApi(30)
        @NonNull
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        @NonNull
        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        @NonNull
        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        @NonNull
        public BoundsCompat inset(@NonNull Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.b(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.b(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
        }

        @RequiresApi(30)
        @NonNull
        public WindowInsetsAnimation.Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            this.mLowerBound = Impl30.getLowerBounds(bounds);
            this.mUpperBound = Impl30.getHigherBounds(bounds);
        }
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this(0, (Interpolator) null, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(windowInsetsAnimation);
        }
    }
}
