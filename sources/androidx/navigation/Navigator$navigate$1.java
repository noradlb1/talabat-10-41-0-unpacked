package androidx.navigation;

import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/navigation/NavBackStackEntry;", "D", "Landroidx/navigation/NavDestination;", "backStackEntry", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Navigator$navigate$1 extends Lambda implements Function1<NavBackStackEntry, NavBackStackEntry> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Navigator<D> f36357g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavOptions f36358h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Navigator.Extras f36359i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Navigator$navigate$1(Navigator<D> navigator, NavOptions navOptions, Navigator.Extras extras) {
        super(1);
        this.f36357g = navigator;
        this.f36358h = navOptions;
        this.f36359i = extras;
    }

    @Nullable
    public final NavBackStackEntry invoke(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof NavDestination)) {
            destination = null;
        }
        if (destination == null) {
            return null;
        }
        NavDestination navigate = this.f36357g.navigate(destination, navBackStackEntry.getArguments(), this.f36358h, this.f36359i);
        if (navigate == null) {
            return null;
        }
        return Intrinsics.areEqual((Object) navigate, (Object) destination) ? navBackStackEntry : this.f36357g.getState().createBackStackEntry(navigate, navigate.addInDefaultArgs(navBackStackEntry.getArguments()));
    }
}
