package com.talabat.talabatlife.features.vendors;

import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferRootResponse;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOffersMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "it", "Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVendorOffers$run$2 extends Lambda implements Function1<VendorOfferRootResponse, VendorOfferListDisplayModel> {
    public static final GetVendorOffers$run$2 INSTANCE = new GetVendorOffers$run$2();

    public GetVendorOffers$run$2() {
        super(1);
    }

    @NotNull
    public final VendorOfferListDisplayModel invoke(@NotNull VendorOfferRootResponse vendorOfferRootResponse) {
        Intrinsics.checkNotNullParameter(vendorOfferRootResponse, "it");
        return VendorOffersMapper.Companion.mapToVendorOffersListDisplayModel(vendorOfferRootResponse);
    }
}
