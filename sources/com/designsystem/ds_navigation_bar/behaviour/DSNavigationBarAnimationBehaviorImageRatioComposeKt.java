package com.designsystem.ds_navigation_bar.behaviour;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"setImageForAnimationBehaviour", "Landroidx/compose/ui/Modifier;", "behaviour", "Lcom/designsystem/ds_navigation_bar/behaviour/DSNavigationBarAnimationBehaviorImageRatioCompose;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarAnimationBehaviorImageRatioComposeKt {
    @NotNull
    @Stable
    public static final Modifier setImageForAnimationBehaviour(@NotNull Modifier modifier, @NotNull DSNavigationBarAnimationBehaviorImageRatioCompose dSNavigationBarAnimationBehaviorImageRatioCompose) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviorImageRatioCompose, "behaviour");
        return OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new DSNavigationBarAnimationBehaviorImageRatioComposeKt$setImageForAnimationBehaviour$1(dSNavigationBarAnimationBehaviorImageRatioCompose));
    }
}
