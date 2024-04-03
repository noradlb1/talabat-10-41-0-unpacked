package com.talabat.configuration.location.mapper;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.configuration.location.model.AreaEntity;
import com.talabat.configuration.location.model.CountryEntity;
import com.talabat.configuration.location.model.MetersOfLocationConfigFwfRemoteConfig;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.configuration.remote.model.AppInfoResultEntity;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageRemoteConfigurationsKeys;
import com.talabat.domain.address.Address;
import com.talabat.mapper.ModelMapper;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/configuration/location/mapper/LocationConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/location/LocationConfig;", "areaMapper", "Lcom/talabat/configuration/location/mapper/AreaMapper;", "countryMapper", "Lcom/talabat/configuration/location/mapper/CountryMapper;", "(Lcom/talabat/configuration/location/mapper/AreaMapper;Lcom/talabat/configuration/location/mapper/CountryMapper;)V", "apply", "source", "mapMetersOfLocationAwareness", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationConfigMapper implements ModelMapper<AppInfoEntity, LocationConfig> {
    @NotNull
    private final AreaMapper areaMapper;
    @NotNull
    private final CountryMapper countryMapper;

    @Inject
    public LocationConfigMapper(@NotNull AreaMapper areaMapper2, @NotNull CountryMapper countryMapper2) {
        Intrinsics.checkNotNullParameter(areaMapper2, "areaMapper");
        Intrinsics.checkNotNullParameter(countryMapper2, "countryMapper");
        this.areaMapper = areaMapper2;
        this.countryMapper = countryMapper2;
    }

    private final int mapMetersOfLocationAwareness() {
        Integer metersOfLocationAwareness = ((MetersOfLocationConfigFwfRemoteConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(HomePageRemoteConfigurationsKeys.LOCATION_CONFIG_METERS_OF_LOCATION_AWARENESS, new MetersOfLocationConfigFwfRemoteConfig((Integer) null, 1, (DefaultConstructorMarker) null), MetersOfLocationConfigFwfRemoteConfig.class)).getMetersOfLocationAwareness();
        if (metersOfLocationAwareness != null) {
            return metersOfLocationAwareness.intValue();
        }
        return 200;
    }

    @NotNull
    public LocationConfig apply(@NotNull AppInfoEntity appInfoEntity) {
        ArrayList arrayList;
        Country country;
        Boolean isAddressMicroServiceEnabled;
        List<CountryEntity> countries;
        Integer countryId;
        List<AreaEntity> areas;
        Intrinsics.checkNotNullParameter(appInfoEntity, "source");
        AppInfoResultEntity result = appInfoEntity.getResult();
        ArrayList arrayList2 = null;
        List<Address> addresses = result != null ? result.getAddresses() : null;
        if (addresses == null) {
            addresses = CollectionsKt__CollectionsKt.emptyList();
        }
        List<Address> list = addresses;
        AppInfoResultEntity result2 = appInfoEntity.getResult();
        if (result2 == null || (areas = result2.getAreas()) == null) {
            arrayList = null;
        } else {
            Iterable<AreaEntity> iterable = areas;
            AreaMapper areaMapper2 = this.areaMapper;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (AreaEntity apply : iterable) {
                arrayList.add(areaMapper2.apply(apply));
            }
        }
        ArrayList emptyList = arrayList == null ? CollectionsKt__CollectionsKt.emptyList() : arrayList;
        AppInfoResultEntity result3 = appInfoEntity.getResult();
        if (result3 == null || (countryId = result3.getCountryId()) == null || (country = Country.Companion.from(countryId.intValue())) == null) {
            country = Country.UNDEFINED;
        }
        Country country2 = country;
        AppInfoResultEntity result4 = appInfoEntity.getResult();
        if (!(result4 == null || (countries = result4.getCountries()) == null)) {
            Iterable<CountryEntity> iterable2 = countries;
            CountryMapper countryMapper2 = this.countryMapper;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
            for (CountryEntity apply2 : iterable2) {
                arrayList3.add(countryMapper2.apply(apply2));
            }
            arrayList2 = arrayList3;
        }
        ArrayList emptyList2 = arrayList2 == null ? CollectionsKt__CollectionsKt.emptyList() : arrayList2;
        AppInfoResultEntity result5 = appInfoEntity.getResult();
        return new LocationConfig(list, emptyList, country2, emptyList2, (result5 == null || (isAddressMicroServiceEnabled = result5.isAddressMicroServiceEnabled()) == null) ? true : isAddressMicroServiceEnabled.booleanValue(), mapMetersOfLocationAwareness());
    }
}
