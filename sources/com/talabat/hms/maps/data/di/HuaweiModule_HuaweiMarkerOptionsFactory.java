package com.talabat.hms.maps.data.di;

import com.huawei.hms.maps.model.MarkerOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_HuaweiMarkerOptionsFactory implements Factory<MarkerOptions> {
    private final HuaweiModule module;

    public HuaweiModule_HuaweiMarkerOptionsFactory(HuaweiModule huaweiModule) {
        this.module = huaweiModule;
    }

    public static HuaweiModule_HuaweiMarkerOptionsFactory create(HuaweiModule huaweiModule) {
        return new HuaweiModule_HuaweiMarkerOptionsFactory(huaweiModule);
    }

    public static MarkerOptions huaweiMarkerOptions(HuaweiModule huaweiModule) {
        return (MarkerOptions) Preconditions.checkNotNullFromProvides(huaweiModule.huaweiMarkerOptions());
    }

    public MarkerOptions get() {
        return huaweiMarkerOptions(this.module);
    }
}
