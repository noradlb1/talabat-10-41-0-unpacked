package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<NavGraphBuilder, Unit> $builder;
    final /* synthetic */ Alignment $contentAlignment;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $enterTransition;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $exitTransition;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $popEnterTransition;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $popExitTransition;
    final /* synthetic */ String $route;
    final /* synthetic */ String $startDestination;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedNavHostKt$AnimatedNavHost$4(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function13, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function14, Function1<? super NavGraphBuilder, Unit> function15, int i11, int i12) {
        super(2);
        this.$navController = navHostController;
        this.$startDestination = str;
        this.$modifier = modifier;
        this.$contentAlignment = alignment;
        this.$route = str2;
        this.$enterTransition = function1;
        this.$exitTransition = function12;
        this.$popEnterTransition = function13;
        this.$popExitTransition = function14;
        this.$builder = function15;
        this.$$changed = i11;
        this.$$default = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedNavHostKt.AnimatedNavHost(this.$navController, this.$startDestination, this.$modifier, this.$contentAlignment, this.$route, this.$enterTransition, this.$exitTransition, this.$popEnterTransition, this.$popExitTransition, this.$builder, composer, this.$$changed | 1, this.$$default);
    }
}
