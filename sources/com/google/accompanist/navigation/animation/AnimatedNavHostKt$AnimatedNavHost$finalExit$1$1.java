package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.ExitTransition;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$finalExit$1$1 extends Lambda implements Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> {
    final /* synthetic */ AnimatedComposeNavigator $composeNavigator;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $exitTransition;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition> $popExitTransition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedNavHostKt$AnimatedNavHost$finalExit$1$1(AnimatedComposeNavigator animatedComposeNavigator, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function1, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12) {
        super(1);
        this.$composeNavigator = animatedComposeNavigator;
        this.$popExitTransition = function1;
        this.$exitTransition = function12;
    }

    @NotNull
    public final ExitTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
        ExitTransition exitTransition;
        ExitTransition exitTransition2;
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
        NavDestination destination = animatedContentScope.getInitialState().getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type com.google.accompanist.navigation.animation.AnimatedComposeNavigator.Destination");
        AnimatedComposeNavigator.Destination destination2 = (AnimatedComposeNavigator.Destination) destination;
        ExitTransition exitTransition3 = null;
        if (this.$composeNavigator.isPop$navigation_animation_release().getValue().booleanValue()) {
            Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(destination2).iterator();
            while (true) {
                if (it.hasNext()) {
                    Function1 function1 = AnimatedNavHostKt.getPopExitTransitions().get(it.next().getRoute());
                    if (function1 != null) {
                        exitTransition2 = (ExitTransition) function1.invoke(animatedContentScope);
                        continue;
                    } else {
                        exitTransition2 = null;
                        continue;
                    }
                    if (exitTransition2 != null) {
                        exitTransition3 = exitTransition2;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (exitTransition3 == null) {
                return this.$popExitTransition.invoke(animatedContentScope);
            }
            return exitTransition3;
        }
        Iterator<NavDestination> it2 = NavDestination.Companion.getHierarchy(destination2).iterator();
        while (true) {
            if (it2.hasNext()) {
                Function1 function12 = AnimatedNavHostKt.getExitTransitions().get(it2.next().getRoute());
                if (function12 != null) {
                    exitTransition = (ExitTransition) function12.invoke(animatedContentScope);
                    continue;
                } else {
                    exitTransition = null;
                    continue;
                }
                if (exitTransition != null) {
                    exitTransition3 = exitTransition;
                    break;
                }
            } else {
                break;
            }
        }
        return exitTransition3 == null ? this.$exitTransition.invoke(animatedContentScope) : exitTransition3;
    }
}
