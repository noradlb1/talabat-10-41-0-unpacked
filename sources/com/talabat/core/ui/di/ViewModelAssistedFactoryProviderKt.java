package com.talabat.core.ui.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, d2 = {"viewModelAssistedFactoryProvider", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "assistedProvider", "Lkotlin/Function0;", "com_talabat_core_ui_ui"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewModelAssistedFactoryProviderKt {
    @NotNull
    public static final <VM extends ViewModel> ViewModelProvider.Factory viewModelAssistedFactoryProvider(@NotNull Function0<? extends VM> function0) {
        Intrinsics.checkNotNullParameter(function0, "assistedProvider");
        return new ViewModelAssistedFactoryProviderKt$viewModelAssistedFactoryProvider$1(function0);
    }
}
