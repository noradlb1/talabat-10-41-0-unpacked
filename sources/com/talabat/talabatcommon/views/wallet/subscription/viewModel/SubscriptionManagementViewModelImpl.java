package com.talabat.talabatcommon.views.wallet.subscription.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetPostSubscriptionCancellationFeedbackUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSetSubscriptionDefaultCardUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionCancellationReasonsUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionDefaultCardUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionDetailUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionPlansUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetSubscriptionViewsDataUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.GetUpdateSubscriptionAutoRenewUseCase;
import com.talabat.talabatcommon.feature.subscriptionManagement.SubscriptionAutoRenewParam;
import com.talabat.talabatcommon.feature.subscriptionManagement.SubscriptionParam;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SetSubscriptionDefaultCardResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewUpdateResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDetailRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackRequest;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResponse;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.IsWalletAddCardFlutterScreenEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDefaultCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import com.talabat.talabatcore.exception.Failure;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020<H\u0016J\b\u0010@\u001a\u00020<H\u0016J\u0010\u0010A\u001a\u00020<2\u0006\u0010/\u001a\u00020\u001eH\u0016J\u0010\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u001eH\u0016J\u0018\u0010D\u001a\u00020<2\u0006\u0010C\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020'H\u0016J\u0010\u0010F\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020<2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u000206H\u0002J\u0010\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u00020[H\u0002J\u0018\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u00020^2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010_\u001a\u00020<2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020<2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010f\u001a\u00020<H\u0016J\b\u0010g\u001a\u00020<H\u0016J\u0010\u0010h\u001a\u00020<2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020mH\u0016J8\u0010n\u001a\u00020<2\b\u0010o\u001a\u0004\u0018\u00010p2\b\u0010q\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010R\u001a\u0004\u0018\u0001062\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010u\u001a\u00020<2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010v\u001a\u00020wH\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001a\u0010-\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006x"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModelImpl;", "Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", "subscriptionPlansUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionPlansUseCase;", "subscriptionUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionUseCase;", "subscriptionViewsDataUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionViewsDataUseCase;", "subscriptionDefaultCardUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionDefaultCardUseCase;", "setSubscriptionDefaultCardUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSetSubscriptionDefaultCardUseCase;", "cardListUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;", "subscriptionDetailUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionDetailUseCase;", "updateSubscriptionAutoRenewUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetUpdateSubscriptionAutoRenewUseCase;", "subscriptionCancellationReasonsUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionCancellationReasonsUseCase;", "postSubscriptionCancellationFeedbackUseCase", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetPostSubscriptionCancellationFeedbackUseCase;", "isWalletAddCardFlutterScreenEnabledUseCase", "Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "(Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionPlansUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionViewsDataUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionDefaultCardUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSetSubscriptionDefaultCardUseCase;Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionDetailUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetUpdateSubscriptionAutoRenewUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionCancellationReasonsUseCase;Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetPostSubscriptionCancellationFeedbackUseCase;Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "cancellationOtherReason", "", "getCancellationOtherReason", "()Ljava/lang/String;", "setCancellationOtherReason", "(Ljava/lang/String;)V", "cancellationReasonId", "getCancellationReasonId", "setCancellationReasonId", "isGetDefaultCardFailed", "", "()Z", "setGetDefaultCardFailed", "(Z)V", "isSubscriptionDefaultCardAvailable", "setSubscriptionDefaultCardAvailable", "isWalletAddCardFlutterScreenEnabled", "setWalletAddCardFlutterScreenEnabled", "subscriptionMemberId", "getSubscriptionMemberId", "setSubscriptionMemberId", "termsAndConditionUrl", "getTermsAndConditionUrl", "setTermsAndConditionUrl", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getWalletCardList", "()Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "setWalletCardList", "(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", "getSavingsInfo", "", "countryId", "", "getSubscriptionCancellationReasons", "getSubscriptionDefaultCard", "getSubscriptionDetail", "getSubscriptionPlans", "country", "getSubscriptions", "isActive", "getWalletCards", "handleCancellationFeedbackFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "handleGetSubscriptionDefaultCard", "subscriptionDefaultCardRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRootResponse;", "handleGetSubscriptionDefaultCardFailure", "handleGetSubscriptionDetailSuccess", "subscriptionDetailRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "handleGetWalletCards", "walletCardListDisplayModel", "handleSetSubscriptionDefaultCard", "setSubscriptionDefaultCardResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SetSubscriptionDefaultCardResponse;", "handleSubscriptionCancellationReasonsSuccess", "subscriptionCancellationReasonResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReasonResponse;", "handleSubscriptionFeedbackSuccess", "subscriptionCancellationFeedbackResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackResponse;", "handleSubscriptionPlanSuccess", "subscriptionPlanRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanRootResponse;", "handleSubscriptionReasonFailure", "handleSubscriptionSuccess", "subscriptionRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "handleUpdateSubscriptionAutoRenewSuccess", "subscriptionAutoRenewUpdateResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewUpdateResponse;", "initFeatureFlags", "onUnSubscribedPlansLoaded", "postSubscriptionCancellationFeedback", "subscriptionCancellationFeedbackRequest", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackRequest;", "setSubscriptionDefaultCard", "subscriptionDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "setSubscriptionViewsData", "subscriptionDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "subscriptionPlanDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "subscriptionDefaultCardDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "updateSubscriptionAutoRenewStatus", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementViewModelImpl extends SubscriptionManagementViewModel {
    @Nullable
    private String cancellationOtherReason;
    @NotNull
    private String cancellationReasonId;
    @NotNull
    private final GetCardListUseCase cardListUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSavingsInfoUseCase getSavingsInfoUseCase;
    private boolean isGetDefaultCardFailed;
    private boolean isSubscriptionDefaultCardAvailable;
    private boolean isWalletAddCardFlutterScreenEnabled;
    @NotNull
    private final IsWalletAddCardFlutterScreenEnabledUseCase isWalletAddCardFlutterScreenEnabledUseCase;
    @NotNull
    private final GetPostSubscriptionCancellationFeedbackUseCase postSubscriptionCancellationFeedbackUseCase;
    @NotNull
    private final GetSetSubscriptionDefaultCardUseCase setSubscriptionDefaultCardUseCase;
    @NotNull
    private final GetSubscriptionCancellationReasonsUseCase subscriptionCancellationReasonsUseCase;
    @NotNull
    private final GetSubscriptionDefaultCardUseCase subscriptionDefaultCardUseCase;
    @NotNull
    private final GetSubscriptionDetailUseCase subscriptionDetailUseCase;
    @NotNull
    private String subscriptionMemberId;
    @NotNull
    private final GetSubscriptionPlansUseCase subscriptionPlansUseCase;
    @NotNull
    private final GetSubscriptionUseCase subscriptionUseCase;
    @NotNull
    private final GetSubscriptionViewsDataUseCase subscriptionViewsDataUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;
    @NotNull
    private String termsAndConditionUrl;
    @NotNull
    private final GetUpdateSubscriptionAutoRenewUseCase updateSubscriptionAutoRenewUseCase;
    @NotNull
    private WalletCardListDisplayModel walletCardList = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);

    public SubscriptionManagementViewModelImpl(@NotNull GetSubscriptionPlansUseCase getSubscriptionPlansUseCase, @NotNull GetSubscriptionUseCase getSubscriptionUseCase, @NotNull GetSubscriptionViewsDataUseCase getSubscriptionViewsDataUseCase, @NotNull GetSubscriptionDefaultCardUseCase getSubscriptionDefaultCardUseCase, @NotNull GetSetSubscriptionDefaultCardUseCase getSetSubscriptionDefaultCardUseCase, @NotNull GetCardListUseCase getCardListUseCase, @NotNull GetSubscriptionDetailUseCase getSubscriptionDetailUseCase, @NotNull GetUpdateSubscriptionAutoRenewUseCase getUpdateSubscriptionAutoRenewUseCase, @NotNull GetSubscriptionCancellationReasonsUseCase getSubscriptionCancellationReasonsUseCase, @NotNull GetPostSubscriptionCancellationFeedbackUseCase getPostSubscriptionCancellationFeedbackUseCase, @NotNull IsWalletAddCardFlutterScreenEnabledUseCase isWalletAddCardFlutterScreenEnabledUseCase2, @NotNull GetSavingsInfoUseCase getSavingsInfoUseCase2, @NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(getSubscriptionPlansUseCase, "subscriptionPlansUseCase");
        Intrinsics.checkNotNullParameter(getSubscriptionUseCase, "subscriptionUseCase");
        Intrinsics.checkNotNullParameter(getSubscriptionViewsDataUseCase, "subscriptionViewsDataUseCase");
        Intrinsics.checkNotNullParameter(getSubscriptionDefaultCardUseCase, "subscriptionDefaultCardUseCase");
        Intrinsics.checkNotNullParameter(getSetSubscriptionDefaultCardUseCase, "setSubscriptionDefaultCardUseCase");
        Intrinsics.checkNotNullParameter(getCardListUseCase, "cardListUseCase");
        Intrinsics.checkNotNullParameter(getSubscriptionDetailUseCase, "subscriptionDetailUseCase");
        Intrinsics.checkNotNullParameter(getUpdateSubscriptionAutoRenewUseCase, "updateSubscriptionAutoRenewUseCase");
        Intrinsics.checkNotNullParameter(getSubscriptionCancellationReasonsUseCase, "subscriptionCancellationReasonsUseCase");
        Intrinsics.checkNotNullParameter(getPostSubscriptionCancellationFeedbackUseCase, "postSubscriptionCancellationFeedbackUseCase");
        Intrinsics.checkNotNullParameter(isWalletAddCardFlutterScreenEnabledUseCase2, "isWalletAddCardFlutterScreenEnabledUseCase");
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase2, "getSavingsInfoUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "subscriptionsFeatureFlag");
        this.subscriptionPlansUseCase = getSubscriptionPlansUseCase;
        this.subscriptionUseCase = getSubscriptionUseCase;
        this.subscriptionViewsDataUseCase = getSubscriptionViewsDataUseCase;
        this.subscriptionDefaultCardUseCase = getSubscriptionDefaultCardUseCase;
        this.setSubscriptionDefaultCardUseCase = getSetSubscriptionDefaultCardUseCase;
        this.cardListUseCase = getCardListUseCase;
        this.subscriptionDetailUseCase = getSubscriptionDetailUseCase;
        this.updateSubscriptionAutoRenewUseCase = getUpdateSubscriptionAutoRenewUseCase;
        this.subscriptionCancellationReasonsUseCase = getSubscriptionCancellationReasonsUseCase;
        this.postSubscriptionCancellationFeedbackUseCase = getPostSubscriptionCancellationFeedbackUseCase;
        this.isWalletAddCardFlutterScreenEnabledUseCase = isWalletAddCardFlutterScreenEnabledUseCase2;
        this.getSavingsInfoUseCase = getSavingsInfoUseCase2;
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.subscriptionMemberId = StringUtils.empty(stringCompanionObject);
        this.termsAndConditionUrl = StringUtils.empty(stringCompanionObject);
        this.cancellationReasonId = StringUtils.empty(stringCompanionObject);
        this.cancellationOtherReason = StringUtils.empty(stringCompanionObject);
    }

    /* access modifiers changed from: private */
    public final void handleCancellationFeedbackFailure(Failure failure) {
        getCancellationFeedbackFailureData().setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void handleGetSubscriptionDefaultCard(SubscriptionDefaultCardRootResponse subscriptionDefaultCardRootResponse) {
        getSubscriptionDefaultCardData().setValue(WalletSubscriptionMapper.Companion.mapSubscriptionDefaultCardToDisplayModel(subscriptionDefaultCardRootResponse));
        setSubscriptionViewsData(getSubscriptionData().getValue(), getSubscriptionPlanData().getValue(), getSubscriptionDefaultCardData().getValue(), getWalletCardListData().getValue(), isGetDefaultCardFailed());
    }

    /* access modifiers changed from: private */
    public final void handleGetSubscriptionDefaultCardFailure(Failure failure) {
        setGetDefaultCardFailed(true);
        getSubscriptionDefaultCardData().setValue(new SubscriptionDefaultCardDisplayModel((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null));
        setSubscriptionViewsData(getSubscriptionData().getValue(), getSubscriptionPlanData().getValue(), getSubscriptionDefaultCardData().getValue(), getWalletCardListData().getValue(), isGetDefaultCardFailed());
    }

    /* access modifiers changed from: private */
    public final void handleGetSubscriptionDetailSuccess(SubscriptionDetailRootResponse subscriptionDetailRootResponse) {
        getSubscriptionDetailData().setValue(WalletSubscriptionMapper.Companion.mapSubscriptionDetailToDisplayModel(subscriptionDetailRootResponse));
    }

    /* access modifiers changed from: private */
    public final void handleGetWalletCards(WalletCardListDisplayModel walletCardListDisplayModel) {
        setWalletCardList(walletCardListDisplayModel);
        getWalletCardListData().setValue(walletCardListDisplayModel);
        setSubscriptionViewsData(getSubscriptionData().getValue(), getSubscriptionPlanData().getValue(), getSubscriptionDefaultCardData().getValue(), getWalletCardListData().getValue(), isGetDefaultCardFailed());
    }

    /* access modifiers changed from: private */
    public final void handleSetSubscriptionDefaultCard(SetSubscriptionDefaultCardResponse setSubscriptionDefaultCardResponse) {
        getSetSubscriptionDefaultCardStatusData().setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void handleSubscriptionCancellationReasonsSuccess(SubscriptionCancellationReasonResponse subscriptionCancellationReasonResponse) {
        getSubscriptionCancellationReasonsData().setValue(WalletSubscriptionMapper.Companion.getSubscriptionCancellationReasons(subscriptionCancellationReasonResponse));
    }

    /* access modifiers changed from: private */
    public final void handleSubscriptionFeedbackSuccess(SubscriptionCancellationFeedbackResponse subscriptionCancellationFeedbackResponse) {
        Boolean bool;
        MutableLiveData<Boolean> subscriptionPostCancellationFeedbackData = getSubscriptionPostCancellationFeedbackData();
        Boolean result = subscriptionCancellationFeedbackResponse.getResult();
        if (result != null) {
            bool = Boolean.valueOf(BooleanKt.orFalse(result));
        } else {
            bool = null;
        }
        subscriptionPostCancellationFeedbackData.setValue(bool);
    }

    /* access modifiers changed from: private */
    public final void handleSubscriptionPlanSuccess(SubscriptionPlanRootResponse subscriptionPlanRootResponse, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        getSubscriptionPlanData().setValue(WalletSubscriptionMapper.Companion.mapPlanResponseToDisplayModel(subscriptionPlanRootResponse, iSubscriptionsFeatureFlagsRepository));
        onUnSubscribedPlansLoaded();
        setSubscriptionViewsData(getSubscriptionData().getValue(), getSubscriptionPlanData().getValue(), getSubscriptionDefaultCardData().getValue(), getWalletCardListData().getValue(), isGetDefaultCardFailed());
    }

    /* access modifiers changed from: private */
    public final void handleSubscriptionReasonFailure(Failure failure) {
        getSubscriptionCancellationReasonsFailureData().setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void handleSubscriptionSuccess(SubscriptionRootResponse subscriptionRootResponse) {
        getSubscriptionData().setValue(WalletSubscriptionMapper.Companion.mapSubscriptionToDisplayModel(subscriptionRootResponse));
        onUnSubscribedPlansLoaded();
        setSubscriptionViewsData(getSubscriptionData().getValue(), getSubscriptionPlanData().getValue(), getSubscriptionDefaultCardData().getValue(), getWalletCardListData().getValue(), isGetDefaultCardFailed());
    }

    /* access modifiers changed from: private */
    public final void handleUpdateSubscriptionAutoRenewSuccess(SubscriptionAutoRenewUpdateResponse subscriptionAutoRenewUpdateResponse) {
        getSubscriptionAutoRenewData().setValue(Boolean.TRUE);
    }

    @Nullable
    public String getCancellationOtherReason() {
        return this.cancellationOtherReason;
    }

    @NotNull
    public String getCancellationReasonId() {
        return this.cancellationReasonId;
    }

    public void getSavingsInfo(int i11) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SubscriptionManagementViewModelImpl$getSavingsInfo$1(this, i11, (Continuation<? super SubscriptionManagementViewModelImpl$getSavingsInfo$1>) null), 3, (Object) null);
    }

    public void getSubscriptionCancellationReasons() {
        this.subscriptionCancellationReasonsUseCase.invoke(Unit.INSTANCE, new SubscriptionManagementViewModelImpl$getSubscriptionCancellationReasons$1(this));
    }

    public void getSubscriptionDefaultCard() {
        this.subscriptionDefaultCardUseCase.invoke(Unit.INSTANCE, new SubscriptionManagementViewModelImpl$getSubscriptionDefaultCard$1(this));
    }

    public void getSubscriptionDetail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        this.subscriptionDetailUseCase.invoke(str, new SubscriptionManagementViewModelImpl$getSubscriptionDetail$1(this));
    }

    @NotNull
    public String getSubscriptionMemberId() {
        return this.subscriptionMemberId;
    }

    public void getSubscriptionPlans(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "country");
        this.subscriptionPlansUseCase.invoke(str, new SubscriptionManagementViewModelImpl$getSubscriptionPlans$1(this));
    }

    public void getSubscriptions(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "country");
        this.subscriptionUseCase.invoke(new SubscriptionParam(str, z11), new SubscriptionManagementViewModelImpl$getSubscriptions$1(this));
    }

    @NotNull
    public String getTermsAndConditionUrl() {
        return this.termsAndConditionUrl;
    }

    @NotNull
    public WalletCardListDisplayModel getWalletCardList() {
        return this.walletCardList;
    }

    public void getWalletCards(int i11) {
        this.cardListUseCase.invoke(Integer.valueOf(i11), new SubscriptionManagementViewModelImpl$getWalletCards$1(this));
    }

    public void initFeatureFlags() {
        setWalletAddCardFlutterScreenEnabled(this.isWalletAddCardFlutterScreenEnabledUseCase.invoke());
    }

    public boolean isGetDefaultCardFailed() {
        return this.isGetDefaultCardFailed;
    }

    public boolean isSubscriptionDefaultCardAvailable() {
        return this.isSubscriptionDefaultCardAvailable;
    }

    public boolean isWalletAddCardFlutterScreenEnabled() {
        return this.isWalletAddCardFlutterScreenEnabled;
    }

    public void onUnSubscribedPlansLoaded() {
        SafeLetKt.safeLet(getSubscriptionData().getValue(), getSubscriptionPlanData().getValue(), new SubscriptionManagementViewModelImpl$onUnSubscribedPlansLoaded$1(this));
    }

    public void postSubscriptionCancellationFeedback(@NotNull SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFeedbackRequest, "subscriptionCancellationFeedbackRequest");
        this.postSubscriptionCancellationFeedbackUseCase.invoke(subscriptionCancellationFeedbackRequest, new SubscriptionManagementViewModelImpl$postSubscriptionCancellationFeedback$1(this));
    }

    public void setCancellationOtherReason(@Nullable String str) {
        this.cancellationOtherReason = str;
    }

    public void setCancellationReasonId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancellationReasonId = str;
    }

    public void setGetDefaultCardFailed(boolean z11) {
        this.isGetDefaultCardFailed = z11;
    }

    public void setSubscriptionDefaultCard(@NotNull SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel) {
        Intrinsics.checkNotNullParameter(subscriptionDefaultCardRequestModel, "subscriptionDefaultCardRequestModel");
        this.setSubscriptionDefaultCardUseCase.invoke(subscriptionDefaultCardRequestModel, new SubscriptionManagementViewModelImpl$setSubscriptionDefaultCard$1(this));
    }

    public void setSubscriptionDefaultCardAvailable(boolean z11) {
        this.isSubscriptionDefaultCardAvailable = z11;
    }

    public void setSubscriptionMemberId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subscriptionMemberId = str;
    }

    public void setSubscriptionViewsData(@Nullable SubscriptionDisplayModel subscriptionDisplayModel, @Nullable SubscriptionPlanDisplayModel subscriptionPlanDisplayModel, @Nullable SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, @Nullable WalletCardListDisplayModel walletCardListDisplayModel, boolean z11) {
        getSubscriptionViewsData().setValue(this.subscriptionViewsDataUseCase.invoke(subscriptionDisplayModel, subscriptionPlanDisplayModel, subscriptionDefaultCardDisplayModel, walletCardListDisplayModel, z11));
    }

    public void setTermsAndConditionUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.termsAndConditionUrl = str;
    }

    public void setWalletAddCardFlutterScreenEnabled(boolean z11) {
        this.isWalletAddCardFlutterScreenEnabled = z11;
    }

    public void setWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "<set-?>");
        this.walletCardList = walletCardListDisplayModel;
    }

    public void updateSubscriptionAutoRenewStatus(@NotNull String str, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel) {
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewRequestModel, "subscriptionAutoRenewRequestModel");
        this.updateSubscriptionAutoRenewUseCase.invoke(new SubscriptionAutoRenewParam(subscriptionAutoRenewRequestModel, str), new SubscriptionManagementViewModelImpl$updateSubscriptionAutoRenewStatus$1(this));
    }
}
