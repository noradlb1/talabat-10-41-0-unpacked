package com.talabat.configuration.location;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import dagger.Reusable;
import datamodels.Area;
import datamodels.Country;
import datamodels.mappers.OldAreaToAreaMapper;
import datamodels.mappers.OldCountryToCountryMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0016J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/talabat/configuration/location/LegacyLocationConfigurationRepository;", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "realRepository", "Lcom/talabat/configuration/location/RealLocationConfigurationRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "areaMapper", "Ldatamodels/mappers/OldAreaToAreaMapper;", "countryMapper", "Ldatamodels/mappers/OldCountryToCountryMapper;", "(Lcom/talabat/configuration/location/RealLocationConfigurationRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Ldatamodels/mappers/OldAreaToAreaMapper;Ldatamodels/mappers/OldCountryToCountryMapper;)V", "cachedLocationConfig", "Lcom/talabat/configuration/location/LocationConfig;", "addresses", "", "Lcom/talabat/domain/address/Address;", "areas", "Lcom/talabat/configuration/location/Area;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "config", "countries", "Lcom/talabat/configuration/location/Country;", "selectedCountry", "setConfig", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class LegacyLocationConfigurationRepository implements MutableLocationConfigurationRepository {
    @NotNull
    private final OldAreaToAreaMapper areaMapper;
    @Nullable
    private LocationConfig cachedLocationConfig;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final OldCountryToCountryMapper countryMapper;
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final RealLocationConfigurationRepository realRepository;

    @Inject
    public LegacyLocationConfigurationRepository(@NotNull RealLocationConfigurationRepository realLocationConfigurationRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull OldAreaToAreaMapper oldAreaToAreaMapper, @NotNull OldCountryToCountryMapper oldCountryToCountryMapper) {
        Intrinsics.checkNotNullParameter(realLocationConfigurationRepository, "realRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(oldAreaToAreaMapper, "areaMapper");
        Intrinsics.checkNotNullParameter(oldCountryToCountryMapper, "countryMapper");
        this.realRepository = realLocationConfigurationRepository;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.featureFlags = iTalabatFeatureFlag;
        this.areaMapper = oldAreaToAreaMapper;
        this.countryMapper = oldCountryToCountryMapper;
    }

    @NotNull
    public List<Address> addresses() {
        return this.realRepository.addresses();
    }

    @NotNull
    public List<Area> areas() {
        return this.realRepository.areas();
    }

    @NotNull
    public LocationConfig config() {
        ArrayList arrayList;
        List<Area> emptyList;
        LocationConfig config = this.realRepository.config();
        List<Address> addresses = config.getAddresses();
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlags, LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false, 2, (Object) null)) {
            emptyList = config.getAreas();
        } else {
            Area[] areaArr = GlobalDataModel.areas;
            if (areaArr != null) {
                OldAreaToAreaMapper oldAreaToAreaMapper = this.areaMapper;
                ArrayList arrayList2 = new ArrayList(areaArr.length);
                for (Area apply : areaArr) {
                    arrayList2.add(oldAreaToAreaMapper.apply(apply));
                }
                arrayList = arrayList2;
                LocationConfig locationConfig = new LocationConfig(addresses, arrayList, this.configurationLocalRepository.selectedCountry(), countries(), config.isAddressMicroServiceEnabled(), config.getMetersOfLocationAwareness());
                this.cachedLocationConfig = locationConfig;
                return locationConfig;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList = emptyList;
        LocationConfig locationConfig2 = new LocationConfig(addresses, arrayList, this.configurationLocalRepository.selectedCountry(), countries(), config.isAddressMicroServiceEnabled(), config.getMetersOfLocationAwareness());
        this.cachedLocationConfig = locationConfig2;
        return locationConfig2;
    }

    @NotNull
    public List<Country> countries() {
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlags, LocationFeatureFlagConstants.LOCATION_REPO_REAL_COUNTRIES, false, 2, (Object) null)) {
            return this.realRepository.config().getCountries();
        }
        Country[] countryArr = GlobalDataModel.countries;
        if (countryArr == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        OldCountryToCountryMapper oldCountryToCountryMapper = this.countryMapper;
        ArrayList arrayList = new ArrayList(countryArr.length);
        for (Country apply : countryArr) {
            arrayList.add(oldCountryToCountryMapper.apply(apply));
        }
        return arrayList;
    }

    @Nullable
    public Country getCountryById(int i11) {
        return MutableLocationConfigurationRepository.DefaultImpls.getCountryById(this, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.talabat.configuration.location.Country} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.talabat.configuration.location.Country} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.talabat.configuration.location.Country} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.talabat.configuration.location.Country} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.configuration.location.Country selectedCountry() {
        /*
            r8 = this;
            com.talabat.configuration.ConfigurationLocalRepository r0 = r8.configurationLocalRepository
            com.talabat.configuration.country.Country r0 = r0.selectedCountry()
            com.talabat.configuration.country.Country r1 = com.talabat.configuration.country.Country.UNDEFINED
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0014
            int r1 = r0.getCountryId()
            if (r1 <= 0) goto L_0x0014
            r1 = r2
            goto L_0x0015
        L_0x0014:
            r1 = r3
        L_0x0015:
            r4 = 0
            if (r1 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r0 = r4
        L_0x001a:
            if (r0 == 0) goto L_0x0050
            java.util.List r1 = r8.countries()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0026:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x004e
            java.lang.Object r5 = r1.next()
            r6 = r5
            com.talabat.configuration.location.Country r6 = (com.talabat.configuration.location.Country) r6
            com.talabat.configuration.country.Country r7 = r6.getCountry()
            if (r7 == r0) goto L_0x004a
            com.talabat.configuration.country.Country r6 = r6.getCountry()
            int r6 = r6.getCountryId()
            int r7 = r0.getCountryId()
            if (r6 != r7) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r6 = r3
            goto L_0x004b
        L_0x004a:
            r6 = r2
        L_0x004b:
            if (r6 == 0) goto L_0x0026
            r4 = r5
        L_0x004e:
            com.talabat.configuration.location.Country r4 = (com.talabat.configuration.location.Country) r4
        L_0x0050:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.location.LegacyLocationConfigurationRepository.selectedCountry():com.talabat.configuration.location.Country");
    }

    public void setConfig(@NotNull LocationConfig locationConfig) {
        Intrinsics.checkNotNullParameter(locationConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.cachedLocationConfig = locationConfig;
        this.realRepository.setConfig(locationConfig);
    }

    public boolean shouldEnableCountry(@NotNull com.talabat.configuration.country.Country country) {
        return MutableLocationConfigurationRepository.DefaultImpls.shouldEnableCountry(this, country);
    }

    @Nullable
    public Object areas(int i11, @NotNull Continuation<? super List<Area>> continuation) {
        return this.realRepository.areas(i11, continuation);
    }
}
