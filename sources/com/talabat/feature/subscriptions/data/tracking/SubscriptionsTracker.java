package com.talabat.feature.subscriptions.data.tracking;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.subscriptions.data.tracking.events.TProBenefitsPageLoaded;
import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOnBoardingFailureEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOnBoardingSuccessEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOnBoardingUnknownTypeEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOrderStatusDeliveryValueEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOrderStatusEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOrderStatusFlagsEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOrderStatusInvokeEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProOrderStatusSuccessEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProReactivateAttemptEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProReactivateLoadedEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProReactivateSuccessEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionAttempted;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionCancellationAborted;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionCancellationLoaded;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionCompleted;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionFailed;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionPlanClicked;
import com.talabat.feature.subscriptions.data.tracking.events.TProSubscriptionPlanLoaded;
import com.talabat.feature.subscriptions.data.tracking.events.TProUpgradeAttemptedEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProUpgradeCompletedEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProUpgradeLoadedEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProUpgradeStartedEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProUserSubscribedEvent;
import com.talabat.feature.subscriptions.data.tracking.events.TProVendorOrder;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.helpers.DateUtils;
import com.talabat.homescreen.network.UrlConstantsKt;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J0\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J0\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J \u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010 \u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010!\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u001f\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010%J\"\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001cH\u0016J)\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\n2\b\u0010/\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u00100J5\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u000e2\b\u00103\u001a\u0004\u0018\u00010\u00132\b\u00104\u001a\u0004\u0018\u00010\u00132\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u00106J5\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\u001c2\b\u00109\u001a\u0004\u0018\u00010\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010<Jg\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u000e2\b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010A\u001a\u0004\u0018\u00010\u000e2\b\u0010B\u001a\u0004\u0018\u00010\u000e2\b\u0010C\u001a\u0004\u0018\u00010\n2\b\u0010D\u001a\u0004\u0018\u00010\n2\b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010F\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010GJ)\u0010H\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010KJ \u0010L\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010M\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\u0013H\u0016J \u0010P\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010Q\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010R\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010S\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010T\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010U\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J \u0010V\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/SubscriptionsTracker;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "dateUtils", "Lcom/talabat/helpers/DateUtils;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/helpers/DateUtils;)V", "dateFormat", "", "benefitsPageLoaded", "", "isSubscribed", "", "getCurrentTime", "getUserId", "proVendorOrder", "orderPrice", "", "restaurant", "voucher", "discountAmount", "subscriptionCancellationAborted", "screenType", "screenName", "subscriptionPlan", "cancellationDay", "", "savingsAmount", "subscriptionCancellationLoaded", "tProAttempted", "tProCompleted", "tProFailed", "tProOnboardingApiFailure", "error", "responseCode", "(Ljava/lang/String;Ljava/lang/Integer;)V", "tProOnboardingApiSuccess", "cardsCount", "headerType", "plansCount", "tProOnboardingUnknownCardTypeFetched", "count", "tProOrderStatus", "dataPointName", "tproMov", "setFreeDelivery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "tProOrderStatusDeliveryValue", "hasDeliveryValue", "cartDeliveryCharges", "cartCalculatedDeliveryCharges", "restaurantDeliveryCharges", "(Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "tProOrderStatusFlags", "shopType", "isTmartFlag", "isNFVFlag", "isFlagEnabledForVendor", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "tProOrderStatusInvoke", "isUserPro", "isSubscribeAtCheckout", "subscriptionId", "isFreeDeliveryEligibleVendor", "isVendorPro", "vendorId", "branchId", "branchName", "isPickUp", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "tProOrderStatusSuccess", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "shouldUpdateCart", "(Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;Ljava/lang/Boolean;)V", "tProPlanClicked", "tProPlanLoaded", "tProSubscribe", "subscriptionAmount", "tProSubscriptionReactivateAttempt", "tProSubscriptionReactivateLoaded", "tProSubscriptionReactivateSuccess", "tProSubscriptionUpgradeAttempted", "tProSubscriptionUpgradeCompleted", "tProSubscriptionUpgradeLoaded", "tProSubscriptionUpgradeStarted", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsTracker implements ISubscriptionsTracker {
    @NotNull
    private final String dateFormat = "dd-MM-yyyy hh:mm";
    @NotNull
    private final DateUtils dateUtils;
    @NotNull
    private final IntegrationGlobalDataModel.Companion globalDataModel;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public SubscriptionsTracker(@NotNull TalabatTracker talabatTracker2, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull DateUtils dateUtils2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        Intrinsics.checkNotNullParameter(dateUtils2, "dateUtils");
        this.talabatTracker = talabatTracker2;
        this.globalDataModel = companion;
        this.dateUtils = dateUtils2;
    }

    private final String getCurrentTime() {
        return this.dateUtils.getStringFromDate(new Date(this.dateUtils.currentTimeInMillis()), this.dateFormat);
    }

    private final String getUserId() {
        return this.globalDataModel.customerID();
    }

    public void benefitsPageLoaded(boolean z11) {
        this.talabatTracker.track(new TProBenefitsPageLoaded(getUserId(), z11));
    }

    public void proVendorOrder(float f11, @NotNull String str, @NotNull String str2, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "restaurant");
        Intrinsics.checkNotNullParameter(str2, UrlConstantsKt.HEADER_VOUCHER);
        this.talabatTracker.track(new TProVendorOrder(getUserId(), f11, str, str2, f12, z11));
    }

    public void subscriptionCancellationAborted(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionCancellationAborted(getUserId(), str, str2, str3, i11, f11));
    }

    public void subscriptionCancellationLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionCancellationLoaded(getUserId(), str, str2, str3, i11, f11));
    }

    public void tProAttempted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionAttempted(str, str2, str3));
    }

    public void tProCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionCompleted(str, str2, str3));
    }

    public void tProFailed(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionFailed(str, str2, str3));
    }

    public void tProOnboardingApiFailure(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.talabatTracker.track(new TProOnBoardingFailureEvent(str, num, getUserId()));
    }

    public void tProOnboardingApiSuccess(int i11, @Nullable String str, int i12) {
        this.talabatTracker.track(new TProOnBoardingSuccessEvent(i11, str, i12, getUserId()));
    }

    public void tProOnboardingUnknownCardTypeFetched(int i11) {
        this.talabatTracker.track(new TProOnBoardingUnknownTypeEvent(i11, getUserId()));
    }

    public void tProOrderStatus(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "dataPointName");
        this.talabatTracker.track(new TProOrderStatusEvent(str, str2, bool));
    }

    public void tProOrderStatusDeliveryValue(@Nullable Boolean bool, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13) {
        this.talabatTracker.track(new TProOrderStatusDeliveryValueEvent(bool, f11, f12, f13));
    }

    public void tProOrderStatusFlags(@Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        this.talabatTracker.track(new TProOrderStatusFlagsEvent(num, bool, bool2, bool3));
    }

    public void tProOrderStatusInvoke(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool5) {
        this.talabatTracker.track(new TProOrderStatusInvokeEvent(bool, bool2, str, bool3, bool4, str2, str3, str4, bool5));
    }

    public void tProOrderStatusSuccess(@Nullable String str, @NotNull TProOrderStatus tProOrderStatus, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(tProOrderStatus, "tProOrderStatus");
        this.talabatTracker.track(new TProOrderStatusSuccessEvent(tProOrderStatus, str, bool));
    }

    public void tProPlanClicked(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionPlanClicked(str, str2, str3));
    }

    public void tProPlanLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProSubscriptionPlanLoaded(str, str2, str3));
    }

    public void tProSubscribe(float f11) {
        this.talabatTracker.track(new TProUserSubscribedEvent(getUserId(), getCurrentTime(), f11));
    }

    public void tProSubscriptionReactivateAttempt(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProReactivateAttemptEvent(str, str2, str3));
    }

    public void tProSubscriptionReactivateLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProReactivateLoadedEvent(str, str2, str3));
    }

    public void tProSubscriptionReactivateSuccess(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProReactivateSuccessEvent(str, str2, str3));
    }

    public void tProSubscriptionUpgradeAttempted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProUpgradeAttemptedEvent(str, str2, str3));
    }

    public void tProSubscriptionUpgradeCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProUpgradeCompletedEvent(str, str2, str3));
    }

    public void tProSubscriptionUpgradeLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProUpgradeLoadedEvent(str, str2, str3));
    }

    public void tProSubscriptionUpgradeStarted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.talabatTracker.track(new TProUpgradeStartedEvent(str, str2, str3));
    }
}
