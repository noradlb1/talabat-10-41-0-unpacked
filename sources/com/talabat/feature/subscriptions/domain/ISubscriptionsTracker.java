package com.talabat.feature.subscriptions.domain;

import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J\u001f\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\u0012H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0012H&J-\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010&J=\u0010'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010,J=\u0010-\u001a\u00020\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u00102Jy\u00103\u001a\u00020\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010=J-\u0010>\u001a\u00020\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010AJ \u0010B\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010C\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\bH&J \u0010F\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010G\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010H\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010I\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010J\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010K\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010L\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&¨\u0006M"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "", "benefitsPageLoaded", "", "isSubscribed", "", "proVendorOrder", "orderPrice", "", "restaurant", "", "voucher", "discountAmount", "subscriptionCancellationAborted", "screenType", "screenName", "subscriptionPlan", "cancellationDay", "", "savingsAmount", "subscriptionCancellationLoaded", "tProAttempted", "tProCompleted", "tProFailed", "tProOnboardingApiFailure", "error", "responseCode", "(Ljava/lang/String;Ljava/lang/Integer;)V", "tProOnboardingApiSuccess", "cardsCount", "headerType", "plansCount", "tProOnboardingUnknownCardTypeFetched", "count", "tProOrderStatus", "dataPointName", "tproMov", "setFreeDelivery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "tProOrderStatusDeliveryValue", "hasDeliveryValue", "cartDeliveryCharges", "cartCalculatedDeliveryCharges", "restaurantDeliveryCharges", "(Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "tProOrderStatusFlags", "shopType", "isTmartFlag", "isNFVFlag", "isFlagEnabledForVendor", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "tProOrderStatusInvoke", "isUserPro", "isSubscribeAtCheckout", "subscriptionId", "isFreeDeliveryEligibleVendor", "isVendorPro", "vendorId", "branchId", "branchName", "isPickUp", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "tProOrderStatusSuccess", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "shouldUpdateCart", "(Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;Ljava/lang/Boolean;)V", "tProPlanClicked", "tProPlanLoaded", "tProSubscribe", "subscriptionAmount", "tProSubscriptionReactivateAttempt", "tProSubscriptionReactivateLoaded", "tProSubscriptionReactivateSuccess", "tProSubscriptionUpgradeAttempted", "tProSubscriptionUpgradeCompleted", "tProSubscriptionUpgradeLoaded", "tProSubscriptionUpgradeStarted", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISubscriptionsTracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void tProOrderStatus$default(ISubscriptionsTracker iSubscriptionsTracker, String str, String str2, Boolean bool, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    str2 = null;
                }
                if ((i11 & 4) != 0) {
                    bool = null;
                }
                iSubscriptionsTracker.tProOrderStatus(str, str2, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tProOrderStatus");
        }

        public static /* synthetic */ void tProOrderStatusDeliveryValue$default(ISubscriptionsTracker iSubscriptionsTracker, Boolean bool, Float f11, Float f12, Float f13, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    bool = null;
                }
                if ((i11 & 2) != 0) {
                    f11 = null;
                }
                if ((i11 & 4) != 0) {
                    f12 = null;
                }
                if ((i11 & 8) != 0) {
                    f13 = null;
                }
                iSubscriptionsTracker.tProOrderStatusDeliveryValue(bool, f11, f12, f13);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tProOrderStatusDeliveryValue");
        }

        public static /* synthetic */ void tProOrderStatusFlags$default(ISubscriptionsTracker iSubscriptionsTracker, Integer num, Boolean bool, Boolean bool2, Boolean bool3, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    num = null;
                }
                if ((i11 & 2) != 0) {
                    bool = null;
                }
                if ((i11 & 4) != 0) {
                    bool2 = null;
                }
                if ((i11 & 8) != 0) {
                    bool3 = null;
                }
                iSubscriptionsTracker.tProOrderStatusFlags(num, bool, bool2, bool3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tProOrderStatusFlags");
        }

        public static /* synthetic */ void tProOrderStatusInvoke$default(ISubscriptionsTracker iSubscriptionsTracker, Boolean bool, Boolean bool2, String str, Boolean bool3, Boolean bool4, String str2, String str3, String str4, Boolean bool5, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    bool = null;
                }
                if ((i11 & 2) != 0) {
                    bool2 = null;
                }
                if ((i11 & 4) != 0) {
                    str = null;
                }
                if ((i11 & 8) != 0) {
                    bool3 = null;
                }
                if ((i11 & 16) != 0) {
                    bool4 = null;
                }
                if ((i11 & 32) != 0) {
                    str2 = null;
                }
                if ((i11 & 64) != 0) {
                    str3 = null;
                }
                if ((i11 & 128) != 0) {
                    str4 = null;
                }
                if ((i11 & 256) != 0) {
                    bool5 = null;
                }
                iSubscriptionsTracker.tProOrderStatusInvoke(bool, bool2, str, bool3, bool4, str2, str3, str4, bool5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tProOrderStatusInvoke");
        }

        public static /* synthetic */ void tProOrderStatusSuccess$default(ISubscriptionsTracker iSubscriptionsTracker, String str, TProOrderStatus tProOrderStatus, Boolean bool, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = null;
                }
                if ((i11 & 4) != 0) {
                    bool = null;
                }
                iSubscriptionsTracker.tProOrderStatusSuccess(str, tProOrderStatus, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tProOrderStatusSuccess");
        }
    }

    void benefitsPageLoaded(boolean z11);

    void proVendorOrder(float f11, @NotNull String str, @NotNull String str2, float f12, boolean z11);

    void subscriptionCancellationAborted(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11);

    void subscriptionCancellationLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11);

    void tProAttempted(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProFailed(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProOnboardingApiFailure(@NotNull String str, @Nullable Integer num);

    void tProOnboardingApiSuccess(int i11, @Nullable String str, int i12);

    void tProOnboardingUnknownCardTypeFetched(int i11);

    void tProOrderStatus(@NotNull String str, @Nullable String str2, @Nullable Boolean bool);

    void tProOrderStatusDeliveryValue(@Nullable Boolean bool, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13);

    void tProOrderStatusFlags(@Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3);

    void tProOrderStatusInvoke(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool5);

    void tProOrderStatusSuccess(@Nullable String str, @NotNull TProOrderStatus tProOrderStatus, @Nullable Boolean bool);

    void tProPlanClicked(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProPlanLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscribe(float f11);

    void tProSubscriptionReactivateAttempt(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscriptionReactivateLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscriptionReactivateSuccess(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscriptionUpgradeAttempted(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscriptionUpgradeCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscriptionUpgradeLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void tProSubscriptionUpgradeStarted(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
