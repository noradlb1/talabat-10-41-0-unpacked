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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020!0%H\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006&"}, d2 = {"Lcom/talabat/feature/ridertips/data/tracking/events/RiderTipClicked;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "riderTipValue", "", "shopType", "", "screenName", "shopId", "", "tipClickOrigin", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getRiderTipValue", "()Ljava/lang/Double;", "setRiderTipValue", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getScreenName", "()Ljava/lang/String;", "setScreenName", "(Ljava/lang/String;)V", "getShopId", "()Ljava/lang/Integer;", "setShopId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShopType", "setShopType", "getTipClickOrigin", "setTipClickOrigin", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipClicked extends TalabatEvent {
    @Nullable
    private Double riderTipValue;
    @Nullable
    private String screenName;
    @Nullable
    private Integer shopId;
    @Nullable
    private String shopType;
    @Nullable
    private String tipClickOrigin;

    public RiderTipClicked(@Nullable Double d11, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3) {
        this.riderTipValue = d11;
        this.shopType = str;
        this.screenName = str2;
        this.shopId = num;
        this.tipClickOrigin = str3;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("riderTipValue", this.riderTipValue), TuplesKt.to("screenName", this.screenName), TuplesKt.to("shopId", this.shopId), TuplesKt.to("shopType", this.shopType), TuplesKt.to("tipClickOrigin", this.tipClickOrigin));
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

    @Nullable
    public final String getTipClickOrigin() {
        return this.tipClickOrigin;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "rider_tip_clicked";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public final void setRiderTipValue(@Nullable Double d11) {
        this.riderTipValue = d11;
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

    public final void setTipClickOrigin(@Nullable String str) {
        this.tipClickOrigin = str;
    }
}
