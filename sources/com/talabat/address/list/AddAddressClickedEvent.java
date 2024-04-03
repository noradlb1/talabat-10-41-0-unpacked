package com.talabat.address.list;

import com.talabat.configuration.country.Country;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u000e*\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/address/list/AddAddressClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "country", "Lcom/talabat/configuration/country/Country;", "latLng", "Lcom/talabat/domain/location/GeoCoordinate;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "selectedCustomerAddressProvider", "Lkotlin/Function0;", "Lcom/talabat/domain/address/Address;", "(Lcom/talabat/configuration/country/Country;Lcom/talabat/domain/location/GeoCoordinate;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;Lkotlin/jvm/functions/Function0;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "orNA", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class AddAddressClickedEvent extends TalabatEvent {
    @NotNull
    private final Country country;
    @Nullable
    private final GeoCoordinate latLng;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final Function0<Address> selectedCustomerAddressProvider;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddAddressClickedEvent(Country country2, GeoCoordinate geoCoordinate, LocationDataFactory locationDataFactory2, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(country2, geoCoordinate, (i11 & 4) != 0 ? new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null) : locationDataFactory2, (i11 & 8) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    private final String orNA(String str) {
        return str == null || StringsKt__StringsJVMKt.isBlank(str) ? "N/A" : str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Double d11;
        Double d12;
        Integer num;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Address invoke = this.selectedCustomerAddressProvider.invoke();
        LocationDataFactory.LocationData createLocationData = this.locationDataFactory.createLocationData(invoke);
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("screenType", ScreenNames.SCREEN_TYPE_USER_ACCOUNT);
        pairArr[1] = TuplesKt.to("screenName", ScreenNames.ADDRESS_LIST);
        pairArr[2] = TuplesKt.to("locationCountry", this.country.getThreeLetterCode());
        GeoCoordinate geoCoordinate = this.latLng;
        Integer num2 = null;
        if (geoCoordinate != null) {
            d11 = Double.valueOf(geoCoordinate.getLatitude());
        } else {
            d11 = null;
        }
        pairArr[3] = TuplesKt.to("locationLat", d11);
        GeoCoordinate geoCoordinate2 = this.latLng;
        if (geoCoordinate2 != null) {
            d12 = Double.valueOf(geoCoordinate2.getLongitude());
        } else {
            d12 = null;
        }
        pairArr[4] = TuplesKt.to("locationLon", d12);
        if (invoke != null) {
            num = Integer.valueOf(invoke.cityId);
        } else {
            num = null;
        }
        pairArr[5] = TuplesKt.to("locationCity", num);
        if (invoke != null) {
            num2 = Integer.valueOf(invoke.areaId);
        }
        pairArr[6] = TuplesKt.to("locationArea", num2);
        pairArr[7] = TuplesKt.to("locationAddress", orNA(createLocationData.getAddress()));
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScreenNames.SCREEN_TYPE_USER_ACCOUNT;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "address_add_clicked";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    public AddAddressClickedEvent(@NotNull Country country2, @Nullable GeoCoordinate geoCoordinate, @NotNull LocationDataFactory locationDataFactory2, @NotNull Function0<Address> function0) {
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        Intrinsics.checkNotNullParameter(function0, "selectedCustomerAddressProvider");
        this.country = country2;
        this.latLng = geoCoordinate;
        this.locationDataFactory = locationDataFactory2;
        this.selectedCustomerAddressProvider = function0;
    }
}
