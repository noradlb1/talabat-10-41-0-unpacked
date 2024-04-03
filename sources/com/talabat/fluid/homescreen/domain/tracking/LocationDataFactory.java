package com.talabat.fluid.homescreen.domain.tracking;

import com.adyen.checkout.core.model.Address;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011BS\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "", "selectedCityProvider", "Lkotlin/Function0;", "", "selectedAreaProvider", "countryCodeProvider", "latLongProvider", "Lkotlin/Pair;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "createLocationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "address", "Lcom/talabat/domain/address/Address;", "getAddress", "selectedCustomerAddress", "LocationData", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationDataFactory {
    @NotNull
    private final Function0<String> countryCodeProvider;
    @NotNull
    private final Function0<Pair<Double, Double>> latLongProvider;
    @NotNull
    private final Function0<String> selectedAreaProvider;
    @NotNull
    private final Function0<String> selectedCityProvider;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "", "city", "", "area", "country", "latitude", "longitude", "address", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getArea", "getCity", "getCountry", "getLatitude", "getLongitude", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationData {
        @NotNull
        private final String address;
        @NotNull
        private final String area;
        @NotNull
        private final String city;
        @NotNull
        private final String country;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;

        public LocationData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkNotNullParameter(str, Address.KEY_CITY);
            Intrinsics.checkNotNullParameter(str2, "area");
            Intrinsics.checkNotNullParameter(str3, "country");
            Intrinsics.checkNotNullParameter(str4, "latitude");
            Intrinsics.checkNotNullParameter(str5, "longitude");
            Intrinsics.checkNotNullParameter(str6, "address");
            this.city = str;
            this.area = str2;
            this.country = str3;
            this.latitude = str4;
            this.longitude = str5;
            this.address = str6;
        }

        public static /* synthetic */ LocationData copy$default(LocationData locationData, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = locationData.city;
            }
            if ((i11 & 2) != 0) {
                str2 = locationData.area;
            }
            String str7 = str2;
            if ((i11 & 4) != 0) {
                str3 = locationData.country;
            }
            String str8 = str3;
            if ((i11 & 8) != 0) {
                str4 = locationData.latitude;
            }
            String str9 = str4;
            if ((i11 & 16) != 0) {
                str5 = locationData.longitude;
            }
            String str10 = str5;
            if ((i11 & 32) != 0) {
                str6 = locationData.address;
            }
            return locationData.copy(str, str7, str8, str9, str10, str6);
        }

        @NotNull
        public final String component1() {
            return this.city;
        }

        @NotNull
        public final String component2() {
            return this.area;
        }

        @NotNull
        public final String component3() {
            return this.country;
        }

        @NotNull
        public final String component4() {
            return this.latitude;
        }

        @NotNull
        public final String component5() {
            return this.longitude;
        }

        @NotNull
        public final String component6() {
            return this.address;
        }

        @NotNull
        public final LocationData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkNotNullParameter(str, Address.KEY_CITY);
            Intrinsics.checkNotNullParameter(str2, "area");
            Intrinsics.checkNotNullParameter(str3, "country");
            Intrinsics.checkNotNullParameter(str4, "latitude");
            Intrinsics.checkNotNullParameter(str5, "longitude");
            Intrinsics.checkNotNullParameter(str6, "address");
            return new LocationData(str, str2, str3, str4, str5, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationData)) {
                return false;
            }
            LocationData locationData = (LocationData) obj;
            return Intrinsics.areEqual((Object) this.city, (Object) locationData.city) && Intrinsics.areEqual((Object) this.area, (Object) locationData.area) && Intrinsics.areEqual((Object) this.country, (Object) locationData.country) && Intrinsics.areEqual((Object) this.latitude, (Object) locationData.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) locationData.longitude) && Intrinsics.areEqual((Object) this.address, (Object) locationData.address);
        }

        @NotNull
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        public final String getArea() {
            return this.area;
        }

        @NotNull
        public final String getCity() {
            return this.city;
        }

        @NotNull
        public final String getCountry() {
            return this.country;
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
            return (((((((((this.city.hashCode() * 31) + this.area.hashCode()) * 31) + this.country.hashCode()) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.address.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.city;
            String str2 = this.area;
            String str3 = this.country;
            String str4 = this.latitude;
            String str5 = this.longitude;
            String str6 = this.address;
            return "LocationData(city=" + str + ", area=" + str2 + ", country=" + str3 + ", latitude=" + str4 + ", longitude=" + str5 + ", address=" + str6 + ")";
        }
    }

    public LocationDataFactory() {
        this((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null);
    }

    public LocationDataFactory(@NotNull Function0<String> function0, @NotNull Function0<String> function02, @NotNull Function0<String> function03, @NotNull Function0<Pair<Double, Double>> function04) {
        Intrinsics.checkNotNullParameter(function0, "selectedCityProvider");
        Intrinsics.checkNotNullParameter(function02, "selectedAreaProvider");
        Intrinsics.checkNotNullParameter(function03, "countryCodeProvider");
        Intrinsics.checkNotNullParameter(function04, "latLongProvider");
        this.selectedCityProvider = function0;
        this.selectedAreaProvider = function02;
        this.countryCodeProvider = function03;
        this.latLongProvider = function04;
    }

    private final String getAddress(com.talabat.domain.address.Address address) {
        if (address == null) {
            return null;
        }
        String str = address.areaName;
        String str2 = address.block;
        String str3 = address.street;
        String str4 = address.buildingNo;
        String str5 = address.floor;
        String str6 = address.extraDirections;
        String invoke = this.countryCodeProvider.invoke();
        return str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str3 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str4 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str5 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str6 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + invoke;
    }

    @NotNull
    public final LocationData createLocationData(@Nullable com.talabat.domain.address.Address address) {
        String str;
        String str2;
        Pair invoke = this.latLongProvider.invoke();
        double doubleValue = ((Number) invoke.component1()).doubleValue();
        double doubleValue2 = ((Number) invoke.component2()).doubleValue();
        String invoke2 = this.selectedCityProvider.invoke();
        if (invoke2 == null) {
            str = "";
        } else {
            str = invoke2;
        }
        String invoke3 = this.selectedAreaProvider.invoke();
        String invoke4 = this.countryCodeProvider.invoke();
        String valueOf = String.valueOf(doubleValue);
        String valueOf2 = String.valueOf(doubleValue2);
        String address2 = getAddress(address);
        if (address2 == null) {
            str2 = "";
        } else {
            str2 = address2;
        }
        return new LocationData(str, invoke3, invoke4, valueOf, valueOf2, str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationDataFactory(Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function0, (i11 & 2) != 0 ? AnonymousClass2.INSTANCE : function02, (i11 & 4) != 0 ? AnonymousClass3.INSTANCE : function03, (i11 & 8) != 0 ? AnonymousClass4.INSTANCE : function04);
    }
}
