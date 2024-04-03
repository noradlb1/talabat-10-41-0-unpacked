package com.talabat.busypopup.viewModel;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsFilteredByCuisine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/busypopup/viewModel/BusyPopupVMBuilder;", "", "()V", "getBusyPopupViewModel", "Lcom/talabat/busypopup/viewModel/BusyPopupViewModel;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getVendorsFilteredByCuisine", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsFilteredByCuisine;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BusyPopupVMBuilder {
    @NotNull
    public static final BusyPopupVMBuilder INSTANCE = new BusyPopupVMBuilder();

    private BusyPopupVMBuilder() {
    }

    @NotNull
    public final BusyPopupViewModel getBusyPopupViewModel(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull GetVendorsFilteredByCuisine getVendorsFilteredByCuisine) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(getVendorsFilteredByCuisine, "getVendorsFilteredByCuisine");
        return new BusyPopupViewModelImpl(iTalabatFeatureFlag, getVendorsFilteredByCuisine);
    }
}
