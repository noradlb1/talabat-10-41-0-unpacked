package com.checkout.frames.screen.paymentform;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.screen.billingaddress.billingaddressform.BillingAddressFormScreenKt;
import com.checkout.frames.screen.navigation.Screen;
import com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt;
import com.checkout.frames.style.screen.BillingFormStyle;
import com.google.accompanist.navigation.animation.NavGraphBuilderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormScreenKt$PaymentFormScreen$1 extends Lambda implements Function1<NavGraphBuilder, Unit> {
    final /* synthetic */ int $animationDuration;
    final /* synthetic */ PaymentFormConfig $config;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ PaymentFormViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentFormScreenKt$PaymentFormScreen$1(PaymentFormConfig paymentFormConfig, PaymentFormViewModel paymentFormViewModel, NavHostController navHostController, int i11) {
        super(1);
        this.$config = paymentFormConfig;
        this.$viewModel = paymentFormViewModel;
        this.$navController = navHostController;
        this.$animationDuration = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavGraphBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$AnimatedNavHost");
        String route = Screen.PaymentDetails.INSTANCE.getRoute();
        final PaymentFormConfig paymentFormConfig = this.$config;
        final PaymentFormViewModel paymentFormViewModel = this.$viewModel;
        final NavHostController navHostController = this.$navController;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-2060511865, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((AnimatedVisibilityScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull NavBackStackEntry navBackStackEntry, @Nullable Composer composer, int i11) {
                Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$composable");
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                PaymentDetailsScreenKt.PaymentDetailsScreen(paymentFormConfig.getStyle().getPaymentDetailsStyle(), paymentFormViewModel.getInjector(), navHostController, composer, 520);
            }
        }), 126, (Object) null);
        String route2 = Screen.BillingFormScreen.INSTANCE.getRoute();
        final int i11 = this.$animationDuration;
        AnonymousClass2 r52 = new Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition>() {
            @Nullable
            public final EnterTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
                Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
                return AnimatedContentScope.m19slideIntoContainerHTTW7Ok$default(animatedContentScope, AnimatedContentScope.SlideDirection.Companion.m36getLeftaUPqQNE(), AnimationSpecKt.tween$default(i11, 0, (Easing) null, 6, (Object) null), (Function1) null, 4, (Object) null);
            }
        };
        final int i12 = this.$animationDuration;
        AnonymousClass3 r62 = new Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition>() {
            @Nullable
            public final ExitTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
                Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
                return AnimatedContentScope.m20slideOutOfContainerHTTW7Ok$default(animatedContentScope, AnimatedContentScope.SlideDirection.Companion.m37getRightaUPqQNE(), AnimationSpecKt.tween$default(i12, 0, (Easing) null, 6, (Object) null), (Function1) null, 4, (Object) null);
            }
        };
        final PaymentFormConfig paymentFormConfig2 = this.$config;
        final PaymentFormViewModel paymentFormViewModel2 = this.$viewModel;
        final NavHostController navHostController2 = this.$navController;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route2, (List) null, (List) null, r52, r62, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-377465552, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((AnimatedVisibilityScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull NavBackStackEntry navBackStackEntry, @Nullable Composer composer, int i11) {
                Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$composable");
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                BillingFormStyle billingFormStyle = paymentFormConfig2.getStyle().getBillingFormStyle();
                Injector injector = paymentFormViewModel2.getInjector();
                final NavHostController navHostController = navHostController2;
                BillingAddressFormScreenKt.BillingAddressFormScreen(billingFormStyle, injector, new Function0<Unit>() {
                    public final void invoke() {
                        navHostController.navigateUp();
                    }
                }, composer, 8);
            }
        }), 102, (Object) null);
    }
}
