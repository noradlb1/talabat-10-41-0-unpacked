package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$11 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Alignment $contentAlignment;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $enterTransition;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $exitTransition;
    final /* synthetic */ NavGraph $graph;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $popEnterTransition;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $popExitTransition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedNavHostKt$AnimatedNavHost$11(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function13, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function14, int i11, int i12) {
        super(2);
        this.$navController = navHostController;
        this.$graph = navGraph;
        this.$modifier = modifier;
        this.$contentAlignment = alignment;
        this.$enterTransition = function1;
        this.$exitTransition = function12;
        this.$popEnterTransition = function13;
        this.$popExitTransition = function14;
        this.$$changed = i11;
        this.$$default = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedNavHostKt.AnimatedNavHost(this.$navController, this.$graph, this.$modifier, this.$contentAlignment, this.$enterTransition, this.$exitTransition, this.$popEnterTransition, this.$popExitTransition, composer, this.$$changed | 1, this.$$default);
    }
}
