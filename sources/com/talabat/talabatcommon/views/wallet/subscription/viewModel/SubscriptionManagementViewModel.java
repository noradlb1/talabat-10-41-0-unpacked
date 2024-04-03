package com.talabat.talabatcommon.views.wallet.subscription.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackRequest;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionCancellationReasonsDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDefaultCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionViewDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH&J\b\u0010X\u001a\u00020UH&J\b\u0010Y\u001a\u00020UH&J\u0010\u0010Z\u001a\u00020U2\u0006\u00103\u001a\u00020\u000bH&J\u0010\u0010[\u001a\u00020U2\u0006\u0010\\\u001a\u00020\u000bH&J\u0018\u0010]\u001a\u00020U2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u0005H&J\u0010\u0010_\u001a\u00020U2\u0006\u0010V\u001a\u00020WH&J\b\u0010`\u001a\u00020UH&J\b\u0010a\u001a\u00020UH&J\u0010\u0010b\u001a\u00020U2\u0006\u0010c\u001a\u00020dH&J\u0010\u0010e\u001a\u00020U2\u0006\u0010f\u001a\u00020gH&J8\u0010@\u001a\u00020U2\b\u0010h\u001a\u0004\u0018\u00010(2\b\u0010i\u001a\u0004\u0018\u0001072\b\u0010j\u001a\u0004\u0018\u00010,2\b\u0010k\u001a\u0004\u0018\u00010L2\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0018\u0010l\u001a\u00020U2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020nH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0012\u0010\u0019\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR \u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u0018\u00103\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR \u00106\u001a\b\u0012\u0004\u0012\u0002070\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR \u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010\tR \u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\tR\u0018\u0010E\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR \u0010H\u001a\b\u0012\u0004\u0012\u0002070\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR\u0018\u0010K\u001a\u00020LX¦\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR \u0010Q\u001a\b\u0012\u0004\u0012\u00020L0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\t¨\u0006o"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "cancellationFeedbackFailureData", "Landroidx/lifecycle/MutableLiveData;", "", "getCancellationFeedbackFailureData", "()Landroidx/lifecycle/MutableLiveData;", "setCancellationFeedbackFailureData", "(Landroidx/lifecycle/MutableLiveData;)V", "cancellationOtherReason", "", "getCancellationOtherReason", "()Ljava/lang/String;", "setCancellationOtherReason", "(Ljava/lang/String;)V", "cancellationReasonId", "getCancellationReasonId", "setCancellationReasonId", "isGetDefaultCardFailed", "()Z", "setGetDefaultCardFailed", "(Z)V", "isSubscriptionDefaultCardAvailable", "setSubscriptionDefaultCardAvailable", "isWalletAddCardFlutterScreenEnabled", "setSubscriptionDefaultCardStatusData", "getSetSubscriptionDefaultCardStatusData", "setSetSubscriptionDefaultCardStatusData", "subscriptionAutoRenewData", "getSubscriptionAutoRenewData", "setSubscriptionAutoRenewData", "subscriptionCancellationReasonsData", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;", "getSubscriptionCancellationReasonsData", "setSubscriptionCancellationReasonsData", "subscriptionCancellationReasonsFailureData", "getSubscriptionCancellationReasonsFailureData", "setSubscriptionCancellationReasonsFailureData", "subscriptionData", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "getSubscriptionData", "setSubscriptionData", "subscriptionDefaultCardData", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "getSubscriptionDefaultCardData", "setSubscriptionDefaultCardData", "subscriptionDetailData", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "getSubscriptionDetailData", "setSubscriptionDetailData", "subscriptionMemberId", "getSubscriptionMemberId", "setSubscriptionMemberId", "subscriptionPlanData", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "getSubscriptionPlanData", "setSubscriptionPlanData", "subscriptionPostCancellationFeedbackData", "getSubscriptionPostCancellationFeedbackData", "setSubscriptionPostCancellationFeedbackData", "subscriptionViewsData", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewDisplayModel;", "getSubscriptionViewsData", "setSubscriptionViewsData", "subscriptionsSavingsData", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "getSubscriptionsSavingsData", "setSubscriptionsSavingsData", "termsAndConditionUrl", "getTermsAndConditionUrl", "setTermsAndConditionUrl", "unSubscribedPlansData", "getUnSubscribedPlansData", "setUnSubscribedPlansData", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getWalletCardList", "()Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "setWalletCardList", "(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", "walletCardListData", "getWalletCardListData", "setWalletCardListData", "getSavingsInfo", "", "countryId", "", "getSubscriptionCancellationReasons", "getSubscriptionDefaultCard", "getSubscriptionDetail", "getSubscriptionPlans", "country", "getSubscriptions", "isActive", "getWalletCards", "initFeatureFlags", "onUnSubscribedPlansLoaded", "postSubscriptionCancellationFeedback", "subscriptionCancellationFeedbackRequest", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackRequest;", "setSubscriptionDefaultCard", "subscriptionDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "subscriptionDisplayModel", "subscriptionPlanDisplayModel", "subscriptionDefaultCardDisplayModel", "walletCardListDisplayModel", "updateSubscriptionAutoRenewStatus", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SubscriptionManagementViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<Boolean> cancellationFeedbackFailureData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> setSubscriptionDefaultCardStatusData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> subscriptionAutoRenewData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionCancellationReasonsDisplayModel> subscriptionCancellationReasonsData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> subscriptionCancellationReasonsFailureData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionDisplayModel> subscriptionData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionDefaultCardDisplayModel> subscriptionDefaultCardData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionItemDisplayModel> subscriptionDetailData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionPlanDisplayModel> subscriptionPlanData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> subscriptionPostCancellationFeedbackData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionViewDisplayModel> subscriptionViewsData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionSavingsInfo> subscriptionsSavingsData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SubscriptionPlanDisplayModel> unSubscribedPlansData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCardListDisplayModel> walletCardListData = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Boolean> getCancellationFeedbackFailureData() {
        return this.cancellationFeedbackFailureData;
    }

    @Nullable
    public abstract String getCancellationOtherReason();

    @NotNull
    public abstract String getCancellationReasonId();

    public abstract void getSavingsInfo(int i11);

    @NotNull
    public final MutableLiveData<Boolean> getSetSubscriptionDefaultCardStatusData() {
        return this.setSubscriptionDefaultCardStatusData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getSubscriptionAutoRenewData() {
        return this.subscriptionAutoRenewData;
    }

    public abstract void getSubscriptionCancellationReasons();

    @NotNull
    public final MutableLiveData<SubscriptionCancellationReasonsDisplayModel> getSubscriptionCancellationReasonsData() {
        return this.subscriptionCancellationReasonsData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getSubscriptionCancellationReasonsFailureData() {
        return this.subscriptionCancellationReasonsFailureData;
    }

    @NotNull
    public final MutableLiveData<SubscriptionDisplayModel> getSubscriptionData() {
        return this.subscriptionData;
    }

    public abstract void getSubscriptionDefaultCard();

    @NotNull
    public final MutableLiveData<SubscriptionDefaultCardDisplayModel> getSubscriptionDefaultCardData() {
        return this.subscriptionDefaultCardData;
    }

    public abstract void getSubscriptionDetail(@NotNull String str);

    @NotNull
    public final MutableLiveData<SubscriptionItemDisplayModel> getSubscriptionDetailData() {
        return this.subscriptionDetailData;
    }

    @NotNull
    public abstract String getSubscriptionMemberId();

    @NotNull
    public final MutableLiveData<SubscriptionPlanDisplayModel> getSubscriptionPlanData() {
        return this.subscriptionPlanData;
    }

    public abstract void getSubscriptionPlans(@NotNull String str);

    @NotNull
    public final MutableLiveData<Boolean> getSubscriptionPostCancellationFeedbackData() {
        return this.subscriptionPostCancellationFeedbackData;
    }

    @NotNull
    public final MutableLiveData<SubscriptionViewDisplayModel> getSubscriptionViewsData() {
        return this.subscriptionViewsData;
    }

    public abstract void getSubscriptions(@NotNull String str, boolean z11);

    @NotNull
    public final MutableLiveData<SubscriptionSavingsInfo> getSubscriptionsSavingsData() {
        return this.subscriptionsSavingsData;
    }

    @NotNull
    public abstract String getTermsAndConditionUrl();

    @NotNull
    public final MutableLiveData<SubscriptionPlanDisplayModel> getUnSubscribedPlansData() {
        return this.unSubscribedPlansData;
    }

    @NotNull
    public abstract WalletCardListDisplayModel getWalletCardList();

    @NotNull
    public final MutableLiveData<WalletCardListDisplayModel> getWalletCardListData() {
        return this.walletCardListData;
    }

    public abstract void getWalletCards(int i11);

    public abstract void initFeatureFlags();

    public abstract boolean isGetDefaultCardFailed();

    public abstract boolean isSubscriptionDefaultCardAvailable();

    public abstract boolean isWalletAddCardFlutterScreenEnabled();

    public abstract void onUnSubscribedPlansLoaded();

    public abstract void postSubscriptionCancellationFeedback(@NotNull SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest);

    public final void setCancellationFeedbackFailureData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.cancellationFeedbackFailureData = mutableLiveData;
    }

    public abstract void setCancellationOtherReason(@Nullable String str);

    public abstract void setCancellationReasonId(@NotNull String str);

    public abstract void setGetDefaultCardFailed(boolean z11);

    public final void setSetSubscriptionDefaultCardStatusData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.setSubscriptionDefaultCardStatusData = mutableLiveData;
    }

    public final void setSubscriptionAutoRenewData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionAutoRenewData = mutableLiveData;
    }

    public final void setSubscriptionCancellationReasonsData(@NotNull MutableLiveData<SubscriptionCancellationReasonsDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionCancellationReasonsData = mutableLiveData;
    }

    public final void setSubscriptionCancellationReasonsFailureData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionCancellationReasonsFailureData = mutableLiveData;
    }

    public final void setSubscriptionData(@NotNull MutableLiveData<SubscriptionDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionData = mutableLiveData;
    }

    public abstract void setSubscriptionDefaultCard(@NotNull SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel);

    public abstract void setSubscriptionDefaultCardAvailable(boolean z11);

    public final void setSubscriptionDefaultCardData(@NotNull MutableLiveData<SubscriptionDefaultCardDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionDefaultCardData = mutableLiveData;
    }

    public final void setSubscriptionDetailData(@NotNull MutableLiveData<SubscriptionItemDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionDetailData = mutableLiveData;
    }

    public abstract void setSubscriptionMemberId(@NotNull String str);

    public final void setSubscriptionPlanData(@NotNull MutableLiveData<SubscriptionPlanDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionPlanData = mutableLiveData;
    }

    public final void setSubscriptionPostCancellationFeedbackData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionPostCancellationFeedbackData = mutableLiveData;
    }

    public final void setSubscriptionViewsData(@NotNull MutableLiveData<SubscriptionViewDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionViewsData = mutableLiveData;
    }

    public abstract void setSubscriptionViewsData(@Nullable SubscriptionDisplayModel subscriptionDisplayModel, @Nullable SubscriptionPlanDisplayModel subscriptionPlanDisplayModel, @Nullable SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, @Nullable WalletCardListDisplayModel walletCardListDisplayModel, boolean z11);

    public final void setSubscriptionsSavingsData(@NotNull MutableLiveData<SubscriptionSavingsInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionsSavingsData = mutableLiveData;
    }

    public abstract void setTermsAndConditionUrl(@NotNull String str);

    public final void setUnSubscribedPlansData(@NotNull MutableLiveData<SubscriptionPlanDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.unSubscribedPlansData = mutableLiveData;
    }

    public abstract void setWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel);

    public final void setWalletCardListData(@NotNull MutableLiveData<WalletCardListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletCardListData = mutableLiveData;
    }

    public abstract void updateSubscriptionAutoRenewStatus(@NotNull String str, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel);
}
