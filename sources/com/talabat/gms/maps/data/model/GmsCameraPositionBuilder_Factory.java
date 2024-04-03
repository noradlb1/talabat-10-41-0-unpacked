package com.talabat.gms.maps.data.model;

import com.google.android.gms.maps.model.CameraPosition;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsCameraPositionBuilder_Factory implements Factory<GmsCameraPositionBuilder> {
    private final Provider<CameraPosition.Builder> googleCameraPositionBuilderProvider;

    public GmsCameraPositionBuilder_Factory(Provider<CameraPosition.Builder> provider) {
        this.googleCameraPositionBuilderProvider = provider;
    }

    public static GmsCameraPositionBuilder_Factory create(Provider<CameraPosition.Builder> provider) {
        return new GmsCameraPositionBuilder_Factory(provider);
    }

    public static GmsCameraPositionBuilder newInstance(CameraPosition.Builder builder) {
        return new GmsCameraPositionBuilder(builder);
    }

    public GmsCameraPositionBuilder get() {
        return newInstance(this.googleCameraPositionBuilderProvider.get());
    }
}
