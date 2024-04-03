package com.talabat.feature.darkstorestooltip.presentation;

import android.animation.Animator;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/talabat/feature/darkstorestooltip/presentation/TooltipView$removeTooltip$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TooltipView$removeTooltip$1$1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TooltipView f58508a;

    public TooltipView$removeTooltip$1$1(TooltipView tooltipView) {
        this.f58508a = tooltipView;
    }

    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
        TooltipView tooltipView = this.f58508a;
        tooltipView.removeView(tooltipView.tooltip);
        this.f58508a.setVisibility(8);
        this.f58508a.tooltip = null;
    }

    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
    }

    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
    }
}
