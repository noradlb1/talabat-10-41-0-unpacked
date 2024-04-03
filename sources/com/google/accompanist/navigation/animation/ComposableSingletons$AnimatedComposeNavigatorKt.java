package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableSingletons$AnimatedComposeNavigatorKt {
    @NotNull
    public static final ComposableSingletons$AnimatedComposeNavigatorKt INSTANCE = new ComposableSingletons$AnimatedComposeNavigatorKt();
    @NotNull

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> f447lambda1 = ComposableLambdaKt.composableLambdaInstance(-2143581737, false, ComposableSingletons$AnimatedComposeNavigatorKt$lambda1$1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$navigation_animation_release  reason: not valid java name */
    public final Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> m9021getLambda1$navigation_animation_release() {
        return f447lambda1;
    }
}
