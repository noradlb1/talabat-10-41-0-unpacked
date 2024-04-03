package com.talabat.darkstores.data.tracking.fees.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/FeeInfoClickedExternalEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "screenName", "(Ljava/lang/String;Ljava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "getVendorId", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeInfoClickedExternalEvent extends TalabatEvent {
    @Nullable
    private final String screenName;
    @Nullable
    private final String vendorId;

    public FeeInfoClickedExternalEvent(@Nullable String str, @Nullable String str2) {
        this.vendorId = str;
        this.screenName = str2;
    }

    public static /* synthetic */ FeeInfoClickedExternalEvent copy$default(FeeInfoClickedExternalEvent feeInfoClickedExternalEvent, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = feeInfoClickedExternalEvent.vendorId;
        }
        if ((i11 & 2) != 0) {
            str2 = feeInfoClickedExternalEvent.screenName;
        }
        return feeInfoClickedExternalEvent.copy(str, str2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to(FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE, FeeTrackingConstantsKt.DISCLAIMER_GENERAL_FEES_EXTERNAL), TuplesKt.to("screenName", this.screenName), TuplesKt.to("shopId", this.vendorId));
    }

    @Nullable
    public final String component1() {
        return this.vendorId;
    }

    @Nullable
    public final String component2() {
        return this.screenName;
    }

    @NotNull
    public final FeeInfoClickedExternalEvent copy(@Nullable String str, @Nullable String str2) {
        return new FeeInfoClickedExternalEvent(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeeInfoClickedExternalEvent)) {
            return false;
        }
        FeeInfoClickedExternalEvent feeInfoClickedExternalEvent = (FeeInfoClickedExternalEvent) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) feeInfoClickedExternalEvent.vendorId) && Intrinsics.areEqual((Object) this.screenName, (Object) feeInfoClickedExternalEvent.screenName);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @Nullable
    public final String getScreenName() {
        return this.screenName;
    }

    @Nullable
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.vendorId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.screenName;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_DISCLAIMER_CLICKED;
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.screenName;
        return "FeeInfoClickedExternalEvent(vendorId=" + str + ", screenName=" + str2 + ")";
    }
}
