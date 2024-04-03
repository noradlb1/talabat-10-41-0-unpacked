package com.checkout.frames.component.paybutton;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.checkout.frames.component.paybutton.PayButtonViewModel;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.view.InternalButtonKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"PayButtonComponent", "", "style", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "(Lcom/checkout/frames/style/component/PayButtonComponentStyle;Lcom/checkout/frames/di/base/Injector;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PayButtonComponentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PayButtonComponent(@NotNull PayButtonComponentStyle payButtonComponentStyle, @NotNull Injector injector, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(payButtonComponentStyle, "style");
        Intrinsics.checkNotNullParameter(injector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(-762860830);
        PayButtonViewModel.Factory factory = new PayButtonViewModel.Factory(injector, payButtonComponentStyle);
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(PayButtonViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            PayButtonViewModel payButtonViewModel = (PayButtonViewModel) viewModel;
            payButtonViewModel.prepare();
            InternalButtonKt.InternalButton(payButtonViewModel.getButtonStyle(), payButtonViewModel.getButtonState(), new PayButtonComponentKt$PayButtonComponent$1(payButtonViewModel), startRestartGroup, 8);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new PayButtonComponentKt$PayButtonComponent$2(payButtonComponentStyle, injector, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }
}
