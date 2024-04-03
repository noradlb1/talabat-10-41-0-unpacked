package com.talabat.feature.darkstores.swimlanes.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesTrackingResponse;", "", "trackingId", "", "(Ljava/lang/String;)V", "getTrackingId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesTrackingResponse {
    @Nullable
    private final String trackingId;

    public SwimlanesTrackingResponse() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public SwimlanesTrackingResponse(@Nullable @Json(name = "tracking_id") String str) {
        this.trackingId = str;
    }

    public static /* synthetic */ SwimlanesTrackingResponse copy$default(SwimlanesTrackingResponse swimlanesTrackingResponse, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlanesTrackingResponse.trackingId;
        }
        return swimlanesTrackingResponse.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.trackingId;
    }

    @NotNull
    public final SwimlanesTrackingResponse copy(@Nullable @Json(name = "tracking_id") String str) {
        return new SwimlanesTrackingResponse(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwimlanesTrackingResponse) && Intrinsics.areEqual((Object) this.trackingId, (Object) ((SwimlanesTrackingResponse) obj).trackingId);
    }

    @Nullable
    public final String getTrackingId() {
        return this.trackingId;
    }

    public int hashCode() {
        String str = this.trackingId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.trackingId;
        return "SwimlanesTrackingResponse(trackingId=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlanesTrackingResponse(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
