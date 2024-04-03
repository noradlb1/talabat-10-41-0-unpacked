package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.homescreen.network.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016J0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0013H\u0016J)\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010'J5\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010-J5\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00132\b\u00100\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u00103Jg\u00104\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u00010\u00062\b\u00107\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010\u00062\b\u00109\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u000b2\b\u0010;\u001a\u0004\u0018\u00010\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010>J)\u0010?\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010BJ \u0010C\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010D\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\tH\u0016J \u0010G\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010H\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010I\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010J\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010K\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010L\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J \u0010M\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¨\u0006N"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsTracker;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "()V", "benefitsPageLoaded", "", "isSubscribed", "", "proVendorOrder", "orderPrice", "", "restaurant", "", "voucher", "discountAmount", "subscriptionCancellationAborted", "screenType", "screenName", "subscriptionPlan", "cancellationDay", "", "savingsAmount", "subscriptionCancellationLoaded", "tProAttempted", "tProCompleted", "tProFailed", "tProOnboardingApiFailure", "error", "responseCode", "(Ljava/lang/String;Ljava/lang/Integer;)V", "tProOnboardingApiSuccess", "cardsCount", "headerType", "plansCount", "tProOnboardingUnknownCardTypeFetched", "count", "tProOrderStatus", "dataPointName", "tproMov", "setFreeDelivery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "tProOrderStatusDeliveryValue", "hasDeliveryValue", "cartDeliveryCharges", "cartCalculatedDeliveryCharges", "restaurantDeliveryCharges", "(Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "tProOrderStatusFlags", "shopType", "isTmartFlag", "isNFVFlag", "isFlagEnabledForVendor", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "tProOrderStatusInvoke", "isUserPro", "isSubscribeAtCheckout", "subscriptionId", "isFreeDeliveryEligibleVendor", "isVendorPro", "vendorId", "branchId", "branchName", "isPickUp", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "tProOrderStatusSuccess", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "shouldUpdateCart", "(Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;Ljava/lang/Boolean;)V", "tProPlanClicked", "tProPlanLoaded", "tProSubscribe", "subscriptionAmount", "tProSubscriptionReactivateAttempt", "tProSubscriptionReactivateLoaded", "tProSubscriptionReactivateSuccess", "tProSubscriptionUpgradeAttempted", "tProSubscriptionUpgradeCompleted", "tProSubscriptionUpgradeLoaded", "tProSubscriptionUpgradeStarted", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeSubscriptionsTracker implements ISubscriptionsTracker {
    public void benefitsPageLoaded(boolean z11) {
        System.out.println("FakeSubscriptionsTracker.benefitsPageLoaded()");
    }

    public void proVendorOrder(float f11, @NotNull String str, @NotNull String str2, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "restaurant");
        Intrinsics.checkNotNullParameter(str2, UrlConstantsKt.HEADER_VOUCHER);
        System.out.println("FakeSubscriptionsTracker.proVendorOrder()");
    }

    public void subscriptionCancellationAborted(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.subscriptionCancellationAborted()");
    }

    public void subscriptionCancellationLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.subscriptionCancellationLoaded()");
    }

    public void tProAttempted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProAttempted()");
    }

    public void tProCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProCompleted()");
    }

    public void tProFailed(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProFailed()");
    }

    public void tProOnboardingApiFailure(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "error");
        System.out.println("FakeSubscriptionsTracker.tProOnboardingApiFailure()");
    }

    public void tProOnboardingApiSuccess(int i11, @Nullable String str, int i12) {
        System.out.println("FakeSubscriptionsTracker.tProOnboardingApiSuccess()");
    }

    public void tProOnboardingUnknownCardTypeFetched(int i11) {
        System.out.println("FakeSubscriptionsTracker.tProOnboardingUnknownCardTypeFetched()");
    }

    public void tProOrderStatus(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "dataPointName");
        System.out.println("FakeSubscriptionsTracker.tProOrderStatus()");
    }

    public void tProOrderStatusDeliveryValue(@Nullable Boolean bool, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13) {
        System.out.println("FakeSubscriptionsTracker.tProOrderStatusDeliveryValue()");
    }

    public void tProOrderStatusFlags(@Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        System.out.println("FakeSubscriptionsTracker.tProOrderStatusFlags()");
    }

    public void tProOrderStatusInvoke(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool5) {
        System.out.println("FakeSubscriptionsTracker.tProOrderStatusInvoke()");
    }

    public void tProOrderStatusSuccess(@Nullable String str, @NotNull TProOrderStatus tProOrderStatus, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(tProOrderStatus, "tProOrderStatus");
        System.out.println("FakeSubscriptionsTracker.tProOrderStatusSuccess()");
    }

    public void tProPlanClicked(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProPlanClicked()");
    }

    public void tProPlanLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProPlanLoaded()");
    }

    public void tProSubscribe(float f11) {
        System.out.println("FakeSubscriptionsTracker.tProSubscribe()");
    }

    public void tProSubscriptionReactivateAttempt(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionReactivateSuccess()");
    }

    public void tProSubscriptionReactivateLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionReactivateLoaded()");
    }

    public void tProSubscriptionReactivateSuccess(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionReactivateSuccess()");
    }

    public void tProSubscriptionUpgradeAttempted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionUpgradeAttempted()");
    }

    public void tProSubscriptionUpgradeCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionUpgradeCompleted()");
    }

    public void tProSubscriptionUpgradeLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionUpgradeLoaded()");
    }

    public void tProSubscriptionUpgradeStarted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        System.out.println("FakeSubscriptionsTracker.tProSubscriptionUpgradeStarted()");
    }
}
