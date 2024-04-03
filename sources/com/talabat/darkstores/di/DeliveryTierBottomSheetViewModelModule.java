package com.talabat.darkstores.di;

import androidx.lifecycle.ViewModelProvider;
import com.talabat.darkstores.feature.cart.views.DeliveryTierBottomSheetViewModelFactory;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/di/DeliveryTierBottomSheetViewModelModule;", "", "bindDeliveryTierBottomSheetViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "deliveryTierBottomSheetViewModelFactory", "Lcom/talabat/darkstores/feature/cart/views/DeliveryTierBottomSheetViewModelFactory;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DeliveryTierBottomSheetViewModelModule {
    @NotNull
    @Binds
    ViewModelProvider.Factory bindDeliveryTierBottomSheetViewModelFactory(@NotNull DeliveryTierBottomSheetViewModelFactory deliveryTierBottomSheetViewModelFactory);
}
