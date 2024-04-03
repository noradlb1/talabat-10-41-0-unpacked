package com.talabat.gms.maps.data.di;

import com.google.android.gms.maps.model.PolygonOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleModule_GooglePolygonOptionsFactory implements Factory<PolygonOptions> {
    private final GoogleModule module;

    public GoogleModule_GooglePolygonOptionsFactory(GoogleModule googleModule) {
        this.module = googleModule;
    }

    public static GoogleModule_GooglePolygonOptionsFactory create(GoogleModule googleModule) {
        return new GoogleModule_GooglePolygonOptionsFactory(googleModule);
    }

    public static PolygonOptions googlePolygonOptions(GoogleModule googleModule) {
        return (PolygonOptions) Preconditions.checkNotNullFromProvides(googleModule.googlePolygonOptions());
    }

    public PolygonOptions get() {
        return googlePolygonOptions(this.module);
    }
}
