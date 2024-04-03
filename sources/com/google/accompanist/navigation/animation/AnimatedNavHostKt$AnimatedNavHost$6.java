package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$6 extends Lambda implements Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> {
    public static final AnimatedNavHostKt$AnimatedNavHost$6 INSTANCE = new AnimatedNavHostKt$AnimatedNavHost$6();

    public AnimatedNavHostKt$AnimatedNavHost$6() {
        super(1);
    }

    @NotNull
    public final ExitTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null);
    }
}
