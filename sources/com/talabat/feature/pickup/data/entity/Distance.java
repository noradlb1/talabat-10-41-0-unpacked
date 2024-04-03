package com.talabat.feature.pickup.data.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/pickup/data/entity/Distance;", "", "distanceInKM", "", "(D)V", "getDistanceInKM", "()D", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Distance {
    @SerializedName("straightline_in_km")
    private final double distanceInKM;

    public Distance(double d11) {
        this.distanceInKM = d11;
    }

    public static /* synthetic */ Distance copy$default(Distance distance, double d11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = distance.distanceInKM;
        }
        return distance.copy(d11);
    }

    public final double component1() {
        return this.distanceInKM;
    }

    @NotNull
    public final Distance copy(double d11) {
        return new Distance(d11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Distance) && Intrinsics.areEqual((Object) Double.valueOf(this.distanceInKM), (Object) Double.valueOf(((Distance) obj).distanceInKM));
    }

    public final double getDistanceInKM() {
        return this.distanceInKM;
    }

    public int hashCode() {
        return Double.doubleToLongBits(this.distanceInKM);
    }

    @NotNull
    public String toString() {
        double d11 = this.distanceInKM;
        return "Distance(distanceInKM=" + d11 + ")";
    }
}
