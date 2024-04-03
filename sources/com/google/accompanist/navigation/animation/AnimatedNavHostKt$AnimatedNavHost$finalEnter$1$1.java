package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterTransition;
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
public final class AnimatedNavHostKt$AnimatedNavHost$finalEnter$1$1 extends Lambda implements Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> {
    final /* synthetic */ AnimatedComposeNavigator $composeNavigator;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $enterTransition;
    final /* synthetic */ Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition> $popEnterTransition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedNavHostKt$AnimatedNavHost$finalEnter$1$1(AnimatedComposeNavigator animatedComposeNavigator, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function12) {
        super(1);
        this.$composeNavigator = animatedComposeNavigator;
        this.$popEnterTransition = function1;
        this.$enterTransition = function12;
    }

    @NotNull
    public final EnterTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
        EnterTransition enterTransition;
        EnterTransition enterTransition2;
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
        NavDestination destination = animatedContentScope.getTargetState().getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type com.google.accompanist.navigation.animation.AnimatedComposeNavigator.Destination");
        AnimatedComposeNavigator.Destination destination2 = (AnimatedComposeNavigator.Destination) destination;
        EnterTransition enterTransition3 = null;
        if (this.$composeNavigator.isPop$navigation_animation_release().getValue().booleanValue()) {
            Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(destination2).iterator();
            while (true) {
                if (it.hasNext()) {
                    Function1 function1 = AnimatedNavHostKt.getPopEnterTransitions().get(it.next().getRoute());
                    if (function1 != null) {
                        enterTransition2 = (EnterTransition) function1.invoke(animatedContentScope);
                        continue;
                    } else {
                        enterTransition2 = null;
                        continue;
                    }
                    if (enterTransition2 != null) {
                        enterTransition3 = enterTransition2;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (enterTransition3 == null) {
                return this.$popEnterTransition.invoke(animatedContentScope);
            }
            return enterTransition3;
        }
        Iterator<NavDestination> it2 = NavDestination.Companion.getHierarchy(destination2).iterator();
        while (true) {
            if (it2.hasNext()) {
                Function1 function12 = AnimatedNavHostKt.getEnterTransitions().get(it2.next().getRoute());
                if (function12 != null) {
                    enterTransition = (EnterTransition) function12.invoke(animatedContentScope);
                    continue;
                } else {
                    enterTransition = null;
                    continue;
                }
                if (enterTransition != null) {
                    enterTransition3 = enterTransition;
                    break;
                }
            } else {
                break;
            }
        }
        return enterTransition3 == null ? this.$enterTransition.invoke(animatedContentScope) : enterTransition3;
    }
}
