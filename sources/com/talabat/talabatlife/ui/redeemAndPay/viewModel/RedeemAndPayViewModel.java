package com.talabat.talabatlife.ui.redeemAndPay.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferRequestModel;
import com.talabat.talabatlife.features.offers.model.transactionDetails.request.OfferTransactionDetailsRequestModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemAndPayDisplayModel;
import com.talabat.talabatlife.ui.redeemAndPay.model.RedeemOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u001cH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/viewModel/RedeemAndPayViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "offersTransactionData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemAndPayDisplayModel;", "getOffersTransactionData", "()Landroidx/lifecycle/MutableLiveData;", "setOffersTransactionData", "(Landroidx/lifecycle/MutableLiveData;)V", "redeemOfferData", "Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;", "getRedeemOfferData", "setRedeemOfferData", "vendorOffersData", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "getVendorOffersData", "setVendorOffersData", "getOfferTransactionDetail", "", "params", "Lcom/talabat/talabatlife/features/offers/model/transactionDetails/request/OfferTransactionDetailsRequestModel;", "getVendorOffers", "restaurantId", "", "countryCode", "redeemOffer", "offerId", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RedeemAndPayViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<RedeemAndPayDisplayModel> offersTransactionData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<RedeemOfferDisplayModel> redeemOfferData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VendorOfferListDisplayModel> vendorOffersData = new MutableLiveData<>();

    public static /* synthetic */ void getVendorOffers$default(RedeemAndPayViewModel redeemAndPayViewModel, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 2) != 0) {
                i12 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            redeemAndPayViewModel.getVendorOffers(i11, i12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorOffers");
    }

    public abstract void getOfferTransactionDetail(@NotNull OfferTransactionDetailsRequestModel offerTransactionDetailsRequestModel);

    @NotNull
    public final MutableLiveData<RedeemAndPayDisplayModel> getOffersTransactionData() {
        return this.offersTransactionData;
    }

    @NotNull
    public final MutableLiveData<RedeemOfferDisplayModel> getRedeemOfferData() {
        return this.redeemOfferData;
    }

    public abstract void getVendorOffers(int i11, int i12);

    @NotNull
    public final MutableLiveData<VendorOfferListDisplayModel> getVendorOffersData() {
        return this.vendorOffersData;
    }

    public abstract void redeemOffer(int i11, @NotNull RedeemOfferRequestModel redeemOfferRequestModel);

    public final void setOffersTransactionData(@NotNull MutableLiveData<RedeemAndPayDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.offersTransactionData = mutableLiveData;
    }

    public final void setRedeemOfferData(@NotNull MutableLiveData<RedeemOfferDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.redeemOfferData = mutableLiveData;
    }

    public final void setVendorOffersData(@NotNull MutableLiveData<VendorOfferListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorOffersData = mutableLiveData;
    }
}
