package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.MarkerOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsMarkerOptionsWrapper_Factory implements Factory<HmsMarkerOptionsWrapper> {
    private final Provider<MarkerOptions> huaweiMarkerOptionsProvider;

    public HmsMarkerOptionsWrapper_Factory(Provider<MarkerOptions> provider) {
        this.huaweiMarkerOptionsProvider = provider;
    }

    public static HmsMarkerOptionsWrapper_Factory create(Provider<MarkerOptions> provider) {
        return new HmsMarkerOptionsWrapper_Factory(provider);
    }

    public static HmsMarkerOptionsWrapper newInstance(MarkerOptions markerOptions) {
        return new HmsMarkerOptionsWrapper(markerOptions);
    }

    public HmsMarkerOptionsWrapper get() {
        return newInstance(this.huaweiMarkerOptionsProvider.get());
    }
}
