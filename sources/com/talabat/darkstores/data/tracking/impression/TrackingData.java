package com.talabat.darkstores.data.tracking.impression;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/tracking/impression/TrackingData;", "", "screenName", "", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getScreenName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingData {
    @Nullable
    private final String eventOrigin;
    @NotNull
    private final String screenName;

    public TrackingData(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.screenName = str;
        this.eventOrigin = str2;
    }

    public static /* synthetic */ TrackingData copy$default(TrackingData trackingData, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = trackingData.screenName;
        }
        if ((i11 & 2) != 0) {
            str2 = trackingData.eventOrigin;
        }
        return trackingData.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.screenName;
    }

    @Nullable
    public final String component2() {
        return this.eventOrigin;
    }

    @NotNull
    public final TrackingData copy(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        return new TrackingData(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackingData)) {
            return false;
        }
        TrackingData trackingData = (TrackingData) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) trackingData.screenName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) trackingData.eventOrigin);
    }

    @Nullable
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    public int hashCode() {
        int hashCode = this.screenName.hashCode() * 31;
        String str = this.eventOrigin;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        String str2 = this.eventOrigin;
        return "TrackingData(screenName=" + str + ", eventOrigin=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackingData(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2);
    }
}
