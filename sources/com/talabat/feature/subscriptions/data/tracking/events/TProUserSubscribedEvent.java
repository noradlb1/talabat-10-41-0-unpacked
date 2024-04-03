package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AdjustTokens;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProUserSubscribedEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "userId", "", "date", "amount", "", "(Ljava/lang/String;Ljava/lang/String;F)V", "getAmount", "()F", "getDate", "()Ljava/lang/String;", "getUserId", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProUserSubscribedEvent extends TProEvent {
    private final float amount;
    @NotNull
    private final String date;
    @NotNull
    private final String userId;

    public TProUserSubscribedEvent(@NotNull String str, @NotNull String str2, float f11) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "date");
        this.userId = str;
        this.date = str2;
        this.amount = f11;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("user_id", this.userId), TuplesKt.to(TProEvent.ATTR_SUBSCRIPTION_AMOUNT, Float.valueOf(this.amount)), TuplesKt.to(TProEvent.ATTR_SUBSCRIPTION_DATE, this.date));
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        if (platformName != PlatformName.ADJUST) {
            return TProEvent.NAME_USER_SUBSCRIBED_EVENT;
        }
        String tProSubscribed = AdjustTokens.tProSubscribed();
        Intrinsics.checkNotNullExpressionValue(tProSubscribed, "{\n        AdjustTokens.tProSubscribed()\n    }");
        return tProSubscribed;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.BRAZE, PlatformName.ADJUST);
    }
}
