package com.talabat.feature.tpro.presentation.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u001a\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\f\u001a\u00020\r*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ANIMATION_TIME", "", "applyFadeEffect", "", "view", "Landroid/view/View;", "onAnimationComplete", "Lkotlin/Function0;", "changeVisibility", "visibility", "", "changeVisibilityWithFade", "endWithAction", "Landroid/view/animation/Animation;", "block", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FadeAnimationKt {
    public static final long ANIMATION_TIME = 500;

    public static final void applyFadeEffect(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "onAnimationComplete");
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        endWithAction(alphaAnimation, new FadeAnimationKt$applyFadeEffect$1(function0));
        view.startAnimation(alphaAnimation);
    }

    public static final void changeVisibility(@NotNull View view, boolean z11) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z11) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final void changeVisibilityWithFade(@NotNull View view, boolean z11) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z11) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            view.startAnimation(alphaAnimation);
            changeVisibility(view, true);
            return;
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(500);
        view.startAnimation(alphaAnimation2);
        changeVisibility(view, false);
    }

    @NotNull
    public static final Animation endWithAction(@NotNull Animation animation, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(animation, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        animation.setAnimationListener(new FadeAnimationKt$endWithAction$1(function0));
        return animation;
    }
}
