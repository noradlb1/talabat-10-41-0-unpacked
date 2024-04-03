package com.designsystem.ds_navigation_bar.behaviour;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSNavigationBarAnimationBehaviorImageRatioComposeKt$setImageForAnimationBehaviour$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviorImageRatioCompose f32454g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarAnimationBehaviorImageRatioComposeKt$setImageForAnimationBehaviour$1(DSNavigationBarAnimationBehaviorImageRatioCompose dSNavigationBarAnimationBehaviorImageRatioCompose) {
        super(1);
        this.f32454g = dSNavigationBarAnimationBehaviorImageRatioCompose;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        this.f32454g.setImageRatioHeight(IntSize.m5637getHeightimpl(layoutCoordinates.m4473getSizeYbymL2g()));
    }
}
