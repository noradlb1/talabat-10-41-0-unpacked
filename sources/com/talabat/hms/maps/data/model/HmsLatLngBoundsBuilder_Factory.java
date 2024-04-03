package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.LatLngBounds;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsLatLngBoundsBuilder_Factory implements Factory<HmsLatLngBoundsBuilder> {
    private final Provider<LatLngBounds.Builder> googleLatLngBoundsBuilderProvider;

    public HmsLatLngBoundsBuilder_Factory(Provider<LatLngBounds.Builder> provider) {
        this.googleLatLngBoundsBuilderProvider = provider;
    }

    public static HmsLatLngBoundsBuilder_Factory create(Provider<LatLngBounds.Builder> provider) {
        return new HmsLatLngBoundsBuilder_Factory(provider);
    }

    public static HmsLatLngBoundsBuilder newInstance(LatLngBounds.Builder builder) {
        return new HmsLatLngBoundsBuilder(builder);
    }

    public HmsLatLngBoundsBuilder get() {
        return newInstance(this.googleLatLngBoundsBuilderProvider.get());
    }
}
