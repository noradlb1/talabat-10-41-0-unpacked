package androidx.navigation;

import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u001e\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u0017*\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0001J\r\u0010\u0019\u001a\u00020\u0014*\u00020\u000eH\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavGraph;", "provider", "Landroidx/navigation/NavigatorProvider;", "id", "", "startDestination", "(Landroidx/navigation/NavigatorProvider;II)V", "", "route", "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;Ljava/lang/String;)V", "destinations", "", "Landroidx/navigation/NavDestination;", "getProvider", "()Landroidx/navigation/NavigatorProvider;", "startDestinationId", "startDestinationRoute", "addDestination", "", "destination", "build", "D", "navDestination", "unaryPlus", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NavDestinationDsl
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    @NotNull
    private final List<NavDestination> destinations = new ArrayList();
    @NotNull
    private final NavigatorProvider provider;
    @IdRes
    private int startDestinationId;
    @Nullable
    private String startDestinationRoute;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to build your NavGraph instead", replaceWith = @ReplaceWith(expression = "NavGraphBuilder(provider, startDestination = startDestination.toString(), route = id.toString())", imports = {}))
    public NavGraphBuilder(@NotNull NavigatorProvider navigatorProvider, @IdRes int i11, @IdRes int i12) {
        super(navigatorProvider.getNavigator(NavGraphNavigator.class), i11);
        Intrinsics.checkNotNullParameter(navigatorProvider, "provider");
        this.provider = navigatorProvider;
        this.startDestinationId = i12;
    }

    public final void addDestination(@NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        this.destinations.add(navDestination);
    }

    public final <D extends NavDestination> void destination(@NotNull NavDestinationBuilder<? extends D> navDestinationBuilder) {
        Intrinsics.checkNotNullParameter(navDestinationBuilder, "navDestination");
        this.destinations.add(navDestinationBuilder.build());
    }

    @NotNull
    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    public final void unaryPlus(@NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        addDestination(navDestination);
    }

    @NotNull
    public NavGraph build() {
        NavGraph navGraph = (NavGraph) super.build();
        navGraph.addDestinations((Collection<? extends NavDestination>) this.destinations);
        int i11 = this.startDestinationId;
        if (i11 != 0 || this.startDestinationRoute != null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                Intrinsics.checkNotNull(str);
                navGraph.setStartDestination(str);
            } else {
                navGraph.setStartDestination(i11);
            }
            return navGraph;
        } else if (getRoute() != null) {
            throw new IllegalStateException("You must set a start destination route");
        } else {
            throw new IllegalStateException("You must set a start destination id");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(@NotNull NavigatorProvider navigatorProvider, @NotNull String str, @Nullable String str2) {
        super(navigatorProvider.getNavigator(NavGraphNavigator.class), str2);
        Intrinsics.checkNotNullParameter(navigatorProvider, "provider");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        this.provider = navigatorProvider;
        this.startDestinationRoute = str;
    }
}
