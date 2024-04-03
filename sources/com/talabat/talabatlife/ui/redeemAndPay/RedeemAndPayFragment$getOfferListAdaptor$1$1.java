package com.talabat.talabatlife.ui.redeemAndPay;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.VendorsOfferListAdaptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatlife/ui/redeemAndPay/RedeemAndPayFragment$getOfferListAdaptor$1$1", "Lcom/talabat/talabatlife/ui/vendorOffers/views/offers/VendorsOfferListAdaptor$VendorOfferSelectedListener;", "onVendorSelected", "", "model", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "position", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayFragment$getOfferListAdaptor$1$1 implements VendorsOfferListAdaptor.VendorOfferSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RedeemAndPayFragment f12079a;

    public RedeemAndPayFragment$getOfferListAdaptor$1$1(RedeemAndPayFragment redeemAndPayFragment) {
        this.f12079a = redeemAndPayFragment;
    }

    public void onVendorSelected(@NotNull VendorOfferDisplayModel vendorOfferDisplayModel, int i11) {
        Intrinsics.checkNotNullParameter(vendorOfferDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        this.f12079a.loadTransactionDetails(vendorOfferDisplayModel.getId());
        this.f12079a.setSelectedOfferId(vendorOfferDisplayModel.getId());
    }
}
