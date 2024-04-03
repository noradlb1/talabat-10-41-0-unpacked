package com.talabat.talabatlife.ui.redeemAndPay.viewModel;

import com.facebook.internal.NativeProtocol;
import com.talabat.talabatlife.features.offers.GetOfferTransactionDetails;
import com.talabat.talabatlife.features.offers.RedeemOffer;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferRequestModel;
import com.talabat.talabatlife.features.offers.model.transactionDetails.request.OfferTransactionDetailsRequestModel;
import com.talabat.talabatlife.features.vendors.GetVendorOffers;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferListRequestModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayDisplayModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0002\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0017H\u0002J\u0018\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/viewModel/RedeemAndPayViewModelImpl;", "Lcom/talabat/talabatlife/ui/redeemAndPay/viewModel/RedeemAndPayViewModel;", "getVendorOffers", "Lcom/talabat/talabatlife/features/vendors/GetVendorOffers;", "getOfferTransactionDetails", "Lcom/talabat/talabatlife/features/offers/GetOfferTransactionDetails;", "redeemOffer", "Lcom/talabat/talabatlife/features/offers/RedeemOffer;", "(Lcom/talabat/talabatlife/features/vendors/GetVendorOffers;Lcom/talabat/talabatlife/features/offers/GetOfferTransactionDetails;Lcom/talabat/talabatlife/features/offers/RedeemOffer;)V", "getOfferTransactionDetail", "", "params", "Lcom/talabat/talabatlife/features/offers/model/transactionDetails/request/OfferTransactionDetailsRequestModel;", "restaurantId", "", "countryCode", "handleRedeemAndPayDisplayModel", "displayModel", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;", "handleRedeemOffer", "redeemOfferDisplayModel", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;", "handleVendorOffersListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "offerId", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayViewModelImpl extends RedeemAndPayViewModel {
    @NotNull
    private final GetOfferTransactionDetails getOfferTransactionDetails;
    @NotNull
    private final GetVendorOffers getVendorOffers;
    @NotNull
    private final RedeemOffer redeemOffer;

    public RedeemAndPayViewModelImpl(@NotNull GetVendorOffers getVendorOffers2, @NotNull GetOfferTransactionDetails getOfferTransactionDetails2, @NotNull RedeemOffer redeemOffer2) {
        Intrinsics.checkNotNullParameter(getVendorOffers2, "getVendorOffers");
        Intrinsics.checkNotNullParameter(getOfferTransactionDetails2, "getOfferTransactionDetails");
        Intrinsics.checkNotNullParameter(redeemOffer2, "redeemOffer");
        this.getVendorOffers = getVendorOffers2;
        this.getOfferTransactionDetails = getOfferTransactionDetails2;
        this.redeemOffer = redeemOffer2;
    }

    /* access modifiers changed from: private */
    public final void handleRedeemAndPayDisplayModel(RedeemAndPayDisplayModel redeemAndPayDisplayModel) {
        getOffersTransactionData().setValue(redeemAndPayDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleRedeemOffer(RedeemOfferDisplayModel redeemOfferDisplayModel) {
        getRedeemOfferData().setValue(redeemOfferDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVendorOffersListDisplayModel(VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        getVendorOffersData().setValue(vendorOfferListDisplayModel);
    }

    public void getOfferTransactionDetail(@NotNull OfferTransactionDetailsRequestModel offerTransactionDetailsRequestModel) {
        Intrinsics.checkNotNullParameter(offerTransactionDetailsRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        this.getOfferTransactionDetails.invoke(offerTransactionDetailsRequestModel, new RedeemAndPayViewModelImpl$getOfferTransactionDetail$1(this));
    }

    public void getVendorOffers(int i11, int i12) {
        this.getVendorOffers.invoke(new VendorOfferListRequestModel(i11, i12), new RedeemAndPayViewModelImpl$getVendorOffers$1(this));
    }

    public void redeemOffer(int i11, @NotNull RedeemOfferRequestModel redeemOfferRequestModel) {
        Intrinsics.checkNotNullParameter(redeemOfferRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        this.redeemOffer.invoke(new RedeemOffer.Params(i11, redeemOfferRequestModel), new RedeemAndPayViewModelImpl$redeemOffer$1(this));
    }
}
