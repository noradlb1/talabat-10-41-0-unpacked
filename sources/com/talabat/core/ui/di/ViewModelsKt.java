package com.talabat.core.ui.di;

import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"viewModels", "Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/view/View;", "factoryProvider", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "com_talabat_core_ui_ui"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewModelsKt {
    public static final /* synthetic */ <VM extends ViewModel> ViewModelLazy<VM> viewModels(View view, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "factoryProvider");
        ViewModelsKt$viewModels$viewModelStoreFactory$1 viewModelsKt$viewModels$viewModelStoreFactory$1 = new ViewModelsKt$viewModels$viewModelStoreFactory$1(view);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy<>(Reflection.getOrCreateKotlinClass(ViewModel.class), viewModelsKt$viewModels$viewModelStoreFactory$1, function0);
    }
}
