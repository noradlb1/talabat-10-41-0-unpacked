package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProUpgradeLoadedEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "screenType", "", "screenName", "subscriptionPlan", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "getScreenType", "getSubscriptionPlan", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "getUserPreferences", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProUpgradeLoadedEvent extends TProEvent {
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String subscriptionPlan;

    public TProUpgradeLoadedEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, TProEvent.ATTR_SUBSCRIPTION_PLAN);
        this.screenType = str;
        this.screenName = str2;
        this.subscriptionPlan = str3;
    }

    private final String getUserPreferences() {
        if (this.subscriptionPlan.length() == 0) {
            return "notsubscribed";
        }
        String str = this.subscriptionPlan;
        return "subscribed:" + str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screen_type", this.screenType), TuplesKt.to("screen_name", this.screenName), TuplesKt.to("userPreferences", getUserPreferences()));
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
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return TProEvent.NAME_UPGRADE_LOADED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
