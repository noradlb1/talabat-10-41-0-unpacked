package com.talabat.hms.maps.data.model;

import com.huawei.hms.maps.model.CameraPosition;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsCameraPositionBuilder_Factory implements Factory<HmsCameraPositionBuilder> {
    private final Provider<CameraPosition.Builder> huaweiCameraPositionBuilderProvider;

    public HmsCameraPositionBuilder_Factory(Provider<CameraPosition.Builder> provider) {
        this.huaweiCameraPositionBuilderProvider = provider;
    }

    public static HmsCameraPositionBuilder_Factory create(Provider<CameraPosition.Builder> provider) {
        return new HmsCameraPositionBuilder_Factory(provider);
    }

    public static HmsCameraPositionBuilder newInstance(CameraPosition.Builder builder) {
        return new HmsCameraPositionBuilder(builder);
    }

    public HmsCameraPositionBuilder get() {
        return newInstance(this.huaweiCameraPositionBuilderProvider.get());
    }
}
