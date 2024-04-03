package com.talabat.talabatlife.ui.vendorOffers;

import buisnessmodels.FilterEngine;
import com.integration.tLife.IntegrationAppTrackerTLife;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "vendor", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "offers", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "branches", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersAnalytics$Companion$fireQRTrackingEvent$1$1 extends Lambda implements Function3<VendorDisplayModel, VendorOfferListDisplayModel, VendorBranchListDisplayModel, Unit> {
    public static final VendorOffersAnalytics$Companion$fireQRTrackingEvent$1$1 INSTANCE = new VendorOffersAnalytics$Companion$fireQRTrackingEvent$1$1();

    public VendorOffersAnalytics$Companion$fireQRTrackingEvent$1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((VendorDisplayModel) obj, (VendorOfferListDisplayModel) obj2, (VendorBranchListDisplayModel) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull VendorDisplayModel vendorDisplayModel, @NotNull VendorOfferListDisplayModel vendorOfferListDisplayModel, @NotNull VendorBranchListDisplayModel vendorBranchListDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "vendor");
        Intrinsics.checkNotNullParameter(vendorOfferListDisplayModel, FilterEngine.DEEPLINKFILER.OFFERS);
        Intrinsics.checkNotNullParameter(vendorBranchListDisplayModel, "branches");
        IntegrationAppTrackerTLife.Companion.onTLifeScanQRClickedFromOfferDetails(vendorDisplayModel.getCuisines(), vendorDisplayModel.getName(), String.valueOf(vendorDisplayModel.getRestaurantId()), String.valueOf(vendorBranchListDisplayModel.getBranches().size()), vendorDisplayModel.getRating().toString(), String.valueOf(vendorDisplayModel.getReviewsCount()), String.valueOf(vendorOfferListDisplayModel.getOfferList().size()), VendorOffersAnalytics.Companion.getOffersNames(vendorOfferListDisplayModel));
    }
}
