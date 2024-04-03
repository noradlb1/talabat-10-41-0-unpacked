package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import s1.e2;

public final class ViewPropertyAnimatorCompat {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f11496a = null;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f11497b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f11498c = -1;
    private final WeakReference<View> mView;

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        @DoNotInline
        public static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        @DoNotInline
        public static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static Interpolator a(ViewPropertyAnimator viewPropertyAnimator) {
            return (Interpolator) viewPropertyAnimator.getInterpolator();
        }
    }

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, float f11) {
            return viewPropertyAnimator.translationZ(f11);
        }

        @DoNotInline
        public static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator, float f11) {
            return viewPropertyAnimator.translationZBy(f11);
        }

        @DoNotInline
        public static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, float f11) {
            return viewPropertyAnimator.z(f11);
        }

        @DoNotInline
        public static ViewPropertyAnimator d(ViewPropertyAnimator viewPropertyAnimator, float f11) {
            return viewPropertyAnimator.zBy(f11);
        }
    }

    public static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        public ViewPropertyAnimatorCompat f11502a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11503b;

        public void onAnimationCancel(@NonNull View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view.getTag(2113929216);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            } else {
                viewPropertyAnimatorListener = null;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.view.ViewPropertyAnimatorListener} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAnimationEnd(@androidx.annotation.NonNull android.view.View r4) {
            /*
                r3 = this;
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f11502a
                int r0 = r0.f11498c
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r4.setLayerType(r0, r1)
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f11502a
                r0.f11498c = r2
            L_0x000f:
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f11502a
                java.lang.Runnable r2 = r0.f11497b
                if (r2 == 0) goto L_0x001a
                r0.f11497b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.view.ViewPropertyAnimatorListener
                if (r2 == 0) goto L_0x0027
                r1 = r0
                androidx.core.view.ViewPropertyAnimatorListener r1 = (androidx.core.view.ViewPropertyAnimatorListener) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.onAnimationEnd(r4)
            L_0x002c:
                r4 = 1
                r3.f11503b = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14.onAnimationEnd(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.view.ViewPropertyAnimatorListener} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAnimationStart(@androidx.annotation.NonNull android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f11503b = r0
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f11502a
                int r0 = r0.f11498c
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r2)
            L_0x000f:
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f11502a
                java.lang.Runnable r1 = r0.f11496a
                if (r1 == 0) goto L_0x001a
                r0.f11496a = r2
                r1.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.view.ViewPropertyAnimatorListener
                if (r1 == 0) goto L_0x0027
                r2 = r0
                androidx.core.view.ViewPropertyAnimatorListener r2 = (androidx.core.view.ViewPropertyAnimatorListener) r2
            L_0x0027:
                if (r2 == 0) goto L_0x002c
                r2.onAnimationStart(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14.onAnimationStart(android.view.View):void");
        }
    }

    public ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f11);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @Nullable
    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return Api18Impl.a(view.animate());
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long j11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long j11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        e2 e2Var;
        View view = this.mView.get();
        if (view != null) {
            if (viewPropertyAnimatorUpdateListener != null) {
                e2Var = new e2(viewPropertyAnimatorUpdateListener, view);
            } else {
                e2Var = null;
            }
            Api19Impl.a(view.animate(), e2Var);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float f11) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.a(view.animate(), f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.b(view.animate(), f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.a(view.animate(), runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    @NonNull
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.b(view.animate());
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            Api16Impl.c(view.animate(), runnable);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float f11) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.c(view.animate(), f11);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float f11) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.d(view.animate(), f11);
        }
        return this;
    }
}
