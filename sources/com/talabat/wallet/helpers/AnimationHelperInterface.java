package com.talabat.wallet.helpers;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tx.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/helpers/AnimationHelperInterface;", "", "animateView", "", "view", "Landroid/view/View;", "xFrom", "", "xTo", "yFrom", "yTo", "duration", "", "delay", "functionToWait", "Lkotlin/Function0;", "setHeight", "newHeight", "", "slideDown", "distance", "slideIn", "viewTobeRemoved", "slideUp", "slideViewLeft", "slideViewRight", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AnimationHelperInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void animateView(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view, float f11, float f12, float f13, float f14, long j11) {
            if (view != null) {
                TranslateAnimation translateAnimation = new TranslateAnimation(f11, f12, f13, f14);
                translateAnimation.setDuration(j11);
                view.startAnimation(translateAnimation);
            }
        }

        public static void delay(@NotNull AnimationHelperInterface animationHelperInterface, long j11, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "functionToWait");
            new Handler().postDelayed(new a(function0), j11);
        }

        /* access modifiers changed from: private */
        /* renamed from: delay$lambda-0  reason: not valid java name */
        public static void m5954delay$lambda0(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "$functionToWait");
            function0.invoke();
        }

        public static void setHeight(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view, int i11) {
            if (view != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
                layoutParams.height = i11;
                constraintLayout.setLayoutParams(layoutParams);
            }
        }

        public static void slideDown(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view, long j11, float f11) {
            if (view != null) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f11);
                translateAnimation.setDuration(j11);
                translateAnimation.setFillAfter(true);
                view.startAnimation(translateAnimation);
            }
        }

        public static void slideIn(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view, @Nullable View view2) {
            if (view != null) {
                view.setVisibility(0);
            }
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (view != null) {
                animationHelperInterface.animateView(view, (float) view.getWidth(), 0.0f, 0.0f, 0.0f, 300);
            }
        }

        public static void slideUp(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view, long j11, float f11) {
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f11, 0.0f);
                translateAnimation.setDuration(j11);
                translateAnimation.setFillAfter(true);
                view.startAnimation(translateAnimation);
            }
        }

        public static void slideViewLeft(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view) {
            Float f11;
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                f11 = Float.valueOf((float) view.getWidth());
            } else {
                f11 = null;
            }
            Intrinsics.checkNotNull(f11);
            animationHelperInterface.animateView(view, 0.0f, f11.floatValue(), 0.0f, 0.0f, 300);
        }

        public static void slideViewRight(@NotNull AnimationHelperInterface animationHelperInterface, @Nullable View view, @Nullable View view2) {
            Float f11;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                f11 = Float.valueOf((float) view.getWidth());
            } else {
                f11 = null;
            }
            Intrinsics.checkNotNull(f11);
            animationHelperInterface.animateView(view, -f11.floatValue(), 0.0f, 0.0f, 0.0f, 300);
        }
    }

    void animateView(@Nullable View view, float f11, float f12, float f13, float f14, long j11);

    void delay(long j11, @NotNull Function0<Unit> function0);

    void setHeight(@Nullable View view, int i11);

    void slideDown(@Nullable View view, long j11, float f11);

    void slideIn(@Nullable View view, @Nullable View view2);

    void slideUp(@Nullable View view, long j11, float f11);

    void slideViewLeft(@Nullable View view);

    void slideViewRight(@Nullable View view, @Nullable View view2);
}
