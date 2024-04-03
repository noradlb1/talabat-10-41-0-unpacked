package com.newrelic.agent.android.instrumentation.androidx.navigation;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.instrumentation.InstrumentationDelegate;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import ke.a;
import ke.b;
import ke.c;
import ke.d;
import ke.e;
import ke.f;
import ke.g;
import ke.h;

public class NavigationController extends InstrumentationDelegate {
    private static Set<FeatureFlag> requiredFeatures = new HashSet<FeatureFlag>() {
        {
            add(FeatureFlag.Jetpack);
        }
    };

    @ReplaceCallSite(isStatic = true)
    public static void invoke(NavHostController navHostController, NavBackStackEntry navBackStackEntry, Composer composer, int i11) {
        navHostController.navigate(navBackStackEntry.getDestination().getId(), navBackStackEntry.getArguments());
        InstrumentationDelegate.executor.submit(new c(navBackStackEntry, composer));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$invoke$1(NavBackStackEntry navBackStackEntry, Composer composer) {
        InstrumentationDelegate.log.debug("invoke(NavController, NavBackStackEntry, Composer, int)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(composer) {
            final /* synthetic */ Composer val$composer;

            {
                this.val$composer = r4;
                put(TtmlNode.TAG_SPAN, "invoke");
                put("navBackStackEntry.id", Integer.valueOf(NavBackStackEntry.this.getDestination().getId()));
                if (NavBackStackEntry.this.getArguments() != null) {
                    put("navBackStackEntry.arguments", NavBackStackEntry.this.getArguments().toString());
                }
                put("composer.rememberedValue", r4.rememberedValue());
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$navigate$2(int i11, NavOptions navOptions, Navigator.Extras extras) {
        InstrumentationDelegate.log.debug("navigate(NavController, int, Bundle, NavOptions, Navigator.Extras)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(i11, navOptions, extras) {
            final /* synthetic */ Navigator.Extras val$extras;
            final /* synthetic */ NavOptions val$options;
            final /* synthetic */ int val$resId;

            {
                String str;
                this.val$resId = r3;
                this.val$options = r4;
                this.val$extras = r5;
                put(TtmlNode.TAG_SPAN, "navigate");
                put("resId", Integer.valueOf(r3));
                if (r4.getPopUpToRoute() != null) {
                    put("options.popUpToRoute", r4.getPopUpToRoute());
                }
                if (-1 != r4.getEnterAnim()) {
                    put("options.enterAnim", Integer.valueOf(r4.getEnterAnim()));
                }
                if (-1 != r4.getExitAnim()) {
                    put("options.exitAnim", Integer.valueOf(r4.getExitAnim()));
                }
                if (-1 != r4.getPopEnterAnim()) {
                    put("options.popEnterAnim", Integer.valueOf(r4.getPopEnterAnim()));
                }
                if (-1 != r4.getPopExitAnim()) {
                    put("options.popExitAnim", Integer.valueOf(r4.getPopExitAnim()));
                }
                if (r5 == null) {
                    str = "null";
                } else {
                    str = r5.toString();
                }
                put("extras", str);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$navigate$default$0(String str, NavOptions navOptions, Navigator.Extras extras) {
        InstrumentationDelegate.log.debug("navigate$default(NavController, String, NavOptions, Navigator.Extras, int, Object)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(str, navOptions, extras) {
            final /* synthetic */ Navigator.Extras val$extras;
            final /* synthetic */ NavOptions val$options;
            final /* synthetic */ String val$route;

            {
                this.val$route = r3;
                this.val$options = r4;
                this.val$extras = r5;
                put(TtmlNode.TAG_SPAN, "navigate");
                put(Constants.ARG_ROUTE, r3);
                if (r4 != null) {
                    put("restoreState", Boolean.valueOf(r4.shouldRestoreState()));
                    put("popUpToInclusive", Boolean.valueOf(r4.isPopUpToInclusive()));
                    put("popUpToSaveState", Boolean.valueOf(r4.shouldPopUpToSaveState()));
                    if (r4.getPopUpToRoute() != null) {
                        put("options.popUpToRoute", r4.getPopUpToRoute());
                    }
                    if (-1 != r4.getEnterAnim()) {
                        put("options.enterAnim", Integer.valueOf(r4.getEnterAnim()));
                    }
                    if (-1 != r4.getExitAnim()) {
                        put("options.exitAnim", Integer.valueOf(r4.getExitAnim()));
                    }
                    if (-1 != r4.getPopEnterAnim()) {
                        put("options.popEnterAnim", Integer.valueOf(r4.getPopEnterAnim()));
                    }
                    if (-1 != r4.getPopExitAnim()) {
                        put("options.popExitAnim", Integer.valueOf(r4.getPopExitAnim()));
                    }
                }
                if (r5 != null) {
                    put("extras", r5);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$navigateUp$3(boolean z11) {
        InstrumentationDelegate.log.debug("navigateUp(NavController)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(z11) {
            final /* synthetic */ boolean val$rc;

            {
                this.val$rc = r3;
                put(TtmlNode.TAG_SPAN, "navigateUp");
                put("result", Boolean.valueOf(r3));
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$popBackStack$5(int i11, boolean z11, boolean z12, boolean z13) {
        InstrumentationDelegate.log.debug("popBackStack(NavController, int, boolean, boolean)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(i11, z11, z12, z13) {
            final /* synthetic */ int val$destinationId;
            final /* synthetic */ boolean val$inclusive;
            final /* synthetic */ boolean val$rc;
            final /* synthetic */ boolean val$saveState;

            {
                this.val$destinationId = r3;
                this.val$inclusive = r4;
                this.val$saveState = r5;
                this.val$rc = r6;
                put(TtmlNode.TAG_SPAN, "popBackStack");
                put("destinationId", Integer.valueOf(r3));
                put("inclusive", Boolean.valueOf(r4));
                put("saveState", Boolean.valueOf(r5));
                put("result", Boolean.valueOf(r6));
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$popBackStack$6(String str, boolean z11, boolean z12, boolean z13) {
        InstrumentationDelegate.log.debug("popBackStack(NavController, String, boolean, boolean) ");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(str, z11, z12, z13) {
            final /* synthetic */ boolean val$inclusive;
            final /* synthetic */ boolean val$rc;
            final /* synthetic */ String val$route;
            final /* synthetic */ boolean val$saveState;

            {
                this.val$route = r3;
                this.val$inclusive = r4;
                this.val$saveState = r5;
                this.val$rc = r6;
                put(TtmlNode.TAG_SPAN, "popBackStack");
                put(Constants.ARG_ROUTE, r3);
                put("inclusive", Boolean.valueOf(r4));
                put("saveState", Boolean.valueOf(r5));
                put("result", Boolean.valueOf(r6));
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$popBackStack$7(boolean z11) {
        InstrumentationDelegate.log.debug("boolean popBackStack(NavHostController)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(z11) {
            final /* synthetic */ boolean val$rc;

            {
                this.val$rc = r3;
                put(TtmlNode.TAG_SPAN, "popBackStack");
                put("result", Boolean.valueOf(r3));
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$popBackStack$default$4(String str, boolean z11, boolean z12) {
        InstrumentationDelegate.log.debug("popBackStack$default(NavController, String, boolean, boolean, int, Object)");
        InstrumentationDelegate.analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(str, z11, z12) {
            final /* synthetic */ boolean val$inclusive;
            final /* synthetic */ String val$route;
            final /* synthetic */ boolean val$saveState;

            {
                this.val$route = r3;
                this.val$inclusive = r4;
                this.val$saveState = r5;
                put(TtmlNode.TAG_SPAN, "popBackStack");
                put(Constants.ARG_ROUTE, r3);
                put("inclusive", Boolean.valueOf(r4));
                put("saveState", Boolean.valueOf(r5));
            }
        });
    }

    @ReplaceCallSite
    public static void navigate(NavController navController, int i11, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        navController.navigate(i11, bundle, navOptions, extras);
        InstrumentationDelegate.submit(requiredFeatures, new g(i11, navOptions, extras));
    }

    @ReplaceCallSite(isStatic = true)
    public static void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i11, Object obj) {
        navController.navigate(str, navOptions, extras);
        InstrumentationDelegate.submit(requiredFeatures, new a(str, navOptions, extras));
    }

    @ReplaceCallSite
    public static boolean navigateUp(NavController navController) {
        boolean navigateUp = navController.navigateUp();
        InstrumentationDelegate.submit(requiredFeatures, new h(navigateUp));
        return navigateUp;
    }

    @ReplaceCallSite
    public static boolean popBackStack(NavController navController, int i11, boolean z11, boolean z12) {
        boolean popBackStack = navController.popBackStack(i11, z11, z12);
        InstrumentationDelegate.submit(requiredFeatures, new d(i11, z11, z12, popBackStack));
        return popBackStack;
    }

    @ReplaceCallSite(isStatic = true)
    public static void popBackStack$default(NavController navController, String str, boolean z11, boolean z12, int i11, Object obj) {
        navController.popBackStack(str, z11, z12);
        InstrumentationDelegate.submit(requiredFeatures, new f(str, z11, z12));
    }

    @ReplaceCallSite
    public static boolean popBackStack(NavController navController, String str, boolean z11, boolean z12) {
        boolean popBackStack = navController.popBackStack(str, z11, z12);
        InstrumentationDelegate.submit(requiredFeatures, new e(str, z11, z12, popBackStack));
        return popBackStack;
    }

    @ReplaceCallSite
    public static boolean popBackStack(NavHostController navHostController) {
        boolean popBackStack = navHostController.popBackStack();
        InstrumentationDelegate.submit(requiredFeatures, new b(popBackStack));
        return popBackStack;
    }
}
