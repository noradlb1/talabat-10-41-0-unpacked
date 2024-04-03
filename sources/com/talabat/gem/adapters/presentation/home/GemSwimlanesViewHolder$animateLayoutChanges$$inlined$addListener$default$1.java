package com.talabat.gem.adapters.presentation.home;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolder$animateLayoutChanges$$inlined$addListener$default$1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewHolder f60065a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f60066b;

    public GemSwimlanesViewHolder$animateLayoutChanges$$inlined$addListener$default$1(GemSwimlanesViewHolder gemSwimlanesViewHolder, View view) {
        this.f60065a = gemSwimlanesViewHolder;
        this.f60066b = view;
    }

    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.f60065a.onAnimationFinished(this.f60066b);
    }

    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }
}
