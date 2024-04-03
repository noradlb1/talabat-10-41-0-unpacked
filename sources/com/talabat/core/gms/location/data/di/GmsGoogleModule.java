package com.talabat.core.gms.location.data.di;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.talabat.core.context.domain.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/core/gms/location/data/di/GmsGoogleModule;", "", "()V", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "context", "Landroid/content/Context;", "googleLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "locationSettingsRequestBuilder", "Lcom/google/android/gms/location/LocationSettingsRequest$Builder;", "settingsClient", "Lcom/google/android/gms/location/SettingsClient;", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class GmsGoogleModule {
    @NotNull
    public static final GmsGoogleModule INSTANCE = new GmsGoogleModule();

    private GmsGoogleModule() {
    }

    @NotNull
    @Provides
    public final FusedLocationProviderClient fusedLocationProviderClient(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(context)");
        return fusedLocationProviderClient;
    }

    @NotNull
    @Provides
    public final LocationRequest googleLocationRequest() {
        return new LocationRequest();
    }

    @NotNull
    @Provides
    public final LocationSettingsRequest.Builder locationSettingsRequestBuilder() {
        return new LocationSettingsRequest.Builder();
    }

    @NotNull
    @Provides
    public final SettingsClient settingsClient(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SettingsClient settingsClient = LocationServices.getSettingsClient(context);
        Intrinsics.checkNotNullExpressionValue(settingsClient, "getSettingsClient(context)");
        return settingsClient;
    }
}
