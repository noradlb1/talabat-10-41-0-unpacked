package com.talabat.hms.maps.data.di;

import com.huawei.hms.maps.model.PolygonOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_HuaweiPolygonOptionsFactory implements Factory<PolygonOptions> {
    private final HuaweiModule module;

    public HuaweiModule_HuaweiPolygonOptionsFactory(HuaweiModule huaweiModule) {
        this.module = huaweiModule;
    }

    public static HuaweiModule_HuaweiPolygonOptionsFactory create(HuaweiModule huaweiModule) {
        return new HuaweiModule_HuaweiPolygonOptionsFactory(huaweiModule);
    }

    public static PolygonOptions huaweiPolygonOptions(HuaweiModule huaweiModule) {
        return (PolygonOptions) Preconditions.checkNotNullFromProvides(huaweiModule.huaweiPolygonOptions());
    }

    public PolygonOptions get() {
        return huaweiPolygonOptions(this.module);
    }
}
