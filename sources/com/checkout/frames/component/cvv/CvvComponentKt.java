package com.checkout.frames.component.cvv;

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
import com.checkout.frames.component.cvv.CvvViewModel;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.CvvComponentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"CvvComponent", "", "style", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "(Lcom/checkout/frames/style/component/CvvComponentStyle;Lcom/checkout/frames/di/base/Injector;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CvvComponentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CvvComponent(@NotNull CvvComponentStyle cvvComponentStyle, @NotNull Injector injector, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(cvvComponentStyle, "style");
        Intrinsics.checkNotNullParameter(injector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(-1137512702);
        CvvViewModel.Factory factory = new CvvViewModel.Factory(injector, cvvComponentStyle);
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(CvvViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            CvvViewModel cvvViewModel = (CvvViewModel) viewModel;
            cvvViewModel.prepare();
            InputComponentKt.InputComponent(cvvViewModel.getComponentStyle(), cvvViewModel.getComponentState().getInputState(), new CvvComponentKt$CvvComponent$1(cvvViewModel), new CvvComponentKt$CvvComponent$2(cvvViewModel), startRestartGroup, 8, 0);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new CvvComponentKt$CvvComponent$3(cvvComponentStyle, injector, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }
}
