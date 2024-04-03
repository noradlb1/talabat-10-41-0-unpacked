package com.talabat.darkstores.data;

import com.visa.checkout.PurchaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/TrackingInfo;", "", "requestId", "", "trackingId", "(Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getTrackingId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingInfo {
    @NotNull
    private final String requestId;
    @NotNull
    private final String trackingId;

    public TrackingInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(str2, "trackingId");
        this.requestId = str;
        this.trackingId = str2;
    }

    public static /* synthetic */ TrackingInfo copy$default(TrackingInfo trackingInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = trackingInfo.requestId;
        }
        if ((i11 & 2) != 0) {
            str2 = trackingInfo.trackingId;
        }
        return trackingInfo.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    @NotNull
    public final String component2() {
        return this.trackingId;
    }

    @NotNull
    public final TrackingInfo copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(str2, "trackingId");
        return new TrackingInfo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackingInfo)) {
            return false;
        }
        TrackingInfo trackingInfo = (TrackingInfo) obj;
        return Intrinsics.areEqual((Object) this.requestId, (Object) trackingInfo.requestId) && Intrinsics.areEqual((Object) this.trackingId, (Object) trackingInfo.trackingId);
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getTrackingId() {
        return this.trackingId;
    }

    public int hashCode() {
        return (this.requestId.hashCode() * 31) + this.trackingId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.requestId;
        String str2 = this.trackingId;
        return "TrackingInfo(requestId=" + str + ", trackingId=" + str2 + ")";
    }
}
