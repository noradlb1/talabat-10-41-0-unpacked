package com.talabat.talabatlife.ui.vendorList;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorList.views.VendorsListAdaptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/talabatlife/ui/vendorList/VendorsListFragment$vendorsItemClickListener$1", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListAdaptor$VendorsItemClickListener;", "onLoyaltyViewClicked", "", "onVendorClicked", "model", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$vendorsItemClickListener$1 implements VendorsListAdaptor.VendorsItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f12093a;

    public VendorsListFragment$vendorsItemClickListener$1(VendorsListFragment vendorsListFragment) {
        this.f12093a = vendorsListFragment;
    }

    public void onLoyaltyViewClicked() {
        this.f12093a.navigateToDashboard();
    }

    public void onVendorClicked(@NotNull VendorDisplayModel vendorDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        VendorsListFragment vendorsListFragment = this.f12093a;
        vendorsListFragment.goToVendorOffersScreen(vendorDisplayModel, vendorsListFragment.isCoffeeMode);
    }
}
