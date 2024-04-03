package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0017J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Landroidx/navigation/compose/ComposeNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/compose/ComposeNavigator$Destination;", "()V", "backStack", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "getBackStack$navigation_compose_release", "()Lkotlinx/coroutines/flow/StateFlow;", "transitionsInProgress", "", "getTransitionsInProgress$navigation_compose_release", "createDestination", "navigate", "", "entries", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "onTransitionComplete", "entry", "onTransitionComplete$navigation_compose_release", "popBackStack", "popUpTo", "savedState", "", "Companion", "Destination", "navigation-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Navigator.Name("composable")
public final class ComposeNavigator extends Navigator<Destination> {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String NAME = "composable";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/navigation/compose/ComposeNavigator$Companion;", "", "()V", "NAME", "", "navigation-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tR'\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/navigation/compose/ComposeNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigator", "Landroidx/navigation/compose/ComposeNavigator;", "content", "Lkotlin/Function1;", "Landroidx/navigation/NavBackStackEntry;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/compose/ComposeNavigator;Lkotlin/jvm/functions/Function3;)V", "getContent$navigation_compose_release", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "navigation-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @NavDestination.ClassType(Composable.class)
    public static final class Destination extends NavDestination {
        public static final int $stable = 0;
        @NotNull
        private final Function3<NavBackStackEntry, Composer, Integer, Unit> content;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(@NotNull ComposeNavigator composeNavigator, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
            super((Navigator<? extends NavDestination>) composeNavigator);
            Intrinsics.checkNotNullParameter(composeNavigator, "navigator");
            Intrinsics.checkNotNullParameter(function3, "content");
            this.content = function3;
        }

        @NotNull
        public final Function3<NavBackStackEntry, Composer, Integer, Unit> getContent$navigation_compose_release() {
            return this.content;
        }
    }

    @NotNull
    public final StateFlow<List<NavBackStackEntry>> getBackStack$navigation_compose_release() {
        return getState().getBackStack();
    }

    @NotNull
    public final StateFlow<Set<NavBackStackEntry>> getTransitionsInProgress$navigation_compose_release() {
        return getState().getTransitionsInProgress();
    }

    public void navigate(@NotNull List<NavBackStackEntry> list, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(list, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        for (NavBackStackEntry pushWithTransition : list) {
            getState().pushWithTransition(pushWithTransition);
        }
    }

    public final void onTransitionComplete$navigation_compose_release(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        getState().markTransitionComplete(navBackStackEntry);
    }

    public void popBackStack(@NotNull NavBackStackEntry navBackStackEntry, boolean z11) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        getState().popWithTransition(navBackStackEntry, z11);
    }

    @NotNull
    public Destination createDestination() {
        return new Destination(this, ComposableSingletons$ComposeNavigatorKt.INSTANCE.m9104getLambda1$navigation_compose_release());
    }
}
