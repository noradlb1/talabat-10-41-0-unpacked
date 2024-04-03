package com.talabat.gms.maps.data.di;

import com.google.android.gms.maps.model.LatLngBounds;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleModule_LatLngBoundsBuilderFactory implements Factory<LatLngBounds.Builder> {
    private final GoogleModule module;

    public GoogleModule_LatLngBoundsBuilderFactory(GoogleModule googleModule) {
        this.module = googleModule;
    }

    public static GoogleModule_LatLngBoundsBuilderFactory create(GoogleModule googleModule) {
        return new GoogleModule_LatLngBoundsBuilderFactory(googleModule);
    }

    public static LatLngBounds.Builder latLngBoundsBuilder(GoogleModule googleModule) {
        return (LatLngBounds.Builder) Preconditions.checkNotNullFromProvides(googleModule.latLngBoundsBuilder());
    }

    public LatLngBounds.Builder get() {
        return latLngBoundsBuilder(this.module);
    }
}
