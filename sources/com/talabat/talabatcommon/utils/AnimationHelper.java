package com.talabat.talabatcommon.utils;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import gv.a;
import gv.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/utils/AnimationHelper;", "", "adjustViewHeight", "", "view", "Landroid/view/View;", "currentHeight", "", "newHeight", "duration", "Lcom/talabat/talabatcommon/utils/AnimationSpeed;", "delay", "", "functionToWait", "Lkotlin/Function0;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AnimationHelper {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void adjustViewHeight(@NotNull AnimationHelper animationHelper, @NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(animationSpeed, "duration");
            ValueAnimator duration = ValueAnimator.ofInt(new int[]{i11, i12}).setDuration(animationSpeed.getValue());
            duration.addUpdateListener(new b(view));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.play(duration);
            animatorSet.start();
        }

        /* access modifiers changed from: private */
        /* renamed from: adjustViewHeight$lambda-0  reason: not valid java name */
        public static void m10941adjustViewHeight$lambda0(View view, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(valueAnimator, "it");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                view.getLayoutParams().height = ((Integer) animatedValue).intValue();
                view.requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        public static void delay(@NotNull AnimationHelper animationHelper, long j11, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "functionToWait");
            new Handler().postDelayed(new a(function0), j11);
        }

        /* access modifiers changed from: private */
        /* renamed from: delay$lambda-2  reason: not valid java name */
        public static void m10942delay$lambda2(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "$functionToWait");
            function0.invoke();
        }
    }

    void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed);

    void delay(long j11, @NotNull Function0<Unit> function0);
}
