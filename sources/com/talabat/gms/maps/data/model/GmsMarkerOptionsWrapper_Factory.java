package com.talabat.gms.maps.data.model;

import com.google.android.gms.maps.model.MarkerOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsMarkerOptionsWrapper_Factory implements Factory<GmsMarkerOptionsWrapper> {
    private final Provider<MarkerOptions> googleMarkerOptionsProvider;

    public GmsMarkerOptionsWrapper_Factory(Provider<MarkerOptions> provider) {
        this.googleMarkerOptionsProvider = provider;
    }

    public static GmsMarkerOptionsWrapper_Factory create(Provider<MarkerOptions> provider) {
        return new GmsMarkerOptionsWrapper_Factory(provider);
    }

    public static GmsMarkerOptionsWrapper newInstance(MarkerOptions markerOptions) {
        return new GmsMarkerOptionsWrapper(markerOptions);
    }

    public GmsMarkerOptionsWrapper get() {
        return newInstance(this.googleMarkerOptionsProvider.get());
    }
}
