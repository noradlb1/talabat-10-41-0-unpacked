package com.talabat.talabatlife.ui.vendorOffers;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.VendorsOfferListAdaptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatlife/ui/vendorOffers/VendorOffersFragment$updateOffers$1$1$1", "Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/VendorsOfferListAdaptor$VendorOfferSelectedListener;", "onVendorSelected", "", "model", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "position", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersFragment$updateOffers$1$1$1 implements VendorsOfferListAdaptor.VendorOfferSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorOffersFragment f12104a;

    public VendorOffersFragment$updateOffers$1$1$1(VendorOffersFragment vendorOffersFragment) {
        this.f12104a = vendorOffersFragment;
    }

    public void onVendorSelected(@NotNull VendorOfferDisplayModel vendorOfferDisplayModel, int i11) {
        Intrinsics.checkNotNullParameter(vendorOfferDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        this.f12104a.setSelectedOfferIndex(i11);
        this.f12104a.handleOfferLimitsWarning(vendorOfferDisplayModel);
    }
}
