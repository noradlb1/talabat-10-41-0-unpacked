package com.google.accompanist.navigation.animation;

import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberAnimatedNavController", "Landroidx/navigation/NavHostController;", "navigators", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "navigation-animation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NavHostControllerKt {
    @ExperimentalAnimationApi
    @NotNull
    @Composable
    public static final NavHostController rememberAnimatedNavController(@NotNull Navigator<? extends NavDestination>[] navigatorArr, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(navigatorArr, "navigators");
        composer.startReplaceableGroup(-514773754);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-514773754, i11, -1, "com.google.accompanist.navigation.animation.rememberAnimatedNavController (NavHostController.kt:35)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AnimatedComposeNavigator();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add((AnimatedComposeNavigator) rememberedValue);
        spreadBuilder.addSpread(navigatorArr);
        NavHostController rememberNavController = androidx.navigation.compose.NavHostControllerKt.rememberNavController((Navigator[]) spreadBuilder.toArray(new Navigator[spreadBuilder.size()]), composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberNavController;
    }
}
