package com.talabat;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/talabat/GroceryDetailsViewScreen$setSort$3$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen$setSort$3$1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f54112a;

    public GroceryDetailsViewScreen$setSort$3$1(GroceryDetailsViewScreen groceryDetailsViewScreen) {
        this.f54112a = groceryDetailsViewScreen;
    }

    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
        ((RelativeLayout) this.f54112a._$_findCachedViewById(R.id.content_view)).setVisibility(8);
        GroceryDetailsViewScreen groceryDetailsViewScreen = this.f54112a;
        int i11 = R.id.sort_bottom_sheet;
        ((RelativeLayout) groceryDetailsViewScreen._$_findCachedViewById(i11)).animate().alpha(0.0f).setListener((Animator.AnimatorListener) null);
        ((RelativeLayout) this.f54112a._$_findCachedViewById(i11)).setVisibility(8);
    }

    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
    }

    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, Param.ANIMATION);
    }
}
