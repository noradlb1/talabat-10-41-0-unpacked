package com.talabat.gms.maps.data.model;

import com.google.android.gms.maps.model.LatLngBounds;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsLatLngBoundsBuilder_Factory implements Factory<GmsLatLngBoundsBuilder> {
    private final Provider<LatLngBounds.Builder> googleLatLngBoundsBuilderProvider;

    public GmsLatLngBoundsBuilder_Factory(Provider<LatLngBounds.Builder> provider) {
        this.googleLatLngBoundsBuilderProvider = provider;
    }

    public static GmsLatLngBoundsBuilder_Factory create(Provider<LatLngBounds.Builder> provider) {
        return new GmsLatLngBoundsBuilder_Factory(provider);
    }

    public static GmsLatLngBoundsBuilder newInstance(LatLngBounds.Builder builder) {
        return new GmsLatLngBoundsBuilder(builder);
    }

    public GmsLatLngBoundsBuilder get() {
        return newInstance(this.googleLatLngBoundsBuilderProvider.get());
    }
}
