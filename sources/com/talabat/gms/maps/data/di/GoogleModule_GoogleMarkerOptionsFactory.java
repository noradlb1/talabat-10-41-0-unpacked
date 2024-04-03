package com.talabat.gms.maps.data.di;

import com.google.android.gms.maps.model.MarkerOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleModule_GoogleMarkerOptionsFactory implements Factory<MarkerOptions> {
    private final GoogleModule module;

    public GoogleModule_GoogleMarkerOptionsFactory(GoogleModule googleModule) {
        this.module = googleModule;
    }

    public static GoogleModule_GoogleMarkerOptionsFactory create(GoogleModule googleModule) {
        return new GoogleModule_GoogleMarkerOptionsFactory(googleModule);
    }

    public static MarkerOptions googleMarkerOptions(GoogleModule googleModule) {
        return (MarkerOptions) Preconditions.checkNotNullFromProvides(googleModule.googleMarkerOptions());
    }

    public MarkerOptions get() {
        return googleMarkerOptions(this.module);
    }
}
