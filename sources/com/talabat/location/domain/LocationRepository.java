package com.talabat.location.domain;

import com.talabat.location.domain.LocationSettingsRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/location/domain/LocationRepository;", "", "newFusedLocationProviderClient", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "newLocationRequest", "Lcom/talabat/location/domain/LocationRequest;", "newLocationSettingsRequestBuilder", "Lcom/talabat/location/domain/LocationSettingsRequest$Builder;", "newSettingsClient", "Lcom/talabat/location/domain/SettingsClient;", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationRepository {
    @NotNull
    FusedLocationProviderClient newFusedLocationProviderClient();

    @NotNull
    LocationRequest newLocationRequest();

    @NotNull
    LocationSettingsRequest.Builder newLocationSettingsRequestBuilder();

    @NotNull
    SettingsClient newSettingsClient();
}
