package com.talabat.gem.domain.entities;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/talabat/gem/domain/entities/Location;", "Ljava/io/Serializable;", "latitude", "", "longitude", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/talabat/gem/domain/entities/Location;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Location implements Serializable {
    @Nullable
    private final Double latitude;
    @Nullable
    private final Double longitude;

    public Location() {
        this((Double) null, (Double) null, 3, (DefaultConstructorMarker) null);
    }

    public Location(@Nullable Double d11, @Nullable Double d12) {
        this.latitude = d11;
        this.longitude = d12;
    }

    public static /* synthetic */ Location copy$default(Location location, Double d11, Double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = location.latitude;
        }
        if ((i11 & 2) != 0) {
            d12 = location.longitude;
        }
        return location.copy(d11, d12);
    }

    @Nullable
    public final Double component1() {
        return this.latitude;
    }

    @Nullable
    public final Double component2() {
        return this.longitude;
    }

    @NotNull
    public final Location copy(@Nullable Double d11, @Nullable Double d12) {
        return new Location(d11, d12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return Intrinsics.areEqual((Object) this.latitude, (Object) location.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) location.longitude);
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        Double d11 = this.latitude;
        int i11 = 0;
        int hashCode = (d11 == null ? 0 : d11.hashCode()) * 31;
        Double d12 = this.longitude;
        if (d12 != null) {
            i11 = d12.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Double d11 = this.latitude;
        Double d12 = this.longitude;
        return "Location(latitude=" + d11 + ", longitude=" + d12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Location(Double d11, Double d12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : d11, (i11 & 2) != 0 ? null : d12);
    }
}
