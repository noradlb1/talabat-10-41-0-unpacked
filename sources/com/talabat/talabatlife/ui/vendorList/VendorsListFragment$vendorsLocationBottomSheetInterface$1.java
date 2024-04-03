package com.talabat.talabatlife.ui.vendorList;

import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import com.talabat.talabatlife.ui.vendorList.views.VendorsLocationFilterBottomSheet;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/talabatlife/ui/vendorList/VendorsListFragment$vendorsLocationBottomSheetInterface$1", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsLocationFilterBottomSheet$VendorsLocationFilterBottomSheetInterface;", "onLocationChange", "", "vendorLocationFilterDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$vendorsLocationBottomSheetInterface$1 implements VendorsLocationFilterBottomSheet.VendorsLocationFilterBottomSheetInterface {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f12094a;

    public VendorsListFragment$vendorsLocationBottomSheetInterface$1(VendorsListFragment vendorsListFragment) {
        this.f12094a = vendorsListFragment;
    }

    public void onLocationChange(@Nullable VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel) {
        if (vendorLocationFilterDisplayModel != null) {
            VendorsListFragment vendorsListFragment = this.f12094a;
            VendorsListFragment.access$getViewModel(vendorsListFragment).setSelectedArea(vendorLocationFilterDisplayModel);
            vendorsListFragment.setCurrentLocationText();
            VendorsListFragment.k(vendorsListFragment, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 255, (Object) null);
        }
    }
}
