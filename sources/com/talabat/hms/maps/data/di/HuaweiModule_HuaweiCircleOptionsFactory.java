package com.talabat.hms.maps.data.di;

import com.huawei.hms.maps.model.CircleOptions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_HuaweiCircleOptionsFactory implements Factory<CircleOptions> {
    private final HuaweiModule module;

    public HuaweiModule_HuaweiCircleOptionsFactory(HuaweiModule huaweiModule) {
        this.module = huaweiModule;
    }

    public static HuaweiModule_HuaweiCircleOptionsFactory create(HuaweiModule huaweiModule) {
        return new HuaweiModule_HuaweiCircleOptionsFactory(huaweiModule);
    }

    public static CircleOptions huaweiCircleOptions(HuaweiModule huaweiModule) {
        return (CircleOptions) Preconditions.checkNotNullFromProvides(huaweiModule.huaweiCircleOptions());
    }

    public CircleOptions get() {
        return huaweiCircleOptions(this.module);
    }
}
