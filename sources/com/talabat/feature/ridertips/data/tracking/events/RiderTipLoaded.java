package com.talabat.feature.ridertips.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010¨\u0006!"}, d2 = {"Lcom/talabat/feature/ridertips/data/tracking/events/RiderTipLoaded;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "riderTipValue", "", "shopType", "", "screenName", "shopId", "", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getRiderTipValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getScreenName", "()Ljava/lang/String;", "setScreenName", "(Ljava/lang/String;)V", "getShopId", "()Ljava/lang/Integer;", "setShopId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShopType", "setShopType", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipLoaded extends TalabatEvent {
    @Nullable
    private final Double riderTipValue;
    @Nullable
    private String screenName;
    @Nullable
    private Integer shopId;
    @Nullable
    private String shopType;

    public RiderTipLoaded(@Nullable Double d11, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.riderTipValue = d11;
        this.shopType = str;
        this.screenName = str2;
        this.shopId = num;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("riderTipValue", this.riderTipValue), TuplesKt.to("screenName", this.screenName), TuplesKt.to("shopId", this.shopId), TuplesKt.to("shopType", this.shopType));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "riderTip";
    }

    @Nullable
    public final Double getRiderTipValue() {
        return this.riderTipValue;
    }

    @Nullable
    public final String getScreenName() {
        return this.screenName;
    }

    @Nullable
    public final Integer getShopId() {
        return this.shopId;
    }

    @Nullable
    public final String getShopType() {
        return this.shopType;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rider_tip_loaded";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public final void setScreenName(@Nullable String str) {
        this.screenName = str;
    }

    public final void setShopId(@Nullable Integer num) {
        this.shopId = num;
    }

    public final void setShopType(@Nullable String str) {
        this.shopType = str;
    }
}
