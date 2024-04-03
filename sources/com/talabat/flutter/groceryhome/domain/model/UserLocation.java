package com.talabat.flutter.groceryhome.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/flutter/groceryhome/domain/model/UserLocation;", "", "countryId", "", "areaId", "latitude", "longitude", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaId", "()Ljava/lang/String;", "getCountryId", "getLatitude", "getLongitude", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserLocation {
    @NotNull
    private final String areaId;
    @NotNull
    private final String countryId;
    @NotNull
    private final String latitude;
    @NotNull
    private final String longitude;

    public UserLocation(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        Intrinsics.checkNotNullParameter(str2, "areaId");
        Intrinsics.checkNotNullParameter(str3, "latitude");
        Intrinsics.checkNotNullParameter(str4, "longitude");
        this.countryId = str;
        this.areaId = str2;
        this.latitude = str3;
        this.longitude = str4;
    }

    public static /* synthetic */ UserLocation copy$default(UserLocation userLocation, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = userLocation.countryId;
        }
        if ((i11 & 2) != 0) {
            str2 = userLocation.areaId;
        }
        if ((i11 & 4) != 0) {
            str3 = userLocation.latitude;
        }
        if ((i11 & 8) != 0) {
            str4 = userLocation.longitude;
        }
        return userLocation.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.countryId;
    }

    @NotNull
    public final String component2() {
        return this.areaId;
    }

    @NotNull
    public final String component3() {
        return this.latitude;
    }

    @NotNull
    public final String component4() {
        return this.longitude;
    }

    @NotNull
    public final UserLocation copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        Intrinsics.checkNotNullParameter(str2, "areaId");
        Intrinsics.checkNotNullParameter(str3, "latitude");
        Intrinsics.checkNotNullParameter(str4, "longitude");
        return new UserLocation(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLocation)) {
            return false;
        }
        UserLocation userLocation = (UserLocation) obj;
        return Intrinsics.areEqual((Object) this.countryId, (Object) userLocation.countryId) && Intrinsics.areEqual((Object) this.areaId, (Object) userLocation.areaId) && Intrinsics.areEqual((Object) this.latitude, (Object) userLocation.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) userLocation.longitude);
    }

    @NotNull
    public final String getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (((((this.countryId.hashCode() * 31) + this.areaId.hashCode()) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.countryId;
        String str2 = this.areaId;
        String str3 = this.latitude;
        String str4 = this.longitude;
        return "UserLocation(countryId=" + str + ", areaId=" + str2 + ", latitude=" + str3 + ", longitude=" + str4 + ")";
    }
}
