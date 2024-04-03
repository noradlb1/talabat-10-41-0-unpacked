package com.talabat.configuration.location;

import com.talabat.configuration.country.Country;
import com.talabat.domain.address.Address;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/talabat/configuration/location/LocationConfig;", "", "addresses", "", "Lcom/talabat/domain/address/Address;", "areas", "Lcom/talabat/configuration/location/Area;", "country", "Lcom/talabat/configuration/country/Country;", "countries", "Lcom/talabat/configuration/location/Country;", "isAddressMicroServiceEnabled", "", "metersOfLocationAwareness", "", "(Ljava/util/List;Ljava/util/List;Lcom/talabat/configuration/country/Country;Ljava/util/List;ZI)V", "getAddresses", "()Ljava/util/List;", "getAreas", "getCountries", "getCountry", "()Lcom/talabat/configuration/country/Country;", "()Z", "getMetersOfLocationAwareness", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final LocationConfig DEFAULT = new LocationConfig(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), Country.UNDEFINED, CollectionsKt__CollectionsKt.emptyList(), true, 200);
    @NotNull
    private final List<Address> addresses;
    @NotNull
    private final List<Area> areas;
    @NotNull
    private final List<Country> countries;
    @NotNull
    private final Country country;
    private final boolean isAddressMicroServiceEnabled;
    private final int metersOfLocationAwareness;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/location/LocationConfig$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/location/LocationConfig;", "getDEFAULT", "()Lcom/talabat/configuration/location/LocationConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocationConfig getDEFAULT() {
            return LocationConfig.DEFAULT;
        }
    }

    public LocationConfig(@NotNull List<Address> list, @NotNull List<Area> list2, @NotNull Country country2, @NotNull List<Country> list3, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        Intrinsics.checkNotNullParameter(list2, "areas");
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(list3, "countries");
        this.addresses = list;
        this.areas = list2;
        this.country = country2;
        this.countries = list3;
        this.isAddressMicroServiceEnabled = z11;
        this.metersOfLocationAwareness = i11;
    }

    public static /* synthetic */ LocationConfig copy$default(LocationConfig locationConfig, List<Address> list, List<Area> list2, Country country2, List<Country> list3, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = locationConfig.addresses;
        }
        if ((i12 & 2) != 0) {
            list2 = locationConfig.areas;
        }
        List<Area> list4 = list2;
        if ((i12 & 4) != 0) {
            country2 = locationConfig.country;
        }
        Country country3 = country2;
        if ((i12 & 8) != 0) {
            list3 = locationConfig.countries;
        }
        List<Country> list5 = list3;
        if ((i12 & 16) != 0) {
            z11 = locationConfig.isAddressMicroServiceEnabled;
        }
        boolean z12 = z11;
        if ((i12 & 32) != 0) {
            i11 = locationConfig.metersOfLocationAwareness;
        }
        return locationConfig.copy(list, list4, country3, list5, z12, i11);
    }

    @NotNull
    public final List<Address> component1() {
        return this.addresses;
    }

    @NotNull
    public final List<Area> component2() {
        return this.areas;
    }

    @NotNull
    public final Country component3() {
        return this.country;
    }

    @NotNull
    public final List<Country> component4() {
        return this.countries;
    }

    public final boolean component5() {
        return this.isAddressMicroServiceEnabled;
    }

    public final int component6() {
        return this.metersOfLocationAwareness;
    }

    @NotNull
    public final LocationConfig copy(@NotNull List<Address> list, @NotNull List<Area> list2, @NotNull Country country2, @NotNull List<Country> list3, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        Intrinsics.checkNotNullParameter(list2, "areas");
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(list3, "countries");
        return new LocationConfig(list, list2, country2, list3, z11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationConfig)) {
            return false;
        }
        LocationConfig locationConfig = (LocationConfig) obj;
        return Intrinsics.areEqual((Object) this.addresses, (Object) locationConfig.addresses) && Intrinsics.areEqual((Object) this.areas, (Object) locationConfig.areas) && this.country == locationConfig.country && Intrinsics.areEqual((Object) this.countries, (Object) locationConfig.countries) && this.isAddressMicroServiceEnabled == locationConfig.isAddressMicroServiceEnabled && this.metersOfLocationAwareness == locationConfig.metersOfLocationAwareness;
    }

    @NotNull
    public final List<Address> getAddresses() {
        return this.addresses;
    }

    @NotNull
    public final List<Area> getAreas() {
        return this.areas;
    }

    @NotNull
    public final List<Country> getCountries() {
        return this.countries;
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    public final int getMetersOfLocationAwareness() {
        return this.metersOfLocationAwareness;
    }

    public int hashCode() {
        int hashCode = ((((((this.addresses.hashCode() * 31) + this.areas.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countries.hashCode()) * 31;
        boolean z11 = this.isAddressMicroServiceEnabled;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.metersOfLocationAwareness;
    }

    public final boolean isAddressMicroServiceEnabled() {
        return this.isAddressMicroServiceEnabled;
    }

    @NotNull
    public String toString() {
        List<Address> list = this.addresses;
        List<Area> list2 = this.areas;
        Country country2 = this.country;
        List<Country> list3 = this.countries;
        boolean z11 = this.isAddressMicroServiceEnabled;
        int i11 = this.metersOfLocationAwareness;
        return "LocationConfig(addresses=" + list + ", areas=" + list2 + ", country=" + country2 + ", countries=" + list3 + ", isAddressMicroServiceEnabled=" + z11 + ", metersOfLocationAwareness=" + i11 + ")";
    }
}
