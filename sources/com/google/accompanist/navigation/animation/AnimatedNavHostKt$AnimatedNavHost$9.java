package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.NavBackStackEntryProviderKt;
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$9 extends Lambda implements Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ SaveableStateHolder $saveableStateHolder;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedNavHostKt$AnimatedNavHost$9(SaveableStateHolder saveableStateHolder, State<? extends List<NavBackStackEntry>> state) {
        super(4);
        this.$saveableStateHolder = saveableStateHolder;
        this.$visibleEntries$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedVisibilityScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull final AnimatedVisibilityScope animatedVisibilityScope, @NotNull NavBackStackEntry navBackStackEntry, @Nullable Composer composer, int i11) {
        Object obj;
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedContent");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1242637642, i11, -1, "com.google.accompanist.navigation.animation.AnimatedNavHost.<anonymous> (AnimatedNavHost.kt:209)");
        }
        List r72 = AnimatedNavHostKt.m9019AnimatedNavHost$lambda5(this.$visibleEntries$delegate);
        ListIterator listIterator = r72.listIterator(r72.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (Intrinsics.areEqual((Object) navBackStackEntry, (Object) (NavBackStackEntry) obj)) {
                break;
            }
        }
        final NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
        if (navBackStackEntry2 != null) {
            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, this.$saveableStateHolder, ComposableLambdaKt.composableLambda(composer, 158545465, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(158545465, i11, -1, "com.google.accompanist.navigation.animation.AnimatedNavHost.<anonymous>.<anonymous> (AnimatedNavHost.kt:221)");
                        }
                        NavDestination destination = navBackStackEntry2.getDestination();
                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type com.google.accompanist.navigation.animation.AnimatedComposeNavigator.Destination");
                        ((AnimatedComposeNavigator.Destination) destination).getContent$navigation_animation_release().invoke(animatedVisibilityScope, navBackStackEntry2, composer, 72);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 456);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
