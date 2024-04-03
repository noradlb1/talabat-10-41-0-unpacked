package com.talabat.darkstores.feature.cart.views;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/DeliveryTierBottomSheetViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryTierBottomSheetViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) new DeliveryTierBottomSheetViewModelFactory();
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
