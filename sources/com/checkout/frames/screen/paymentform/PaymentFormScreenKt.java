package com.checkout.frames.screen.paymentform;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import com.checkout.frames.screen.navigation.Screen;
import com.checkout.frames.screen.paymentform.PaymentFormViewModel;
import com.google.accompanist.navigation.animation.AnimatedNavHostKt;
import com.google.accompanist.navigation.animation.NavHostControllerKt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"PaymentFormScreen", "", "config", "Lcom/checkout/frames/screen/paymentform/PaymentFormConfig;", "(Lcom/checkout/frames/screen/paymentform/PaymentFormConfig;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PaymentFormScreen(@NotNull PaymentFormConfig paymentFormConfig, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        PaymentFormConfig paymentFormConfig2 = paymentFormConfig;
        Intrinsics.checkNotNullParameter(paymentFormConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Composer startRestartGroup = composer.startRestartGroup(793943815);
        NavHostController rememberAnimatedNavController = NavHostControllerKt.rememberAnimatedNavController(new Navigator[0], startRestartGroup, 8);
        PaymentFormViewModel.Factory factory = new PaymentFormViewModel.Factory(paymentFormConfig.getPublicKey(), paymentFormConfig.getContext(), paymentFormConfig.getEnvironment(), paymentFormConfig.getPaymentFlowHandler(), paymentFormConfig.getSupportedCardSchemeList());
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(PaymentFormViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            AnimatedNavHostKt.AnimatedNavHost(rememberAnimatedNavController, Screen.PaymentDetails.INSTANCE.getRoute(), (Modifier) null, (Alignment) null, (String) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition>) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition>) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends EnterTransition>) null, (Function1<? super AnimatedContentScope<NavBackStackEntry>, ? extends ExitTransition>) null, new PaymentFormScreenKt$PaymentFormScreen$1(paymentFormConfig, (PaymentFormViewModel) viewModel, rememberAnimatedNavController, 350), startRestartGroup, 8, 508);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new PaymentFormScreenKt$PaymentFormScreen$2(paymentFormConfig, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }
}
