package com.talabat.feature.pickup.presentation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rn.j;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupTooltipViewAnimations;", "", "()V", "animateSlideTo", "", "tobeAnimatedView", "Landroid/view/View;", "Companion", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupTooltipViewAnimations {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long animationDuration = 200;
    public static final float animationEnd = 0.0f;
    @NotNull
    public static final String animationName = "alpha";
    public static final float animationStart = 1.0f;
    public static final float pivotY = 0.0f;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupTooltipViewAnimations$Companion;", "", "()V", "animationDuration", "", "animationEnd", "", "animationName", "", "animationStart", "pivotY", "animateToHide", "", "tobeAnimatedView", "Landroid/view/View;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void animateToHide(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "tobeAnimatedView");
            new PickupTooltipViewAnimations().animateSlideTo(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: animateSlideTo$lambda-0  reason: not valid java name */
    public static final void m10253animateSlideTo$lambda0(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$tobeAnimatedView");
        Intrinsics.checkNotNullParameter(valueAnimator, Param.ANIMATION);
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            view.setTranslationY(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void animateSlideTo(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "tobeAnimatedView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        view.setPivotY(0.0f);
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new PickupTooltipViewAnimations$animateSlideTo$1(view));
        ofFloat.addUpdateListener(new j(view));
        ofFloat.start();
    }
}
