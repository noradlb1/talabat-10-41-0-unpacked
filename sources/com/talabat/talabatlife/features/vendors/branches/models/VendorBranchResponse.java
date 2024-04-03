package com.talabat.talabatlife.features.vendors.branches.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchResponse;", "", "()V", "area", "", "getArea", "()Ljava/lang/String;", "city", "getCity", "distanceInMeters", "", "getDistanceInMeters", "()Ljava/lang/Double;", "Ljava/lang/Double;", "id", "", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "latitude", "getLatitude", "longitude", "getLongitude", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorBranchResponse {
    @SerializedName("area")
    @Nullable
    private final String area;
    @SerializedName("city")
    @Nullable
    private final String city;
    @SerializedName("distanceInMeters")
    @Nullable
    private final Double distanceInMeters;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f12053id;
    @SerializedName("latitude")
    @Nullable
    private final Double latitude;
    @SerializedName("longitude")
    @Nullable
    private final Double longitude;

    @Nullable
    public final String getArea() {
        return this.area;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final Double getDistanceInMeters() {
        return this.distanceInMeters;
    }

    @Nullable
    public final Integer getId() {
        return this.f12053id;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }
}
