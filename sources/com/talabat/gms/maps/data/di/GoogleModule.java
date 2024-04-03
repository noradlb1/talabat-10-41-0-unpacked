package com.talabat.gms.maps.data.di;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/gms/maps/data/di/GoogleModule;", "", "()V", "cameraPositionBuilder", "Lcom/google/android/gms/maps/model/CameraPosition$Builder;", "googleCircleOptions", "Lcom/google/android/gms/maps/model/CircleOptions;", "googleMarkerOptions", "Lcom/google/android/gms/maps/model/MarkerOptions;", "googlePolygonOptions", "Lcom/google/android/gms/maps/model/PolygonOptions;", "latLngBoundsBuilder", "Lcom/google/android/gms/maps/model/LatLngBounds$Builder;", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class GoogleModule {
    @NotNull
    @Provides
    public final CameraPosition.Builder cameraPositionBuilder() {
        return new CameraPosition.Builder();
    }

    @NotNull
    @Provides
    public final CircleOptions googleCircleOptions() {
        return new CircleOptions();
    }

    @NotNull
    @Provides
    public final MarkerOptions googleMarkerOptions() {
        return new MarkerOptions();
    }

    @NotNull
    @Provides
    public final PolygonOptions googlePolygonOptions() {
        return new PolygonOptions();
    }

    @NotNull
    @Provides
    public final LatLngBounds.Builder latLngBoundsBuilder() {
        return new LatLngBounds.Builder();
    }
}
