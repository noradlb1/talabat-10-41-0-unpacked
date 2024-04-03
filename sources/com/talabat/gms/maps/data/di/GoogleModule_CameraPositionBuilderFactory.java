package com.talabat.gms.maps.data.di;

import com.google.android.gms.maps.model.CameraPosition;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleModule_CameraPositionBuilderFactory implements Factory<CameraPosition.Builder> {
    private final GoogleModule module;

    public GoogleModule_CameraPositionBuilderFactory(GoogleModule googleModule) {
        this.module = googleModule;
    }

    public static CameraPosition.Builder cameraPositionBuilder(GoogleModule googleModule) {
        return (CameraPosition.Builder) Preconditions.checkNotNullFromProvides(googleModule.cameraPositionBuilder());
    }

    public static GoogleModule_CameraPositionBuilderFactory create(GoogleModule googleModule) {
        return new GoogleModule_CameraPositionBuilderFactory(googleModule);
    }

    public CameraPosition.Builder get() {
        return cameraPositionBuilder(this.module);
    }
}
