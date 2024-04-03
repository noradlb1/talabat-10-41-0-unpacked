package library.talabat.mvp.addressV2;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.configuration.country.Country;
import com.talabat.domain.location.GeoCoordinate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Llibrary/talabat/mvp/addressV2/UserLocationAddress;", "", "cityId", "", "areaId", "country", "Lcom/talabat/configuration/country/Country;", "latLng", "Lcom/talabat/domain/location/GeoCoordinate;", "(IILcom/talabat/configuration/country/Country;Lcom/talabat/domain/location/GeoCoordinate;)V", "getAreaId", "()I", "getCityId", "getCountry", "()Lcom/talabat/configuration/country/Country;", "getLatLng", "()Lcom/talabat/domain/location/GeoCoordinate;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserLocationAddress {
    private final int areaId;
    private final int cityId;
    @NotNull
    private final Country country;
    @NotNull
    private final GeoCoordinate latLng;

    public UserLocationAddress(int i11, int i12, @NotNull Country country2, @NotNull GeoCoordinate geoCoordinate) {
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        this.cityId = i11;
        this.areaId = i12;
        this.country = country2;
        this.latLng = geoCoordinate;
    }

    public static /* synthetic */ UserLocationAddress copy$default(UserLocationAddress userLocationAddress, int i11, int i12, Country country2, GeoCoordinate geoCoordinate, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = userLocationAddress.cityId;
        }
        if ((i13 & 2) != 0) {
            i12 = userLocationAddress.areaId;
        }
        if ((i13 & 4) != 0) {
            country2 = userLocationAddress.country;
        }
        if ((i13 & 8) != 0) {
            geoCoordinate = userLocationAddress.latLng;
        }
        return userLocationAddress.copy(i11, i12, country2, geoCoordinate);
    }

    public final int component1() {
        return this.cityId;
    }

    public final int component2() {
        return this.areaId;
    }

    @NotNull
    public final Country component3() {
        return this.country;
    }

    @NotNull
    public final GeoCoordinate component4() {
        return this.latLng;
    }

    @NotNull
    public final UserLocationAddress copy(int i11, int i12, @NotNull Country country2, @NotNull GeoCoordinate geoCoordinate) {
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        return new UserLocationAddress(i11, i12, country2, geoCoordinate);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLocationAddress)) {
            return false;
        }
        UserLocationAddress userLocationAddress = (UserLocationAddress) obj;
        return this.cityId == userLocationAddress.cityId && this.areaId == userLocationAddress.areaId && this.country == userLocationAddress.country && Intrinsics.areEqual((Object) this.latLng, (Object) userLocationAddress.latLng);
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getCityId() {
        return this.cityId;
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    @NotNull
    public final GeoCoordinate getLatLng() {
        return this.latLng;
    }

    public int hashCode() {
        return (((((this.cityId * 31) + this.areaId) * 31) + this.country.hashCode()) * 31) + this.latLng.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.cityId;
        int i12 = this.areaId;
        Country country2 = this.country;
        GeoCoordinate geoCoordinate = this.latLng;
        return "UserLocationAddress(cityId=" + i11 + ", areaId=" + i12 + ", country=" + country2 + ", latLng=" + geoCoordinate + ")";
    }
}
