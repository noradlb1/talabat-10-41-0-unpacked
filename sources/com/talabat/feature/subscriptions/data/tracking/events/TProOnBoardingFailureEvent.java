package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOnBoardingFailureEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "errorMessage", "", "responseCode", "", "userId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "getResponseCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserId", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingFailureEvent extends TProEvent {
    @NotNull
    private final String errorMessage;
    @Nullable
    private final Integer responseCode;
    @NotNull
    private final String userId;

    public TProOnBoardingFailureEvent(@NotNull String str, @Nullable Integer num, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(str2, "userId");
        this.errorMessage = str;
        this.responseCode = num;
        this.userId = str2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errorMessage", this.errorMessage), TuplesKt.to("responseCode", this.responseCode), TuplesKt.to("userId", this.userId));
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final Integer getResponseCode() {
        return this.responseCode;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro_onboarding_failure";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }
}
