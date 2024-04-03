package com.checkout.frames.screen.billingaddress.billingaddressform;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.screen.navigation.Screen;
import com.checkout.frames.style.screen.BillingFormStyle;
import com.google.accompanist.navigation.animation.AnimatedNavHostKt;
import com.google.accompanist.navigation.animation.NavHostControllerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"BillingAddressFormScreen", "", "style", "Lcom/checkout/frames/style/screen/BillingFormStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "onClose", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/screen/BillingFormStyle;Lcom/checkout/frames/di/base/Injector;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressFormScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BillingAddressFormScreen(@NotNull BillingFormStyle billingFormStyle, @NotNull Injector injector, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        BillingFormStyle billingFormStyle2 = billingFormStyle;
        Injector injector2 = injector;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(billingFormStyle2, "style");
        Intrinsics.checkNotNullParameter(injector2, "injector");
        Intrinsics.checkNotNullParameter(function02, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(-580407037);
        NavHostController rememberAnimatedNavController = NavHostControllerKt.rememberAnimatedNavController(new Navigator[0], startRestartGroup, 8);
        Composer composer2 = startRestartGroup;
        AnimatedNavHostKt.AnimatedNavHost(rememberAnimatedNavController, Screen.BillingFormDetails.INSTANCE.getRoute(), (Modifier) null, (Alignment) null, (String) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition>) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition>) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition>) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition>) null, new BillingAddressFormScreenKt$BillingAddressFormScreen$1(billingFormStyle, injector, rememberAnimatedNavController, function0, i11, 250), composer2, 8, 508);
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BillingAddressFormScreenKt$BillingAddressFormScreen$2(billingFormStyle2, injector2, function02, i11));
        }
    }
}
