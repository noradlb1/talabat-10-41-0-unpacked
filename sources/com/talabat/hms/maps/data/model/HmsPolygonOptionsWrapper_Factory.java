package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.PolygonOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsPolygonOptionsWrapper_Factory implements Factory<HmsPolygonOptionsWrapper> {
    private final Provider<PolygonOptions> huaweiPolygonOptionsProvider;

    public HmsPolygonOptionsWrapper_Factory(Provider<PolygonOptions> provider) {
        this.huaweiPolygonOptionsProvider = provider;
    }

    public static HmsPolygonOptionsWrapper_Factory create(Provider<PolygonOptions> provider) {
        return new HmsPolygonOptionsWrapper_Factory(provider);
    }

    public static HmsPolygonOptionsWrapper newInstance(PolygonOptions polygonOptions) {
        return new HmsPolygonOptionsWrapper(polygonOptions);
    }

    public HmsPolygonOptionsWrapper get() {
        return newInstance(this.huaweiPolygonOptionsProvider.get());
    }
}
