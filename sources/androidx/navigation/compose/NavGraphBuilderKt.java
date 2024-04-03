package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.DialogNavigator;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aP\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000e\u001aZ\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0012\u001aS\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0016¨\u0006\u0017"}, d2 = {"composable", "", "Landroidx/navigation/NavGraphBuilder;", "route", "", "arguments", "", "Landroidx/navigation/NamedNavArgument;", "deepLinks", "Landroidx/navigation/NavDeepLink;", "content", "Lkotlin/Function1;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "dialog", "dialogProperties", "Landroidx/compose/ui/window/DialogProperties;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;)V", "navigation", "startDestination", "builder", "Lkotlin/ExtensionFunctionType;", "navigation-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphBuilderKt {
    public static final void composable(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(list2, "deepLinks");
        Intrinsics.checkNotNullParameter(function3, "content");
        ComposeNavigator.Destination destination = new ComposeNavigator.Destination((ComposeNavigator) navGraphBuilder.getProvider().getNavigator(ComposeNavigator.class), function3);
        destination.setRoute(str);
        for (NamedNavArgument namedNavArgument : list) {
            destination.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink addDeepLink : list2) {
            destination.addDeepLink(addDeepLink);
        }
        navGraphBuilder.addDestination(destination);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function3 function3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i11 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        composable(navGraphBuilder, str, list, list2, function3);
    }

    public static final void dialog(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @NotNull DialogProperties dialogProperties, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(list2, "deepLinks");
        Intrinsics.checkNotNullParameter(dialogProperties, "dialogProperties");
        Intrinsics.checkNotNullParameter(function3, "content");
        DialogNavigator.Destination destination = new DialogNavigator.Destination((DialogNavigator) navGraphBuilder.getProvider().getNavigator(DialogNavigator.class), dialogProperties, function3);
        destination.setRoute(str);
        for (NamedNavArgument namedNavArgument : list) {
            destination.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink addDeepLink : list2) {
            destination.addDeepLink(addDeepLink);
        }
        navGraphBuilder.addDestination(destination);
    }

    public static /* synthetic */ void dialog$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, DialogProperties dialogProperties, Function3 function3, int i11, Object obj) {
        List list3;
        List list4;
        DialogProperties dialogProperties2;
        if ((i11 & 2) != 0) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list3 = list;
        }
        if ((i11 & 4) != 0) {
            list4 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list4 = list2;
        }
        if ((i11 & 8) != 0) {
            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
        } else {
            dialogProperties2 = dialogProperties;
        }
        dialog(navGraphBuilder, str, list3, list4, dialogProperties2, function3);
    }

    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull String str2, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(str2, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(list2, "deepLinks");
        Intrinsics.checkNotNullParameter(function1, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), str, str2);
        function1.invoke(navGraphBuilder2);
        NavGraph build = navGraphBuilder2.build();
        for (NamedNavArgument namedNavArgument : list) {
            build.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink addDeepLink : list2) {
            build.addDeepLink(addDeepLink);
        }
        navGraphBuilder.addDestination(build);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list3 = list;
        if ((i11 & 8) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        navigation(navGraphBuilder, str, str2, list3, list2, function1);
    }
}
