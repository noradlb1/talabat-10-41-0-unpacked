package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$7$1 extends Lambda implements Function1<AnimatedContentScope<NavBackStackEntry>, ContentTransform> {
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $finalEnter;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $finalExit;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedNavHostKt$AnimatedNavHost$7$1(Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12, State<? extends List<NavBackStackEntry>> state) {
        super(1);
        this.$finalEnter = function1;
        this.$finalExit = function12;
        this.$visibleEntries$delegate = state;
    }

    @NotNull
    public final ContentTransform invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$AnimatedContent");
        if (AnimatedNavHostKt.m9019AnimatedNavHost$lambda5(this.$visibleEntries$delegate).contains(animatedContentScope.getInitialState())) {
            return AnimatedContentKt.with(this.$finalEnter.invoke(animatedContentScope), this.$finalExit.invoke(animatedContentScope));
        }
        return AnimatedContentKt.with(EnterTransition.Companion.getNone(), ExitTransition.Companion.getNone());
    }
}
