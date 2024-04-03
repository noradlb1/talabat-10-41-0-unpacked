package com.talabat.hms.maps.data.di;

import com.huawei.hms.maps.model.LatLngBounds;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_LatLngBoundsBuilderFactory implements Factory<LatLngBounds.Builder> {
    private final HuaweiModule module;

    public HuaweiModule_LatLngBoundsBuilderFactory(HuaweiModule huaweiModule) {
        this.module = huaweiModule;
    }

    public static HuaweiModule_LatLngBoundsBuilderFactory create(HuaweiModule huaweiModule) {
        return new HuaweiModule_LatLngBoundsBuilderFactory(huaweiModule);
    }

    public static LatLngBounds.Builder latLngBoundsBuilder(HuaweiModule huaweiModule) {
        return (LatLngBounds.Builder) Preconditions.checkNotNullFromProvides(huaweiModule.latLngBoundsBuilder());
    }

    public LatLngBounds.Builder get() {
        return latLngBoundsBuilder(this.module);
    }
}
