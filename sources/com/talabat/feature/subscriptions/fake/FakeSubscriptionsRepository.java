package com.talabat.feature.subscriptions.fake;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.FreeTrialInfo;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import com.talabat.feature.subscriptions.fake.di.FakeSubscriptionsFeature;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJA\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014JA\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020#2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J9\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010,JA\u0010-\u001a\u00020.2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u00102JA\u00103\u001a\u00020.2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u00102J)\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u00107J)\u00108\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u00107J)\u00109\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010<J)\u0010=\u001a\u00020.2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u00107R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsRepository;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "repositoryThrowError", "", "savingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "(ZLcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;)V", "cancelFreeTrial", "", "membershipId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTProOnBoardingBannerAndPlans", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerAndPlanModel;", "countryId", "", "duration", "freeCoffee", "voucherCode", "requestingPage", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "getProCentralizationStatusForCountry", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProVendorMov", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "branchId", "getSavingsInfo", "getSubscriptionCancellationReasons", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionDetails", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "getSubscriptionsForCountry", "payForSubscriptionOTP", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "planId", "paymentMethod", "cardTokenId", "deliveryFee", "orderId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "card4Digits", "cardType", "cardExpiryDate", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlanWithErrorHandling", "sendCancellationFeedback", "reasonId", "other", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeWithB2BVoucher", "updateAutoRenew", "autoRenewal", "isImmediateCancelDisable", "(Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upgradeSubscriptionPlan", "currentPlanId", "upgradeablePlanId", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeSubscriptionsRepository implements ISubscriptionsRepository {
    private final boolean repositoryThrowError;
    @NotNull
    private final SubscriptionSavingsInfo savingsInfo;

    @Inject
    public FakeSubscriptionsRepository(@FakeSubscriptionsFeature(name = "repositoryThrowError") boolean z11, @NotNull @FakeSubscriptionsFeature(name = "savingsInfo") SubscriptionSavingsInfo subscriptionSavingsInfo) {
        Intrinsics.checkNotNullParameter(subscriptionSavingsInfo, "savingsInfo");
        this.repositoryThrowError = z11;
        this.savingsInfo = subscriptionSavingsInfo;
    }

    @Nullable
    public Object cancelFreeTrial(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Object fetchTProOnBoardingBannerAndPlans(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super TProOnBoardingBannerAndPlanModel> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Object getMultiPlan(int i11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super SubscriptionMultiPlan> continuation) {
        return new SubscriptionMultiPlan(false, (FreeTrialInfo) null, (List) null, (List) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    @Nullable
    public Object getProCentralizationStatusForCountry(int i11, @NotNull Continuation<? super ProCentralization> continuation) {
        return new ProCentralization((List) null, false, false, 7, (DefaultConstructorMarker) null);
    }

    @Nullable
    public Object getProVendorMov(int i11, @NotNull Continuation<? super ProVendorMov> continuation) {
        return new ProVendorMov((Float) null, 0, false, 7, (DefaultConstructorMarker) null);
    }

    @Nullable
    public Object getSavingsInfo(int i11, @NotNull Continuation<? super SubscriptionSavingsInfo> continuation) {
        if (!this.repositoryThrowError) {
            return this.savingsInfo;
        }
        throw new Throwable("error - getSavingsInfo");
    }

    @Nullable
    public Object getSubscriptionCancellationReasons(@NotNull Continuation<? super List<SubscriptionCancellationReason>> continuation) {
        return CollectionsKt__CollectionsKt.listOf(new SubscriptionCancellationReason("Title A", "1", 1), new SubscriptionCancellationReason("Title B", ExifInterface.GPS_MEASUREMENT_2D, 2), new SubscriptionCancellationReason("Title C", ExifInterface.GPS_MEASUREMENT_3D, 3), new SubscriptionCancellationReason("Title D", OnlineLocationService.SRC_DEFAULT, 4));
    }

    @Nullable
    public Object getSubscriptionDetails(@NotNull String str, @NotNull Continuation<? super Subscription> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Object getSubscriptionsForCountry(int i11, @NotNull Continuation<? super List<Subscription>> continuation) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Nullable
    public Object payForSubscriptionOTP(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<? super SubscriptionOTPPaymentStatus> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Object payForSubscriptionPlan(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation) {
        return new SubscriptionPaymentStatus((SubscriptionPaymentStatus.PaymentResult) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    @Nullable
    public Object payForSubscriptionPlanWithErrorHandling(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation) {
        return new SubscriptionPaymentStatus((SubscriptionPaymentStatus.PaymentResult) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    @Nullable
    public Object sendCancellationFeedback(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Nullable
    public Object subscribeWithB2BVoucher(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super String> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Object updateAutoRenew(@NotNull String str, boolean z11, boolean z12, @NotNull Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    @Nullable
    public Object upgradeSubscriptionPlan(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super SubscriptionPaymentStatus> continuation) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
