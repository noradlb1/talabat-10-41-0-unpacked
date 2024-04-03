package com.talabat.hms.maps.data.di;

import com.huawei.hms.maps.model.CameraPosition;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_CameraPositionBuilderFactory implements Factory<CameraPosition.Builder> {
    private final HuaweiModule module;

    public HuaweiModule_CameraPositionBuilderFactory(HuaweiModule huaweiModule) {
        this.module = huaweiModule;
    }

    public static CameraPosition.Builder cameraPositionBuilder(HuaweiModule huaweiModule) {
        return (CameraPosition.Builder) Preconditions.checkNotNullFromProvides(huaweiModule.cameraPositionBuilder());
    }

    public static HuaweiModule_CameraPositionBuilderFactory create(HuaweiModule huaweiModule) {
        return new HuaweiModule_CameraPositionBuilderFactory(huaweiModule);
    }

    public CameraPosition.Builder get() {
        return cameraPositionBuilder(this.module);
    }
}
