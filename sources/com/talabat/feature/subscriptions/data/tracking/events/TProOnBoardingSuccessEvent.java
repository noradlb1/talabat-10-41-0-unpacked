package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOnBoardingSuccessEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "cardsCount", "", "headerType", "", "plansCount", "userId", "(ILjava/lang/String;ILjava/lang/String;)V", "getCardsCount", "()I", "getHeaderType", "()Ljava/lang/String;", "getPlansCount", "getUserId", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingSuccessEvent extends TProEvent {
    private final int cardsCount;
    @Nullable
    private final String headerType;
    private final int plansCount;
    @NotNull
    private final String userId;

    public TProOnBoardingSuccessEvent(int i11, @Nullable String str, int i12, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "userId");
        this.cardsCount = i11;
        this.headerType = str;
        this.plansCount = i12;
        this.userId = str2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cardsCount", Integer.valueOf(this.cardsCount)), TuplesKt.to("headerType", this.headerType), TuplesKt.to("plansCount", Integer.valueOf(this.plansCount)), TuplesKt.to("userId", this.userId));
    }

    public final int getCardsCount() {
        return this.cardsCount;
    }

    @Nullable
    public final String getHeaderType() {
        return this.headerType;
    }

    public final int getPlansCount() {
        return this.plansCount;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro_onboarding_success";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }
}
