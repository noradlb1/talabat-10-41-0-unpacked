package com.talabat.talabatlife.ui.vendorOffers.viewModel;

import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatlife.features.subscription.GetSubscriptionPaymentUseCase;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.features.vendors.GetVendorBranches;
import com.talabat.talabatlife.features.vendors.GetVendorInfo;
import com.talabat.talabatlife.features.vendors.GetVendorOffers;
import com.talabat.talabatlife.features.vendors.branches.models.VendorBranchListRequestModel;
import com.talabat.talabatlife.features.vendors.offers.models.VendorOfferListRequestModel;
import com.talabat.talabatlife.tracking.SubscriptionCompletedUseCase;
import com.talabat.talabatlife.tracking.SubscriptionFailedUseCase;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/viewModel/VendorOffersViewModelImpl;", "Lcom/talabat/talabatlife/ui/vendorOffers/viewModel/VendorOffersViewModel;", "getVendorBranches", "Lcom/talabat/talabatlife/features/vendors/GetVendorBranches;", "getVendorOffers", "Lcom/talabat/talabatlife/features/vendors/GetVendorOffers;", "getVendorInfo", "Lcom/talabat/talabatlife/features/vendors/GetVendorInfo;", "subscriptionPaymentUseCase", "Lcom/talabat/talabatlife/features/subscription/GetSubscriptionPaymentUseCase;", "subscriptionFailedUseCase", "Lcom/talabat/talabatlife/tracking/SubscriptionFailedUseCase;", "subscriptionCompletedUseCase", "Lcom/talabat/talabatlife/tracking/SubscriptionCompletedUseCase;", "(Lcom/talabat/talabatlife/features/vendors/GetVendorBranches;Lcom/talabat/talabatlife/features/vendors/GetVendorOffers;Lcom/talabat/talabatlife/features/vendors/GetVendorInfo;Lcom/talabat/talabatlife/features/subscription/GetSubscriptionPaymentUseCase;Lcom/talabat/talabatlife/tracking/SubscriptionFailedUseCase;Lcom/talabat/talabatlife/tracking/SubscriptionCompletedUseCase;)V", "plan", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "getPlan", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "setPlan", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;)V", "getReachedLimit", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel$LimitType;", "offer", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "", "requestModel", "Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListRequestModel;", "restaurantId", "", "countryCode", "handleSuccessSubscriptionService", "subscriptionPaymentDisplayModel", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "handleVendorBranchListDisplayModel", "displayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;", "handleVendorDisplayModel", "data", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "handleVendorOffersListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "payForSubscription", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "sendSubscriptionFailed", "error", "", "setPaymentPlan", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersViewModelImpl extends VendorOffersViewModel {
    @NotNull
    private final GetVendorBranches getVendorBranches;
    @NotNull
    private final GetVendorInfo getVendorInfo;
    @NotNull
    private final GetVendorOffers getVendorOffers;
    @Nullable
    private PaymentInfoDisplayModel plan;
    @NotNull
    private final SubscriptionCompletedUseCase subscriptionCompletedUseCase;
    @NotNull
    private final SubscriptionFailedUseCase subscriptionFailedUseCase;
    @NotNull
    private final GetSubscriptionPaymentUseCase subscriptionPaymentUseCase;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VendorOfferDisplayModel.LimitType.values().length];
            iArr[VendorOfferDisplayModel.LimitType.Monthly.ordinal()] = 1;
            iArr[VendorOfferDisplayModel.LimitType.Daily.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VendorOffersViewModelImpl(@NotNull GetVendorBranches getVendorBranches2, @NotNull GetVendorOffers getVendorOffers2, @NotNull GetVendorInfo getVendorInfo2, @NotNull GetSubscriptionPaymentUseCase getSubscriptionPaymentUseCase, @NotNull SubscriptionFailedUseCase subscriptionFailedUseCase2, @NotNull SubscriptionCompletedUseCase subscriptionCompletedUseCase2) {
        Intrinsics.checkNotNullParameter(getVendorBranches2, "getVendorBranches");
        Intrinsics.checkNotNullParameter(getVendorOffers2, "getVendorOffers");
        Intrinsics.checkNotNullParameter(getVendorInfo2, "getVendorInfo");
        Intrinsics.checkNotNullParameter(getSubscriptionPaymentUseCase, "subscriptionPaymentUseCase");
        Intrinsics.checkNotNullParameter(subscriptionFailedUseCase2, "subscriptionFailedUseCase");
        Intrinsics.checkNotNullParameter(subscriptionCompletedUseCase2, "subscriptionCompletedUseCase");
        this.getVendorBranches = getVendorBranches2;
        this.getVendorOffers = getVendorOffers2;
        this.getVendorInfo = getVendorInfo2;
        this.subscriptionPaymentUseCase = getSubscriptionPaymentUseCase;
        this.subscriptionFailedUseCase = subscriptionFailedUseCase2;
        this.subscriptionCompletedUseCase = subscriptionCompletedUseCase2;
    }

    /* access modifiers changed from: private */
    public final void handleSuccessSubscriptionService(SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        PaymentInfoDisplayModel paymentInfoDisplayModel = this.plan;
        if (paymentInfoDisplayModel != null) {
            UseCase.invoke$default(this.subscriptionCompletedUseCase, new SubscriptionCompletedUseCase.Params(paymentInfoDisplayModel.getPlanAmount()), (Function1) null, 2, (Object) null);
        }
        getSubscriptionPaymentData().setValue(subscriptionPaymentDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVendorBranchListDisplayModel(VendorBranchListDisplayModel vendorBranchListDisplayModel) {
        getVendorBranchData().setValue(vendorBranchListDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVendorDisplayModel(VendorDisplayModel vendorDisplayModel) {
        getVendorData().setValue(vendorDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVendorOffersListDisplayModel(VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        getVendorOffersData().setValue(vendorOfferListDisplayModel);
    }

    @Nullable
    public final PaymentInfoDisplayModel getPlan() {
        return this.plan;
    }

    @NotNull
    public VendorOfferDisplayModel.LimitType getReachedLimit(@NotNull VendorOfferDisplayModel vendorOfferDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorOfferDisplayModel, "offer");
        boolean z11 = false;
        boolean z12 = false;
        for (VendorOfferDisplayModel.OfferLimitModel next : vendorOfferDisplayModel.getLimits()) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i11 == 1) {
                z11 = next.isReached();
            } else if (i11 == 2) {
                z12 = next.isReached();
            }
        }
        if (z11) {
            return VendorOfferDisplayModel.LimitType.Monthly;
        }
        if (z12) {
            return VendorOfferDisplayModel.LimitType.Daily;
        }
        return VendorOfferDisplayModel.LimitType.None;
    }

    public void getVendorBranches(@NotNull VendorBranchListRequestModel vendorBranchListRequestModel) {
        Intrinsics.checkNotNullParameter(vendorBranchListRequestModel, "requestModel");
        this.getVendorBranches.invoke(vendorBranchListRequestModel, new VendorOffersViewModelImpl$getVendorBranches$1(this));
    }

    public void getVendorInfo(int i11) {
        this.getVendorInfo.invoke(Integer.valueOf(i11), new VendorOffersViewModelImpl$getVendorInfo$1(this));
    }

    public void getVendorOffers(int i11, int i12) {
        this.getVendorOffers.invoke(new VendorOfferListRequestModel(i11, i12), new VendorOffersViewModelImpl$getVendorOffers$1(this));
    }

    public void payForSubscription(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentRequestModel, "requestModel");
        this.subscriptionPaymentUseCase.invoke(subscriptionPaymentRequestModel, new VendorOffersViewModelImpl$payForSubscription$1(this));
    }

    public void sendSubscriptionFailed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        PaymentInfoDisplayModel paymentInfoDisplayModel = this.plan;
        if (paymentInfoDisplayModel != null) {
            UseCase.invoke$default(this.subscriptionFailedUseCase, new SubscriptionFailedUseCase.Params(false, paymentInfoDisplayModel.getPlanAmount(), str), (Function1) null, 2, (Object) null);
        }
    }

    public void setPaymentPlan(@Nullable PaymentInfoDisplayModel paymentInfoDisplayModel) {
        this.plan = paymentInfoDisplayModel;
    }

    public final void setPlan(@Nullable PaymentInfoDisplayModel paymentInfoDisplayModel) {
        this.plan = paymentInfoDisplayModel;
    }
}
