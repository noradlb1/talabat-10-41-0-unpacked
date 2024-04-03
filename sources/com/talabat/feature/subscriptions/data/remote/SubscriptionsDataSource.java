package com.talabat.feature.subscriptions.data.remote;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.feature.subscriptions.data.remote.ProApi;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsApi;
import com.talabat.feature.subscriptions.data.remote.model.CancellationFeedbackRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.ProVendorMovRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SendCancellationFeedbackRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionAutoRenewRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionDetailsRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRootResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlansRootResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.UpgradePlanRequestModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJA\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0011\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJA\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H@ø\u0001\u0000¢\u0006\u0002\u00107J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H@ø\u0001\u0000¢\u0006\u0002\u0010<J!\u0010=\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010>\u001a\u00020?H@ø\u0001\u0000¢\u0006\u0002\u0010@J!\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsDataSource;", "", "subscriptionApi", "Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsApi;", "proApi", "Lcom/talabat/feature/subscriptions/data/remote/ProApi;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "(Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsApi;Lcom/talabat/feature/subscriptions/data/remote/ProApi;Lcom/talabat/authentication/aaa/secrets/SecretProvider;)V", "cancelFreeTrial", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionsAutoRenewUpdateRootResponse;", "membershipId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiPlanWithHeroBanner", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlansRootResponseModel;", "country", "", "duration", "freeCoffee", "", "voucherCode", "requestingPage", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProCentralizationStatusForCountry", "Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationRootResponse;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProVendorMov", "Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovRootResponse;", "branchId", "getSavingsInfo", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionSavingsInfoRootResponse;", "getSubscriptionCancellationReasons", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionCancellationReasonsRootResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionDetails", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionDetailsRootResponse;", "getSubscriptionMultiPlan", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanRootResponse;", "getSubscriptionsForCountry", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionsRootResponse;", "payForSubscriptionPlan", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse;", "subscriptionPaymentRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRequestModel;", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlanOTP", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRootResponseModel;", "subscriptionPaymentOTPRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRequestModel;", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCancellationFeedback", "Lcom/talabat/feature/subscriptions/data/remote/model/SendCancellationFeedbackRootResponse;", "cancellationFeedbackRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/CancellationFeedbackRequestModel;", "(Lcom/talabat/feature/subscriptions/data/remote/model/CancellationFeedbackRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeWithB2BVoucher", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRootResponse;", "subscribeWithB2BVoucherRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRequestModel;", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAutoRenew", "subscriptionAutoRenewRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionAutoRenewRequestModel;", "(Ljava/lang/String;Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionAutoRenewRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upgradeSubscriptionPlan", "upgradePlanRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanRequestModel;", "(Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanRequestModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsDataSource {
    @NotNull
    private final ProApi proApi;
    @NotNull
    private final SecretProvider secretProvider;
    @NotNull
    private final SubscriptionsApi subscriptionApi;

    @Inject
    public SubscriptionsDataSource(@NotNull SubscriptionsApi subscriptionsApi, @NotNull ProApi proApi2, @NotNull SecretProvider secretProvider2) {
        Intrinsics.checkNotNullParameter(subscriptionsApi, "subscriptionApi");
        Intrinsics.checkNotNullParameter(proApi2, "proApi");
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        this.subscriptionApi = subscriptionsApi;
        this.proApi = proApi2;
        this.secretProvider = secretProvider2;
    }

    @Nullable
    public final Object cancelFreeTrial(@NotNull String str, @NotNull Continuation<? super SubscriptionsAutoRenewUpdateRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.cancelFreeTrial$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, str, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object getMultiPlanWithHeroBanner(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super TProOnBoardingBannerAndPlansRootResponseModel> continuation) {
        return ProApi.DefaultImpls.getMultiPlanWithHeroBanner$default(this.proApi, 0, this.secretProvider.getSubscriptionsKey(), str3, i11, str, bool, str2, continuation, 1, (Object) null);
    }

    @Nullable
    public final Object getProCentralizationStatusForCountry(int i11, @NotNull Continuation<? super ProCentralizationRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.getProCentralizationStatus$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, i11, this.secretProvider.getTproSubscriptionProductId(), continuation, 2, (Object) null);
    }

    @Nullable
    public final Object getProVendorMov(int i11, @NotNull Continuation<? super ProVendorMovRootResponse> continuation) {
        return ProApi.DefaultImpls.getProVendorMov$default(this.proApi, 0, i11, continuation, 1, (Object) null);
    }

    @Nullable
    public final Object getSavingsInfo(int i11, @NotNull Continuation<? super SubscriptionSavingsInfoRootResponse> continuation) {
        return ProApi.DefaultImpls.getSavingsInfo$default(this.proApi, this.secretProvider.getSubscriptionsKey(), 0, i11, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object getSubscriptionCancellationReasons(@NotNull Continuation<? super SubscriptionCancellationReasonsRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.getSubscriptionCancellationReasons$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object getSubscriptionDetails(@NotNull String str, @NotNull Continuation<? super SubscriptionDetailsRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.getSubscriptionDetails$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, str, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object getSubscriptionMultiPlan(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super SubscriptionMultiPlanRootResponse> continuation) {
        return ProApi.DefaultImpls.getSubscriptionMultiPlan$default(this.proApi, 0, this.secretProvider.getSubscriptionsKey(), str3, i11, str, bool, str2, continuation, 1, (Object) null);
    }

    @Nullable
    public final Object getSubscriptionsForCountry(int i11, @NotNull Continuation<? super SubscriptionsRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.getSubscriptionsForCountry$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, i11, this.secretProvider.getTproSubscriptionProductId(), continuation, 2, (Object) null);
    }

    @Nullable
    public final Object payForSubscriptionPlan(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel, @NotNull Continuation<? super SubscriptionPaymentRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.payForSubscriptionPlan$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, subscriptionPaymentRequestModel, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object payForSubscriptionPlanOTP(@NotNull SubscriptionPaymentOTPRequestModel subscriptionPaymentOTPRequestModel, @NotNull Continuation<? super SubscriptionPaymentOTPRootResponseModel> continuation) {
        return SubscriptionsApi.DefaultImpls.payForSubscriptionPlanOTP$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, subscriptionPaymentOTPRequestModel, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object sendCancellationFeedback(@NotNull CancellationFeedbackRequestModel cancellationFeedbackRequestModel, @NotNull Continuation<? super SendCancellationFeedbackRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.sendCancellationFeedback$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, cancellationFeedbackRequestModel, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object subscribeWithB2BVoucher(@NotNull SubscriptionB2BVoucherRequestModel subscriptionB2BVoucherRequestModel, @NotNull Continuation<? super SubscriptionB2BVoucherRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.subscribeWithB2BVoucher$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, subscriptionB2BVoucherRequestModel, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object updateAutoRenew(@NotNull String str, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, @NotNull Continuation<? super SubscriptionsAutoRenewUpdateRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.updateSubscriptionAutoRenewStatus$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, str, subscriptionAutoRenewRequestModel, continuation, 2, (Object) null);
    }

    @Nullable
    public final Object upgradeSubscriptionPlan(@NotNull UpgradePlanRequestModel upgradePlanRequestModel, @NotNull String str, @NotNull Continuation<? super SubscriptionPaymentRootResponse> continuation) {
        return SubscriptionsApi.DefaultImpls.upgradeSubscriptionPlan$default(this.subscriptionApi, this.secretProvider.getSubscriptionsKey(), 0, str, upgradePlanRequestModel, continuation, 2, (Object) null);
    }
}
