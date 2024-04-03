package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0016J*\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\fH\u0016R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006\""}, d2 = {"Lcom/google/accompanist/navigation/animation/AnimatedComposeNavigator;", "Landroidx/navigation/Navigator;", "Lcom/google/accompanist/navigation/animation/AnimatedComposeNavigator$Destination;", "()V", "backStack", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "getBackStack$navigation_animation_release", "()Lkotlinx/coroutines/flow/StateFlow;", "isPop", "Landroidx/compose/runtime/MutableState;", "", "isPop$navigation_animation_release", "()Landroidx/compose/runtime/MutableState;", "transitionsInProgress", "", "getTransitionsInProgress$navigation_animation_release", "createDestination", "markTransitionComplete", "", "entry", "markTransitionComplete$navigation_animation_release", "navigate", "entries", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "popBackStack", "popUpTo", "savedState", "Companion", "Destination", "navigation-animation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Navigator.Name("animatedComposable")
public final class AnimatedComposeNavigator extends Navigator<Destination> {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String NAME = "animatedComposable";
    @NotNull
    private final MutableState<Boolean> isPop = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/accompanist/navigation/animation/AnimatedComposeNavigator$Companion;", "", "()V", "NAME", "", "navigation-animation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @StabilityInferred(parameters = 0)
    @ExperimentalAnimationApi
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bR2\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t¢\u0006\u0002\b\nX\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/google/accompanist/navigation/animation/AnimatedComposeNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigator", "Lcom/google/accompanist/navigation/animation/AnimatedComposeNavigator;", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/navigation/NavBackStackEntry;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lcom/google/accompanist/navigation/animation/AnimatedComposeNavigator;Lkotlin/jvm/functions/Function4;)V", "getContent$navigation_animation_release", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "navigation-animation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @NavDestination.ClassType(Composable.class)
    public static final class Destination extends NavDestination {
        public static final int $stable = 0;
        @NotNull
        private final Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> content;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(@NotNull AnimatedComposeNavigator animatedComposeNavigator, @NotNull Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
            super((Navigator<? extends NavDestination>) animatedComposeNavigator);
            Intrinsics.checkNotNullParameter(animatedComposeNavigator, "navigator");
            Intrinsics.checkNotNullParameter(function4, "content");
            this.content = function4;
        }

        @NotNull
        public final Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> getContent$navigation_animation_release() {
            return this.content;
        }
    }

    @NotNull
    public final StateFlow<List<NavBackStackEntry>> getBackStack$navigation_animation_release() {
        return getState().getBackStack();
    }

    @NotNull
    public final StateFlow<Set<NavBackStackEntry>> getTransitionsInProgress$navigation_animation_release() {
        return getState().getTransitionsInProgress();
    }

    @NotNull
    public final MutableState<Boolean> isPop$navigation_animation_release() {
        return this.isPop;
    }

    public final void markTransitionComplete$navigation_animation_release(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        getState().markTransitionComplete(navBackStackEntry);
    }

    public void navigate(@NotNull List<NavBackStackEntry> list, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        for (NavBackStackEntry pushWithTransition : list) {
            getState().pushWithTransition(pushWithTransition);
        }
        this.isPop.setValue(Boolean.FALSE);
    }

    public void popBackStack(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        getState().popWithTransition(navBackStackEntry, z11);
        this.isPop.setValue(Boolean.TRUE);
    }

    @NotNull
    public Destination createDestination() {
        return new Destination(this, ComposableSingletons$AnimatedComposeNavigatorKt.INSTANCE.m9021getLambda1$navigation_animation_release());
    }
}
