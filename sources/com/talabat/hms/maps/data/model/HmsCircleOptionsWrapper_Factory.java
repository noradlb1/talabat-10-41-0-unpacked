package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.CircleOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsCircleOptionsWrapper_Factory implements Factory<HmsCircleOptionsWrapper> {
    private final Provider<CircleOptions> huaweiCircleOptionsProvider;

    public HmsCircleOptionsWrapper_Factory(Provider<CircleOptions> provider) {
        this.huaweiCircleOptionsProvider = provider;
    }

    public static HmsCircleOptionsWrapper_Factory create(Provider<CircleOptions> provider) {
        return new HmsCircleOptionsWrapper_Factory(provider);
    }

    public static HmsCircleOptionsWrapper newInstance(CircleOptions circleOptions) {
        return new HmsCircleOptionsWrapper(circleOptions);
    }

    public HmsCircleOptionsWrapper get() {
        return newInstance(this.huaweiCircleOptionsProvider.get());
    }
}
