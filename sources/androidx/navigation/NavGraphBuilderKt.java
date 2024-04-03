package androidx.navigation;

import androidx.annotation.IdRes;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u000b*\u00020\f2\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"navigation", "", "Landroidx/navigation/NavGraphBuilder;", "id", "", "startDestination", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "", "route", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphBuilderKt {
    @NotNull
    @Deprecated(message = "Use routes to build your NavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @IdRes int i11, @IdRes int i12, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i11, i12);
        function1.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, int i11, int i12, Function1 function1, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i11, i12);
        function1.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @NotNull
    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @NotNull String str, @Nullable String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, str, str2);
        function1.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, String str, String str2, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(navigatorProvider, "<this>");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, str, str2);
        function1.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    @Deprecated(message = "Use routes to build your nested NavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @IdRes int i11, @IdRes int i12, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), i11, i12);
        function1.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull String str2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(str2, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), str, str2);
        function1.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }
}
