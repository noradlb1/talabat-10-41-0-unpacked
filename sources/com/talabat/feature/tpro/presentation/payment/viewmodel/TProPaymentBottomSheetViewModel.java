package com.talabat.feature.tpro.presentation.payment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.language.Language;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.MultiPlanParams;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.homescreen.network.UrlConstantsKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.talabatremoteconfiguration.keys.FreeCoffeeRemoteConfiguration;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0006\u00102\u001a\u00020\u0019J\u0018\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106J.\u00107\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u0015J\u001e\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020*2\u0006\u00108\u001a\u00020\u001cJ\u0006\u0010?\u001a\u00020@R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0017¨\u0006A"}, d2 = {"Lcom/talabat/feature/tpro/presentation/payment/viewmodel/TProPaymentBottomSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "getSubscriptionPaymentUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase;", "getActiveSubscriptionsUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionWithB2BVoucherUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionWithB2BVoucherUseCase;", "multiPlanParams", "Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;", "subscriptionPaymentOTPUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "remoteConfig", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionPaymentUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/GetActiveSubscriptionsUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionWithB2BVoucherUseCase;Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "country", "Landroidx/lifecycle/MutableLiveData;", "", "getCountry", "()Landroidx/lifecycle/MutableLiveData;", "failedSubscription", "", "getFailedSubscription$com_talabat_feature_tpro_presentation_presentation", "freeCoffeeText", "", "getFreeCoffeeText", "()Ljava/lang/String;", "setFreeCoffeeText", "(Ljava/lang/String;)V", "otpFailureSubscription", "getOtpFailureSubscription$com_talabat_feature_tpro_presentation_presentation", "otpSuccessSubscription", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "getOtpSuccessSubscription$com_talabat_feature_tpro_presentation_presentation", "subscribedToB2b", "", "getSubscribedToB2b$com_talabat_feature_tpro_presentation_presentation", "subscriptionMultiPlan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "getSubscriptionMultiPlan$com_talabat_feature_tpro_presentation_presentation", "subscriptionMultiPlanFailure", "getSubscriptionMultiPlanFailure$com_talabat_feature_tpro_presentation_presentation", "successSubscription", "getSuccessSubscription$com_talabat_feature_tpro_presentation_presentation", "verification3ds", "getVerification3ds$com_talabat_feature_tpro_presentation_presentation", "getSubscriptionMultiPlan", "subscribeInTpro", "planId", "selectedCard", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "subscribeToProOTP", "cardTokenId", "orderId", "deliveryFee", "paymentMethodId", "subscribeWithB2BVoucher", "voucher", "tProMultiPlan", "updateCustomerInfo", "Lkotlinx/coroutines/Job;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final MutableLiveData<Integer> country;
    @NotNull
    private final MutableLiveData<Unit> failedSubscription = new MutableLiveData<>();
    @NotNull
    private String freeCoffeeText;
    /* access modifiers changed from: private */
    @NotNull
    public final GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSubscriptionPaymentUseCase getSubscriptionPaymentUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final MultiPlanParams multiPlanParams;
    @NotNull
    private final MutableLiveData<Unit> otpFailureSubscription = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<SubscriptionOTPPaymentStatus> otpSuccessSubscription = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> subscribedToB2b = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<TProPlanDisplayModel> subscriptionMultiPlan = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Unit> subscriptionMultiPlanFailure = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final SubscriptionPaymentOTPUseCase subscriptionPaymentOTPUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionStatusRepository subscriptionStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final GetSubscriptionWithB2BVoucherUseCase subscriptionWithB2BVoucherUseCase;
    @NotNull
    private final MutableLiveData<Unit> successSubscription = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<String> verification3ds = new MutableLiveData<>();

    @Inject
    public TProPaymentBottomSheetViewModel(@NotNull GetSubscriptionPaymentUseCase getSubscriptionPaymentUseCase2, @NotNull GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull GetSubscriptionWithB2BVoucherUseCase getSubscriptionWithB2BVoucherUseCase, @NotNull MultiPlanParams multiPlanParams2, @NotNull SubscriptionPaymentOTPUseCase subscriptionPaymentOTPUseCase2, @NotNull RemoteConfiguration remoteConfiguration) {
        boolean z11;
        String str;
        Intrinsics.checkNotNullParameter(getSubscriptionPaymentUseCase2, "getSubscriptionPaymentUseCase");
        Intrinsics.checkNotNullParameter(getActiveSubscriptionsUseCase2, "getActiveSubscriptionsUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        Intrinsics.checkNotNullParameter(getSubscriptionWithB2BVoucherUseCase, "subscriptionWithB2BVoucherUseCase");
        Intrinsics.checkNotNullParameter(multiPlanParams2, "multiPlanParams");
        Intrinsics.checkNotNullParameter(subscriptionPaymentOTPUseCase2, "subscriptionPaymentOTPUseCase");
        Intrinsics.checkNotNullParameter(remoteConfiguration, "remoteConfig");
        this.getSubscriptionPaymentUseCase = getSubscriptionPaymentUseCase2;
        this.getActiveSubscriptionsUseCase = getActiveSubscriptionsUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.subscriptionWithB2BVoucherUseCase = getSubscriptionWithB2BVoucherUseCase;
        this.multiPlanParams = multiPlanParams2;
        this.subscriptionPaymentOTPUseCase = subscriptionPaymentOTPUseCase2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.freeCoffeeText = StringUtils.empty(stringCompanionObject);
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.country = mutableLiveData;
        Map map = (Map) remoteConfiguration.getRemoteConfiguration(FreeCoffeeRemoteConfiguration.FREE_COFFEE_WELCOME_TEXTS, MapsKt__MapsKt.emptyMap(), new HashMap().getClass());
        if (configurationLocalRepository2.selectedLanguage() == Language.ENGLISH) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!map.isEmpty()) {
            if (z11) {
                str = (String) map.get("freeCoffeTextEnglish");
            } else {
                str = (String) map.get("freeCoffeTextLocal");
            }
            this.freeCoffeeText = str == null ? StringUtils.empty(stringCompanionObject) : str;
        }
        mutableLiveData.postValue(Integer.valueOf(configurationLocalRepository2.selectedCountry().getPhoneCodeISO3166()));
    }

    @NotNull
    public final MutableLiveData<Integer> getCountry() {
        return this.country;
    }

    @NotNull
    public final MutableLiveData<Unit> getFailedSubscription$com_talabat_feature_tpro_presentation_presentation() {
        return this.failedSubscription;
    }

    @NotNull
    public final String getFreeCoffeeText() {
        return this.freeCoffeeText;
    }

    @NotNull
    public final MutableLiveData<Unit> getOtpFailureSubscription$com_talabat_feature_tpro_presentation_presentation() {
        return this.otpFailureSubscription;
    }

    @NotNull
    public final MutableLiveData<SubscriptionOTPPaymentStatus> getOtpSuccessSubscription$com_talabat_feature_tpro_presentation_presentation() {
        return this.otpSuccessSubscription;
    }

    @NotNull
    public final MutableLiveData<Boolean> getSubscribedToB2b$com_talabat_feature_tpro_presentation_presentation() {
        return this.subscribedToB2b;
    }

    public final void getSubscriptionMultiPlan() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1(this, (Continuation<? super TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1>) null), 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<TProPlanDisplayModel> getSubscriptionMultiPlan$com_talabat_feature_tpro_presentation_presentation() {
        return this.subscriptionMultiPlan;
    }

    @NotNull
    public final MutableLiveData<Unit> getSubscriptionMultiPlanFailure$com_talabat_feature_tpro_presentation_presentation() {
        return this.subscriptionMultiPlanFailure;
    }

    @NotNull
    public final MutableLiveData<Unit> getSuccessSubscription$com_talabat_feature_tpro_presentation_presentation() {
        return this.successSubscription;
    }

    @NotNull
    public final MutableLiveData<String> getVerification3ds$com_talabat_feature_tpro_presentation_presentation() {
        return this.verification3ds;
    }

    public final void setFreeCoffeeText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.freeCoffeeText = str;
    }

    public final void subscribeInTpro(@NotNull String str, @Nullable WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProPaymentBottomSheetViewModel$subscribeInTpro$1(this, str, walletCardDisplayModel, (Continuation<? super TProPaymentBottomSheetViewModel$subscribeInTpro$1>) null), 3, (Object) null);
    }

    public final void subscribeToProOTP(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "cardTokenId");
        Intrinsics.checkNotNullParameter(str3, "orderId");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "deliveryFee");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProPaymentBottomSheetViewModel$subscribeToProOTP$1(this, str, str2, str5, str3, i11, (Continuation<? super TProPaymentBottomSheetViewModel$subscribeToProOTP$1>) null), 3, (Object) null);
    }

    public final void subscribeWithB2BVoucher(@NotNull String str, @NotNull TProPlanDisplayModel tProPlanDisplayModel, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.HEADER_VOUCHER);
        Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "tProMultiPlan");
        Intrinsics.checkNotNullParameter(str2, "cardTokenId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1(this, tProPlanDisplayModel, str, str2, (Continuation<? super TProPaymentBottomSheetViewModel$subscribeWithB2BVoucher$1$1>) null), 3, (Object) null);
    }

    @NotNull
    public final Job updateCustomerInfo() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProPaymentBottomSheetViewModel$updateCustomerInfo$1(this, (Continuation<? super TProPaymentBottomSheetViewModel$updateCustomerInfo$1>) null), 3, (Object) null);
    }
}
