package com.designsystem.ds_bottom_sheet_v2;

import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n¸\u0006\u000b"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release", "androidx/core/transition/TransitionKt$doOnEnd$$inlined$addListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: com.designsystem.ds_bottom_sheet_v2.BottomSheetSharedTransition$prepareHeightAnimator$lambda-9$$inlined$doOnEnd$1  reason: invalid class name */
public final class BottomSheetSharedTransition$prepareHeightAnimator$lambda9$$inlined$doOnEnd$1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f30597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f30598b;

    public BottomSheetSharedTransition$prepareHeightAnimator$lambda9$$inlined$doOnEnd$1(View view, int i11) {
        this.f30597a = view;
        this.f30598b = i11;
    }

    public void onTransitionCancel(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
    }

    public void onTransitionEnd(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        View view = this.f30597a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f30598b;
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public void onTransitionPause(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
    }

    public void onTransitionResume(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
    }

    public void onTransitionStart(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
    }
}
