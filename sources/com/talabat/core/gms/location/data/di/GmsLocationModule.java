package com.talabat.core.gms.location.data.di;

import com.talabat.core.gms.location.data.DefaultGmsLocationRepository;
import com.talabat.core.gms.location.data.GmsFusedLocationProviderClient;
import com.talabat.core.gms.location.data.GmsLocationRequest;
import com.talabat.core.gms.location.data.GmsLocationSettingsRequestBuilderWrapper;
import com.talabat.core.gms.location.data.GmsSettingsClientWrapper;
import com.talabat.core.gms.location.domain.GmsLocationRepository;
import com.talabat.location.domain.FusedLocationProviderClient;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.LocationSettingsRequest;
import com.talabat.location.domain.SettingsClient;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/gms/location/data/di/GmsLocationModule;", "", "fusedLocationProviderClient", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "real", "Lcom/talabat/core/gms/location/data/GmsFusedLocationProviderClient;", "gmsLocationRepository", "Lcom/talabat/core/gms/location/domain/GmsLocationRepository;", "Lcom/talabat/core/gms/location/data/DefaultGmsLocationRepository;", "locationRequest", "Lcom/talabat/location/domain/LocationRequest;", "Lcom/talabat/core/gms/location/data/GmsLocationRequest;", "locationSettingsRequestBuilder", "Lcom/talabat/location/domain/LocationSettingsRequest$Builder;", "Lcom/talabat/core/gms/location/data/GmsLocationSettingsRequestBuilderWrapper;", "settingsClient", "Lcom/talabat/location/domain/SettingsClient;", "Lcom/talabat/core/gms/location/data/GmsSettingsClientWrapper;", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface GmsLocationModule {
    @NotNull
    @Binds
    FusedLocationProviderClient fusedLocationProviderClient(@NotNull GmsFusedLocationProviderClient gmsFusedLocationProviderClient);

    @NotNull
    @Binds
    @Reusable
    GmsLocationRepository gmsLocationRepository(@NotNull DefaultGmsLocationRepository defaultGmsLocationRepository);

    @NotNull
    @Binds
    LocationRequest locationRequest(@NotNull GmsLocationRequest gmsLocationRequest);

    @NotNull
    @Binds
    LocationSettingsRequest.Builder locationSettingsRequestBuilder(@NotNull GmsLocationSettingsRequestBuilderWrapper gmsLocationSettingsRequestBuilderWrapper);

    @NotNull
    @Binds
    SettingsClient settingsClient(@NotNull GmsSettingsClientWrapper gmsSettingsClientWrapper);
}
