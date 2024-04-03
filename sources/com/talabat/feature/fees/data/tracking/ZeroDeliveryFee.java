package com.talabat.feature.fees.data.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/fees/data/tracking/ZeroDeliveryFee;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "(Ljava/lang/String;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "", "featureName", "hashCode", "", "name", "platforms", "", "toString", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ZeroDeliveryFee extends TalabatEvent {
    @NotNull
    private final String screenName;

    public ZeroDeliveryFee(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.screenName = str;
    }

    private final String component1() {
        return this.screenName;
    }

    public static /* synthetic */ ZeroDeliveryFee copy$default(ZeroDeliveryFee zeroDeliveryFee, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = zeroDeliveryFee.screenName;
        }
        return zeroDeliveryFee.copy(str);
    }

    @NotNull
    public Map<String, String> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", this.screenName), TuplesKt.to(FeeTrackingConstantsKt.ATTRIBUTE_ALERT_TYPE, "zero_delivery_fee"));
    }

    @NotNull
    public final ZeroDeliveryFee copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        return new ZeroDeliveryFee(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZeroDeliveryFee) && Intrinsics.areEqual((Object) this.screenName, (Object) ((ZeroDeliveryFee) obj).screenName);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "fees";
    }

    public int hashCode() {
        return this.screenName.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_ALERT_SHOWN;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        return "ZeroDeliveryFee(screenName=" + str + ")";
    }
}
