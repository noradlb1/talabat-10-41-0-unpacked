package com.talabat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/talabat/HomeScreenMap$hideMapDragMapTutorial$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMap$hideMapDragMapTutorial$1 implements Animation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f54207b;

    public HomeScreenMap$hideMapDragMapTutorial$1(HomeScreenMap homeScreenMap) {
        this.f54207b = homeScreenMap;
    }

    public void onAnimationEnd(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
        ((LinearLayout) this.f54207b._$_findCachedViewById(R.id.drag_tut_container)).setVisibility(8);
    }

    public void onAnimationRepeat(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
    }

    public void onAnimationStart(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, Param.ANIMATION);
    }
}
