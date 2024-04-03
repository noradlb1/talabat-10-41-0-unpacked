package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$1 extends Lambda implements Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> {
    public static final AnimatedNavHostKt$AnimatedNavHost$1 INSTANCE = new AnimatedNavHostKt$AnimatedNavHost$1();

    public AnimatedNavHostKt$AnimatedNavHost$1() {
        super(1);
    }

    @NotNull
    public final EnterTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null);
    }
}
