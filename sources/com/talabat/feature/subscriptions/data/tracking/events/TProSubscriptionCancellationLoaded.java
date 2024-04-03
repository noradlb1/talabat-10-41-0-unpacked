package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001cH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProSubscriptionCancellationLoaded;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "userId", "", "screenType", "screenName", "subscriptionPlan", "cancellationDay", "", "savingsAmount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IF)V", "getCancellationDay", "()I", "getSavingsAmount", "()F", "getScreenName", "()Ljava/lang/String;", "getScreenType", "getSubscriptionPlan", "getUserId", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProSubscriptionCancellationLoaded extends TProEvent {
    private final int cancellationDay;
    private final float savingsAmount;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String subscriptionPlan;
    @NotNull
    private final String userId;

    public TProSubscriptionCancellationLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, float f11) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        Intrinsics.checkNotNullParameter(str4, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.userId = str;
        this.screenType = str2;
        this.screenName = str3;
        this.subscriptionPlan = str4;
        this.cancellationDay = i11;
        this.savingsAmount = f11;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        String str = this.subscriptionPlan;
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("user_id", this.userId), TuplesKt.to("screen_type", this.screenType), TuplesKt.to("screen_name", this.screenName), TuplesKt.to(TProEvent.ATTR_SUBSCRIPTION_PLAN, this.subscriptionPlan), TuplesKt.to("userPreferences", "subscribed:" + str), TuplesKt.to(TProEvent.ATTR_CANCELLATION_DAY, Integer.valueOf(this.cancellationDay)), TuplesKt.to(TProEvent.ATTR_SAVINGS_AMOUNT, Float.valueOf(this.savingsAmount)));
    }

    public final int getCancellationDay() {
        return this.cancellationDay;
    }

    public final float getSavingsAmount() {
        return this.savingsAmount;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final String getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return TProEvent.NAME_SUBSCRIPTION_CANCELLATION_LOADED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
