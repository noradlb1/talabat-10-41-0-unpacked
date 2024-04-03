package com.talabat.configuration.location;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.areas.Areas2Rest;
import com.talabat.configuration.areas.mapper.Area2Mapper;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.AreasRest;
import com.talabat.configuration.location.mapper.LocationConfigMapper;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.domain.address.Address;
import dagger.Reusable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0016J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/talabat/configuration/location/RealLocationConfigurationRepository;", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "mapper", "Lcom/talabat/configuration/location/mapper/LocationConfigMapper;", "areas2Rest", "Lcom/talabat/configuration/areas/Areas2Rest;", "area2Mapper", "Lcom/talabat/configuration/areas/mapper/Area2Mapper;", "(Lcom/talabat/configuration/AppInfoContainer;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/mapper/LocationConfigMapper;Lcom/talabat/configuration/areas/Areas2Rest;Lcom/talabat/configuration/areas/mapper/Area2Mapper;)V", "cachedLocationConfig", "Lcom/talabat/configuration/location/LocationConfig;", "addresses", "", "Lcom/talabat/domain/address/Address;", "areas", "Lcom/talabat/configuration/location/Area;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "config", "countries", "Lcom/talabat/configuration/location/Country;", "selectedCountry", "setConfig", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class RealLocationConfigurationRepository implements MutableLocationConfigurationRepository {
    @NotNull
    private final AppInfoContainer appInfoContainer;
    @NotNull
    private final Area2Mapper area2Mapper;
    @NotNull
    private final Areas2Rest areas2Rest;
    @Nullable
    private LocationConfig cachedLocationConfig;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigMapper mapper;

    @Inject
    public RealLocationConfigurationRepository(@NotNull AppInfoContainer appInfoContainer2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigMapper locationConfigMapper, @NotNull @AreasRest Areas2Rest areas2Rest2, @NotNull Area2Mapper area2Mapper2) {
        Intrinsics.checkNotNullParameter(appInfoContainer2, "appInfoContainer");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigMapper, "mapper");
        Intrinsics.checkNotNullParameter(areas2Rest2, "areas2Rest");
        Intrinsics.checkNotNullParameter(area2Mapper2, "area2Mapper");
        this.appInfoContainer = appInfoContainer2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.mapper = locationConfigMapper;
        this.areas2Rest = areas2Rest2;
        this.area2Mapper = area2Mapper2;
    }

    @NotNull
    public List<Address> addresses() {
        return config().getAddresses();
    }

    @NotNull
    public List<Area> areas() {
        return config().getAreas();
    }

    @NotNull
    public LocationConfig config() {
        LocationConfig locationConfig;
        LocationConfig locationConfig2 = this.cachedLocationConfig;
        if (locationConfig2 != null) {
            return locationConfig2;
        }
        AppInfoEntity cachedAppInfoEntity = this.appInfoContainer.getCachedAppInfoEntity();
        if (cachedAppInfoEntity == null || (locationConfig = this.mapper.apply(cachedAppInfoEntity)) == null) {
            locationConfig = null;
        } else {
            this.cachedLocationConfig = locationConfig;
        }
        if (locationConfig == null) {
            return LocationConfig.Companion.getDEFAULT();
        }
        return locationConfig;
    }

    @NotNull
    public List<Country> countries() {
        return config().getCountries();
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.location.RealLocationConfigurationRepository.selectedCountry():com.talabat.configuration.location.Country");
    }

    public void setConfig(@NotNull LocationConfig locationConfig) {
        Intrinsics.checkNotNullParameter(locationConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.cachedLocationConfig = locationConfig;
    }

    public boolean shouldEnableCountry(@NotNull Country country) {
        return MutableLocationConfigurationRepository.DefaultImpls.shouldEnableCountry(this, country);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object areas(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.configuration.location.Area>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.configuration.location.RealLocationConfigurationRepository$areas$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.configuration.location.RealLocationConfigurationRepository$areas$1 r0 = (com.talabat.configuration.location.RealLocationConfigurationRepository$areas$1) r0
            int r1 = r0.f55772k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55772k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.configuration.location.RealLocationConfigurationRepository$areas$1 r0 = new com.talabat.configuration.location.RealLocationConfigurationRepository$areas$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f55770i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55772k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55769h
            com.talabat.configuration.location.RealLocationConfigurationRepository r5 = (com.talabat.configuration.location.RealLocationConfigurationRepository) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0066
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.configuration.location.LocationConfig r6 = r4.cachedLocationConfig
            if (r6 == 0) goto L_0x0058
            com.talabat.configuration.country.Country r2 = r6.getCountry()
            int r2 = r2.getCountryId()
            if (r2 != r5) goto L_0x0058
            java.util.List r2 = r6.getAreas()
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0058
            java.util.List r5 = r6.getAreas()
            return r5
        L_0x0058:
            com.talabat.configuration.areas.Areas2Rest r6 = r4.areas2Rest
            r0.f55769h = r4
            r0.f55772k = r3
            java.lang.Object r6 = r6.getAreas(r5, r0)
            if (r6 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r5 = r4
        L_0x0066:
            com.talabat.configuration.areas.model.Areas2Entity r6 = (com.talabat.configuration.areas.model.Areas2Entity) r6
            java.util.List r6 = r6.getResult()
            if (r6 == 0) goto L_0x0095
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            com.talabat.configuration.areas.mapper.Area2Mapper r5 = r5.area2Mapper
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0081:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0096
            java.lang.Object r1 = r6.next()
            com.talabat.configuration.areas.model.Area2 r1 = (com.talabat.configuration.areas.model.Area2) r1
            com.talabat.configuration.location.Area r1 = r5.apply((com.talabat.configuration.areas.model.Area2) r1)
            r0.add(r1)
            goto L_0x0081
        L_0x0095:
            r0 = 0
        L_0x0096:
            if (r0 != 0) goto L_0x009c
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.location.RealLocationConfigurationRepository.areas(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
