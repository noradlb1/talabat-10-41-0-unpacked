package com.talabat.darkstores.data.tracking.fees.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/FeeInfoClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "screenName", "disclaimerType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisclaimerType", "()Ljava/lang/String;", "getScreenName", "getVendorId", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeInfoClickedEvent extends TalabatEvent {
    @Nullable
    private final String disclaimerType;
    @Nullable
    private final String screenName;
    @Nullable
    private final String vendorId;

    public FeeInfoClickedEvent(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.vendorId = str;
        this.screenName = str2;
        this.disclaimerType = str3;
    }

    public static /* synthetic */ FeeInfoClickedEvent copy$default(FeeInfoClickedEvent feeInfoClickedEvent, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = feeInfoClickedEvent.vendorId;
        }
        if ((i11 & 2) != 0) {
            str2 = feeInfoClickedEvent.screenName;
        }
        if ((i11 & 4) != 0) {
            str3 = feeInfoClickedEvent.disclaimerType;
        }
        return feeInfoClickedEvent.copy(str, str2, str3);
    }

    @NotNull
    public Map<String, String> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.toMap(FeeTrackingUtilsKt.getFeeInfoTrackingData(this.vendorId, this.screenName, this.disclaimerType));
    }

    @Nullable
    public final String component1() {
        return this.vendorId;
    }

    @Nullable
    public final String component2() {
        return this.screenName;
    }

    @Nullable
    public final String component3() {
        return this.disclaimerType;
    }

    @NotNull
    public final FeeInfoClickedEvent copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new FeeInfoClickedEvent(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeeInfoClickedEvent)) {
            return false;
        }
        FeeInfoClickedEvent feeInfoClickedEvent = (FeeInfoClickedEvent) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) feeInfoClickedEvent.vendorId) && Intrinsics.areEqual((Object) this.screenName, (Object) feeInfoClickedEvent.screenName) && Intrinsics.areEqual((Object) this.disclaimerType, (Object) feeInfoClickedEvent.disclaimerType);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @Nullable
    public final String getDisclaimerType() {
        return this.disclaimerType;
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
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.disclaimerType;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
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
        String str3 = this.disclaimerType;
        return "FeeInfoClickedEvent(vendorId=" + str + ", screenName=" + str2 + ", disclaimerType=" + str3 + ")";
    }
}
