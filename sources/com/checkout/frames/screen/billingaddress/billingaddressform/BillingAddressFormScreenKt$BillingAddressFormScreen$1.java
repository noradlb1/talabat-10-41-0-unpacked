package com.checkout.frames.screen.billingaddress.billingaddressform;

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
import com.checkout.frames.screen.countrypicker.CountryPickerScreenKt;
import com.checkout.frames.screen.navigation.Screen;
import com.checkout.frames.style.screen.BillingFormStyle;
import com.checkout.frames.style.screen.CountryPickerStyle;
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
public final class BillingAddressFormScreenKt$BillingAddressFormScreen$1 extends Lambda implements Function1<NavGraphBuilder, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $animationDuration;
    final /* synthetic */ NavHostController $childNavController;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ BillingFormStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressFormScreenKt$BillingAddressFormScreen$1(BillingFormStyle billingFormStyle, Injector injector, NavHostController navHostController, Function0<Unit> function0, int i11, int i12) {
        super(1);
        this.$style = billingFormStyle;
        this.$injector = injector;
        this.$childNavController = navHostController;
        this.$onClose = function0;
        this.$$dirty = i11;
        this.$animationDuration = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavGraphBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$AnimatedNavHost");
        String route = Screen.BillingFormDetails.INSTANCE.getRoute();
        final BillingFormStyle billingFormStyle = this.$style;
        Injector injector = this.$injector;
        NavHostController navHostController = this.$childNavController;
        final Injector injector2 = injector;
        final NavHostController navHostController2 = navHostController;
        final Function0<Unit> function0 = this.$onClose;
        final int i11 = this.$$dirty;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1069172611, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((AnimatedVisibilityScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.jvm.functions.Function0} */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @androidx.compose.runtime.Composable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.animation.AnimatedVisibilityScope r7, @org.jetbrains.annotations.NotNull androidx.navigation.NavBackStackEntry r8, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r9, int r10) {
                /*
                    r6 = this;
                    java.lang.String r10 = "$this$composable"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r10)
                    java.lang.String r7 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
                    com.checkout.frames.style.screen.BillingFormStyle r7 = r15
                    com.checkout.frames.style.screen.BillingAddressDetailsStyle r0 = r7.getBillingAddressDetailsStyle()
                    com.checkout.frames.di.base.Injector r1 = r16
                    androidx.navigation.NavHostController r2 = r17
                    kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r18
                    r8 = 1157296644(0x44faf204, float:2007.563)
                    r9.startReplaceableGroup(r8)
                    boolean r8 = r9.changed((java.lang.Object) r7)
                    java.lang.Object r10 = r9.rememberedValue()
                    if (r8 != 0) goto L_0x002e
                    androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r8 = r8.getEmpty()
                    if (r10 != r8) goto L_0x0036
                L_0x002e:
                    com.checkout.frames.screen.billingaddress.billingaddressform.BillingAddressFormScreenKt$BillingAddressFormScreen$1$1$1$1 r10 = new com.checkout.frames.screen.billingaddress.billingaddressform.BillingAddressFormScreenKt$BillingAddressFormScreen$1$1$1$1
                    r10.<init>(r7)
                    r9.updateRememberedValue(r10)
                L_0x0036:
                    r9.endReplaceableGroup()
                    r3 = r10
                    kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
                    int r7 = r19
                    r7 = r7 & 112(0x70, float:1.57E-43)
                    r5 = r7 | 520(0x208, float:7.29E-43)
                    r4 = r9
                    com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt.BillingAddressDetailsScreen(r0, r1, r2, r3, r4, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.screen.billingaddress.billingaddressform.BillingAddressFormScreenKt$BillingAddressFormScreen$1.AnonymousClass1.invoke(androidx.compose.animation.AnimatedVisibilityScope, androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
            }
        }), 126, (Object) null);
        String route2 = Screen.CountryPicker.INSTANCE.getRoute();
        final int i12 = this.$animationDuration;
        AnonymousClass2 r62 = new Function1<AnimatedContentScope<NavBackStackEntry>, EnterTransition>() {
            @Nullable
            public final EnterTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
                Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
                return AnimatedContentScope.m19slideIntoContainerHTTW7Ok$default(animatedContentScope, AnimatedContentScope.SlideDirection.Companion.m39getUpaUPqQNE(), AnimationSpecKt.tween$default(i12, 0, (Easing) null, 6, (Object) null), (Function1) null, 4, (Object) null);
            }
        };
        final int i13 = this.$animationDuration;
        AnonymousClass3 r72 = new Function1<AnimatedContentScope<NavBackStackEntry>, ExitTransition>() {
            @Nullable
            public final ExitTransition invoke(@NotNull AnimatedContentScope<NavBackStackEntry> animatedContentScope) {
                Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
                return AnimatedContentScope.m20slideOutOfContainerHTTW7Ok$default(animatedContentScope, AnimatedContentScope.SlideDirection.Companion.m34getDownaUPqQNE(), AnimationSpecKt.tween$default(i13, 0, (Easing) null, 6, (Object) null), (Function1) null, 4, (Object) null);
            }
        };
        final BillingFormStyle billingFormStyle2 = this.$style;
        final Injector injector3 = this.$injector;
        final int i14 = this.$$dirty;
        final NavHostController navHostController3 = this.$childNavController;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route2, (List) null, (List) null, r62, r72, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1494053268, true, new Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((AnimatedVisibilityScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull NavBackStackEntry navBackStackEntry, @Nullable Composer composer, int i11) {
                Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$composable");
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                CountryPickerStyle countryPickerStyle = billingFormStyle2.getCountryPickerStyle();
                Injector injector = injector3;
                final NavHostController navHostController = navHostController3;
                CountryPickerScreenKt.CountryPickerScreen(countryPickerStyle, injector, new Function0<Unit>() {
                    public final void invoke() {
                        navHostController.navigateUp();
                    }
                }, composer, (i14 & 112) | 8);
            }
        }), 102, (Object) null);
    }
}
