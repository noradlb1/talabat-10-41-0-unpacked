package com.talabat.talabatlife.ui.vendorOffers.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListRequestModel;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H&J\u001a\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020&H&J\u0010\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH&J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001fH&J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006/"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/viewModel/VendorOffersViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "subscriptionPaymentData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "getSubscriptionPaymentData", "()Landroidx/lifecycle/MutableLiveData;", "setSubscriptionPaymentData", "(Landroidx/lifecycle/MutableLiveData;)V", "vendorBranchData", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;", "getVendorBranchData", "setVendorBranchData", "vendorData", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "getVendorData", "setVendorData", "vendorOffersData", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "getVendorOffersData", "setVendorOffersData", "getReachedLimit", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$LimitType;", "offer", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "getSubscriptionPaymentRequestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "planId", "", "getVendorBranches", "", "requestModel", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListRequestModel;", "getVendorInfo", "restaurantId", "", "getVendorOffers", "countryCode", "payForSubscription", "sendSubscriptionFailed", "error", "setPaymentPlan", "plan", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VendorOffersViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<SubscriptionPaymentDisplayModel> subscriptionPaymentData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VendorBranchListDisplayModel> vendorBranchData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VendorDisplayModel> vendorData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VendorOfferListDisplayModel> vendorOffersData = new MutableLiveData<>();

    public static /* synthetic */ void getVendorOffers$default(VendorOffersViewModel vendorOffersViewModel, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 2) != 0) {
                i12 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            vendorOffersViewModel.getVendorOffers(i11, i12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorOffers");
    }

    @NotNull
    public abstract VendorOfferDisplayModel.LimitType getReachedLimit(@NotNull VendorOfferDisplayModel vendorOfferDisplayModel);

    @NotNull
    public final MutableLiveData<SubscriptionPaymentDisplayModel> getSubscriptionPaymentData() {
        return this.subscriptionPaymentData;
    }

    @NotNull
    public final SubscriptionPaymentRequestModel getSubscriptionPaymentRequestModel(@NotNull WalletCardDisplayModel walletCardDisplayModel, @Nullable String str) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        SubscriptionPaymentRequestModel subscriptionPaymentRequestModel = new SubscriptionPaymentRequestModel((String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 127, (DefaultConstructorMarker) null);
        if (str == null) {
            str = "";
        }
        subscriptionPaymentRequestModel.setPlanId(str);
        subscriptionPaymentRequestModel.setCardTokenId(walletCardDisplayModel.getTokenId());
        subscriptionPaymentRequestModel.setCard4Digits((String) StringsKt__StringsKt.split$default((CharSequence) walletCardDisplayModel.getCardNumber(), new String[]{SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE}, false, 0, 6, (Object) null).get(1));
        subscriptionPaymentRequestModel.setCardType(walletCardDisplayModel.getCardType());
        subscriptionPaymentRequestModel.setPaymentMethod(PaymentMethod.CARD.getValue());
        String expiryMonth = walletCardDisplayModel.getExpiryMonth();
        String take = StringsKt___StringsKt.take(String.valueOf(Calendar.getInstance().get(1)), 2);
        String expiryYear = walletCardDisplayModel.getExpiryYear();
        subscriptionPaymentRequestModel.setCardExpiryDate(expiryMonth + "/" + take + expiryYear);
        return subscriptionPaymentRequestModel;
    }

    @NotNull
    public final MutableLiveData<VendorBranchListDisplayModel> getVendorBranchData() {
        return this.vendorBranchData;
    }

    public abstract void getVendorBranches(@NotNull VendorBranchListRequestModel vendorBranchListRequestModel);

    @NotNull
    public final MutableLiveData<VendorDisplayModel> getVendorData() {
        return this.vendorData;
    }

    public abstract void getVendorInfo(int i11);

    public abstract void getVendorOffers(int i11, int i12);

    @NotNull
    public final MutableLiveData<VendorOfferListDisplayModel> getVendorOffersData() {
        return this.vendorOffersData;
    }

    public abstract void payForSubscription(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel);

    public abstract void sendSubscriptionFailed(@NotNull String str);

    public abstract void setPaymentPlan(@Nullable PaymentInfoDisplayModel paymentInfoDisplayModel);

    public final void setSubscriptionPaymentData(@NotNull MutableLiveData<SubscriptionPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionPaymentData = mutableLiveData;
    }

    public final void setVendorBranchData(@NotNull MutableLiveData<VendorBranchListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorBranchData = mutableLiveData;
    }

    public final void setVendorData(@NotNull MutableLiveData<VendorDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorData = mutableLiveData;
    }

    public final void setVendorOffersData(@NotNull MutableLiveData<VendorOfferListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.vendorOffersData = mutableLiveData;
    }
}
