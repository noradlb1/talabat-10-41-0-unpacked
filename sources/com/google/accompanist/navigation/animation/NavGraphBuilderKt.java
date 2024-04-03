package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composer;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraphBuilder;
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001añ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062#\b\u0002\u0010\n\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000b¢\u0006\u0002\b\u000f2#\b\u0002\u0010\u0010\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u000f2#\b\u0002\u0010\u0012\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000b¢\u0006\u0002\b\u000f2#\b\u0002\u0010\u0013\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u000f2\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0018\u001aé\u0001\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062#\b\u0002\u0010\n\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000b¢\u0006\u0002\b\u000f2#\b\u0002\u0010\u0010\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u000f2#\b\u0002\u0010\u0012\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u000b¢\u0006\u0002\b\u000f2#\b\u0002\u0010\u0013\u001a\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b¢\u0006\u0002\b\u000f2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u000fH\u0007¨\u0006\u001c"}, d2 = {"composable", "", "Landroidx/navigation/NavGraphBuilder;", "route", "", "arguments", "", "Landroidx/navigation/NamedNavArgument;", "deepLinks", "Landroidx/navigation/NavDeepLink;", "enterTransition", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/ExtensionFunctionType;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "navigation", "startDestination", "builder", "navigation-animation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NavGraphBuilderKt {
    @ExperimentalAnimationApi
    public static final void composable(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function13, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function14, @NotNull Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(list2, "deepLinks");
        Intrinsics.checkNotNullParameter(function4, "content");
        AnimatedComposeNavigator.Destination destination = new AnimatedComposeNavigator.Destination((AnimatedComposeNavigator) navGraphBuilder.getProvider().getNavigator(AnimatedComposeNavigator.class), function4);
        destination.setRoute(str);
        for (NamedNavArgument namedNavArgument : list) {
            destination.addArgument(namedNavArgument.component1(), namedNavArgument.component2());
        }
        for (NavDeepLink addDeepLink : list2) {
            destination.addDeepLink(addDeepLink);
        }
        if (function1 != null) {
            AnimatedNavHostKt.getEnterTransitions().put(str, function1);
        }
        if (function12 != null) {
            AnimatedNavHostKt.getExitTransitions().put(str, function12);
        }
        if (function13 != null) {
            AnimatedNavHostKt.getPopEnterTransitions().put(str, function13);
        }
        if (function14 != null) {
            AnimatedNavHostKt.getPopExitTransitions().put(str, function14);
        }
        navGraphBuilder.addDestination(destination);
    }

    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function4 function4, int i11, Object obj) {
        List list3;
        List list4;
        Function1 function15;
        Function1 function16;
        Function1 function17;
        Function1 function18;
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
            function15 = null;
        } else {
            function15 = function1;
        }
        if ((i11 & 16) != 0) {
            function16 = null;
        } else {
            function16 = function12;
        }
        if ((i11 & 32) != 0) {
            function17 = function15;
        } else {
            function17 = function13;
        }
        if ((i11 & 64) != 0) {
            function18 = function16;
        } else {
            function18 = function14;
        }
        composable(navGraphBuilder, str, list3, list4, function15, function16, function17, function18, function4);
    }

    @ExperimentalAnimationApi
    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @NotNull String str, @NotNull String str2, @NotNull List<NamedNavArgument> list, @NotNull List<NavDeepLink> list2, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function1, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function12, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition> function13, @Nullable Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition> function14, @NotNull Function1<? super NavGraphBuilder, Unit> function15) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(str2, Constants.ARG_ROUTE);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(list2, "deepLinks");
        Intrinsics.checkNotNullParameter(function15, "builder");
        androidx.navigation.compose.NavGraphBuilderKt.navigation(navGraphBuilder, str, str2, list, list2, function15);
        Unit unit = Unit.INSTANCE;
        if (function1 != null) {
            AnimatedNavHostKt.getEnterTransitions().put(str2, function1);
        }
        if (function12 != null) {
            AnimatedNavHostKt.getExitTransitions().put(str2, function12);
        }
        if (function13 != null) {
            AnimatedNavHostKt.getPopEnterTransitions().put(str2, function13);
        }
        if (function14 != null) {
            AnimatedNavHostKt.getPopExitTransitions().put(str2, function14);
        }
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i11, Object obj) {
        List list3;
        List list4;
        Function1 function16;
        Function1 function17;
        Function1 function18;
        Function1 function19;
        int i12 = i11;
        if ((i12 & 4) != 0) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list3 = list;
        }
        if ((i12 & 8) != 0) {
            list4 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list4 = list2;
        }
        if ((i12 & 16) != 0) {
            function16 = null;
        } else {
            function16 = function1;
        }
        if ((i12 & 32) != 0) {
            function17 = null;
        } else {
            function17 = function12;
        }
        if ((i12 & 64) != 0) {
            function18 = function16;
        } else {
            function18 = function13;
        }
        if ((i12 & 128) != 0) {
            function19 = function17;
        } else {
            function19 = function14;
        }
        navigation(navGraphBuilder, str, str2, list3, list4, function16, function17, function18, function19, function15);
    }
}
