package com.checkout.frames.component.cardnumber;

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
import com.checkout.frames.component.base.InputComponentKt;
import com.checkout.frames.component.cardnumber.CardNumberViewModel;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"CardNumberComponent", "", "style", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "(Lcom/checkout/frames/style/component/CardNumberComponentStyle;Lcom/checkout/frames/di/base/Injector;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CardNumberComponentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CardNumberComponent(@NotNull CardNumberComponentStyle cardNumberComponentStyle, @NotNull Injector injector, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "style");
        Intrinsics.checkNotNullParameter(injector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(1774005104);
        CardNumberViewModel.Factory factory = new CardNumberViewModel.Factory(injector, cardNumberComponentStyle);
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(CardNumberViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            CardNumberViewModel cardNumberViewModel = (CardNumberViewModel) viewModel;
            InputComponentKt.InputComponent(cardNumberViewModel.getComponentStyle(), cardNumberViewModel.getComponentState().getInputState(), new CardNumberComponentKt$CardNumberComponent$1(cardNumberViewModel), new CardNumberComponentKt$CardNumberComponent$2(cardNumberViewModel), startRestartGroup, 8, 0);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new CardNumberComponentKt$CardNumberComponent$3(cardNumberComponentStyle, injector, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }
}
