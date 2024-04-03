package androidx.navigation;

import androidx.annotation.IdRes;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\n¨\u0006\u000e"}, d2 = {"contains", "", "Landroidx/navigation/NavGraph;", "id", "", "route", "", "get", "Landroidx/navigation/NavDestination;", "minusAssign", "", "node", "plusAssign", "other", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphKt {
    public static final boolean contains(@NotNull NavGraph navGraph, @IdRes int i11) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        return navGraph.findNode(i11) != null;
    }

    @NotNull
    public static final NavDestination get(@NotNull NavGraph navGraph, @IdRes int i11) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        NavDestination findNode = navGraph.findNode(i11);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i11 + " was found in " + navGraph);
    }

    public static final void minusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(navDestination, "node");
        navGraph.remove(navDestination);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(navDestination, "node");
        navGraph.addDestination(navDestination);
    }

    public static final boolean contains(@NotNull NavGraph navGraph, @NotNull String str) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        return navGraph.findNode(str) != null;
    }

    @NotNull
    public static final NavDestination get(@NotNull NavGraph navGraph, @NotNull String str) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        NavDestination findNode = navGraph.findNode(str);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + str + " was found in " + navGraph);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavGraph navGraph2) {
        Intrinsics.checkNotNullParameter(navGraph, "<this>");
        Intrinsics.checkNotNullParameter(navGraph2, "other");
        navGraph.addAll(navGraph2);
    }
}
