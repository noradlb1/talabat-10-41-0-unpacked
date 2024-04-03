package com.talabat.feature.subscriptions.domain;

import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006JA\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010JA\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001c2\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J9\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010)JA\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010/JA\u00100\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010/J)\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u00104J)\u00105\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u00104J)\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u00109J)\u0010:\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u00104\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "", "cancelFreeTrial", "", "membershipId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTProOnBoardingBannerAndPlans", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "countryId", "", "duration", "freeCoffee", "", "voucherCode", "requestingPage", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "getProCentralizationStatusForCountry", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProVendorMov", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "branchId", "getSavingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "getSubscriptionCancellationReasons", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionDetails", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "getSubscriptionsForCountry", "payForSubscriptionOTP", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "planId", "paymentMethod", "cardTokenId", "deliveryFee", "orderId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "card4Digits", "cardType", "cardExpiryDate", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlanWithErrorHandling", "sendCancellationFeedback", "reasonId", "other", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeWithB2BVoucher", "updateAutoRenew", "autoRenewal", "isImmediateCancelDisable", "(Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upgradeSubscriptionPlan", "currentPlanId", "upgradeablePlanId", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISubscriptionsRepository {
    @Nullable
    Object cancelFreeTrial(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object fetchTProOnBoardingBannerAndPlans(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super TProOnBoardingBannerAndPlanModel> continuation);

    @Nullable
    Object getMultiPlan(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super SubscriptionMultiPlan> continuation);

    @Nullable
    Object getProCentralizationStatusForCountry(int i11, @NotNull Continuation<? super ProCentralization> continuation);

    @Nullable
    Object getProVendorMov(int i11, @NotNull Continuation<? super ProVendorMov> continuation);

    @Nullable
    Object getSavingsInfo(int i11, @NotNull Continuation<? super SubscriptionSavingsInfo> continuation);

    @Nullable
    Object getSubscriptionCancellationReasons(@NotNull Continuation<? super List<SubscriptionCancellationReason>> continuation);

    @Nullable
    Object getSubscriptionDetails(@NotNull String str, @NotNull Continuation<? super Subscription> continuation);

    @Nullable
    Object getSubscriptionsForCountry(int i11, @NotNull Continuation<? super List<Subscription>> continuation);

    @Nullable
    Object payForSubscriptionOTP(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<? super SubscriptionOTPPaymentStatus> continuation);

    @Nullable
    Object payForSubscriptionPlan(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation);

    @Nullable
    Object payForSubscriptionPlanWithErrorHandling(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation);

    @Nullable
    Object sendCancellationFeedback(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object subscribeWithB2BVoucher(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super String> continuation);

    @Nullable
    Object updateAutoRenew(@NotNull String str, boolean z11, boolean z12, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object upgradeSubscriptionPlan(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation);
}
