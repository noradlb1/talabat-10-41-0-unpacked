package com.talabat.core.gms.location.data;

import com.talabat.core.gms.location.domain.GmsLocationRepository;
import com.talabat.location.domain.FusedLocationProviderClient;
import com.talabat.location.domain.LocationRequest;
import com.talabat.location.domain.LocationSettingsRequest;
import com.talabat.location.domain.SettingsClient;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B?\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/gms/location/data/DefaultGmsLocationRepository;", "Lcom/talabat/core/gms/location/domain/GmsLocationRepository;", "locationRequest", "Ljavax/inject/Provider;", "Lcom/talabat/location/domain/LocationRequest;", "fusedLocationProviderClient", "Lcom/talabat/location/domain/FusedLocationProviderClient;", "settingsClient", "Lcom/talabat/location/domain/SettingsClient;", "locationSettingsBuilder", "Lcom/talabat/location/domain/LocationSettingsRequest$Builder;", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "newFusedLocationProviderClient", "newLocationRequest", "newLocationSettingsRequestBuilder", "newSettingsClient", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGmsLocationRepository implements GmsLocationRepository {
    @NotNull
    private final Provider<FusedLocationProviderClient> fusedLocationProviderClient;
    @NotNull
    private final Provider<LocationRequest> locationRequest;
    @NotNull
    private final Provider<LocationSettingsRequest.Builder> locationSettingsBuilder;
    @NotNull
    private final Provider<SettingsClient> settingsClient;

    @Inject
    public DefaultGmsLocationRepository(@NotNull Provider<LocationRequest> provider, @NotNull Provider<FusedLocationProviderClient> provider2, @NotNull Provider<SettingsClient> provider3, @NotNull Provider<LocationSettingsRequest.Builder> provider4) {
        Intrinsics.checkNotNullParameter(provider, "locationRequest");
        Intrinsics.checkNotNullParameter(provider2, "fusedLocationProviderClient");
        Intrinsics.checkNotNullParameter(provider3, "settingsClient");
        Intrinsics.checkNotNullParameter(provider4, "locationSettingsBuilder");
        this.locationRequest = provider;
        this.fusedLocationProviderClient = provider2;
        this.settingsClient = provider3;
        this.locationSettingsBuilder = provider4;
    }

    @NotNull
    public FusedLocationProviderClient newFusedLocationProviderClient() {
        FusedLocationProviderClient fusedLocationProviderClient2 = this.fusedLocationProviderClient.get();
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient2, "fusedLocationProviderClient.get()");
        return fusedLocationProviderClient2;
    }

    @NotNull
    public LocationRequest newLocationRequest() {
        LocationRequest locationRequest2 = this.locationRequest.get();
        Intrinsics.checkNotNullExpressionValue(locationRequest2, "locationRequest.get()");
        return locationRequest2;
    }

    @NotNull
    public LocationSettingsRequest.Builder newLocationSettingsRequestBuilder() {
        LocationSettingsRequest.Builder builder = this.locationSettingsBuilder.get();
        Intrinsics.checkNotNullExpressionValue(builder, "locationSettingsBuilder.get()");
        return builder;
    }

    @NotNull
    public SettingsClient newSettingsClient() {
        SettingsClient settingsClient2 = this.settingsClient.get();
        Intrinsics.checkNotNullExpressionValue(settingsClient2, "settingsClient.get()");
        return settingsClient2;
    }
}
