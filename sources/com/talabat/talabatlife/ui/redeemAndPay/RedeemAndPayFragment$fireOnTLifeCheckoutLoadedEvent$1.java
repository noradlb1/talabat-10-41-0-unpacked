package com.talabat.talabatlife.ui.redeemAndPay;

import com.integration.tLife.IntegrationAppTrackerTLife;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "offerData", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "vendorData", "", "invoke", "(Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;F)Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayFragment$fireOnTLifeCheckoutLoadedEvent$1 extends Lambda implements Function2<VendorOfferListDisplayModel, Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RedeemAndPayFragment f12078g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemAndPayFragment$fireOnTLifeCheckoutLoadedEvent$1(RedeemAndPayFragment redeemAndPayFragment) {
        super(2);
        this.f12078g = redeemAndPayFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((VendorOfferListDisplayModel) obj, ((Number) obj2).floatValue());
    }

    @Nullable
    public final Unit invoke(@NotNull VendorOfferListDisplayModel vendorOfferListDisplayModel, float f11) {
        Intrinsics.checkNotNullParameter(vendorOfferListDisplayModel, "offerData");
        if (this.f12078g.getContext() == null) {
            return null;
        }
        RedeemAndPayFragment redeemAndPayFragment = this.f12078g;
        IntegrationAppTrackerTLife.Companion.onTLifeCheckoutLoaded(redeemAndPayFragment.redeemAndPayDisplayModel.getMerchantName(), String.valueOf(redeemAndPayFragment.redeemAndPayDisplayModel.getBrandId()), redeemAndPayFragment.getOffersSize(), redeemAndPayFragment.getOfferName(), String.valueOf(redeemAndPayFragment.redeemAndPayDisplayModel.getAmount()), redeemAndPayFragment.getOfferID());
        return Unit.INSTANCE;
    }
}
