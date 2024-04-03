package com.talabat.darkstores.feature.main.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewStateViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "deliveryTierBottomSheetViewState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierBottomSheetViewState;", "getDeliveryTierBottomSheetViewState", "()Landroidx/lifecycle/MutableLiveData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryTierBottomSheetViewStateViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<DeliveryTierBottomSheetViewState> deliveryTierBottomSheetViewState = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<DeliveryTierBottomSheetViewState> getDeliveryTierBottomSheetViewState() {
        return this.deliveryTierBottomSheetViewState;
    }
}
