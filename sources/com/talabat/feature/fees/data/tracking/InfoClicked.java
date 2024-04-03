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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÂ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/fees/data/tracking/InfoClicked;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "disclaimerType", "", "screenName", "shopId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InfoClicked extends TalabatEvent {
    @NotNull
    private final String disclaimerType;
    @NotNull
    private final String screenName;
    private final int shopId;

    public InfoClicked(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE);
        Intrinsics.checkNotNullParameter(str2, "screenName");
        this.disclaimerType = str;
        this.screenName = str2;
        this.shopId = i11;
    }

    private final String component1() {
        return this.disclaimerType;
    }

    private final String component2() {
        return this.screenName;
    }

    private final int component3() {
        return this.shopId;
    }

    public static /* synthetic */ InfoClicked copy$default(InfoClicked infoClicked, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = infoClicked.disclaimerType;
        }
        if ((i12 & 2) != 0) {
            str2 = infoClicked.screenName;
        }
        if ((i12 & 4) != 0) {
            i11 = infoClicked.shopId;
        }
        return infoClicked.copy(str, str2, i11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to(FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE, this.disclaimerType), TuplesKt.to("screenName", this.screenName), TuplesKt.to("shopId", Integer.valueOf(this.shopId)));
    }

    @NotNull
    public final InfoClicked copy(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE);
        Intrinsics.checkNotNullParameter(str2, "screenName");
        return new InfoClicked(str, str2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoClicked)) {
            return false;
        }
        InfoClicked infoClicked = (InfoClicked) obj;
        return Intrinsics.areEqual((Object) this.disclaimerType, (Object) infoClicked.disclaimerType) && Intrinsics.areEqual((Object) this.screenName, (Object) infoClicked.screenName) && this.shopId == infoClicked.shopId;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "fees";
    }

    public int hashCode() {
        return (((this.disclaimerType.hashCode() * 31) + this.screenName.hashCode()) * 31) + this.shopId;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_DISCLAIMER_CLICKED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.disclaimerType;
        String str2 = this.screenName;
        int i11 = this.shopId;
        return "InfoClicked(disclaimerType=" + str + ", screenName=" + str2 + ", shopId=" + i11 + ")";
    }
}
